package com.wang.jmonkey.cloud.auth.feign;

import com.wang.jmonkey.cloud.auth.feign.fallback.UserServiceFallbackImpl;
import com.wang.jmonkey.cloud.common.model.vo.UserVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: 用户服务
 * @Auther: HeJiawang
 * @Date: 2018/7/9
 */
@FeignClient(name = "JMonkey-Modules-UPMS", fallback = UserServiceFallbackImpl.class)
public interface UserService {

    /**
     * 根据用户登录名称获取用户角色信息
     * @param username
     * @return
     */
    @GetMapping("/user/findUserVoByUsername/{username}")
    UserVo findUserVoByUsername( String username );
}
