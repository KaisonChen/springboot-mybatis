package com.boot.example.utils;

import java.util.List;

/**
 * @author lig
 * @date 2017/12/11
 */

public class PageBean<T> {
    private static final long serialVersionUID = 1L;

    private int pageNum;//当前页

    private int pageSize;//每页的数量

    private long total;//总记录数

    private long pages;//总页数

    private List<T> list;//结果集

    private boolean isFirstPage = false;//是否为第一页

    private boolean isLastPage = false;//是否为最后一页

    public PageBean(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public void setPageList(List<T> sourceList){
        this.total = sourceList.size();
        this.pages = getTotalPages(sourceList);
        int endRecord;
        int startRecord;
        if(this.pageNum > this.pages){
            this.list = sourceList;
            return;
        }
        if(this.pageNum == this.pages){
            endRecord = (this.pageSize)*(this.pageNum-1)+(int)(this.total%this.pageSize);
            startRecord = endRecord - (int)(this.total%this.pageSize);
        }else{
            endRecord = (this.pageSize)*(this.pageNum);
            startRecord = endRecord - this.pageSize;
        }

        this.list = sourceList.subList(startRecord,endRecord);
    }


    public long getTotalPages(List<T> sourceList){
        long recordTotal = this.total;
        int size = this.pageSize;
        long remainder = recordTotal%size;
        return (remainder==0)?(recordTotal/size):(recordTotal/size+1);
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }
}
