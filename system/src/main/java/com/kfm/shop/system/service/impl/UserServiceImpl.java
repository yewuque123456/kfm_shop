package com.kfm.shop.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.shop.system.model.User;
import com.kfm.shop.system.model.UserRole;
import com.kfm.shop.system.service.UserRoleService;
import com.kfm.shop.system.service.UserService;
import com.kfm.shop.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2023-12-19 19:19:57
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private UserRoleService userRoleService;

    @Override
    @Transactional
    public boolean save(User entity) {
        //保存用户信息，自增长主键会被设置到 实体中
        boolean save = super.save(entity);
        Integer [] rolesIds  = entity.getRoleIds();
        //没有选择角色
        if(ObjectUtils.isEmpty(rolesIds)) {
            return save;
        }
        //保存用户信息
        List<UserRole> userRoles = new ArrayList<>();
        for(Integer roleId: rolesIds) {
            userRoles.add(new UserRole().setUserId(entity.getId()).setRoleId(roleId));
        }
        //批量保存用户角色信息
        boolean b= userRoleService.saveBatch(userRoles);
        return save && b;

    }

}




