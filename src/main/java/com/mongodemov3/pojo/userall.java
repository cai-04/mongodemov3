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
public class userall {
    //此实体类是user、UserExtendInfo的完整体现用于展示信息
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("基本信息创建时间")
    private Date createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("拓展信息创建时间")
    private Date ExdateTime;
    @Id
    @ApiModelProperty(value = "用户ID", example = "1")
    private int id;
    @ApiModelProperty("用户姓名")
    private String name;
    @ApiModelProperty("用户昵称")
    private String nickname;
    @ApiModelProperty(value = "年龄", example = "1")
    private int age;
    @ApiModelProperty("性别")
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("拓展信息创建时间")
    private Date exdateTime;
    @ApiModelProperty("身份证")
    private String codeNum;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("学校")
    private String school;
    @ApiModelProperty("住址")
    private String address;
}
