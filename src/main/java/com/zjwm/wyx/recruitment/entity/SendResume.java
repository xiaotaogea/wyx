package com.zjwm.wyx.recruitment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 投递简历记录
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendResume implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	//用户
	private int userId;
	//简历id
	private int resumeId;
	//简历名称
	private String resumeName;
	//公司id
	private int companyId;
	//公司名称
	private String companyName;
	//岗位id
	private int jobId;
	//岗位名称
	private String jobName;
	private String welfare;//待遇
	//类型 ：1为投递成功2为已被查看3为邀请面试4为已拒绝
	private int type;
	//状态：1为上架2为下架
	private int status;
	private int createTime;
}
