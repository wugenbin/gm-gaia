package com.ntc.gaia.base.persist.springmybatis;

import java.sql.SQLException;
import java.util.List;

import com.ntc.gaia.base.model.common.Pagination;


/**
 * 通用公共业务DAO接口层
 *
 * @author David
 * @date 2017-08-10
 * <p/>
 * 动态参数类型
 */
public interface IDao {

    /**
     * 新增记录
     *
     * @param <T> 动态参数类型
     * @param vo  添加参数对象
     * @throws SQLException SQL异常类
     */
    <T> T addVO(T vo) throws SQLException;

    /**
     * 新增记录(批量)
     *
     * @param <T>  动态参数类型
     * @param list <T> 添加参数列表
     * @throws SQLException SQL异常类
     */
    <T> List<T> addVOBatch(List<T> list) throws SQLException;

    /**
     * 删除记录
     *
     * @throws SQLException SQL异常类
     */
    int deleteVOAll() throws SQLException;

    /**
     * 删除记录通过ID
     *
     * @param id 主键Id
     * @throws SQLException SQL异常类
     */
    int deleteVOById(Long id) throws SQLException;

    /**
     * 批量删除记录
     *
     * @param list 主键list
     * @throws SQLException SQL异常类
     */
    int deleteVOBatch(List<Long> list) throws SQLException;

    /**
     * 修改记录
     *
     * @param <T> 动态参数类型
     * @param vo  修改参数对象
     * @throws SQLException SQL异常类
     */
    <T> int updateVO(T vo) throws SQLException;

    /**
     * 修改记录(批量)
     *
     * @param <T>  动态参数类型
     * @param list 修改参数列表
     * @throws SQLException SQL异常类
     */
    <T> int updateVOBatch(List<T> list) throws SQLException;

    /**
     * 查询表最大主键(Integer类型的主键)
     *
     * @throws SQLException SQL异常类
     */
    Long queryMaxPK() throws SQLException;

    /**
     * 查询一条记录
     *
     * @param <T> 动态参数类型
     * @param id  主键Id
     * @throws SQLException SQL异常类
     * @result 查询结果对象
     */
    <T> T queryVOById(Long id) throws SQLException;

    /**
     * 查询一条记录
     *
     * @param <T> 动态参数类型
     * @param vo  查询条件对象
     * @throws SQLException SQL异常类
     */
    <T> T queryVOByCond(T vo) throws SQLException;

    /**
     * 查询总统计数
     *
     * @throws SQLException SQL异常类
     */
    Long queryCount() throws SQLException;

    /**
     * 查询所有列表
     *
     * @param <T> 动态参数类型
     * @return 结果列表
     * @throws SQLException SQL异常类
     */
    <T> List<T> queryList() throws SQLException;

    /**
     * 查询所有有效的(只涉及有业务状态控制字段的查询)
     *
     * @param <T> status状态
     * @return 结果列表
     * @throws SQLException SQL异常类
     */
    <T> List<T> queryListET(int status) throws SQLException;

    /**
     * 查询统计数量(包含条件)
     *
     * @param <T> 动态参数类型
     * @param vo  查询参数对象
     * @return 返回统计结果
     * @throws SQLException SQL异常类
     */
    <T> Long queryCountByCond(T vo) throws SQLException;

    /**
     * 查询结果列表(包含条件)
     *
     * @param <T> 动态参数类型
     * @param vo  查询参数对象
     * @return 返回列表结果
     * @throws SQLException SQL异常类
     */
    <T> List<T> queryListByCond(T vo) throws SQLException;

    /**
     * UI分页查询展示
     *
     * @param pagin 查询参数对象
     * @return 返回列表结果
     * @throws SQLException SQL异常类
     */
    Pagination queryListForPagin(Pagination pagin) throws SQLException;

}
