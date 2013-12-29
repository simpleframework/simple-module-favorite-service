package net.simpleframework.module.favorite;

import net.simpleframework.ctx.ModuleException;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class FavoriteException extends ModuleException {

	public FavoriteException(final String msg, final Throwable cause) {
		super(msg, cause);
	}

	public static FavoriteException of(final String msg) {
		return _of(FavoriteException.class, msg);
	}

	public static FavoriteException of(final Throwable throwable) {
		return _of(FavoriteException.class, null, throwable);
	}

	private static final long serialVersionUID = -6038341656399824481L;
}
