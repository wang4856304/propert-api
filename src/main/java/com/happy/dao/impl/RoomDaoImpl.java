package com.happy.dao.impl;

import com.happy.dao.BaseDao;
import com.happy.dao.RoomDao;
import com.happy.entity.bo.RoomBo;
import com.happy.entity.po.RoomPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangjun
 * @Title: RoomDaoImpl
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/10 15:08
 */

@Repository
public class RoomDaoImpl extends BaseDao implements RoomDao {
    @Override
    public String getDefaultBindRoom(@Param("roomId")String customerId) {
        return masterSqlSessionTemplate.selectOne("Room.getDefaultBindRoom", customerId);
    }

    @Override
    public List<String> getRoomList(@Param("roomId")String customerId) {
        return masterSqlSessionTemplate.selectList("Room.getRoomList", customerId);
    }

    @Override
    public RoomPo getRoomById(@Param("roomId")String roomId) {
        return masterSqlSessionTemplate.selectOne("Room.getRoomById", roomId);
    }

    @Override
    public Integer updateDefaultBindRoom(RoomBo roomBo) {
        return masterSqlSessionTemplate.update("Room.updateDefaultBindRoom", roomBo);
    }

    @Override
    public Integer updateOtherRoomDefault(RoomBo roomBo) {
        return masterSqlSessionTemplate.update("Room.updateOtherRoomDefault", roomBo);
    }

    @Override
    public Integer bindRoom(RoomBo roomBo) {
        return masterSqlSessionTemplate.insert("Room.bindRoom", roomBo);
    }

    @Override
    public Integer deleteBindRoom(RoomBo roomBo) {
        return masterSqlSessionTemplate.delete("Room.deleteBindRoom", roomBo);
    }

    @Override
    public List<RoomPo> getRoomListByLayerId(@Param("layerId") String layerId) {
        return masterSqlSessionTemplate.selectList("Room.getRoomListByLayerId", layerId);
    }

    @Override
    public List<RoomPo> getRoomListByIds(RoomBo roomBo) {
        return masterSqlSessionTemplate.selectList("Room.getRoomListByIds", roomBo);
    }

    @Override
    public RoomPo getOwnerByNameAndId(RoomBo roomBo) {
        return masterSqlSessionTemplate.selectOne("Room.getOwnerByNameAndId", roomBo);
    }

    @Override
    public List<RoomPo> getUserRoomList(@Param("customerId") String customerId) {
        return masterSqlSessionTemplate.selectList("Room.getUserRoomList", customerId);
    }
}
