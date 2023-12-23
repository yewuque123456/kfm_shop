package com.kfm.comm.service;

import cn.hutool.core.lang.tree.Tree;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.kfm.shop.SystemSpringBootApplication;
import com.kfm.shop.system.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = SystemSpringBootApplication.class)
class MenuServiceTest {
   @Autowired

   private MenuService menuService;

   @Test
    public void testList() throws JsonProcessingException {
       List<Tree<Integer>> trees  = menuService.treeList(null);

       JsonMapper jsonMapper = new JsonMapper();
       System.out.println(jsonMapper.writeValueAsString(trees));
   }

}