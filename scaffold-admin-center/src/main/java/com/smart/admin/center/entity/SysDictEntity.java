package com.smart.admin.center.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 字典
 *
 * @author guwenchang
 * @date 2019-05-23 16:46:55
 */
@Data
@TableName("t_sys_dict")
public class SysDictEntity implements Serializable{
    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 数据值
     */
    private String value;
    /**
     * 标签名
     */
    private String label;
    /**
     * 类型
     */
    private String type;
    /**
     * 描述
     */
    private String description;
    /**
     * 排序（升序）
     */
    private Integer sort;
    /**
     * 字典状态 1 启用，2 禁用
     */
    private Integer status;
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
