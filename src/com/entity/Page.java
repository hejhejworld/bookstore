package com.entity;

import java.util.List;

public class Page<T> {
    /**
     * @param currentPage    当前是第几个页面
     * @param pageTotal      总页面数
     * @param pageTotalCount 所有页面的总记录数
     * @param PAGE_SIZE       每页有几条记录
     * @param items          页面数据
     */
    public static final Integer PAGE_SIZE = 4;
    private Integer currentPage;
    private Integer pageTotal;
    private Integer pageTotalCount;
    private List<T> items;
    private String url;

    public Page(Integer currentPage, Integer pageTotal, Integer pageTotalCount, List<T> items) {
        this.currentPage = currentPage;
        this.pageTotal = pageTotal;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
    }

    public Page() {
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageTotal=" + pageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                '}';
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
