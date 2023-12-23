package com.kfm.shop.system.interceptor;

import com.kfm.shop.comm.ex.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
        //获取请求头中的token
        String header = request.getHeader("Authorization");
          if(StringUtils.hasText(header)){
              Object o = redisTemplate.opsForValue().get(header);
              if(ObjectUtils.isEmpty(o)) {
                  throw new ServiceException("登录已经过期");
              }
              return true;
          }
         throw new ServiceException("请先登录");
    }
}