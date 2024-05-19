package cn.chaZ.test.infrastructure;

import cn.chaZ.domain.strategy.model.valobj.StrategyAwardStockKeyVO;
import cn.chaZ.infrastructure.persistent.dao.IFailedMessageRecordDao;
import cn.chaZ.infrastructure.persistent.po.FailedMessageRecord;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: big-market
 * @description: 测试发送失败MQ信息
 * @author: chaZ
 * @create: 2024-05-17 21:30
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class FailedMessageRecordDaoTest {
    @Resource
    private IFailedMessageRecordDao failedMessageRecordDao;


    @Test
    public void test_queryFailedMessageRecord() {
        String topic = "chaZ-topic";
        List<FailedMessageRecord> awards = failedMessageRecordDao.queryFailedMessageRecord();
        log.info("测试结果：{}", JSON.toJSONString(awards));

    }
    @Test
    public void test_queryFailedMessageRecordByMessageId() {
        List<FailedMessageRecord> awards = failedMessageRecordDao.queryFailedMessageRecordByMessageId("80722040379");
        log.info("测试结果：{}", JSON.toJSONString(awards));

    }

    @Test
    public void test_insertFailedMessageRecord() {
        log.info("测试开始");
        failedMessageRecordDao.insertFailedMessageRecord(FailedMessageRecord.builder()
                .topic("chaZ-topic")
                .messageId(RandomStringUtils.randomNumeric(11))
                .messageTimestamp(new Date())
                .strategyId(100006L)
                .awardId(108)
                .createTime(new Date())
                .build());
        log.info("插入测试成功");
    }

    @Test
    public void test_deleteFailedMessageRecord() {
        failedMessageRecordDao.deleteFailedMessageRecord("12345678910");
        log.info("删除测试成功");
    }

}
