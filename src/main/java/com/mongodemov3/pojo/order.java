package com.mongodemov3.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class order {
    @Id
    @ApiModelProperty(value = "订单id", example = "1")
    private int id;//订单id
    @ApiModelProperty("状态")
    private String status;//状态
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @ApiModelProperty("下单时间")
    private Date orderTime;//下单时间
    @ApiModelProperty("发货人")
    private String shipper;//发货人
    @ApiModelProperty("发货地址")
    private String shippingAdress;//发货地址
    @ApiModelProperty("发货人手机")
    private long shipperPhone;//发货人手机
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @ApiModelProperty("发货时间")
    private Date shipTime;//发货时间
    @ApiModelProperty("接收人")
    private String recevier;//接收人
    @ApiModelProperty("接收地址")
    private String recevierAddress;//接收地址
    @ApiModelProperty("接收人号码")
    private long receviePhone;//接收人号码
    @ApiModelProperty("物流信息")
    private List<Logistics> logistics;//物流信息
}
