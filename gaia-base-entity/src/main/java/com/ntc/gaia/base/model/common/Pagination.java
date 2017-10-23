package com.ntc.gaia.base.model.common;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询:条件,结果对象
 *
 * @author david
 * @date 2017-08-10
 */
@SuppressWarnings("unused")
public class Pagination implements Serializable {

    private static final long serialVersionUID = 1887144200448112253L;

    /**
     * 一页数据默认10条
     */
    private int pageSize = 10;

    /**
     * 当前页码
     */
    private int pageNo = 1;

    /**
     * 开始查询的行号
     */
    private int startRow = 0;

    /**
     * 上一页
     */
    private int upPage = 1;

    /**
     * 下一页
     */
    private int nextPage = 1;

    /**
     * 一共有多少条数据
     */
    private long totalCount = 0;

    /**
     * 一共有多少页
     */
    private long totalPage = 1;

    /**
     * 查询条件参数对象
     */
    private Object params;

    /**
     * 数据集合
     */
    private List<Object> datas;

    /**
     * 分页的url
     */
    private String pageUrl;

    private boolean hasNext = false;// 是否有下一页

    private boolean hasPre = false;// 是否有上一页

    private String parameter = ""; // 参数变量

    private int rowStartIndex = 1;// 行开始编号

    private int startHref = 1;// 连接跳转开始编号

    /**
     * 获取第一条记录位置
     *
     * @return
     */
    public int getFirstResult() {
        return (this.getPageNo() - 1) * this.getPageSize();
    }

    public int getStartRow() {
        return (this.getPageNo() - 1) * this.getPageSize();
    }

    /**
     * 获取最后记录位置
     *
     * @return
     */
    public int getLastResult() {
        return this.getPageNo() * this.getPageSize();
    }

    /**
     * 计算一共多少页
     */
    public void setTotalPage() {
        this.totalPage = (int) ((this.totalCount % this.pageSize > 0) ? (this.totalCount / this.pageSize + 1)
                : this.totalCount / this.pageSize);
    }

    /**
     * 设置 上一页
     */
    public void setUpPage() {
        this.upPage = (this.pageNo > 1) ? this.pageNo - 1 : this.pageNo;
    }

    /**
     * 设置下一页
     */
    public void setNextPage() {
        this.nextPage = (this.pageNo == this.totalPage) ? this.pageNo : this.pageNo + 1;
    }


    public int getNextPage() {
        return nextPage;
    }

    public long getTotalPage() {
        if (totalPage < 1) {
            totalPage = 1;
        }
        return totalPage;
    }

    public int getUpPage() {
        return upPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        if (pageNo < 1) {
            pageNo = 1;
        }
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        if(pageNo<1){
            pageNo=1;
        }
        this.pageNo = pageNo;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    public void setStartHref(int startHref) {
        this.startHref = startHref;
    }

    public int getStartHref() {

        if (getTotalPage() <= 10) {
            startHref = 1; // 不够10页，当前页连接从(1-10)
        } else {
            if (pageNo % 10 == 0) {
                startHref = (pageNo / 10) * 10 - 9;
            } else {
                startHref = (pageNo / 10) * 10 + 1;
            }
        }
        return startHref;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPre() {
        return hasPre;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public int getRowStartIndex() {

        rowStartIndex = (pageNo - 1) * pageSize;
        return rowStartIndex;
    }

    public void setRowStartIndex(int rowStartIndex) {
        this.rowStartIndex = rowStartIndex;
    }

    public Pagination() {
        this.init();
    }

    public Pagination(int pageNo, int pageSize, Object params) {
        this.setPageNo(pageNo);
        this.setPageSize(pageSize);
        this.setParams(params);
    }

    public Pagination(int pageNo, int pageSize, long totalCount) {
        this.setPageNo(pageNo);
        this.setPageSize(pageSize);
        this.setTotalCount(totalCount);
        this.init();
    }

    /**
     * 初始化计算分页
     */
    public void init() {

        this.setTotalPage();// 设置一共页数
        this.setUpPage();// 设置上一页
        this.setNextPage();// 设置下一页
    }
}
