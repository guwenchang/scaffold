package com.smart.starter.core.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guwenchang
 * @date 2019-05-23
 */
@Data
public class TreeNode {


    /**
     * 节点编码
     */
    private String code;
    /**
     * 父节点编码
     */
    private String parentCode;
    /**
     * 子节点集合
     */
    private List<TreeNode> children = new ArrayList<TreeNode>();

    public void add(TreeNode node) {
        children.add(node);
    }
}
