package cn.chaZ.domain.strategy.service;

import cn.chaZ.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-04-30 12:31
 **/

public interface IRaffleAward {
    /**
     * 根据策略ID查询抽奖奖品列表配置
     *
     * @param strategyId 策略ID
     * @return 奖品列表
     */
    List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId);
}
