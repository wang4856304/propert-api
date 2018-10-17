package com.happy.controller;

import com.happy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangjun
 * @Title: RoomController
 * @ProjectName newHappy
 * @Description: 房间操作
 * @date 2018/10/10 14:10
 */

@RestController
@RequestMapping("/room")
public class RoomController extends BaseController {

    @Autowired
    private RoomService roomService;

    @RequestMapping("/getDefaultRoom")
    public Object getDefaultRoom(@RequestHeader("token") String token) {
        return buildResponse(roomService.getDefaultRoom(token));
    }

    @RequestMapping("/bindRoom")
    public Object bindRoom(@RequestHeader("token") String token, String roomId) {
        return buildResponse(roomService.bindRoom(roomId, token));
    }

    @RequestMapping("/getRoomListByIds")
    public Object getRoomListByIds(@RequestParam String communityId, @RequestParam String unitId,
                                   @RequestParam String floorId, @RequestParam String layerId) {
        return buildResponse(roomService.getRoomListByIds(communityId, floorId, unitId, layerId));
    }

    @RequestMapping("/checkRoomOwner")
    public Object checkRoomOwner(@RequestParam String roomId, @RequestParam String ownerName) {
        return buildResponse(roomService.checkRoomOwner(roomId, ownerName));
    }

    @RequestMapping("/getUserRoomList")
    public Object getUserRoomList(@RequestHeader("token") String token) {
        return buildResponse(roomService.getUserRoomList(token));
    }

    @RequestMapping("/setDefaultRoom")
    public Object setDefaultRoom(@RequestHeader("token") String token, String roomId) {
        return buildResponse(roomService.setDefaultRoom(roomId, token));
    }
}
