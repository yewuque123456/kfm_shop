package com.kfm.shop.system.service;

import com.kfm.shop.system.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【sys_user】的数据库操作Service
* @createDate 2023-12-19 19:19:57
*/
public interface UserService extends IService<User> {
     User login(User user) throws Exception;
}
