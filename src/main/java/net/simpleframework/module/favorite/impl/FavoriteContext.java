package net.simpleframework.module.favorite.impl;

import static net.simpleframework.common.I18n.$m;

import net.simpleframework.ado.db.DbEntityTable;
import net.simpleframework.ctx.Module;
import net.simpleframework.module.common.AbstractCommonModuleContext;
import net.simpleframework.module.favorite.Favorite;
import net.simpleframework.module.favorite.FavoriteItem;
import net.simpleframework.module.favorite.IFavoriteService;
import net.simpleframework.module.favorite.plugin.IFavoriteContext;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class FavoriteContext extends AbstractCommonModuleContext
		implements IFavoriteContext {
	@Override
	protected DbEntityTable[] createEntityTables() {
		return new DbEntityTable[] { new DbEntityTable(Favorite.class, "sf_favorite"),
				new DbEntityTable(FavoriteItem.class, "sf_favorite_item") };
	}

	@Override
	public IFavoriteService getFavoriteService() {
		return singleton(FavoriteService.class);
	}

	@Override
	public FavoritePluginRegistry getPluginRegistry() {
		return singleton(FavoritePluginRegistry.class);
	}

	@Override
	protected Module createModule() {
		return super.createModule().setName(MODULE_NAME).setText($m("FavoriteContext.0"))
				.setOrder(21);
	}
}
