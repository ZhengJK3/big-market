package cn.chaZ.trigger.job;

import cn.chaZ.domain.strategy.event.RaffleEvent;
import cn.chaZ.domain.strategy.model.valobj.FailedMessageRecordVO;
import cn.chaZ.domain.strategy.model.valobj.StrategyAwardStockKeyVO;
import cn.chaZ.domain.strategy.repository.IStrategyRepository;
import cn.chaZ.domain.strategy.service.IRaffleStock;
import cn.chaZ.types.model.BaseEvent;
import com.alibaba.fastjson2.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-04-28 15:47
 **/

@Slf4j
@Data
@Component()
@RocketMQMessageListener(topic = "chaZ-topic", consumerGroup = "chaZ-group")
public class UpdateAwardStockJob implements RocketMQListener<String> {
    @Resource
    private IRaffleStock raffleStock;
    @Resource
    private IStrategyRepository strategyRepository;

    private BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();

    @Override
    public void onMessage(String s) {
        messageQueue.offer(s);
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void exec() {
        log.info("定时任务，更新奖品消耗库存【延迟队列获取，降低对数据库的更新频次，不要产生竞争】");
        int maxBatchSize = 10; // 每次最多处理的消息数量
        int processedCount = 0;
        while (processedCount < maxBatchSize && !messageQueue.isEmpty()) {
            try {
                String message = messageQueue.take();
                processMessage(message);
            } catch (InterruptedException e) {
                log.error("定时任务中断", e);
                throw new RuntimeException(e);
            }
        }
    }

    public void processMessage(String s) {
        log.info("接收到MQ消息 {}", s);
        BaseEvent<StrategyAwardStockKeyVO> event = JSON.parseObject(s, RaffleEvent.class);
        try {
            StrategyAwardStockKeyVO strategyAwardStockKeyVO = event.getData();
            if (null == strategyAwardStockKeyVO) return;
            log.info("定时任务，更新奖品消耗库存 strategyId:{} awardId:{}", strategyAwardStockKeyVO.getStrategyId(), strategyAwardStockKeyVO.getAwardId());
            raffleStock.updateStrategyAwardStock(strategyAwardStockKeyVO.getStrategyId(), strategyAwardStockKeyVO.getAwardId());
        } catch (Exception e) {
            log.error("定时任务，更新奖品消耗库存失败", e);
        }
    }

    @Scheduled(cron = "0/8 * * * * ?")
    public void retryFailedMessages() {
        log.info("定时任务，扫描MQ发送失败记录");
        List<FailedMessageRecordVO> failedMessageRecordVOList = strategyRepository.queryFailedMessageRecord();
        if (null == failedMessageRecordVOList || 0 == failedMessageRecordVOList.size()) {
            return;
        }
        log.info("重新发送失败记录");
        for (FailedMessageRecordVO failedMessageRecordVO : failedMessageRecordVOList) {
            strategyRepository.deleteFailedMessageRecord(failedMessageRecordVO.getMessageId());
            strategyRepository.reSendFailedMessage(failedMessageRecordVO);
        }
    }

}

