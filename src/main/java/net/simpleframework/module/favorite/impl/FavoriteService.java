package net.simpleframework.module.favorite.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.db.common.ExpressionValue;
import net.simpleframework.ado.db.common.SQLValue;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.ID;
import net.simpleframework.common.coll.ArrayUtils;
import net.simpleframework.ctx.service.ado.db.AbstractDbBeanService;
import net.simpleframework.module.common.bean.CategoryStat;
import net.simpleframework.module.favorite.Favorite;
import net.simpleframework.module.favorite.FavoriteItem;
import net.simpleframework.module.favorite.IFavoriteContent;
import net.simpleframework.module.favorite.IFavoriteContextAware;
import net.simpleframework.module.favorite.IFavoriteService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class FavoriteService extends AbstractDbBeanService<Favorite>
		implements IFavoriteService, IFavoriteContextAware {

	@Override
	public FavoriteItem getFavoriteItem(final int favoriteMark, final Object contentId) {
		return getEntityManager(FavoriteItem.class).queryForBean(
				new ExpressionValue("favoriteMark=? and contentId=?", favoriteMark, contentId));
	}

	@Override
	public FavoriteItem getFavoriteItem(final Favorite favorite) {
		return getEntityManager(FavoriteItem.class).getBean(favorite.getFavoriteId());
	}

	@Override
	public Favorite getFavorite(final Object userId, final int favoriteMark,
			final Object contentId) {
		if (userId == null || contentId == null) {
			return null;
		}
		final FavoriteItem favoriteItem = getFavoriteItem(favoriteMark, contentId);
		if (favoriteItem != null) {
			return getBean("userId=? and favoriteId=?", userId, favoriteItem.getId());
		}
		return null;
	}

	@Override
	public IDataQuery<Favorite> queryFavorites(final int favoriteMark, final Object userId,
			final Object categoryId) {
		Object[] params = new Object[] {};
		String sql = "select a.* from " + getTablename(Favorite.class) + " a left join "
				+ getTablename(FavoriteItem.class) + " b on a.favoriteId=b.id where 1=1";
		if (favoriteMark > 0) {
			sql += " and b.favoriteMark=?";
			params = ArrayUtils.add(params, favoriteMark);
		}
		if (userId != null) {
			sql += " and a.userId=?";
			params = ArrayUtils.add(params, userId);
		}
		if (categoryId != null) {
			if ("none".equals(categoryId)) {
				sql += " and b.categoryId is null";
			} else {
				sql += " and b.categoryId=?";
				params = ArrayUtils.add(params, categoryId);
			}
		}
		return query(new SQLValue(sql, params));
	}

	@Override
	public List<CategoryStat> queryCategoryItems(final int favoriteMark, final Object userId) {
		final List<CategoryStat> l = new ArrayList<CategoryStat>();
		if (userId != null) {
			Object[] params = new Object[] { userId };
			String sql = "select b.categoryId, count(*) as cc from " + getTablename(Favorite.class)
					+ " a left join " + getTablename(FavoriteItem.class)
					+ " b on a.favoriteId=b.id where a.userId=?";
			if (favoriteMark > 0) {
				sql += " and b.favoriteMark=?";
				params = ArrayUtils.add(params, favoriteMark);
			}
			sql += " and b.categoryId is not null group by b.categoryId";
			final IDataQuery<Map<String, Object>> dq = getQueryManager().query(sql, params);
			for (Map<String, Object> m; (m = dq.next()) != null;) {
				final String categoryId = (String) m.get("categoryId");
				l.add(new CategoryStat(categoryId, m.get("cc")));
			}
		}
		return l;
	}

	@Override
	public void insertFavorite(final int favoriteMark, final Favorite favorite,
			final IFavoriteContent content) {
		final ID contentId = content.getContentId();
		FavoriteItem favoriteItem = getFavoriteItem(favoriteMark, contentId);
		if (favoriteItem == null) {
			favoriteItem = new FavoriteItem();
			favoriteItem.setFavoriteMark(favoriteMark);
			favoriteItem.setContentId(contentId);
			favoriteItem.setTopic(content.getTopic());
			favoriteItem.setUrl(content.getUrl());
			favoriteItem.setFavorites(1);
			favoriteItem.setCategoryId(content.getCategoryId());
			favoriteItem.setDescription(content.getDescription());
			getEntityManager(FavoriteItem.class).insert(favoriteItem);
		} else {
			favoriteItem.setFavorites(count("favoriteId=?", favoriteItem.getId()) + 1);
			getEntityManager(FavoriteItem.class).update(new String[] { "favorites" }, favoriteItem);
		}

		favorite.setFavoriteId(favoriteItem.getId());
		insert(favorite);
	}

	@Override
	public void onInit() throws Exception {
		super.onInit();

		addListener(new DbEntityAdapterEx<Favorite>() {
			@Override
			public void onBeforeDelete(final IDbEntityManager<Favorite> manager,
					final IParamsValue paramsValue) throws Exception {
				super.onBeforeDelete(manager, paramsValue);
				final IDbEntityManager<FavoriteItem> service2 = getEntityManager(FavoriteItem.class);
				for (final Favorite favorite : coll(manager, paramsValue)) {
					final ID fId = favorite.getFavoriteId();
					final int c = count("favoriteId=?", fId);
					if (c <= 1) {
						service2.delete(new ExpressionValue("id=?", fId));
					} else {
						final FavoriteItem favoriteItem = service2.getBean(fId);
						if (favoriteItem != null) {
							favoriteItem.setFavorites(c - 1);
							service2.update(new String[] { "favorites" }, favoriteItem);
						}
					}
				}
			}
		});
	}
}
