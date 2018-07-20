package com.wang.jmonkey.cloud.common.utils;

import com.wang.jmonkey.cloud.common.model.BaseTreeNode;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 树形结构构造器
 * @Auther: HeJiawang
 * @Date: 2018/7/3
 */
public class TreeUtil {

    /**
     * 构建树形结构数据
     * @param treeNodes
     * @param root
     * @param <T>
     * @return
     */
    public static <T extends BaseTreeNode> List<T> bulid(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<>();

        treeNodes.forEach( treeNode -> {
            if ( root == treeNode.getParentId() || StringUtils.equals("", treeNode.getParentId()) ) trees.add(treeNode);
            treeNodes.forEach(it -> { if ( StringUtils.equals(it.getParentId(), treeNode.getId()) ) treeNode.addChildren(it); });
        });

        return trees;
    }
}
