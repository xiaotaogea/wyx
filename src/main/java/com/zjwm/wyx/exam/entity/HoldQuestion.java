package com.zjwm.wyx.exam.entity;

import com.zjwm.wyx.course.entity.Hold;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoldQuestion {
    private Hold hold;
    private Question question;
}
