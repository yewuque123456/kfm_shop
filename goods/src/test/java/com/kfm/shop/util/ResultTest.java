package com.kfm.shop.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    public void test(){
        Result ok = Result.ok().put("timestamp",System.currentTimeMillis());
        JsonMapper jsonMapper = new JsonMapper();
        try{
            String s  = jsonMapper.writeValueAsString(ok);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}