package com.zcy.fruitshop.util;

import lombok.Data;

import java.util.List;

@Data
public class Paging<T> {

    private int pageNum;

    private int pageSize;

    private int totalPage;

    private int totalCount;

    private List<T> data;

    public Paging(int pageNum, int pageSize, int totalCount, List<T> data){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPage = (totalCount+pageSize-1)/pageSize;
        this.data = data;
    }

}
