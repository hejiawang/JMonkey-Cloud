package com.wang.jmonkey.cloud.auth.feign.fallback;

import com.wang.jmonkey.cloud.auth.feign.UserService;
import com.wang.jmonkey.cloud.common.model.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户服务的fallback
 * @Auther: HeJiawang
 * @Date: 2018/7/9
 */
@Slf4j
@Service
public class UserServiceFallbackImpl implements UserService {

    @Override
    public UserVo findUserVoByUsername(String username) {
        log.error("调用{}异常:{}", "findUserByUsername", username);
        return null;
    }
}
