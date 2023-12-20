package com.kfm.shop.service;

import com.kfm.shop.goods.model.Goods;
import com.kfm.shop.goods.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GoodsServiceTest {
    @Autowired
    private GoodsService goodsService;

    @Test
    public void test() {
        assertNotNull(goodsService);
    } @Test
    public void find() {
        List<Goods> list = goodsService.list();
        System.out.println(list);
        assertEquals(1,list.size());
    }
    @Test
    public void save(){
        Goods goods = new Goods();
        goods.setName("测试商品");
        goodsService.save(goods);
    }
}
