package cn.chaZ.domain.strategy.service;

import cn.chaZ.domain.strategy.model.valobj.StrategyAwardStockKeyVO;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-05-10 15:24
 **/

public interface IRaffleStock {

    /**
     * 获取奖品库存消耗队列
     *
     * @return 奖品库存Key信息
     * @throws InterruptedException 异常
     */
    StrategyAwardStockKeyVO takeQueueValue() throws InterruptedException;

    /**
     * 更新奖品库存消耗记录
     *
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     */
    void updateStrategyAwardStock(Long strategyId, Integer awardId);

}

