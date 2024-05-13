package cn.chaZ.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: big-market
 * @description: 抽奖奖品列表，应答对象
 * @author: chaZ
 * @create: 2024-04-30 15:07
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleAwardListResponseDTO {
    /** 奖品ID */
    private Integer awardID;
    /** 奖品标题 */
    private String awardTitle;
    /** 奖品副标题 */
    private String awardSubTitle;
    /** 奖品排序编号 */
    private Integer sort;

}
