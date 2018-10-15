package com.happy.entity.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangjun
 * @Title: LayerPo
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/11 20:36
 */

@Data
@NoArgsConstructor
public class LayerPo {

    private String layerId;
    private String layerName;
    private List<RoomPo> roomPoList;
}
