package com.kfm.shop.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kfm.shop.system.model.User;
import com.kfm.shop.system.model.UserRole;

/**
* @author Administrator
* @description 针对表【sys_user_role】的数据库操作Service
* @createDate 2023-12-20 17:29:49
*/
public interface UserRoleService extends IService<UserRole> {

    boolean save(User entity);
}
