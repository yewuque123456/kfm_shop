package com.kfm.shop.system.model.dto;

import lombok.Data;

@Data
public class RoleGrantMenuDTO {
    private Integer roleId;

    private Integer[] menuIds;
}
