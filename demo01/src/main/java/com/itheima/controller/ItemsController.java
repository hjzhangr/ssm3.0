package com.itheima.controller;

import com.itheima.pojo.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 张红杰 13022800618
 * @version 1.0, 2017.8.10 17:56
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	@RequestMapping("findAllItems.action")
	public ModelAndView findAllItems() {
		List<Items> itemsList = itemsService.findAllItems();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("itemsList");
		print();

		Demo01.test01();
		new Demo02().test02();
		new Demo02().test02();
		new Demo02().test02();
		new Demo02().test02();

		return modelAndView;
	}

	@RequestMapping("editItem.action")
	public ModelAndView editItems(Integer id) {
		Items items = itemsService.findById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("items", items);
		modelAndView.setViewName("editItems");
		print();
		return modelAndView;
	}

	@RequestMapping("updateItems.action")
	public String updateItems(Items items) {
		itemsService.saveOrUpdateItems(items);
		print();
		return "success";
	}

	@RequestMapping("findByName.action")
	public ModelAndView findByName(String name) {
		List<Items> itemsList = itemsService.findByName(name);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("itemsList");
		print();
		return modelAndView;
	}

	@RequestMapping("/addItems.action")
	public String toAddItems() {
		print();
		return "editItems";
	}

	@RequestMapping("deleteItems.action")
	public String deleteItems(Integer[] ids) {
		itemsService.deleteItems(ids);
		print();
		return "success";
	}

	public void print() {
		System.out.println("???22222");
		System.out.println("测试打印输出222444442233333...");
	}

}
