package com.cn.jzedy.page.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by Jzedy on 2018/4/10
 */
public class Page {

    private int pageNum;    //每页显示数目
    private int pageSize;   //当前页数
    private long total;     //数据总数
    private long totalPages;//总页数
    private boolean isFirst;//是否是第一页
    private boolean isLast; //是否是最后一页
    private List<Map<String,Object>> contents; //数据内容

    public Page() {
    }

    public Page(int pageNum, int pageSize, long total, List<Map<String,Object>> contents) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.contents = contents;
        this.total = total;
        if (total % pageNum == 0){
            this.totalPages = total/pageNum;
        }else this.totalPages = total/pageNum+1;
        this.isFirst = (pageSize ==1);
        this.isLast = (pageSize == totalPages);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public List<Map<String, Object>> getContents() {
        return contents;
    }

    public void setContents(List<Map<String, Object>> contents) {
        this.contents = contents;
    }
}
