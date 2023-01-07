package com.mongodemov3.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class LogBean {
    @ApiModelProperty("日志ID")
    private String id;//日志ID
    @ApiModelProperty(value = "用户ID", example = "1")
    private Integer userId;//用户ID
    @ApiModelProperty("用户姓名")
    private String username;//用户姓名
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    private Date createDate;//创建时间
    @ApiModelProperty("ip")
    private String ip;//ip地址
    @ApiModelProperty("类名")
    private String className;//类名
    @ApiModelProperty("方法名")
    private String method;//方法名
    @ApiModelProperty("请求")
    private String requestURI;//请求
    @ApiModelProperty("响应结果")
    private String responseResults;//响应结果

}
