package cn.chaZ.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: big-market
 * @description: 策略奖品实体
 * @author: chaZ
 * @create: 2024-04-13 22:30
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardEntity {
    /** 抽奖策略ID */
    private Long strategyId;
    /** 抽奖奖品ID */
    private Integer awardId;
    /** 抽奖奖品标题 */
    private String awardTitle;
    /** 抽奖结果副标题 */
    private String awardSubTitle;
    /** 奖品库存总量 */
    private Integer awardCount;
    /** 奖品库存剩余 */
    private Integer awardCountSurplus;
    /** 奖品中奖概率 */
    private BigDecimal awardRate;
    /** 排序 */
    private Integer sort;
}
