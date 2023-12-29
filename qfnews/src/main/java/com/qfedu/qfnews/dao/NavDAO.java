package com.qfedu.qfnews.dao;

import com.common.dbaccess.core.BaseDAO;
import com.qfedu.qfnews.bean.Nav;
import java.util.List;

/**
 * @author Komorebi
 * @since 2023.12.27.14:08
 */
public class NavDAO extends BaseDAO<Nav> {

    public List<Nav> getNavList(){
        return selectList(Nav.class,"select * from tbl_nav") ;
    }

}
