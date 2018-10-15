package com.happy.service;

import com.happy.entity.Response;

/**
 * @author wangjun
 * @Title: CommunityService
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/12 11:06
 */
public interface CommunityService {

    Response getCommunityByName(String communityName);
}
