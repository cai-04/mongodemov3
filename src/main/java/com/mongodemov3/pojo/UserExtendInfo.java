package com.mongodemov3.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class UserExtendInfo {
    @Id
    @ApiModelProperty(value = "用户id", example = "1")
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("拓展信息创建时间")
    private Date exdateTime;//拓展信息创建时间
    @ApiModelProperty("身份证")
    private String codeNum;//身份证
    @ApiModelProperty("电话")
    private String phone;//电话
    @ApiModelProperty("学校")
    private String school;//学校
    @ApiModelProperty("住址")
    private String address;//住址
}
