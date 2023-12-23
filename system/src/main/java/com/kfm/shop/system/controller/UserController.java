package com.kfm.shop.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.kfm.shop.comm.util.Result;
import com.kfm.shop.system.annotation.Permission;
import com.kfm.shop.system.model.User;
import com.kfm.shop.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 *
 * 用户管理 controller
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    @PostMapping("/login")
    @ApiOperation(value = "用户登录",notes = "用户登录")
    public Result Login(@ApiParam(name = "user",value = "用户信息",required = true)@RequestBody User user){
//        //根据用户名查询个人信息
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("username",user.getUsername());
//        queryWrapper.eq("password",user.getPassword());
//        User user1 = userService.getOne(queryWrapper);
//        if(ObjectUtils.isEmpty(user)) {
//            return Result.error("用户名或者密码错误");
//        }
//       //TODO 生成token
//        String token = new Random().nextLong() + "";
        String token = userService.login(user);

        //权限保存到用户中
        return  Result.ok("登录成功").put("token",token);

    }

    @GetMapping
    @ApiOperation(value = "获取所有用户信息",notes = "获取所有用户信息")
    @Permission("system:user")
    public Result getGoods(@ApiParam(name ="user",value = "用户信息",required = true) User user){
        //构建查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(user.getName())) {
            queryWrapper.like("user", user.getName());
        }
        if (!ObjectUtils.isEmpty(user.getPassword())){
            queryWrapper.eq("password",user.getPassword());
        }
        // 分页
        PageHelper.startPage(user.getPage() ,user.getSize());
        return Result.ok(userService.list(queryWrapper));
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取用户信息", notes = "根据id获取用户信息")
    @Permission("system:user")
    public Result getGoodsById(@ApiParam(name = "id", value = "用户id", required = true) @PathVariable Integer id) {
        return Result.ok(userService.getById(id));
    }

    @PostMapping("/edit")
    @ApiOperation(value = "根据id修改用户信息", notes = "根据id修改用户信息")
    @Permission("system:user")
    public Result updateGoodsById(@ApiParam(name = "menu", value = "用户信息", required = true)@RequestBody User user) {
     return Result.ok(userService.updateById(user));

    }


    @PutMapping("/add")
    @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
    @Permission("system:user")
    public Result addGoods(@ApiParam(name = "user", value = "用户信息", required = true)@RequestBody User user) {
        return Result.ok(userService.save(user));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除用户信息", notes = "根据id删除用户信息")
    @Permission("Role_ADMIN")
    public Result deleteGoodsById(@ApiParam(name = "id", value = "用户id", required = true) @PathVariable Integer id) {
        return Result.ok(userService.removeById(id));
    }
}

