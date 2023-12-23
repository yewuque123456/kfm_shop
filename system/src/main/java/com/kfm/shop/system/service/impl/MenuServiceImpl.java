package com.kfm.shop.system.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.lang.tree.parser.NodeParser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.shop.system.mapper.MenuMapper;
import com.kfm.shop.system.model.Menu;
import com.kfm.shop.system.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_menu】的数据库操作Service实现
* @createDate 2023-12-19 19:19:57
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{
    @Override
    public List<cn.hutool.core.lang.tree.Tree<Integer>> treeList(Menu menu) {
        // 构建查询条件
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(menu) && !ObjectUtils.isEmpty(menu.getName())) {
            queryWrapper.like("name", menu.getName());
        }
        // 排序
        queryWrapper.orderByAsc("parent_id", "order_num");
        // 分页
//        PageHelper.startPage(sysMenu.getPage(), sysMenu.getSize());
        List<Menu> sysMenus = baseMapper.selectList(queryWrapper);


        // 配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        // 设置节点名
//        treeNodeConfig.setChildrenKey("children");
        // 最大递归深度
        treeNodeConfig.setDeep(2);

        /*
            转换器 (含义:找出父节点为字符串零的所有子节点, 并递归查找对应的子节点, 深度最多为 3)
              泛型一: 父节点类型  泛型二: 主键类型  eg: <SysMenu, Integer>

              build 参数：
                1. 所有节点集合
                2. 根节点 id
                3. 配置
                4. 转换器 (被转换的节点, 转换后的节点)

         */
        List<Tree<Integer>> treeNodes = TreeUtil.<Menu, Integer>build(sysMenus, 0, treeNodeConfig,
                new NodeParser<Menu, Integer>() {
                    @Override
                    public void parse(Menu treeNode, Tree<Integer> tree) {
                        tree.setId(treeNode.getId());
                        tree.setParentId(treeNode.getParentId());
                        tree.setName(treeNode.getName());
                        // 扩展属性 ...
                        tree.putExtra("permissionCode", treeNode.getPermissionCode());
                        tree.putExtra("url", treeNode.getUrl());
                        tree.putExtra("type", treeNode.getType());
                        tree.putExtra("orderNum", treeNode.getOrderNum());
                    }
                });

        return treeNodes;
    }
}




