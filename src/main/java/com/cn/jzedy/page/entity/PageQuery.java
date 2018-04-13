package com.cn.jzedy.page.entity;

/**
 * @auther Jzedy
 * @time 2018/4/13 23:13
 * @description
 */
public class PageQuery {
    private Integer pageNum;
    private Integer pageSize;

    public Integer getPageNum() {
        if (pageNum == null){
            pageNum =1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (pageSize == null){
            pageSize = 1;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
