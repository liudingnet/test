package com.horse.identifier.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="图片验证结果")
public class ImgValidation {
    @ApiModelProperty(value = "是否已打印")
    private boolean isPrinted;
    @ApiModelProperty(value = "是否已贴码")
    private boolean isStuck;
    @ApiModelProperty(value = "图片地址")
    private String imgUrl;
    @ApiModelProperty(value = "机型")
    private String modelId;
    @ApiModelProperty(value = "机号")
    private String serialNo;
}
