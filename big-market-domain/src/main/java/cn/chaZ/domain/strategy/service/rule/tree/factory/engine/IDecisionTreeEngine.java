package cn.chaZ.domain.strategy.service.rule.tree.factory.engine;

import cn.chaZ.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-04-24 19:59
 **/

public interface IDecisionTreeEngine {
    DefaultTreeFactory.StrategyAwardData process(String userId, Long strategyId, Integer awardId);

}
