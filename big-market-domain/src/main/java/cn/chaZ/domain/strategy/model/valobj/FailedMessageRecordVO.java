package cn.chaZ.domain.strategy.model.valobj;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-05-18 20:21
 **/
@Data
@Builder
public class FailedMessageRecordVO {
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
}
