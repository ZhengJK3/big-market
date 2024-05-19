package cn.chaZ.types.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: big-market
 * @description:
 * @author: chaZ
 * @create: 2024-05-16 15:58
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseEvent<T> {
    private String id;
    private Date timestamp;
    private T data;
}
