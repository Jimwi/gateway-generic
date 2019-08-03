package com.example.gateway.dao.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by JiWen on 2019/6/30 at home.
 */
public class BaseEntity implements Serializable {
    private Long id;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
