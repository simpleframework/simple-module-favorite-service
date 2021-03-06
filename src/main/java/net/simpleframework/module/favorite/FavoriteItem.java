package net.simpleframework.module.favorite;

import net.simpleframework.ado.bean.AbstractDescriptionBean;
import net.simpleframework.ado.db.common.EntityInterceptor;
import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
@EntityInterceptor(listenerTypes = { "net.simpleframework.module.log.EntityDeleteLogAdapter" })
public class FavoriteItem extends AbstractDescriptionBean {
	/* 收藏标识 */
	private int favoriteMark;

	/* 内容id */
	private ID contentId;

	/* 内容的userId */
	private ID userId;

	/* 标题 */
	private String topic;

	/* 地址 */
	private String url;

	/* 收藏次数 */
	private int favorites;

	/* 内容所属于的类目id，没有则为空 */
	private ID categoryId;

	public int getFavoriteMark() {
		return favoriteMark;
	}

	public void setFavoriteMark(final int favoriteMark) {
		this.favoriteMark = favoriteMark;
	}

	public ID getContentId() {
		return contentId;
	}

	public void setContentId(final ID contentId) {
		this.contentId = contentId;
	}

	public ID getUserId() {
		return userId;
	}

	public void setUserId(final ID userId) {
		this.userId = userId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(final String topic) {
		this.topic = topic;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	public int getFavorites() {
		return favorites;
	}

	public void setFavorites(final int favorites) {
		this.favorites = favorites;
	}

	public ID getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(final ID categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return getTopic();
	}

	private static final long serialVersionUID = 7023840125008691695L;
}
