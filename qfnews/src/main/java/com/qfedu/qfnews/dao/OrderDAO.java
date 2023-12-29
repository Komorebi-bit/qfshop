package com.qfedu.qfnews.dao;

import com.common.dbaccess.core.BaseDAO;
import com.qfedu.qfnews.bean.Order;

/**
 * @author Komorebi
 * @since 2023.12.29.14:30
 */
public class OrderDAO extends BaseDAO<Order> {

    public void addOrder(Order order) {
        String sql = "insert into tbl_order(name,address,"
            + "mobile,count,ctime,pid) values(?,?,?,?,now(),?)";
        updateBySql(sql, order.name, order.address,
            order.mobile, order.count, order.pid);
    }
}
