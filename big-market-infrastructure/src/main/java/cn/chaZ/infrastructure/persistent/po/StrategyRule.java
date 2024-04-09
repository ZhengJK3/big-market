package cn.chaZ.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @program: big-market
 * @description: 抽奖规则
 * @author: chaZ
 * @create: 2024-04-09 16:41
 **/
@Data
public class StrategyRule {
    /** 自增ID */
    private Long id;
    /** 抽奖策略ID */
    private Integer strategyId;
    /** 抽奖奖品ID */
    private Integer awardId;
    /** 抽奖规则类型【1-策略规则，2-奖品规则】 */
    private Integer ruleType;
    /** 筹建规则类型【rule_lock】 */
    private String ruleModel;
    /** 抽奖规则比值 */
    private String ruleValue;
    /** 抽奖规则描述 */
    private String ruleDesc;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
