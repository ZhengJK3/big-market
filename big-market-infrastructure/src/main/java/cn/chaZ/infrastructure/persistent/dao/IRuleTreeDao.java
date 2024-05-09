package cn.chaZ.infrastructure.persistent.dao;

import cn.chaZ.infrastructure.persistent.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;


/**
 * @program: big-market
 * @description: 规则树表DAO
 * @author: chaZ
 * @create: 2024-04-26 11:05
 **/

@Mapper
public interface IRuleTreeDao {

    RuleTree queryRuleTreeByTreeId(String treeId);

}

