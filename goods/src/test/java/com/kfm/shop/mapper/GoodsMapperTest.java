package com.kfm.shop.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kfm.shop.goods.mapper.GoodsMapper;
import com.kfm.shop.goods.model.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

 @SpringBootTest
class GoodsMapperTest {
      @Autowired
      private GoodsMapper goodsMapper;

      @Test
     public void test() {
          System.out.println(goodsMapper);
          Assert.notNull(goodsMapper, "goodsMapper is null");
      }
      @Test
     public void selectAll() {
           QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
           queryWrapper.eq("name","苹果");
          List<Goods> goods  = goodsMapper.selectList(queryWrapper);
          System.out.println(goods);
          assertEquals(0,goods.size());
       }
       @Test
     public void insert() {
           Goods goods = new Goods();
           goods.setName("桔子");
           goods.setPrice(790L);
           goods.setNum(200);
          int insert = goodsMapper.insert(goods);
           assertEquals(1,insert);
       }
       @Test
      public void update() {
           Goods goods = new Goods();
           goods.setId(1);
           goods.setName("香蕉");
           int update = goodsMapper.updateById(goods);
           Assert.notNull(goods, "goods is null");
       }
       @Test
       public void delete() {
           int delete = goodsMapper.deleteById(1);
           Assert.notNull(delete, "delete is null");
       }
}