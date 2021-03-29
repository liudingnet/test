package com.horse.identifier.controller;

import com.horse.identifier.model.ResponseWrapper;
import com.horse.identifier.service.AccountService;
import com.horse.identifier.util.constant.DeviceTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@Api(tags = "登录服务API")
public class LoginController {
    @Autowired
    AccountService accountService;

    @GetMapping("/login")
    @ApiOperation("微信小程序登录验证，成功则返回token，后续访问设置WX_Small_Program_Token")
    public ResponseWrapper<String> wxspLogin(String userName, String pwd){
        try{
            accountService.Login(userName, pwd, DeviceTypeEnum.WX_Small_Program);
        }
        catch(Exception e){

        }
        return new ResponseWrapper<>();
    }

    @GetMapping("/bslogin")
    @ApiOperation("浏览器登录验证，成功则返回token，后续访问设置Browser_Token")
    public ResponseWrapper<String> Login(String userName, String pwd){
        return new ResponseWrapper<>();
    }

    @GetMapping("/logout")
    @ApiOperation("登出微信小程序")
    public ResponseWrapper<String> wxspLoginOut(){
        return new ResponseWrapper<>();
    }

    @GetMapping("/bslogout")
    @ApiOperation("登出浏览器")
    public ResponseWrapper<String> LoginOut(){
        return new ResponseWrapper<>();
    }
}
