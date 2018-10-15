package com.happy.entity.vo;

import com.happy.entity.po.FloorPo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangjun
 * @Title: RoomInfoVo
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/12 11:24
 */
@Data
@NoArgsConstructor
public class RoomInfoVo {
    private String communityId;
    private String communityName;
    List<FloorPo> floorPoList;
}
