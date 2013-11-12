package net.simpleframework.module.favorite.impl;

import static net.simpleframework.common.I18n.$m;
import net.simpleframework.ado.db.DbEntityTable;
import net.simpleframework.ctx.Module;
import net.simpleframework.ctx.permission.IPermissionConst;
import net.simpleframework.module.common.AbstractCommonModuleContext;
import net.simpleframework.module.favorite.Favorite;
import net.simpleframework.module.favorite.FavoriteItem;
import net.simpleframework.module.favorite.IFavoriteService;
import net.simpleframework.module.favorite.plugin.IFavoriteContext;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class FavoriteContext extends AbstractCommonModuleContext implements
		IFavoriteContext {

	@Override
	protected DbEntityTable[] getEntityTables() {
		return new DbEntityTable[] { Favorite.TBL, FavoriteItem.TBL };
	}

	@Override
	public String getManagerRole() {
		return IPermissionConst.ROLE_MANAGER;
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
		return new Module().setName(MODULE_NAME).setText($m("FavoriteContext.0")).setOrder(21);
	}
}
