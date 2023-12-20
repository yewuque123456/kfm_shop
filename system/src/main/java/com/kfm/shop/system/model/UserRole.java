package com.kfm.shop.system.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 
 * @TableName sys_user_role
 */
@TableName(value ="sys_user_role")
@Data
@Accessors(chain = true)
public class UserRole implements Serializable {
    /**
     * 用户id
     */
    @TableId
    private Integer userId;

    /**
     * 角色id
     */
    @TableField
    private Integer roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}