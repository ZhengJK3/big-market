package cn.chaZ.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: big-market
 * @description: 抽奖应答结果
 * @author: chaZ
 * @create: 2024-04-30 15:11
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleResponseDTO {
    /** 奖品ID */
    private Integer awardID;
    /** 奖品排序编号【策略奖品配置的奖品顺序编号】 */
    private Integer awardIndex;
}
