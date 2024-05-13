package cn.chaZ.types.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: big-market
 * @description: 返回
 * @author: chaZ
 * @create: 2024-04-30 15:05
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> implements Serializable {
    private String code;
    private String info;
    private T data;
}
