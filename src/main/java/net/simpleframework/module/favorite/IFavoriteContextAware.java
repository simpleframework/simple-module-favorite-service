package net.simpleframework.module.favorite;

import net.simpleframework.ctx.IModuleContextAware;
import net.simpleframework.ctx.ModuleContextFactory;
import net.simpleframework.module.favorite.plugin.IFavoriteContext;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IFavoriteContextAware extends IModuleContextAware {

	static IFavoriteContext favoriteContext = ModuleContextFactory.get(IFavoriteContext.class);
}