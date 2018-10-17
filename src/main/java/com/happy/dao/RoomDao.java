package com.happy.dao;

import com.happy.entity.bo.RoomBo;
import com.happy.entity.po.RoomPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangjun
 * @Title: RoomDao
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/10 14:41
 */
public interface RoomDao {

    String getDefaultBindRoom(@Param("roomId")String customerId);
    List<String> getRoomList(@Param("roomId")String customerId);
    RoomPo getRoomById(@Param("roomId") String roomId);
    Integer updateDefaultBindRoom(RoomBo roomBo);
    Integer updateOtherRoomDefault(RoomBo roomBo);
    Integer bindRoom(RoomBo roomBo);
    Integer deleteBindRoom(RoomBo roomBo);
    List<RoomPo> getRoomListByLayerId(String layerId);
    List<RoomPo> getRoomListByIds(RoomBo roomBo);
    RoomPo getOwnerByNameAndId(RoomBo roomBo);
    List<RoomPo> getUserRoomList(String customerId);
}
