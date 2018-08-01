package com.wang.jmonkey.cloud.modules.upms.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.cloud.common.model.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @Description: 字典类型
 * @Auther: HeJiawang
 * @Date: 2018/8/1
 */
@Data
@Accessors(chain = true)
@TableName("sys_dict_type")
public class SysDictTypeEntity extends BaseEntity<SysDictTypeEntity> {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 字典类型
     */
    @NotEmpty(message = "字典类型不能为空")
    @Length(max = 20, message = "字典类型长度不能超过20")
    private String type;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
