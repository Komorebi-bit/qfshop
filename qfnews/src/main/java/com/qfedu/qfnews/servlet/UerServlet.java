package com.qfedu.qfnews.servlet;

import com.common.dbaccess.servlet.BaseHttpServlet;
import com.qfedu.qfnews.bean.User;
import com.qfedu.qfnews.dao.UserDAO;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Komorebi
 * @since 2023.12.26.11:32
 */
@WebServlet({"/user_signin"})//用户登录
public class UerServlet extends BaseHttpServlet {
    UserDAO userDAO = new UserDAO();

    public String signin(HttpServletRequest req, HttpServletResponse resp)
        throws Exception {
        User user = getParameter(req, User.class);
        User result = userDAO.getUser(user);
        if(result==null){//登录失败
            req.setAttribute("msg","用户名或密码错误");
            return forward("/signin.jsp");//转发
        }else{//登录成功
            //System.out.println(result.getId());
            return redirect("/main.html?username="+ URLEncoder.encode(result.getUsername()
                , "UTF-8"));//重定向
        }
    }


}
