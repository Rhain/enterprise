package com.rhain.enterprise.model;

import com.rhain.enterprise.payload.ProductRequest;

public class Product extends DateAudit {
    private Integer id;
    private Integer categoryId;
    private String name;
    private String desc;
    private String size;
    private String img;
    private Integer order;

    public Product(){}

    public Product(ProductRequest productRequest) {
        super();
        this.categoryId = productRequest.getCategoryId();
        this.name = productRequest.getName();
        this.desc = productRequest.getDesc();
        this.size = productRequest.getSize();
        this.img = productRequest.getImg();
        this.order = productRequest.getOrder();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
