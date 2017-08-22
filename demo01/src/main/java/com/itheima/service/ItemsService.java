package com.itheima.service;

import com.itheima.pojo.Items;

import java.util.List;

/**
 * @author 张红杰 13022800618
 * @version 1.0, 2017.8.10 13:46
 */
public interface ItemsService {

	/**
	 * 通过id查找商品
	 *
	 * @param id
	 * @return
	 */
	Items findById(Integer id);

	/**
	 * 查询所有商品
	 *
	 * @return
	 */
	List<Items> findAllItems();

	/**
	 * 通过商品名称查找商品
	 *
	 * @param name
	 * @return
	 */
	List<Items> findByName(String name);

	/**
	 * 删除指定id的商品
	 *
	 * @param ids
	 */
	void deleteItems(Integer[] ids);

	/**
	 * 添加或者更新指定商品
	 *
	 * @param items
	 */
	void saveOrUpdateItems(Items items);

}
