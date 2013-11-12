package net.simpleframework.module.favorite;

import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public interface IFavoriteContent {

	/**
	 * 获取收藏内容的id
	 * 
	 * @param content
	 * @return
	 */
	ID getContentId();

	/**
	 * 主题
	 * 
	 * @return
	 */
	String getTopic();

	/**
	 * 打开链接
	 * 
	 * @return
	 */
	String getUrl();

	ID getCategoryId();

	/**
	 * 描述
	 * 
	 * @return
	 */
	String getDescription();
}
