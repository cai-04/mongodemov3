package com.mongodemov3.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class Logistics {
    @ApiModelProperty(value = "订单id", example = "1")
    private int orderId;//订单id
    @ApiModelProperty("操作")
    private String operation;//操作
    @ApiModelProperty("操作员")
    private String operator;//操作员
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @ApiModelProperty("操作时间")
    private Date operationTime;//操作时间
    @ApiModelProperty("地址")
    private String address;//地址
    @ApiModelProperty("备注细节")
    private String details;//备注细节
}

