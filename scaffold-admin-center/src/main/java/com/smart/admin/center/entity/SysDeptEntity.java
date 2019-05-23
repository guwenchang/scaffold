package com.smart.admin.center.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 部门
 *
 * @author guwenchang
 * @date 2019-05-23 15:14:18
 */
@Data
@TableName("t_sys_dept")
public class SysDeptEntity implements Serializable{
    private static final long serialVersionUID=1L;

    /**
     * 部门id
     */
    @TableId(type = IdType.AUTO)
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
    private Boolean delFlag;

}
