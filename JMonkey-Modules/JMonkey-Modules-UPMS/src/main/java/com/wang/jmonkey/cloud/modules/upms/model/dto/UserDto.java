package com.wang.jmonkey.cloud.modules.upms.model.dto;

import com.wang.jmonkey.cloud.modules.upms.model.entity.SysRoleEntity;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Description: user dto
 * @Auther: HeJiawang
 * @Date: 2018/7/6
 */
@Data
@Accessors(chain = true)
public class UserDto extends SysUserEntity {

    private List<String> roleIdList;

    private List<SysRoleEntity> roleList;

    /**
     * 将dto转化为entity
     * @param userDto
     * @return
     */
    public static SysUserEntity converToEntity( UserDto userDto ){
        SysUserEntity userEntity = new SysUserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        return userEntity;
    }

    /**
     * 将entity转换为dto
     * @param userEntity
     * @return
     */
    public static UserDto converFromEntity( SysUserEntity userEntity ){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity, userDto);
        return userDto;
    }
}
