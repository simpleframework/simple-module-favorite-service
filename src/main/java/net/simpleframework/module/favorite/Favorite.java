package net.simpleframework.module.favorite;

import net.simpleframework.ado.bean.AbstractUserAwareBean;
import net.simpleframework.ado.db.common.EntityInterceptor;
import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
@EntityInterceptor(listenerTypes = { "net.simpleframework.module.log.EntityDeleteLogAdapter" })
public class Favorite extends AbstractUserAwareBean implements IFavoriteContextAware {
	/* 收藏内容id */
	private ID favoriteId;

	public ID getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(final ID favoriteId) {
		this.favoriteId = favoriteId;
	}

	private static final long serialVersionUID = 2615241723570917053L;
}
