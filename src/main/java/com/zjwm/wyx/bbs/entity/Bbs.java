package com.zjwm.wyx.bbs.entity;

import com.zjwm.wyx.login.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bbs implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int cateId;//栏目主键
	private int type;// 帖子类型：1普通贴2悬赏贴
	private int fen;// 悬赏积分
	private String title;// 标题
	private String content;// 内容

	private int uid;
	private int pv;// 点击量
	private int status;// 状态：1显示0隐藏
	private String lable;//标签
	private int createTime;
	
	private UserEntity userEntity;//用户
	private BbsReply bbsReply;//参与
	private BbsCategory bbsCategory;//帖子种类

}
