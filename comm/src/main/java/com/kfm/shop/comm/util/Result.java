package com.kfm.shop.comm.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Result extends HashMap<String, Object> implements Serializable {
    private static Result getInstance(Integer code) {
        return new Result().put("timestamp",System.currentTimeMillis()).put("code",code);
    }
    public static Result ok() {
        return getInstance(200).put("message","操作成功");
    }
    public static Result ok(Object data) {
        return getInstance(200).put("message","操作成功");
    }
    public static Result error(String message) {
        return getInstance(500).put("message",message);
    }

    @Override
    public Result put(String key,Object value){
        super.put(key, value);
        return this;
    }
}
