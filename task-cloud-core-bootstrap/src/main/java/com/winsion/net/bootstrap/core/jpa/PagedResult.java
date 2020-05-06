package com.winsion.net.bootstrap.core.jpa;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhoucong on 2017/6/27.
 */
public class PagedResult<T> implements Serializable {
    private List<T> data;
    private int pageIndex;
    private int pageSize;
    private int pageTotal;

    public PagedResult(List<T> data, int pageIndex, int pageSize, int elementTotal) {
        this.data = data;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.pageTotal = (elementTotal / pageSize) + (elementTotal % pageSize != 0 ? 1 : 0);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }
}
