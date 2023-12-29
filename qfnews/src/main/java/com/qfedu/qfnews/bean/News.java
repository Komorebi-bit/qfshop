package com.qfedu.qfnews.bean;

import com.common.dbaccess.annotation.NotNull;
import com.common.dbaccess.annotation.TableBean;
import java.util.Date;

/**
 * @author Komorebi
 * @since 2023.12.26.16:21
 */
public class News {
    public String datetime;
    //视图中有
    public String nav;
    public Integer type;

    public String getDatetime() {
        return datetime;
    }
    @TableBean(ignore = true)//告诉数据库，忽略他
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    private Integer id;
    @NotNull    //添加修改时不能为空
    private String title;
    @NotNull
    private String content;
    private Date ctime;
    private Integer nid;
    private String image;
    private String photo;
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
