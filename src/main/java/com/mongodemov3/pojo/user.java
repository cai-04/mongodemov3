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
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class user {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("基本信息创建时间")
    private Date createDate;//基本信息创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("拓展信息创建时间")
    private Date ExdateTime;//拓展信息创建时间
    @Id
    @ApiModelProperty(value = "用户ID", example = "1")
    private int id;//用户ID
    @ApiModelProperty("用户姓名")
    private String name;//用户姓名
    @ApiModelProperty("用户昵称")
    private String nickname;//用户昵称
    @ApiModelProperty(value = "年龄", example = "1")
    private int age;//年龄
    @ApiModelProperty("性别")
    private String sex;//性别
}


