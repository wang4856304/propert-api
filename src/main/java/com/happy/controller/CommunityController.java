package com.happy.controller;

import com.happy.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjun
 * @Title: CommunityController
 * @ProjectName newHappy
 * @Description: 小区
 * @date 2018/10/11 19:42
 */


@RestController
@RequestMapping("/community")
public class CommunityController extends BaseController {

    @Autowired
    private CommunityService communityService;

    @RequestMapping("/getCommunityByName")
    public Object getCommunityByName(@RequestHeader("token") String token, @RequestParam String communityName) {
        return buildResponse(communityService.getCommunityByName(communityName));
    }
}
