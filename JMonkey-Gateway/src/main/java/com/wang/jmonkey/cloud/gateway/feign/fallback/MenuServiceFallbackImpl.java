package com.wang.jmonkey.cloud.gateway.feign.fallback;

import com.wang.jmonkey.cloud.common.model.vo.MenuVo;
import com.wang.jmonkey.cloud.gateway.feign.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/7/9
 */
@Service
@Slf4j
public class MenuServiceFallbackImpl implements MenuService {

    @Override
    public Set<MenuVo> findMenuVoByRoleCode(String roleCode) {
        log.error("调用{}异常:{}", "findMenuByRole", roleCode);
        return null;
    }
}
