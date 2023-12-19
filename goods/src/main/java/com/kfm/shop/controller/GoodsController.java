package com.kfm.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.kfm.shop.model.Goods;
import com.kfm.shop.service.GoodsService;
import com.kfm.shop.util.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping
    @ApiOperation(value = "获取所有商品信息",notes = "获取所有商品信息")
    public Result getGoods(@ApiParam(name = "goods",value = "商品信息")Goods goods) {
        //构建查询条件
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        if(!ObjectUtils.isEmpty(goods.getName())) {
            queryWrapper.like("name",goods.getName());
        }
        if(!ObjectUtils.isEmpty(goods.getStatus())) {
            queryWrapper.eq("status",goods.getStatus());
    }
        //分页
        PageHelper.startPage(goods.getPage(),goods.getSize());
       return Result.ok(goodsService.list(queryWrapper));
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取商品信息",notes = "根据id获取商品信息")
    public Result getGoodsById(@ApiParam(name = "goods",value = "商品信息",required = true) @PathVariable Integer id){
        return Result.ok(goodsService.getById(id));
    }
    @PostMapping("/edit")
    @ApiOperation(value = "根据id获取商品信息",notes = "根据id获取商品信息")
    public Result updateGoods(@ApiParam(name = "goods",value = "商品信息",required = true) Goods goods){
        return Result.ok(goodsService.updateById(goods));
    }
    @PutMapping ("/add")
    @ApiOperation(value = "新增商品信息",notes = "新增商品信息")
    public Result addGoods(@ApiParam(name = "goods",value = "商品信息",required = true) Goods goods){
        return Result.ok(goodsService.save(goods));
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除商品信息",notes = "根据id删除商品信息")
    public Result deleteGoods(@ApiParam(name = "id",value = "id",required = true) @PathVariable Integer id){
        return Result.ok(goodsService.removeById(id));
    }

}
