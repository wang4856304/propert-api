package com.happy.service;

import com.happy.entity.Response;
import com.happy.entity.dto.user.UserChangePwdDto;
import com.happy.entity.dto.user.UserDto;
import com.happy.entity.dto.user.UserLoginDto;
import com.happy.entity.dto.user.UserResetPwdDto;

/**
 * }
 *
 * @author Administrator
 * @Description:
 * @date 2018/8/17 11:44
 */
public interface UserService {
    Response registerUser(UserDto userDto);
    Response login(UserLoginDto userLoginDto);
    Response loginOut(String token);
    Response getUserInfo(String token);
    Response changeUserPassword(UserChangePwdDto userChangePwdDto);
    Response resetUserPassword(UserResetPwdDto userResetPwdDto);
    String getUserIdByToken(String token);
}
