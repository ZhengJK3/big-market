package cn.chaZ.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: big-market
 * @description: 策略结果实体
 * @author: chaZ
 * @create: 2024-04-13 22:30
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AwardEntity {
    /** 用户ID */
    private String userId;
    private String userName;
    private String userAge;

    /** 奖品ID */
    private Integer awardId;
}
