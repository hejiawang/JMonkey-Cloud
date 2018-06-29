package com.wang.jmonkey.cloud.common.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.wang.jmonkey.cloud.common.model.enums.RecordStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Description: 基础实体
 * @Auther: HeJiawang
 * @Date: 2018/4/13
 */
@Data
@Accessors(chain = true)
public abstract class BaseEntity<T extends BaseEntity> extends Model<T> {

    /**
     * 创建日期
     */
    protected Date createDate;

    /**
     * 创建人
     */
    protected String createBy;

    /**
     * 最后修改日期
     */
    protected Date updateDate;

    /**
     * 最后修改人
     */
    protected String updateBy;

    /**
     * 备注
     */
    protected String remark;

    /**
     * 记录状态
     */
    @TableLogic
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    protected RecordStatusEnum deleteFlag;
}
