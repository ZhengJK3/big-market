package cn.chaZ.domain.strategy.service.rule.chain;

/**
 * @program: big-market
 * @description: 责任链装配
 * @author: chaZ
 * @create: 2024-04-19 10:54
 **/

public interface ILogicChainArmory {

    ILogicChain next();

    ILogicChain appendNext(ILogicChain next);

}

