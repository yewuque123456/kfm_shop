package com.kfm.comm.ex;

import com.kfm.shop.util.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e) {
        if (StringUtils.hasText(e.getMessage())){
            return Result.error(e.getMessage());
        }
    return Result.error("服务器发生错误，请重试");
   }
}
