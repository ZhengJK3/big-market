package cn.chaZ.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @program: big-market
 * @description: 抽奖策略表
 * @author: chaZ
 * @create: 2024-04-09 16:31
 **/
@Data
public class Strategy {
    /** 自增ID */
    private Long id;
    /** 抽奖策略ID */
    private Integer strategyId;
    /** 抽奖策略描述 */
    private String strategyDesc;
    /** 模型策略 */
    private String ruleModels;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
