package com.kfm.shop.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.kfm.shop.comm.util.Result;
import com.kfm.shop.system.model.Role;
import com.kfm.shop.system.model.dto.RoleGrantMenuDTO;
import com.kfm.shop.system.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 *
 * 角色管理 controller
 */


@RestController
@RequestMapping("/role")
@Api(tags = "角色管理")
public class RoleController {
    @Autowired
    private RoleService roleService;


    @GetMapping
    @ApiOperation(value = "获取所有角色信息",notes = "获取所有角色信息")
    public Result getGoods(@ApiParam(name ="role",value = "角色信息",required = true) Role role ){
        //构建查询条件
       QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(role.getName())) {
           queryWrapper.like("name", role.getName());
        }
        if (!ObjectUtils.isEmpty(role.getRoleCode())){
           queryWrapper.eq("status", role.getRoleCode());
        }
        // 分页
        PageHelper.startPage(role.getPage(),role.getSize());
        return Result.ok(roleService.list(queryWrapper));
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取角色信息", notes = "根据id获取角色信息")
    public Result getGoodsById(@ApiParam(name = "id", value = "角色id", required = true) @PathVariable Integer id) {
        return Result.ok(roleService.getById(id));
    }


    @PostMapping("/edit")
    @ApiOperation(value = "根据id修改角色信息", notes = "根据id修改角色信息")
    public Result updateGoodsById(@ApiParam(name = "menu", value = "角色信息", required = true) Role role) {
        return Result.ok(roleService.updateById(role));
    }


    @PutMapping("/add")
    @ApiOperation(value = "新增角色信息", notes = "新增角色信息")
    public Result addGoods(@ApiParam(name = "role", value = "角色信息", required = true) Role role) {
        return Result.ok(roleService.save(role));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除角色信息", notes = "根据id删除角色信息")
    public Result deleteGoodsById(@ApiParam(name = "id", value = "角色id", required = true) @PathVariable Integer id) {
        return Result.ok(roleService.removeById(id));
    }

    @PostMapping("/grant")
    @ApiOperation(value = "根据设置角色权限", notes = "根据id设置角色权限")
    public Result grantMenu(@RequestBody RoleGrantMenuDTO roleGrantMenuDTO) {
        return Result.ok(roleService.grant(roleGrantMenuDTO));
    }
}

