package cn.chaZ.infrastructure.persistent.dao;

import cn.chaZ.infrastructure.persistent.po.Award;
import cn.chaZ.infrastructure.persistent.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-04-09 16:47
 **/

@Mapper
public interface IStrategyDao {
    List<Award> queryStrategyList();

    Strategy queryStrategyByStrategyId(Long strategyId);
}
