package com.happy.service;

import com.happy.entity.Response;
import com.happy.entity.po.RoomPo;

/**
 * @author wangjun
 * @Title: RoomService
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/10 14:13
 */
public interface RoomService {

    Response getDefaultRoom(String token);
    Response getRoomListByIds(String communityId, String floorId, String unitId, String layerId);
    Response checkRoomOwner(String roomId, String ownerName);
    Response bindRoom(String roomId, String customerId);
}
