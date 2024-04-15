package cn.chaZ.test.domain;

import cn.chaZ.domain.strategy.service.armory.IStrategyArmory;
import cn.chaZ.infrastructure.persistent.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RMap;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-04-15 15:01
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {

    @Resource
    private IStrategyArmory strategyArmory;

    /**
     * 策略ID；10001L、10002L 装配的时候创建策略表写入到 Redis Map 中
     */
    @Test
    public void test_strategyArmory() {
        boolean success = strategyArmory.assembleLotteryStrategy(100001L);
        log.info("测试结果：{}", success);
    }

    /**
     * 从装配的策略中随机获取奖品ID值
     */
    @Test
    public void test_getAssembleRandomVal() {
        log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100001L));
        log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100001L));
        log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100001L));
    }


}

