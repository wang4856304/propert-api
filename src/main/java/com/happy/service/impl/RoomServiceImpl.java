package com.happy.service.impl;

import com.happy.dao.RoomDao;
import com.happy.entity.Response;
import com.happy.entity.bo.RoomBo;
import com.happy.entity.po.RoomPo;
import com.happy.enums.BusinessErrorEnum;
import com.happy.service.BaseService;
import com.happy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangjun
 * @Title: RoomServiceImpl
 * @ProjectName newHappy
 * @Description: 房间操作
 * @date 2018/10/10 14:40
 */

@Service
public class RoomServiceImpl extends BaseService implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Override
    public Response getDefaultRoom(String token) {
        String customerId="460901004080357376";
        String roomId = roomDao.getDefaultBindRoom(customerId);
        RoomPo roomPo = roomDao.getRoomById(roomId);
        return buildSuccesResponse(roomPo);
    }

    @Override
    public Response getRoomListByIds(String communityId, String floorId, String unitId, String layerId) {
        RoomBo roomBo = new RoomBo();
        roomBo.setCommunityId(communityId);
        roomBo.setFloorId(floorId);
        roomBo.setUnitId(unitId);
        roomBo.setLayerId(layerId);
        List<RoomPo> roomPos = roomDao.getRoomListByIds(roomBo);
        return buildSuccesResponse(roomPos);
    }

    @Override
    public Response checkRoomOwner(String roomId, String ownerName) {
        RoomBo roomBo = new RoomBo();
        roomBo.setRoomId(roomId);
        roomBo.setOwnerName(ownerName);
        RoomPo roomPo = roomDao.getOwnerByNameAndId(roomBo);
        if (roomPo == null) {
            return buildErrorResponse(BusinessErrorEnum.OWNER_ERROR.getCode(), BusinessErrorEnum.OWNER_ERROR.getMsg());
        }
        return buildSuccesResponse();
    }

    @Override
    public Response bindRoom(String roomId, String customerId) {
        RoomBo roomBo = new RoomBo();
        roomBo.setCustomerId("");
        roomBo.setCustomerId(customerId);
        roomBo.setRoomId(roomId);
        roomDao.bindRoom(roomBo);
        return buildSuccesResponse();
    }
}
