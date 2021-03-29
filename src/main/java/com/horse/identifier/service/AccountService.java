package com.horse.identifier.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.horse.identifier.entity.User;
import com.horse.identifier.util.constant.DeviceTypeEnum;

public interface AccountService extends IService<User> {
    String Login(String userName, String pwd, DeviceTypeEnum deviceTypeEnum) throws Exception;
    void LoginOut(String userName, DeviceTypeEnum deviceTypeEnum);
}
