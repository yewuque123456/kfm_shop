package com.kfm.shop.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kfm.shop.comm.model.BaseModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName sys_role
 */
@TableName(value ="sys_role")
@Data
public class Role extends BaseModel implements Serializable {
    /**
     * 角色id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String roleCode;

    @TableField(exist = false)
    private static final long serialVersionUID =1l;
}