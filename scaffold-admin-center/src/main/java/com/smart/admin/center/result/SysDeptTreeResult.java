package com.smart.admin.center.result;

import com.smart.starter.core.model.TreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门树
 * @author guwenchang
 * @date 2019-05-23
 */
@Data
public class SysDeptTreeResult extends TreeNode {

    /**
     * 部门名称
     */
    private String name;
}
