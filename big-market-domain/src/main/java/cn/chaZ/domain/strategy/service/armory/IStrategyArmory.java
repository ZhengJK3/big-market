package cn.chaZ.domain.strategy.service.armory;

/**
 * @program: big-market
 * @description: 策略装配库(兵工厂)，负责初始化策略计算
 * @author: chaZ
 * @create: 2024-04-13 21:59
 **/

public interface IStrategyArmory {
    /**
     * 装配抽奖策略配置「触发的时机可以为活动审核通过后进行调用」
     *
     * @param strategyId 策略ID
     * @return 装配结果
     */
    boolean assembleLotteryStrategy(Long strategyId);
}