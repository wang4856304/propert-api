package com.happy.dao;

import com.happy.entity.po.LayerPo;

import java.util.List;

/**
 * @author wangjun
 * @Title: LayerDao
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/12 10:46
 */
public interface LayerDao {
    List<LayerPo> getLayerListByUnitId(String unitId);
}
