package com.rhain.enterprise.payload;

import javax.validation.constraints.NotNull;

public class CarouselRequest {
    @NotNull
    private String name;
    @NotNull
    private String img;
    @NotNull
    private Integer order;
    private Integer productId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
