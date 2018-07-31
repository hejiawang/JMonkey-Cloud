package com.wang.jmonkey.cloud.modules.upms.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.cloud.common.http.abs.BaseHttp;
import com.wang.jmonkey.cloud.common.http.result.HttpPageResult;
import com.wang.jmonkey.cloud.common.http.result.HttpResult;
import com.wang.jmonkey.cloud.common.model.vo.UserVo;
import com.wang.jmonkey.cloud.common.utils.UUIDUtil;
import com.wang.jmonkey.cloud.common.utils.file.FtpFileUtil;
import com.wang.jmonkey.cloud.modules.upms.model.dto.UserDto;
import com.wang.jmonkey.cloud.modules.upms.model.dto.UserInfo;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 用户管理 api
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class SysUserApi extends BaseHttp {

    @Resource
    private ISysUserService sysUserService;

    @Value("${JMonkey.file.user.photo}")
    private String userPhotoPath;

    /**
     * 用户信息列表
     * @param page
     * @param userEntity
     * @return
     */
    @GetMapping(value = "/list")
    public HttpPageResult<UserDto> list(Page<SysUserEntity> page, SysUserEntity userEntity) {
        return new HttpPageResult<>( sysUserService.selectPage( page, userEntity ) );
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @GetMapping(value = "/listAll")
    public HttpResult<List<UserDto>> listAll(){
        return new HttpResult<>(sysUserService.selectAll());
    }

    /**
     * 保存用户信息
     * @param UserDto 用户信息
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult<Boolean> save( @RequestBody @Validated UserDto UserDto ){
        return new HttpResult<>(sysUserService.insert(UserDto));
    }

    /**
     * 修改用户信息
     * @param UserDto 用户信息
     * @return
     */
    @PutMapping(value = "/modify")
    public HttpResult<Boolean> modify( @RequestBody @Validated UserDto UserDto ){
        return new HttpResult<>(sysUserService.updateById(UserDto));
    }

    /**
     * 删除用户信息
     * @param id 用户ID
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public HttpResult<Boolean> delete( @PathVariable Serializable id ){
        return new HttpResult<>(sysUserService.deleteById(id));
    }

    /**
     * 重置用户密码为123456
     * @param id 用户id
     * @return
     */
    @GetMapping(value = "/restPasswsord/{id}")
    public HttpResult<Boolean> restPasswsord( @PathVariable String id ){
        return new HttpResult<>(sysUserService.restPasswsord(id, "123456"));
    }

    /**
     * 修改密码
     * @param userEntity 用户信息
     * @return
     */
    @PutMapping(value = "/modifyPassword")
    public HttpResult<Boolean> modifyPassword( @RequestBody SysUserEntity userEntity ){
        return new HttpResult<>(sysUserService.restPasswsord(userEntity.getId(), userEntity.getPassword()));
    }

    /**
     * 查找用户信息
     * @param id 用户ID
     * @return
     */
    @GetMapping(value = "/findDto/{id}")
    public HttpResult<UserDto> findDtoById( @PathVariable String id ){
        return new HttpResult<>(sysUserService.findDtoById(id));
    }

    /**
     * 校验用户名是否存在
     * @param userEntity 用户信息
     * @return
     */
    @PostMapping(value = "/checkUserName")
    public HttpResult<Boolean> checkUserName( @RequestBody SysUserEntity userEntity ){
        return new HttpResult<>(sysUserService.checkUserName(userEntity));
    }

    /**
     * 校验用户原始密码是否正确
     * @param userEntity userEntity
     * @return true 原始密码不正确
     */
    @PostMapping(value = "/checkPassword")
    public HttpResult<Boolean> checkPassword( @RequestBody SysUserEntity userEntity ){
        return new HttpResult<>(sysUserService.checkPassword(userEntity));
    }

    /**
     * 根据用户名称获取用户信息
     * @param username 用户名称
     * @return
     */
    @GetMapping(value = "/findByUsername")
    public HttpResult<SysUserEntity> findByUsername( @NotEmpty(message = "用户名不能为空") String username ){
        return new HttpResult<>( sysUserService.findByUsername(username) );
    }

    /**
     * 根据用户名称获取用户vo信息
     * @param username 用户名称
     * @return 用户vo
     */
    @GetMapping("/findUserVoByUsername/{username}")
    public UserVo findUserVoByUsername(@PathVariable("username") String username){
        return sysUserService.findUserVoByUsername(username);
    }

    /**
     * 获取用户登录信息
     * @param userVo 用户vo
     * @return 用户登录信息
     */
    @GetMapping("/info")
    public HttpResult<UserInfo> info( UserVo userVo ){
        return new HttpResult<>( sysUserService.info(userVo) );
    }

    /**
     * 上传用户头像
     * @param uploadFile
     * @return
     */
    @PostMapping("/uploadPhoto")
    public HttpResult<String> uploadPhoto( @RequestParam(value = "file") MultipartFile uploadFile ){
        HttpResult<String> result = new HttpResult<>();
        try {
            String fileName = UUIDUtil.value() + "_" + uploadFile.getOriginalFilename();
            InputStream is = uploadFile.getInputStream();

            if( FtpFileUtil.uploadFile(userPhotoPath, fileName, is) ) result.setResult( userPhotoPath + "/" + fileName);
            else result.setIsSuccess(false);
        } catch (IOException e) {
            log.error("uploadPhoto error : ", e);
            result.setIsSuccess(false);
        }
        return result;
    }

    /**
     * 导入用户信息
     * @return
     */
    @PostMapping("/importUser")
    public HttpResult<Void> importUser(  @RequestParam(value = "file" ) MultipartFile multipartFile ){
        HttpResult<Void> result = new HttpResult<>();
        System.out.println( multipartFile.getOriginalFilename() );
        return result;
    }
}
