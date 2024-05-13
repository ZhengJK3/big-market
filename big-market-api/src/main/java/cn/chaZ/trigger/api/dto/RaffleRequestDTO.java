package cn.chaZ.trigger.api.dto;

import lombok.Data;

/**
 * @program: big-market
 * @description: 抽奖请求参数
 * @author: chaZ
 * @create: 2024-04-30 16:08
 **/

@Data
public class RaffleRequestDTO {
    // 抽奖策略ID
    private Long strategyId;
}
