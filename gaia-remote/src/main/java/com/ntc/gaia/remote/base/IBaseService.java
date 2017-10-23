package com.ntc.gaia.remote.base;

import java.util.List;

import com.ntc.gaia.base.model.common.Pagination;
import com.ntc.gaia.base.utils.exception.BusinessException;

public interface IBaseService {

	/**
	 * 新增一个对象
	 * 
	 * @param <T>
	 *            动态参数类型
	 * @param vo
	 *            添加参数对象
	 */
	<T> T saveVO(T vo);

	/**
	 * 批量新增对象
	 * 
	 * @param <T>
	 *            动态参数类型
	 * @param voList
	 *            添加参数对象列表
	 */
	<T> List<T> batchSaveVO(List<T> list);

	/**
	 * 通过主键ID删除实体对象
	 * 
	 * @param id
	 *            主键ID
	 */
	void deleteVO(Long id);

	/**
	 * 更新对象方法
	 * 
	 * @ vo 参数对象
	 */
	<T> T updateVO(T vo);

	/**
	 * 批量修改对象
	 * 
	 * @param <T>
	 *            动态参数类型
	 * @param voList
	 *            添加参数对象列表
	 */
	<T> List<T> batchUpdateVO(List<T> list);

	/**
	 * 通过主键ID查询单个对象
	 * 
	 * @param id
	 *            主键ID
	 * 
	 * @return 结果对象
	 */
	<T> T queryVOById(Long id);

	/**
	 * 查询所有列表
	 * 
	 * @return 结果列表
	 */
	<T> List<T> queryAllList();

	/**
	 * 查询所有统计数量
	 * 
	 * @return 结果数量
	 */
	Long queryAllCount();

	/**
	 * UI 分页查询展示
	 * 
	 * @param <T>
	 *            动态参数类型
	 * @param vo
	 *            查询参数对象
	 * @return 返回列表结果
	 * @throws BussionException
	 *             业务异常类
	 */
	Pagination queryListForPagin(Pagination pagin);
}
