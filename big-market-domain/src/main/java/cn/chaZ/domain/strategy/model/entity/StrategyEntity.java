package cn.chaZ.domain.strategy.model.entity;

import cn.chaZ.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @program: big-market
 * @description: 策略实体
 * @author: chaZ
 * @create: 2024-04-16 16:03
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyEntity {
    /** 抽奖策略ID */
    private Integer strategyId;
    /** 抽奖策略描述 */
    private String strategyDesc;
    /** 模型策略 */
    private String ruleModels;

    public String[] ruleModels(){
        if(StringUtils.isBlank(ruleModels)) return null;
        return ruleModels.split(Constants.SPLIT);
    }

    public String getRuleWeight(){
        String[] ruleModels = this.ruleModels();
        for (String ruleModel : ruleModels) {
            if ("rule_weight".equals(ruleModel)) {
                return ruleModel;
            }
        }
        return null;
    }
}
