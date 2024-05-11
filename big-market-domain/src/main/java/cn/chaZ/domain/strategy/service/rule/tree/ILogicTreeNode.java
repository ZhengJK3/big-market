package cn.chaZ.domain.strategy.service.rule.tree;

import cn.chaZ.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @program: big-market
 * @description: 规则树接口
 * @author: chaZ
 * @create: 2024-04-24 19:56
 **/

public interface ILogicTreeNode {
    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId, String ruleValue);
}
