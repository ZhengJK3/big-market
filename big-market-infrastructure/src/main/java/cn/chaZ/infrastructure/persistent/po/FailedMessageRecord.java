package cn.chaZ.infrastructure.persistent.po;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @program: big-market
 * @description: 发送失败的MQ消息。
 * @author: chaZ
 * @create: 2024-05-17 20:21
 **/

@Data
@Builder
public class FailedMessageRecord {
    /** 自增ID */
    private Integer id;
    /** MQ消息的topic */
    private String topic;
    /** MQ消息的ID */
    private String messageId;
    /** MQ消息的时间戳 */
    private Date messageTimestamp;
    /** MQ消息的数据，strategyID */
    private Long strategyId;
    /** MQ消息的数据，awardID */
    private Integer awardId;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
