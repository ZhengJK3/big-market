package cn.chaZ.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: big-market
 * @description: 策略条件实体
 * @author: chaZ
 * @create: 2024-04-13 22:30
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StategyConditionEntity {

    /** 用户ID */
    private String userId;
    /** 策略ID */
    private Integer strategyId;
}
