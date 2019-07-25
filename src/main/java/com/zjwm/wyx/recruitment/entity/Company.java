package com.zjwm.wyx.recruitment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 课程
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;
	//公司id
	private int companyId;
	//公司名称
	private String companyName;

}
