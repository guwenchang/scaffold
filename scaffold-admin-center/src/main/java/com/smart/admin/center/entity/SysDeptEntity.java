package com.smart.admin.center.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;


/**
 * 部门 实体
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
@TableName("t_sys_dept")
public class SysDeptEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 部门编码
     */
    private String code;

    /**
     * 父部门编码
     */
    private String parentCode;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除 0 正常，1 删除
     */
    @TableLogic
    private Boolean delFlag;


}
