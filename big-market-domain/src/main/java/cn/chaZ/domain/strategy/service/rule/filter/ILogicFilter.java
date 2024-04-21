package cn.chaZ.domain.strategy.service.rule.filter;

import cn.chaZ.domain.strategy.model.entity.RuleActionEntity;
import cn.chaZ.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-04-17 10:02
 **/

public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {

    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);

}

