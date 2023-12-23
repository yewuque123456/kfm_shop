package com.kfm.shop.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kfm.shop.system.model.Role;
import com.kfm.shop.system.model.dto.RoleGrantMenuDTO;

/**
* @author Administrator
* @description 针对表【sys_role】的数据库操作Service
* @createDate 2023-12-19 19:19:57
*/
public interface RoleService extends IService<Role> {
       boolean grant(RoleGrantMenuDTO roleGrantMenuDTO);
}
