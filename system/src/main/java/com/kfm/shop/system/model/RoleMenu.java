package com.kfm.shop.system.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 
 * @TableName sys_role_menu
 */
@TableName(value ="sys_role_menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RoleMenu implements Serializable {
    /**
     * 角色id
     */
    @TableId
    private Integer roleId;

    /**
     * 菜单id
     */
    @TableField
    private Integer menuId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}