package com.kfm.shop.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kfm.shop.comm.model.BaseModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
@Data
@ToString(callSuper = true)
public class Menu extends BaseModel implements Serializable {
    /**
     * 菜单id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 权限编码
     */
    private String permissionCode;

    /**
     * 父菜单id
     */
    private Integer parentId;

    /**
     * 菜单url
     */
    private String url;

    /**
     * 类型 1:菜单 2:按钮
     */
    private Integer type;


}