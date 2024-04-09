package cn.chaZ.infrastructure.persistent.dao;

import cn.chaZ.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-04-09 16:48
 **/

@Mapper
public interface IStrategyRuleDao {
    List<Award> queryStrategyRuleList();
}
