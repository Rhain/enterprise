package com.rhain.enterprise.model;

import com.rhain.enterprise.payload.CategoryRequest;

public class Category extends DateAudit {
    private Integer id;
    private String name;
    private Integer order;
    private String img;

    public Category(){}

    public Category(CategoryRequest categoryRequest) {
        super();
        this.name = categoryRequest.getName();
        this.order = categoryRequest.getOrder();
        this.img = categoryRequest.getImg();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
