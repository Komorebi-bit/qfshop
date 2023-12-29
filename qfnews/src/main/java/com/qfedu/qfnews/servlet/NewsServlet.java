package com.qfedu.qfnews.servlet;

import com.common.dbaccess.servlet.BaseHttpServlet;
import com.common.dbaccess.util.NotNullUtil;
import com.qfedu.qfnews.bean.Nav;
import com.qfedu.qfnews.bean.News;
import com.qfedu.qfnews.dao.NavDAO;
import com.qfedu.qfnews.dao.NewsDAO;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Komorebi
 * @since 2023.12.26.16:33
 */
@MultipartConfig//还需要再开通，接收文件注解
@WebServlet({
    "/news_list","/news_del","/news_add","/news_image",
    "/news_app"
})
public class NewsServlet extends BaseHttpServlet {
    NewsDAO newsDAO= new NewsDAO();
    NavDAO navDAO = new NavDAO();

    public void app(HttpServletRequest req, HttpServletResponse resp){
        //鸿蒙传入一个nid给Java
        Integer nid = getIntParam(req, "nid");
        if(nid == null){
            nid = 0;
        }
        // System.out.println(nid);
        outRespJson(newsDAO.getNewsByNid(nid),resp);
    }

    public void image(HttpServletRequest req, HttpServletResponse resp){
        //jetty启动项目才能使用这个方法
        String fileName = copyUploadFile(req,"E:/Code/qfnews/web/upload");//把接收到的图片保存到某个地方
        outRespJson("/qfnews/upload/"+fileName,resp);

        // String fileName = copyUpload(req,"E:/Code/qfnews/web/upload");
        // fileName = fileName.substring(16);
        outRespJson(fileName,resp);
    }

    public String add(HttpServletRequest req, HttpServletResponse resp){
        if(isPost(req)){
            News news = getParameter(req,News.class);
            if(NotNullUtil.isBlank(news)){
                //title content 有一个为空
                return jsAlert("请完善新闻信息！",resp);
            }
            newsDAO.updateNews(news);
            return redirect("/news_list");
        }else{//get请求
            Integer id = getIntParam(req,"id");
            if(id != null){//按照id查询历史数据
                //修改，在原有数据之上微调整
                req.setAttribute("bean",newsDAO.getNews(id));
            }
            List<Nav> navList = navDAO.getNavList();
            req.setAttribute("navList",navList);
            return forward("/view/qfnews/news/add.jsp");
        }

    };

    public String del(HttpServletRequest req, HttpServletResponse resp){
        int id = getIntParam(req,"id");
        newsDAO.deleteById("tbl_news",id);
        return redirect("/news_list");
    }


    //fastjson
    //转发和重定向带数据到网页，返回值必须是String
    //把数据直接打印到网页，返回值是void
    public String list(HttpServletRequest req, HttpServletResponse resp){
        List<News> newsList = newsDAO.getNewsByNid(0);//查询全部新闻
        // print(newsList);
        //outRespJson(newsList,resp);//把数据直接输出到客户端中
        req.setAttribute("retList",newsList);
        return forward("/view/qfnews/news/list.jsp");

    }
}
