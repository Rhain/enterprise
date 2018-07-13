package com.rhain.enterprise.payload;

import javax.validation.constraints.NotNull;

public class ProductRequest {

    @NotNull
    private Integer categoryId;
    @NotNull
    private String name;
    @NotNull
    private String desc;
    @NotNull
    private String size;
    @NotNull
    private String img;
    @NotNull
    private Integer order;
    @NotNull
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
