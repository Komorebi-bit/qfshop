package com.qfedu.qfnews.dao;

import com.common.dbaccess.core.BaseDAO;
import com.qfedu.qfnews.bean.News;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Komorebi
 * @since 2023.12.26.16:25
 */
public class NewsDAO extends BaseDAO<News> {

    public News getNews(int id) {
        String sql = "select * from v_news where id=?";
        //查询单条数据
        return singleBySql(News.class, sql, id);
    }

    public List<News> getNewsByNid(int nid){
        List<News> newsList = new ArrayList<>();
        if(nid != 0){
            String sql = "select * from v_news where nid=? order by id desc";
            newsList.addAll(selectList(News.class,sql,nid));
        }else{//查询全部
            String sql = "select * from v_news order by id desc";
            newsList.addAll(selectList(News.class,sql));
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (News news : newsList) {
            news.setDatetime(format.format(news.getCtime()));

        }
        return newsList;
    }

    public void updateNews(News news){
            if (news.getId() == null || news.getId() == 0) {
                //id不存在，则为添加
                String sql = "insert into tbl_news(title,content,ctime,nid,image,photo,price) "
                    + "values(?,?,now(),?,?,?,?)";
                updateBySql(sql, news.getTitle(), news.getContent(), news.getNid(), news.getImage()
                    , news.getPhoto(), news.getPrice()); //添加，删除，修改
            } else {//修改
                String sql = "update tbl_news set title=?,content=?,nid=?,image=?,photo=?"
                    + ",price=? where id=?";
                updateBySql(sql, news.getTitle(), news.getContent(), news.getNid(), news.getImage()
                    , news.getPhoto(), news.getPrice(), news.getId());
            }
    }
}
