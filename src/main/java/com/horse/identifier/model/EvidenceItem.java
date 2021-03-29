package com.horse.identifier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description="贴码清单明细")
public class EvidenceItem {
    @ApiModelProperty(value = "贴码时间")
    private String createTime;
    @ApiModelProperty(value = "贴码地址")
    private String address;
    @ApiModelProperty(value = "贴码价格")
    private Number price;
    @ApiModelProperty(value = "机型")
    private String modelId;
    @ApiModelProperty(value = "机号")
    private String serialNo;
}
