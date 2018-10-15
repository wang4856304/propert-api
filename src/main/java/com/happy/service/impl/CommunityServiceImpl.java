package com.happy.service.impl;

import com.happy.dao.*;
import com.happy.entity.Response;
import com.happy.entity.po.FloorPo;
import com.happy.entity.po.LayerPo;
import com.happy.entity.po.UnitPo;
import com.happy.entity.vo.RoomInfoVo;
import com.happy.enums.BusinessErrorEnum;
import com.happy.service.BaseService;
import com.happy.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author wangjun
 * @Title: CommunityServiceImpl
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/12 11:07
 */

@Service
public class CommunityServiceImpl extends BaseService implements CommunityService {

    @Autowired
    private CommunityDao communityDao;

    @Autowired
    private FloorDao floorDao;

    @Autowired
    private UnitDao unitDao;

    @Autowired
    private LayerDao layerDao;

    @Autowired
    private RoomDao roomDao;

    @Override
    public Response getCommunityByName(String communityName) {

        String communityId = communityDao.getCommunityByName(communityName);
        RoomInfoVo roomInfoVo = new RoomInfoVo();
        if (StringUtils.isEmpty(communityId)) {
            return buildErrorResponse(BusinessErrorEnum.NO_COMMUNITY_ERROR.getCode(), BusinessErrorEnum.NO_COMMUNITY_ERROR.getMsg());
        }
        roomInfoVo.setCommunityId(communityId);
        roomInfoVo.setCommunityName(communityName);
        List<FloorPo> floorPos = floorDao.getFloorListByCommunityId(communityId);
        if (floorPos != null&&floorPos.size() > 0) {
            roomInfoVo.setFloorPoList(floorPos);
            for (FloorPo floorPo: floorPos) {//楼编号
                List<UnitPo> unitPos = unitDao.getUnitListByFloorId(floorPo.getFloorId());
                if (unitPos != null&&unitPos.size() > 0) {
                    floorPo.setUnitPoList(unitPos);
                    for (UnitPo unitPo: unitPos) {//单元
                        List<LayerPo> layerPos = layerDao.getLayerListByUnitId(unitPo.getUnitId());//楼层
                        if (layerPos != null&&layerPos.size() > 0) {
                            unitPo.setLayerPoList(layerPos);
                        }
                    }
                }
            }
        }
        return buildSuccesResponse(roomInfoVo);
    }
}
