package com.horse.identifier.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="统一返回对象")
public class ResponseWrapper<T> {
    @ApiModelProperty(value = "执行结果")
    private boolean isSuccess = true;
    @ApiModelProperty(value = "执行提示信息")
    private String msg;
    @ApiModelProperty(value = "数据对象")
    private T Data;
}