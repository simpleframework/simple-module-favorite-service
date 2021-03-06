package net.simpleframework.module.favorite;

import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IFavoriteContent {

	/**
	 * 获取收藏内容的id
	 * 
	 * @return
	 */
	ID getContentId();

	/**
	 * 获取收藏内容的userId
	 * 
	 * @return
	 */
	ID getUserId();

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
