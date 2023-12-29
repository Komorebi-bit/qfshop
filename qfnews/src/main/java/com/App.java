package com;

import com.qfedu.qfnews.bean.User;
import com.qfedu.qfnews.dao.UserDAO;

/**
 * @author Komorebi
 * @since 2023.12.26.14:13
 */
public class App {
    public static void main(String[] args){
        User user = new User();
        user.setPassword("123");
        user.setUsername("张三");
        UserDAO userDAO = new UserDAO();
        User user1 = userDAO.getUser(user);
        System.out.println(user1.getId()+"  "+ user1.getPassword()+"   "+user1.getUsername()+"");
    }
}
