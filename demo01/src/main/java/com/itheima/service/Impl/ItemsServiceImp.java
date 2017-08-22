package com.itheima.service.Impl;

import com.itheima.mapper.ItemsMapper;
import com.itheima.pojo.Items;
import com.itheima.pojo.ItemsExample;
import com.itheima.service.ItemsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * @author 张红杰 13022800618
 * @version 1.0, 2017.8.10 13:47
 */
@Service
@Transactional
public class ItemsServiceImp implements ItemsService {

	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public Items findById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Items> findAllItems() {
		return itemsMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public List<Items> findByName(String name) {
		ItemsExample itemsExample = new ItemsExample();
		ItemsExample.Criteria criteria = itemsExample.createCriteria();
		criteria.andNameLike("%"+name+"%");
		List<Items> itemsList = itemsMapper.selectByExampleWithBLOBs(itemsExample);
		return itemsList;
	}

	@Override
	public void deleteItems(Integer[] ids) {
		if (ids != null) {
			for (Integer id : ids) {
				itemsMapper.deleteByPrimaryKey(id);
			}
		}
	}

	@Override
	public void saveOrUpdateItems(Items items) {
		if(items != null && items.getId() == null){
			items.setId(new Random().nextInt(500));
			itemsMapper.insert(items);
		}
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
