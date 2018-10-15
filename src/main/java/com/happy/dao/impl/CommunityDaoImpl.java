package com.happy.dao.impl;

import com.happy.dao.BaseDao;
import com.happy.dao.CommunityDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author wangjun
 * @Title: CommunityDaoImpl
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/11 20:39
 */

@Repository
public class CommunityDaoImpl extends BaseDao implements CommunityDao {
    @Override
    public String getCommunityByName(@Param("communityName") String communityName) {
        return masterSqlSessionTemplate.selectOne("Community.getCommunityByName", communityName);
    }
}
