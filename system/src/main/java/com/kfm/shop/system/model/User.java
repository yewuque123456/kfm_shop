package com.kfm.shop.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kfm.shop.comm.model.BaseModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Data
@ToString
public class User extends BaseModel implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 姓名
     */
    private String name;

    @TableField(exist = false)

    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private List<Role> roles;

     @TableField(exist = false)
    private Integer [] roleIds;

}