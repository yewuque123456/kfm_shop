package com.kfm.shop.system.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.kfm.shop.system.model.User;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString(callSuper = true)
public class UserDTO  extends User  implements Serializable {
    @TableField(exist = false)
    private List<RoleDTO> roles;
}
