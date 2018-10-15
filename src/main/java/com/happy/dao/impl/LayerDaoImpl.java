package com.happy.dao.impl;

import com.happy.dao.BaseDao;
import com.happy.dao.LayerDao;
import com.happy.entity.po.LayerPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangjun
 * @Title: LayerDaoImpl
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/12 10:47
 */

@Repository
public class LayerDaoImpl extends BaseDao implements LayerDao{
    @Override
    public List<LayerPo> getLayerListByUnitId(@Param("unitId") String unitId) {
        return masterSqlSessionTemplate.selectList("Layer.getLayerListByUnitId", unitId);
    }
}
