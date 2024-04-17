package cn.chaZ.domain.strategy.service;

import cn.chaZ.domain.strategy.model.entity.RaffleAwardEntity;
import cn.chaZ.domain.strategy.model.entity.RaffleFactorEntity;

/**
 * @program: big-market
 * @description: 抽奖策略接口
 * @author: chaZ
 * @create: 2024-04-17 11:18
 **/

public interface IRaffleStrategy {
    /**
     * 执行抽奖；用抽奖因子入参，执行抽奖计算，返回奖品信息
     *
     * @param raffleFactorEntity 抽奖因子实体对象，根据入参信息计算抽奖结果
     * @return 抽奖的奖品
     */
    RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity);

}