package com.kfm.comm.util;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;

@Data
@Accessors(chain = true)
public class Result extends HashMap<String, Object> implements Serializable {

    private static com.kfm.comm.util.Result getInstance(Integer code){
        return new com.kfm.comm.util.Result().put("timestamp", System.currentTimeMillis()).put("code", code);
    }

    public static com.kfm.comm.util.Result ok() {
        return getInstance(200).put("message", "操作成功");
    }

    public static com.kfm.comm.util.Result ok(Object data) {
        return getInstance(200).put("message", "操作成功").put("data", data);
    }


    public static com.kfm.comm.util.Result error(String message) {
        return getInstance(500).put("message", message);
    }


    @Override
    public com.kfm.comm.util.Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
