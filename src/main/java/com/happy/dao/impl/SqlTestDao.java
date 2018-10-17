package com.happy.dao.impl;

import com.happy.entity.bo.SqlTestBo;

import java.util.List;

/**
 * @author wangjun
 * @Title: SqlTestDao
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/15 11:28
 */
public interface SqlTestDao {
    Integer insertBatch(List<SqlTestBo> sqlTestBoList);
    Integer insert(SqlTestBo testBo);
    List<SqlTestBo> selectByName(String name);
}
