package com.qfedu.qfnews.servlet;

import com.common.dbaccess.servlet.BaseHttpServlet;
import com.qfedu.qfnews.bean.Nav;
import com.qfedu.qfnews.dao.NavDAO;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Komorebi
 * @since 2023.12.28.15:46
 */
@WebServlet({
    "/nav_app",
})
public class NavServlet extends BaseHttpServlet {
    NavDAO navDAO = new NavDAO();
    //给手机用的数据，返回写void
    public void app(HttpServletRequest req, HttpServletResponse resp){
        List<Nav> navList = navDAO.getNavList();
        Nav first = new Nav();
        first.setId(0);
        first.setNav("全部");
        first.setType(0);
        navList.add(0,first);
        outRespJson(navList,resp);
        // System.out.println(navList);
    }

}
