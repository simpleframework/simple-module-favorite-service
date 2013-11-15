package net.simpleframework.module.favorite;

import net.simpleframework.ado.bean.AbstractIdBean;
import net.simpleframework.ado.db.DbEntityTable;
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
public class FavoriteItem extends AbstractIdBean {
	/* 收藏标识 */
	private int favoriteMark;

	/* 内容id */
	private ID contentId;

	/* 标题 */
	private String topic;

	/* 地址 */
	private String url;

	/* 收藏次数 */
	private int favorites;

	/* 内容所属于的类目id，没有则为空 */
	private ID categoryId;

	/* 描述 */
	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return getTopic();
	}

	public static final DbEntityTable TBL = new DbEntityTable(FavoriteItem.class, "sf_favorite_item");

	private static final long serialVersionUID = 7023840125008691695L;
}
