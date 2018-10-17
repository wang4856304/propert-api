package com.happy.dao.impl;

import com.happy.dao.BaseDao;
import com.happy.entity.bo.SqlTestBo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangjun
 * @Title: SqlTestDaoImpl
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/15 11:34
 */

@Repository
public class SqlTestDaoImpl extends BaseDao implements SqlTestDao {
    @Override
    public Integer insertBatch(List<SqlTestBo> sqlTestBoList) {
        //return masterSqlSessionTemplate.insert("SqlTest.insertBatch", sqlTestBoList);
        return masterMSSqlSessionTemplate.insert("SqlTest.insertBatch", sqlTestBoList);
    }

    @Override
    public Integer insert(SqlTestBo testBo) {
        return masterMSSqlSessionTemplate.insert("SqlTest.insertBatch", testBo);
    }

    @Override
    public List<SqlTestBo> selectByName(String name) {
        return masterMSSqlSessionTemplate.selectList("SqlTest.selectByName", name);
    }
}
