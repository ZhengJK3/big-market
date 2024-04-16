package cn.chaZ.domain.strategy.model.entity;

import cn.chaZ.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: big-market
 * @description: 策略规则实体
 * @author: chaZ
 * @create: 2024-04-16 16:03
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyRuleEntity {
    /**
     * 抽奖策略ID
     */
    private Long strategyId;
    /**
     * 抽奖奖品ID
     */
    private Integer awardId;
    /**
     * 抽奖规则类型【1-策略规则，2-奖品规则】
     */
    private Integer ruleType;
    /**
     * 筹建规则类型【rule_lock】
     */
    private String ruleModel;
    /**
     * 抽奖规则比值
     */
    private String ruleValue;
    /**
     * 抽奖规则描述
     */
    private String ruleDesc;

    /**
     * 获取权重值
     * 数据案例；4000:102,103,104,105 5000:102,103,104,105,106,107 6000:102,103,104,105,106,107,108,109
     */
    public Map<String, List<Integer>> getRuleWeightValues() {
        // 判断是不是rule_weight
        if (!"rule_weight".equals(ruleModel)) {
            return null;
        }
        // 将rulevalue分成一组一组，分开处理
        String[] ruleValueGroups = ruleValue.split(Constants.SPACE);
        Map<String, List<Integer>> resultMap = new HashMap<>();
        for (String ruleValueGroup : ruleValueGroups) {
            // 检查输入是否为空
            if (null == ruleValueGroup || ruleValueGroup.isEmpty()) {
                return resultMap;
            }
            // 分割字符串以获取键和值，键就ruleValueGroup，值是一个list，存着各个awardId
            String[] parts = ruleValueGroup.split(Constants.COLON);
            if (parts.length != 2) {
                throw new IllegalArgumentException("rule_weight rule_rule invalid input format" + ruleValueGroup);
            }
            // 解析
            String[] awardIdStr = parts[1].split(Constants.SPLIT);
            List<Integer> awardIds = new ArrayList<>();
            for (String awardId : awardIdStr) {
                awardIds.add(Integer.parseInt(awardId));
            }
            resultMap.put(ruleValueGroup, awardIds);
        }
        return resultMap;
    }
}
