package com.punici.cloud.model.utils;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> implements Serializable
{
    private long nowPage;
    
    private long pageSize;
    
    private long totalCount;
    
    private long totalPageNum;
    
    private List<T> list;
    
    public PageResult(PageResult<?> tr)
    {
        this.nowPage = tr.nowPage;
        this.pageSize = tr.pageSize;
        this.totalCount = tr.totalCount;
        this.totalPageNum = tr.totalPageNum;
    }
}
