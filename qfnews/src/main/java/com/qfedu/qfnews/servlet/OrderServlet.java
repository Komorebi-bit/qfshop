package com.qfedu.qfnews.servlet;

import com.common.dbaccess.servlet.BaseHttpServlet;
import com.qfedu.qfnews.bean.Order;
import com.qfedu.qfnews.dao.OrderDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Komorebi
 * @since 2023.12.29.14:33
 */

@WebServlet({
    "/order_add"
})
public class OrderServlet extends BaseHttpServlet {
    OrderDAO orderDAO = new OrderDAO();

    public void add(HttpServletRequest req, HttpServletResponse resp) {
        Order order = getParameter(req, Order.class);
        orderDAO.addOrder(order); // 把买的东西插入到数据表中
        outRespJson(200, resp); // 给手机一个响应
    }

}
