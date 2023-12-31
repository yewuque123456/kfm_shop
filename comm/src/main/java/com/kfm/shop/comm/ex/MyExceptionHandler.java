package com.kfm.shop.comm.ex;
import com.kfm.shop.comm.util.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//处理异常
@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler( Exception.class)
    public Result handleException(Exception e) {
        if(StringUtils.hasText(e.getMessage())) {
            return Result.error(e.getMessage());
        }
        return Result.error("未知异常");
    }
}
