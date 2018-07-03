package com.wang.jmonkey.cloud.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 树形结构父类
 * @Auther: HeJiawang
 * @Date: 2018/7/3
 */
@Data
@Accessors(chain = true)
public abstract class BaseTreeNode extends BaseVo {

    protected String id;
    protected String parentId;
    protected List<BaseTreeNode> children = new ArrayList<>();

    /**
     * 添加子节点
     * @param node
     */
    public void addChildren(BaseTreeNode node) {
        children.add(node);
    }
}
