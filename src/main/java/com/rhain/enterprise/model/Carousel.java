package com.rhain.enterprise.model;

import com.rhain.enterprise.payload.CarouselRequest;

public class Carousel extends DateAudit {
    private Integer id;
    private String name;
    private String img;
    private Integer order;
    private Integer productId;

    public Carousel(){}

    public Carousel(CarouselRequest carouselRequest) {
        super();
        this.name = carouselRequest.getName();
        this.img = carouselRequest.getImg();
        this.order = carouselRequest.getOrder();
        this.productId = carouselRequest.getProductId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
