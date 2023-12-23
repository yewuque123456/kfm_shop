package com.kfm.shop.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kfm.shop.system.model.Role;
import com.kfm.shop.system.model.UserRole;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_user_role】的数据库操作Mapper
* @createDate 2023-12-20 17:29:49
* @Entity com.kfm.shop.system.model.UserRole
*/
public interface UserRoleMapper extends BaseMapper<UserRole> {
     List<Role> selectRoleByUserId(Integer userId);
}




