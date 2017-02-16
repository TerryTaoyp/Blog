package com.pandawork.common.entity;

/**
 * Created by Taoyongpan on 2016/11/16.
 */
public class Page {
    private Integer pageNow = 1;//当前页数

    private Integer pageSize = 15;//每页显示的记录数

    private Integer totalCount ;//总的记录条数

    private Integer totalPageCount;//总的页数

    private Integer startPos ;//开始位置，从0开始

    @SuppressWarnings("unused")
    private boolean hasFirst;//是否有首页

    @SuppressWarnings("unused")
    private boolean hasPre;//是否有上一页

    @SuppressWarnings("unused")
    private boolean hasNext;//是否有下一页

    @SuppressWarnings("unused")
    private boolean hasLast;//是否有最后一页

    /**
     * 通过构造函数传入总记录数和当前页
     * @param totalCount
     * @param pageNow
     */
    public Page( int totalCount, int pageNow){
        this.totalCount = totalCount;
        this.pageNow = pageNow;
    }

    /**
     * 取得总页数 总页数 = 总记录数 / 总页数
     * @return
     */
    public int getTotalPageCount(){
        totalPageCount = getTotalCount()/getPageSize();
        return (totalCount%pageSize == 0)?totalPageCount:totalPageCount+1;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    /**
     * 取得选择记录的初始位置
     * @return
     */
    public Integer getStartPos() {
        return (pageNow - 1)*pageSize;
    }

    public void setStartPos(Integer startPos) {
        this.startPos = startPos;
    }

    /**
     * 是否有第一页
     * @return
     */
    public boolean isHasFirst() {
        return (pageNow == 1)?false:true;
    }

    public void setHasFirst(boolean hasFirst) {
        this.hasFirst = hasFirst;
    }

    /**
     * 是否有首页
     * @return
     */
    public boolean isHasPre() {
        //如果有首页就有前一页，因为有首页就不是第一页
        return isHasFirst()?true:false;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    /**
     * 是否有下一页
     * @return
     */
    public boolean isHasNext() {
        //如果有尾页就有下一页，因为有尾页表明不是最后一页
        return isHasLast()?true:false;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    /**
     * 是否有尾页
     * @return
     */
    public boolean isHasLast() {
        //如果不是最后一页就有尾页
        return (pageNow == getTotalCount())?false:true;
    }

    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }

}
