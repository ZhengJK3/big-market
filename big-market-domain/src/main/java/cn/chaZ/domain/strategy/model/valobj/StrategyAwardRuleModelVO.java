package cn.chaZ.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * @program: big-market
 * @description: 抽奖策略规则规则值对象；值对象，没有唯一ID，仅限于从数据库查询对象
 * @author: chaZ
 * @create: 2024-04-18 09:05
 **/

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardRuleModelVO {

    private String ruleModels;

}

