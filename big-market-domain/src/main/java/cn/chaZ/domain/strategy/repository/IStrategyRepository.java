package cn.chaZ.domain.strategy.repository;

import cn.chaZ.domain.strategy.model.entity.StrategyAwardEntity;
import cn.chaZ.domain.strategy.model.entity.StrategyEntity;
import cn.chaZ.domain.strategy.model.entity.StrategyRuleEntity;
import cn.chaZ.domain.strategy.model.valobj.RuleTreeVO;
import cn.chaZ.domain.strategy.model.valobj.StrategyAwardRuleModelVO;

import java.util.List;
import java.util.Map;

/**
 * @program: big-market
 * @description: 策略服务仓储接口
 * @author: chaZ
 * @create: 2024-04-13 22:03
 **/

public interface IStrategyRepository {
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String key, Integer rateRange, Map<Integer, Integer> strategyAwardSearchRateTable);

    Integer getStrategyAwardAssemble(String key, Integer rateKey);

    int getRateRange(Long strategyId);

    int getRateRange(String key);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

    StrategyAwardRuleModelVO queryStrategyAwardRuleModelVO(Long strategyId, Integer awardId);

    /**
     * 根据规则树ID，查询树结构信息
     *
     * @param treeId 规则树ID
     * @return 树结构信息
     */
    RuleTreeVO queryRuleTreeVOByTreeId(String treeId);


}
