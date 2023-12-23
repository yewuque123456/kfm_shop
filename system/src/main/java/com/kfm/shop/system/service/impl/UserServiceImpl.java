package com.kfm.shop.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.shop.comm.ex.ServiceException;
import com.kfm.shop.system.mapper.MenuMapper;
import com.kfm.shop.system.mapper.UserMapper;
import com.kfm.shop.system.mapper.UserRoleMapper;
import com.kfm.shop.system.model.Menu;
import com.kfm.shop.system.model.Role;
import com.kfm.shop.system.model.User;
import com.kfm.shop.system.model.UserRole;
import com.kfm.shop.system.service.UserRoleService;
import com.kfm.shop.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    @Transactional
    public boolean save(User entity) {
        //保存用户信息，自增长主键会被设置到 实体中
        boolean save = super.save(entity);
        Integer[] rolesIds = entity.getRoleIds();
        //没有选择角色
        if (ObjectUtils.isEmpty(rolesIds)) {
            return save;
        }
        //保存用户信息
        List<UserRole> userRoles = new ArrayList<>();
        for (Integer roleId : rolesIds) {
            userRoles.add(new UserRole().setUserId(entity.getId()).setRoleId(roleId));
        }
        //批量保存用户角色信息
        boolean b = userRoleService.saveBatch(userRoles);
        return save && b;
    }

      @Override
      public String login(User user) {
            //根据用户名查询用户信息
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username",user.getUsername());
            queryWrapper.eq("password",user.getPassword());
             user = getOne(queryWrapper);
            if(ObjectUtils.isEmpty(user)) {
                throw new ServiceException("用户名或密码错误");
            }
            //TODO  生成token
          String token = new Random().nextLong() + "";
            //保存用户信息
          redisTemplate.opsForValue().set(token,user);


          //存用户权限信息
          //1. 根据用户id 查询角色权限
          List<Role> roles = userRoleMapper.selectRoleByUserId(user.getId());
          // 2.根据角色信息查询权限想信息
          List<Integer> ids =roles.stream().map((role) -> role.getId()).toList();
         if(ObjectUtils.isEmpty(ids)) {
             return token;
         }
         List<Menu> menus = menuMapper.selectMenusWithRoleIds(ids);

         //3.将所有权限存到list集合中
          List<String> permissions = new ArrayList<>();
          for(Role role : roles) {
              permissions.add("ROLE_" + role.getRoleCode().toUpperCase());
          }
          for(Menu menu: menus) {
              permissions.add(menu.getPermissionCode());
          }
          //存到redis中
          redisTemplate.opsForValue().set(token + "_permissions",permissions);
          return token;
    }
}




