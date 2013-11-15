package net.simpleframework.module.favorite.plugin;

import net.simpleframework.module.common.plugin.IModulePlugin;
import net.simpleframework.module.favorite.IFavoriteContent;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IFavoritePlugin extends IModulePlugin {

	/**
	 * 获取收藏内容对象
	 * 
	 * @param contentId
	 * @return
	 */
	IFavoriteContent getContent(Object contentId);

	/**
	 * 获取分类的显示名称
	 * 
	 * @param categoryId
	 * @return
	 */
	String getCategoryText(Object categoryId);
}
