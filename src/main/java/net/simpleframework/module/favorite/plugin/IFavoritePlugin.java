package net.simpleframework.module.favorite.plugin;

import net.simpleframework.module.common.plugin.IModulePlugin;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IFavoritePlugin extends IModulePlugin {

	/**
	 * 获取分类的显示名称
	 * 
	 * @param categoryId
	 * @return
	 */
	String getCategoryText(Object categoryId);
}
