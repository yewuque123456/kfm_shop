package com.kfm.shop.system.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.kfm.shop.system.model.Menu;
import com.kfm.shop.system.model.Role;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString(callSuper = true)
public class RoleDTO  extends Role implements Serializable {

    @TableField(exist = false)
    private List<Menu> menus;

}
