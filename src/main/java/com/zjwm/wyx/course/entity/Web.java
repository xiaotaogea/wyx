package com.zjwm.wyx.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Web implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name; // 网站名

	private UserWClass userWClasses;
	private AllClass allClass;
}
