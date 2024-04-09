package cn.chaZ.infrastructure.persistent.dao;

import cn.chaZ.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: big-market
 * @description: 奖品表DAO
 * @author: chaZ
 * @create: 2024-04-09 16:46
 **/

@Mapper
public interface IAwardDao {

    List<Award> queryAwardList();
}
