package cn.chaZ.domain.strategy.model.valobj;

import cn.chaZ.domain.strategy.service.rule.factory.DefaultLogicFactory;
import cn.chaZ.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * 获取抽奖中规则；或者使用 lambda 表达式
     * <p>
     * List<String> ruleModelList = Arrays.stream(ruleModels.split(Constants.SPLIT))
     * .filter(DefaultLogicFactory.LogicModel::isCenter)
     * .collect(Collectors.toList());
     * return ruleModelList;
     * <p>
     * List<String> collect = Arrays.stream(ruleModelValues).filter(DefaultLogicFactory.LogicModel::isCenter).collect(Collectors.toList());
     */
    public String[] raffleCenterRuleModelList() {
        List<String> ruleModelList = new ArrayList<>();
        String[] ruleModelValues = ruleModels.split(Constants.SPLIT);
        for (String ruleModelValue : ruleModelValues) {
            if (DefaultLogicFactory.LogicModel.isCenter(ruleModelValue)) {
                ruleModelList.add(ruleModelValue);
            }
        }
        return ruleModelList.toArray(new String[0]);
    }

    public String[] raffleAfterRuleModelList() {
        List<String> ruleModelList = new ArrayList<>();
        String[] ruleModelValues = ruleModels.split(Constants.SPLIT);
        for (String ruleModelValue : ruleModelValues) {
            if (DefaultLogicFactory.LogicModel.isAfter(ruleModelValue)) {
                ruleModelList.add(ruleModelValue);
            }
        }
        return ruleModelList.toArray(new String[0]);
    }

}
