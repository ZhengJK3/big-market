package cn.chaZ.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @program: big-market
 * @description: 抽奖活动单 持久化对象
 * @author: chaZ
 * @create: 2024-05-24 16:54
 **/
@Data
public class RaffleActivityOrder {
    /** 自增ID */
    private Long id;

    /** 用户ID */
    private String userId;

    /** 活动ID */
    private Long activityId;

    /** 活动名称 */
    private String activityName;

    /** 抽奖策略ID */
    private Long strategyId;

    /** 订单ID */
    private String orderId;

    /** 下单时间 */
    private Date orderTime;

    /** 订单状态（not_used、used、expire） */
    private String state;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

}
