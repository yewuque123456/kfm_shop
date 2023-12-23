package com.kfm.comm.mapper;

import com.kfm.shop.SystemSpringBootApplication;
import com.kfm.shop.system.mapper.MenuMapper;
import com.kfm.shop.system.mapper.UserMapper;
import com.kfm.shop.system.model.Menu;
import com.kfm.shop.system.model.dto.RoleDTO;
import com.kfm.shop.system.model.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = {SystemSpringBootApplication.class})
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;


    @Test
     public void test(){

    }
    @Test
    void selectUserIdWithRole() {
        UserDTO userDTOS  = userMapper.selectUserByIdWithRole(2);
        System.out.println(userDTOS);


        List<RoleDTO> roles = userDTOS.getRoles();
        //获取所有的id
        List<Integer> ids = roles.stream().map((role) -> role.getId()).toList();
        List<Menu> menus =  menuMapper.selectMenusWithRoleIds(ids);
        System.out.println(menus);
    }

}