package net.simpleframework.module.favorite;

import java.util.List;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.ctx.service.ado.db.IDbBeanService;
import net.simpleframework.module.common.bean.CategoryStat;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public interface IFavoriteService extends IDbBeanService<Favorite> {

	/**
	 * @param userId
	 * @param favoriteMark
	 * @param contentId
	 * @return
	 */
	Favorite getFavorite(Object userId, int favoriteMark, Object contentId);

	FavoriteItem getFavoriteItem(int favoriteMark, Object contentId);

	FavoriteItem getFavoriteItem(Favorite favorite);

	/**
	 * 查找指定用户的收藏
	 * 
	 * @param favoriteMark
	 * @param userId
	 * @param categoryId
	 * @return
	 */
	IDataQuery<Favorite> queryFavorites(int favoriteMark, Object userId, Object categoryId);

	/**
	 * 查找收藏的分类
	 * 
	 * @param favoriteMark
	 * @param userId
	 * @return
	 */
	List<CategoryStat> queryCategoryItems(int favoriteMark, Object userId);

	/**
	 * 插入
	 * 
	 * @param favoriteMark
	 * @param favorite
	 * @param content
	 */
	void insertFavorite(int favoriteMark, Favorite favorite, IFavoriteContent content);
}
