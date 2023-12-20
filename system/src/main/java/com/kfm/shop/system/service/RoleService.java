package com.kfm.shop.system.service;

import com.kfm.shop.system.model.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_role】的数据库操作Service
* @createDate 2023-12-19 19:19:57
*/
public interface RoleService extends IService<Role> {
       List<Role> selectRoleByUserId(Integer userId);
}
