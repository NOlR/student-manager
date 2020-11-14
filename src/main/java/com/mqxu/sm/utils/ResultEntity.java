package com.mqxu.sm.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 返回结果实体
 * @author: mqxu
 * @create: 2020-11-14 20:07
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultEntity {
    private int code;
    private String message;
    private Object data;
}
