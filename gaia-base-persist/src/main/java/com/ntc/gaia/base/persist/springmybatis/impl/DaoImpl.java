package com.ntc.gaia.base.persist.springmybatis.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.ntc.gaia.base.persist.springmybatis.vo.DBConstants;
import com.ntc.gaia.base.model.common.Pagination;

/**
 * 操作DAO公共业务父类
 * 持久化操作采用的是Spring和mybatis整合的的模板类方法（SqlSessionTemplate的各方法）
 * @author David
 * @date 2017-08-10
 * 
 */
public class DaoImpl {

	// MyBaits 操作SQL会话模板
	@Autowired
	protected SqlSessionTemplate sqlSession;
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSession;
	}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSession = sqlSessionTemplate;
	}

	/**
	 * 封装MyBatis 查询操作
	 * 
	 * @param key
	 *            mapper键值
	 * @param params
	 *            执行SQL参数
	 * 
	 * @return T 返回结果对象
	 * @throws SQLException
	 *             执行数据库异常
	 */
	protected <T> T query(String key, Object params) throws SQLException {

		try {
			return (T) sqlSession.selectOne(key, params);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	/**
	 * 封装MyBatis 新增操作
	 * 
	 * @param key
	 *            mapper键值
	 * @param params
	 *            执行SQL参数
	 * 
	 * @return T 返回结果对象
	 * @throws SQLException
	 *             执行数据库异常
	 */
	protected <T> T add(String key, Object params) throws SQLException {

		try {

			sqlSession.insert(key, params);
			return (T) params;

		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	/**
	 * 封装MyBatis 批量新增操作
	 * 
	 * @param key
	 *            mapper键值
	 * @param params
	 *            执行SQL参数
	 * 
	 * @return List<T> 返回结果列表对象
	 * @throws SQLException
	 *             执行数据库异常
	 */
	protected <T> List<T> addBatch(String key, Object params) throws SQLException {

		try {
			sqlSession.insert(key, params);
			return (List<T>) params;

		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	/**
	 * 封装MyBatis 通过ID删除操作
	 * 
	 * @param key
	 *            mapper键值
	 * @param id
	 *            执行SQL参数
	 * 
	 * @return List<T> 返回结果列表对象
	 * @throws SQLException
	 *             执行数据库异常
	 */
	protected int delete(String key, Serializable id) throws SQLException {

		int rs = DBConstants.FAILURE;
		try {
			sqlSession.delete(key, id);
			rs = DBConstants.SUCCESS;

		} catch (Exception e) {
			throw new SQLException(e);
		}
		return rs;
	}

	/**
	 * 封装MyBatis 通过参数删除操作
	 * 
	 * @param key
	 *            mapper键值
	 * @param params
	 *            执行SQL参数
	 * 
	 * @return int 返回操作标识
	 * @throws SQLException
	 *             执行数据库异常
	 */
	protected int delete(String key, Object params) throws SQLException {

		int rs = DBConstants.FAILURE;
		try {
			sqlSession.delete(key, params);
			rs = DBConstants.SUCCESS;

		} catch (Exception e) {
			throw new SQLException(e);
		}
		return rs;
	}

	/**
	 * 封装MyBatis 更新操作
	 * 
	 * @param key
	 *            mapper键值
	 * @param params
	 *            执行SQL参数
	 * 
	 * @return int 返回操作标识
	 * @throws SQLException
	 *             执行数据库异常
	 */
	protected int update(String key, Object params) throws SQLException {

		int rs = DBConstants.FAILURE;
		try {
			sqlSession.update(key, params);
			rs = DBConstants.SUCCESS;

		} catch (Exception e) {
			throw new SQLException(e);
		}
		return rs;
	}

	/**
	 * 封装MyBatis 查询操作
	 * 
	 * @param key
	 *            mapper键值
	 * 
	 * @return T 返回查询对象
	 * @throws SQLException
	 *             执行数据库异常
	 */
	protected <T> T queryList(String key) throws SQLException {

		try {
			return (T) sqlSession.selectList(key);

		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	/**
	 * 封装MyBatis 查询操作
	 *
	 * @param key
	 *            mapper键值
	 ** @param params
	 *            执行SQL参数
	 * @return T 返回查询对象
	 * @throws SQLException
	 *             执行数据库异常
	 */
	protected <T> T queryList(String key, Object params) throws SQLException {

		try {

			return (T) sqlSession.selectList(key, params);

		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	/**
	 * 封装MyBatis 查询总记录数操作
	 *
	 * @param key
	 *            mapper键值

	 * @return Long 返回查询的总记录数（Long型数据）
	 * @throws SQLException
	 *             执行数据库异常
	 */
	protected Long queryCount(String key) throws SQLException {

		try {
			return (Long) sqlSession.selectOne(key);

		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	/**
	 * 封装MyBatis 查询操作
	 *
	 * @param key
	 *            mapper键值
	 ** @param params
	 *            执行SQL参数
	 * @return Long 返回查询的总记录数
	 * @throws SQLException
	 *             执行数据库异常
	 */
	protected Long queryCount(String key, Object params) throws SQLException {

		try {
			return (Long) sqlSession.selectOne(key, params);

		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	protected <T> Map<T, T> queryMap(String key, String params) throws SQLException {
		try {
			return sqlSession.selectMap(key, params);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	protected <T> Map<T, T> queryMap(String key, Object object, String params) throws SQLException {
		try {
			return sqlSession.selectMap(key, object, params);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	protected Pagination queryForPagin(String key1, String key2, Pagination pagin) throws SQLException {

		// 1.条件判断,参数处理
		Pagination pn = (pagin != null) ? pagin : new Pagination();

		// 2.获取总记录数
		long totalRows = this.queryCount(key1, pn);

		// 3.分页参数处理
		pn.setTotalCount(totalRows);
		pn.init();

		// 4.查询分页满足条件的列表
		List list = this.queryList(key2, pn);//进行分页处理
		pn.setDatas(list);

		return pn;
	}

}
