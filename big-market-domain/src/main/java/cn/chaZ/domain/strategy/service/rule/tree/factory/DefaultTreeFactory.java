package cn.chaZ.domain.strategy.service.rule.tree.factory;

import cn.chaZ.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.chaZ.domain.strategy.model.valobj.RuleTreeVO;
import cn.chaZ.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.chaZ.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import cn.chaZ.domain.strategy.service.rule.tree.factory.engine.impl.DecisionTreeEngine;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @program: big-market
 * @description: 规则树工厂
 * @author: chaZ
 * @create: 2024-04-24 19:57
 **/

@Service
public class DefaultTreeFactory {

    private final Map<String, ILogicTreeNode> logicTreeNodeGroup;

    public DefaultTreeFactory(Map<String, ILogicTreeNode> logicTreeNodeGroup) {
        this.logicTreeNodeGroup = logicTreeNodeGroup;
    }
    public IDecisionTreeEngine openLogicTree(RuleTreeVO ruleTreeVO) {
        return new DecisionTreeEngine(logicTreeNodeGroup, ruleTreeVO);
    }

    /**
     * 决策树个动作实习
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TreeActionEntity {
        private RuleLogicCheckTypeVO ruleLogicCheckType;
        private StrategyAwardVO strategyAwardVO;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StrategyAwardVO {
        /** 抽奖奖品ID - 内部流转使用 */
        private Integer awardId;
        /** 抽奖奖品规则 */
        private String awardRuleValue;
    }


}
