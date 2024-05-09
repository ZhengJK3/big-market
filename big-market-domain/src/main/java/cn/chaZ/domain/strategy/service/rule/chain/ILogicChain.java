package cn.chaZ.domain.strategy.service.rule.chain;

import cn.chaZ.domain.strategy.service.rule.chain.factory.DefaultChainFactory;

/**
 * @program: big-market
 * @description: 抽奖策略规则责任链接口
 * @author: chaZ
 * @create: 2024-04-19 10:53
 **/

public interface ILogicChain extends ILogicChainArmory{

    /**
     * 责任链接口
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @return 奖品对象
     */
    DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId);

}
