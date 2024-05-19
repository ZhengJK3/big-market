package cn.chaZ.domain.strategy.repository;

import cn.chaZ.domain.strategy.model.entity.StrategyAwardEntity;
import cn.chaZ.domain.strategy.model.entity.StrategyEntity;
import cn.chaZ.domain.strategy.model.entity.StrategyRuleEntity;
import cn.chaZ.domain.strategy.model.valobj.FailedMessageRecordVO;
import cn.chaZ.domain.strategy.model.valobj.RuleTreeVO;
import cn.chaZ.domain.strategy.model.valobj.StrategyAwardRuleModelVO;
import cn.chaZ.domain.strategy.model.valobj.StrategyAwardStockKeyVO;

import java.util.List;
import java.util.Map;

/**
 * @program: big-market
 * @description: 策略服务仓储接口
 * @author: chaZ
 * @create: 2024-04-13 22:03
 **/

public interface IStrategyRepository {
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String key, Integer rateRange, Map<Integer, Integer> strategyAwardSearchRateTable);

    Integer getStrategyAwardAssemble(String key, Integer rateKey);

    int getRateRange(Long strategyId);

    int getRateRange(String key);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

    StrategyAwardRuleModelVO queryStrategyAwardRuleModelVO(Long strategyId, Integer awardId);

    /**
     * 根据规则树ID，查询树结构信息
     *
     * @param treeId 规则树ID
     * @return 树结构信息
     */
    RuleTreeVO queryRuleTreeVOByTreeId(String treeId);

    /**
     * 缓存奖品库存
     *
     * @param cacheKey   key
     * @param awardCount 库存值
     */
    void cacheStrategyAwardCount(String cacheKey, Integer awardCount);

    /**
     * 缓存key，decr 方式扣减库存
     *
     * @param cacheKey 缓存Key
     * @return 扣减结果
     */
    Boolean subtractionAwardStock(String cacheKey);

    /**
     * 写入奖品库存消费队列
     *
     * @param strategyAwardStockKeyVO 对象值对象
     */
    void awardStockConsumeSendQueue(StrategyAwardStockKeyVO strategyAwardStockKeyVO);
    /**
     * 写入奖品库存RocketMQ消费队列
     *
     * @param strategyAwardStockKeyVO 对象值对象
     */
    void awardStockConsumeSendMQ(StrategyAwardStockKeyVO strategyAwardStockKeyVO);
    /**
     * 获取奖品库存消费队列
     */
    StrategyAwardStockKeyVO takeQueueValue() throws InterruptedException;

    /**
     * 更新奖品库存消耗
     *
     * @param strategyId 策略ID
     * @param awardId 奖品ID
     */
    void updateStrategyAwardStock(Long strategyId, Integer awardId);

    /**
     * 根据策略ID+奖品ID的唯一值组合，查询奖品信息
     *
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return 奖品信息
     */
    StrategyAwardEntity queryStrategyAwardEntity(Long strategyId, Integer awardId);

    /**
     * 找到所有要重新发送的消息
     *
     * @return 奖品信息
     */
    List<FailedMessageRecordVO> queryFailedMessageRecord();
    /**
     * 将发送失败的消息存储到数据库
     *
     * @param failedMessageRecordVO 发送失败的消息
     * @return 奖品信息
     */
    void insertFailedMessageRecord(FailedMessageRecordVO failedMessageRecordVO);
    /**
     * 处理发送失败的消息后将消息从数据库中删除
     *
     * @param messageId 要删除的消息ID
     * @return 奖品信息
     */
    void deleteFailedMessageRecord(String messageId);

    /**
     * 处理发送失败的消息后将消息从数据库中删除
     *
     * @param failedMessageRecordVO 要重新发送的消息
     * @return 奖品信息
     */
    void reSendFailedMessage(FailedMessageRecordVO failedMessageRecordVO);


}
