package com.zcy.fruitshop.util;

import lombok.Data;

@Data
public class BasePageParam {

    private int pagination;

    private int pageSize;

    private Long pid;

    private Integer status;

    public BasePageParam(int pagination, int pageSize, Long pid, Integer status){
        this.pagination = pagination;
        this.pageSize = pageSize;
        this.pid = pid;
        this.status = status;
    }

}
