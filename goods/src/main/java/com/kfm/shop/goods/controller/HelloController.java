package com.kfm.shop.goods.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "HelloController",description = "测试controller")
public class HelloController {
    @GetMapping("/hello")
    @ApiOperation(value = "hello接口",notes = "测试接口")
    @ApiResponses(
        @ApiResponse(code = 200,message = "成功",response = String.class,
        examples = @Example(
                @ExampleProperty(value = "hello world",mediaType = "application/text")
            )
        ))
    public String hello() {
        return "hello world";
    }
    @PostMapping("/hello")
    public String helloPost(String name) {
        return "hello" + name;
    }
}
