package net.simpleframework.module.favorite.plugin;

import net.simpleframework.module.common.ICommonModuleContext;
import net.simpleframework.module.common.plugin.ModulePluginRegistry;
import net.simpleframework.module.favorite.IFavoriteService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IFavoriteContext extends ICommonModuleContext {

	static final String MODULE_NAME = "simple-module-favorite";

	/**
	 * 得到收藏管理器
	 * 
	 * @return
	 */
	IFavoriteService getFavoriteService();

	FavoritePluginRegistry getPluginRegistry();

	public static class FavoritePluginRegistry extends ModulePluginRegistry<IFavoritePlugin> {
	}
}
