package cn.chaZ.infrastructure.persistent.event;

import cn.chaZ.domain.strategy.event.RaffleEvent;
import cn.chaZ.domain.strategy.model.valobj.StrategyAwardStockKeyVO;
import cn.chaZ.infrastructure.persistent.dao.IFailedMessageRecordDao;
import cn.chaZ.infrastructure.persistent.po.FailedMessageRecord;
import cn.chaZ.types.model.BaseEvent;
import com.alibaba.fastjson.JSON;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-05-16 16:10
 **/
@Component
@Slf4j
public class EventPublisher implements IEventPublisher{
    @Setter
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    //    @Resource
//    private IStrategyRepository strategyRepository;
    @Resource
    private IFailedMessageRecordDao failedMessageRecordDao;

    public void publish(String topic, RaffleEvent message) {
        int retryCount = 3;
        while (retryCount > 0) {
            try {
                String mqMessage = JSON.toJSONString(message);
                log.info("发送MQ消息 topic:{} message:{}", topic, mqMessage);
                rocketMQTemplate.convertAndSend(topic, mqMessage);
                return;
            } catch (Exception e) {
                retryCount--;
                log.error("发送MQ消息失败 topic:{} message:{}", topic, JSON.toJSONString(message), e);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        // 重试多次后依旧失败，执行补偿逻辑
        saveFailure(topic, message);
    }


    public void publishDelivery(String topic, RaffleEvent message, int delayTimeLevel) {
        int retryCount = 3;
        while (retryCount > 0) {
            try {
                String mqMessage = JSON.toJSONString(message);
                log.info("发送MQ延迟消息 topic:{} message:{}", topic, mqMessage);
                rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(message).build(), 3000, delayTimeLevel);
                return;
            } catch (Exception e) {
                retryCount--;
                log.error("发送MQ延迟消息失败 topic:{} message:{}", topic, JSON.toJSONString(message), e);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        // 重试多次后依旧失败，执行补偿逻辑
        saveFailure(topic, message);

    }

    public void saveFailure(String topic, RaffleEvent message) {
        log.error("多次重试后发送MQ消息失败，记录到数据库进行后续补偿 topic:{} message:{}", topic, JSON.toJSONString(message));
        // 可以将消息保存到数据库或其他存储中，供后续处理
        StrategyAwardStockKeyVO strategyAwardStockKeyVO = message.getData();
        log.info("保存发送失败的信息。");
        failedMessageRecordDao.insertFailedMessageRecord(FailedMessageRecord.builder()
                .topic(topic)
                .messageId(message.getId())
                .messageTimestamp(message.getTimestamp())
                .strategyId(strategyAwardStockKeyVO.getStrategyId())
                .awardId(strategyAwardStockKeyVO.getAwardId())
                .createTime(new Date())
                .build());
    }
}
