package net.simpleframework.module.favorite;

import net.simpleframework.ctx.AbstractModuleRef;
import net.simpleframework.ctx.IContextBase;
import net.simpleframework.ctx.ModuleContextFactory;
import net.simpleframework.module.common.plugin.ModulePluginFactory;
import net.simpleframework.module.favorite.plugin.IFavoriteContext;
import net.simpleframework.module.favorite.plugin.IFavoritePlugin;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class FavoriteRef extends AbstractModuleRef {
	@Override
	public void onInit(final IContextBase context) throws Exception {
		super.onInit(context);

		getModuleContext().getPluginRegistry().registPlugin(getPluginClass());
	}

	protected abstract Class<? extends IFavoritePlugin> getPluginClass();

	public IFavoritePlugin plugin() {
		return ModulePluginFactory.get(getPluginClass());
	}

	@Override
	public IFavoriteContext getModuleContext() {
		return ModuleContextFactory.get(IFavoriteContext.class);
	}
}
