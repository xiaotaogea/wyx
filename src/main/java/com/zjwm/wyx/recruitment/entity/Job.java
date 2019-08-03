package com.zjwm.wyx.recruitment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private int companyId;//公司id
	private String jobName;//岗位名称
	private int workArea;//工作区域
	private int number;//招聘人数
	private int workYear;//工作年限

	private int education;//学历
	private int emolumentLow;//最低薪水
	private int emolumentHigh;//最高薪水

	private String intro;//岗位简介
	private String requirement;//岗位要求
	private String welfare;//福利名称

	private int checkNum;//查看数量
	private int collectNum;//收藏数量
	
	private int state;//状态
	private int createTime;

	private Company company;
	private List<Welfare> welfares;//福利集合




}
