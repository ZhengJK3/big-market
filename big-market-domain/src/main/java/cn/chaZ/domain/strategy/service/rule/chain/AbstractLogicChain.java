package cn.chaZ.domain.strategy.service.rule.chain;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-04-19 10:52
 **/

@Slf4j
public abstract class AbstractLogicChain implements ILogicChain {

    private ILogicChain next;

    @Override
    public ILogicChain next() {
        return next;
    }

    @Override
    public ILogicChain appendNext(ILogicChain next) {
        this.next = next;
        return next;
    }

    protected abstract String ruleModel();

}

