package cn.chaZ.infrastructure.persistent.dao;

import cn.chaZ.infrastructure.persistent.po.FailedMessageRecord;
import cn.chaZ.types.model.BaseEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: big-market
 * @description: MQ补偿表
 * @author: chaZ
 * @create: 2024-05-17 20:31
 **/

@Mapper
public interface IFailedMessageRecordDao {
    List<FailedMessageRecord> queryFailedMessageRecordByMessageId(String messageId);
    List<FailedMessageRecord> queryFailedMessageRecord();

    void insertFailedMessageRecord(FailedMessageRecord failedMessageRecord);

    void deleteFailedMessageRecord(String messageId);

}
