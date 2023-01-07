package com.mongodemov3.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collation = "logdbs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel

public class Log {
    @ApiModelProperty(value = "日志id")
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    private Date date;//创建时间
    @ApiModelProperty("source")
    private String source;
    @ApiModelProperty("level")
    private String level;
    @ApiModelProperty("logger")
    private String logger;
    @ApiModelProperty("thread")
    private String thread;
    @ApiModelProperty("message")
    private String message;
}

