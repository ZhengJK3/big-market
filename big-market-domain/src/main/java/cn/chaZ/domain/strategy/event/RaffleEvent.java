package cn.chaZ.domain.strategy.event;

import cn.chaZ.domain.strategy.model.valobj.StrategyAwardStockKeyVO;
import cn.chaZ.types.model.BaseEvent;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;

/**
 * @program: big-market
 * @description: Rocket信息主题
 * @author: chaZ
 * @create: 2024-05-16 15:58
 **/

@Data
@EqualsAndHashCode(callSuper = true)
public class RaffleEvent extends BaseEvent<StrategyAwardStockKeyVO> {
    public static String TOPIC = "chaZ-topic";

    public static RaffleEvent create(StrategyAwardStockKeyVO data) {
        RaffleEvent event = new RaffleEvent();
        event.setId(RandomStringUtils.randomNumeric(11));
        event.setTimestamp(new Date());
        event.setData(data);
        return event;
    }

    public static RaffleEvent recreate(String id, Date date, StrategyAwardStockKeyVO data){
        RaffleEvent event = new RaffleEvent();
        event.setId(id);
        event.setTimestamp(date);
        event.setData(data);
        return event;
    }
}
