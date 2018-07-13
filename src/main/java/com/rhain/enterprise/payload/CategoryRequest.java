package com.rhain.enterprise.payload;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class CategoryRequest {
    @NotNull
    private String name;
    @NotNull
    @PositiveOrZero
    private Integer order;
    @NotNull
    private String img;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
