package com.rhain.enterprise.service;

import com.github.pagehelper.PageInfo;
import com.rhain.enterprise.model.Carousel;
import com.rhain.enterprise.payload.CarouselRequest;

public interface CarouselService {

    Carousel addCarousel(CarouselRequest carouselRequest);

    PageInfo<Carousel> findCarousels(int pageNum, int pageSize);

    int updateCarousel(Carousel carousel);

    void deleteCarousel(Integer id);
}
