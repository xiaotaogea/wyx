package com.zjwm.wyx.exam.entity;

import com.zjwm.wyx.course.entity.Hold;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoldExam {
    private Hold hold;
    private Exam exam;
}
