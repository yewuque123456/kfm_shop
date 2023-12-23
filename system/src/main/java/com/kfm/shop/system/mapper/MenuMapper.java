package com.kfm.shop.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kfm.shop.system.model.Menu;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_menu】的数据库操作Mapper
* @createDate 2023-12-19 19:19:57
* @Entity  com.kfm.comm.model.Menu
*/
public interface MenuMapper extends BaseMapper<Menu> {

     List<Menu> selectMenusWithRoleIds( List<Integer> ids);


}




