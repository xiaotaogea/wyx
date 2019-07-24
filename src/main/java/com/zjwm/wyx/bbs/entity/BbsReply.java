package com.zjwm.wyx.bbs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BbsReply implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int userId;//用户主键
	private int bbsId;// 帖子主键
	private int replyId;// 回复ID
	private String content;// 内容
	private int status;// 状态：1显示0隐藏
	private int adopt;//采纳：1是0否

	private int createTime;
	

}
