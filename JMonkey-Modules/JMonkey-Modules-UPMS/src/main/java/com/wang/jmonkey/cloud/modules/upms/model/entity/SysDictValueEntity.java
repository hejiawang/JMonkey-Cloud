package com.wang.jmonkey.cloud.modules.upms.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.cloud.common.model.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * @Description: 字典值
 * @Auther: HeJiawang
 * @Date: 2018/8/1
 */
@Data
@Accessors(chain = true)
@TableName("sys_dict_value")
public class SysDictValueEntity extends BaseEntity<SysDictValueEntity> {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 字典类型ID
     */
    @NotEmpty(message = "字典类型ID不能为空")
    private String typeId;

    /**
     * 字典标签
     */
    @NotEmpty(message = "字典标签不能为空")
    @Length(max = 20, message = "字典标签长度不能超过20")
    private String lable;

    /**
     * 字典键值
     */
    @NotEmpty(message = "字典键值不能为空")
    @Length(max = 20, message = "字典键值长度不能超过20")
    private String value;

    /**
     * 排序值
     */
    @Range(min = 1, max = 10000, message = "排序值从1-10000")
    private Integer sort;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
