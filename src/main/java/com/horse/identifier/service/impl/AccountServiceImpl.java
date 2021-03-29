package com.horse.identifier.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.horse.identifier.entity.User;
import com.horse.identifier.mapper.UserMapper;
import com.horse.identifier.service.AccountService;
import com.horse.identifier.util.constant.DeviceTypeEnum;
import com.horse.identifier.util.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl extends ServiceImpl<UserMapper, User> implements AccountService {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String Login(String userName, String pwd, DeviceTypeEnum deviceTypeEnum) throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_no", userName);
        User user = this.getOne(queryWrapper);
        if (user == null)
            throw new Exception(String.format("员工{0}不存在！", userName));
        if (!user.getPassword().equalsIgnoreCase(pwd))
            throw new Exception(String.format("密码错误！"));
        if (redisTemplate.hasKey(userName + deviceTypeEnum))
            throw new Exception(String.format("用户已登录！"));

        String token = tokenService.generateToken(user, deviceTypeEnum);

        //小程序客户端12小时会话时间,后续改为配置
        if (deviceTypeEnum == DeviceTypeEnum.WX_Small_Program)
            redisTemplate.opsForValue().set(userName + deviceTypeEnum, token, 12, TimeUnit.HOURS);

        //PC端30分钟会话时间,后续改为配置
        if (deviceTypeEnum == DeviceTypeEnum.Browser)
            redisTemplate.opsForValue().set(userName + deviceTypeEnum, token, 30, TimeUnit.MINUTES);

        return token;
    }


    @Override
    public void LoginOut(String userName, DeviceTypeEnum deviceTypeEnum) {

    }
}
