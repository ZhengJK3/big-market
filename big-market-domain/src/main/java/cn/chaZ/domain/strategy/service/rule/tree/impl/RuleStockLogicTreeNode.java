package cn.chaZ.domain.strategy.service.rule.tree.impl;

import cn.chaZ.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.chaZ.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.chaZ.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-04-24 20:00
 **/

@Slf4j
@Component("rule_stock")
public class RuleStockLogicTreeNode implements ILogicTreeNode {

    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .build();
    }

}
