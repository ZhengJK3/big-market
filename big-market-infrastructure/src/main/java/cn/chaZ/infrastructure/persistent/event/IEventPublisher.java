package cn.chaZ.infrastructure.persistent.event;

import cn.chaZ.domain.strategy.event.RaffleEvent;
import cn.chaZ.types.model.BaseEvent;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-05-18 21:33
 **/

public interface IEventPublisher {
    void publish(String topic, RaffleEvent message);
    void publishDelivery(String topic, RaffleEvent message, int delayTimeLevel);
    void saveFailure(String topic, RaffleEvent message);
}
