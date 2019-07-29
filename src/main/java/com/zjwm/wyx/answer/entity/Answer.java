package com.zjwm.wyx.answer.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	@ApiModelProperty("网站id")
	private int wid;
    @ApiModelProperty("所属全部课程属性id")
	private int acid;
    @ApiModelProperty("课程id")
	private int clid;
    @ApiModelProperty("视频id")
	private int vid;
    @ApiModelProperty("用户id")
	private int uid;
    @ApiModelProperty("内容")
	private String content;
    @ApiModelProperty("回复id")
	private int pid;
    @ApiModelProperty("视频播放时长")
	private String vTime;

	private int addTime;

}
