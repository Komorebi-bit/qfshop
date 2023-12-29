package com.qfedu.qfnews.dao;

import com.common.dbaccess.core.BaseDAO;
import com.qfedu.qfnews.bean.User;

/**
 * @author Komorebi
 * @since 2023.12.26.11:31
 */
public class UserDAO extends BaseDAO<User> {
    public User getUser(User user){
        String sql="select * from tbl_user where username=? and password=?";
        return singleBySql(User.class,sql,user.getUsername(),user.getPassword());
    }
}
