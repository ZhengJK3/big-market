package cn.chaZ.test.infrastructure;

import cn.chaZ.infrastructure.persistent.dao.IAwardDao;
import cn.chaZ.infrastructure.persistent.dao.IStrategyAwardDao;
import cn.chaZ.infrastructure.persistent.po.Award;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-04-09 19:29
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardDaoTest {
    @Resource
    private IAwardDao awardDao;
    @Resource
    private IStrategyAwardDao strategyAwardDao;

    @Test
    public void test_queryAwardList(){
        List<Award> awards = strategyAwardDao.queryStrategyAwardList();
        log.info("测试结果：{}", JSON.toJSONString(awards));

    }
}
