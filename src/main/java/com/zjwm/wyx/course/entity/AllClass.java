package com.zjwm.wyx.course.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllClass implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private int wid;
	
}
