package com.rhain.enterprise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rhain.enterprise.dao.CarouselDao;
import com.rhain.enterprise.model.Carousel;
import com.rhain.enterprise.model.Category;
import com.rhain.enterprise.payload.CarouselRequest;
import com.rhain.enterprise.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "carouselService")
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselDao carouselDao;

    @Override
    public Carousel addCarousel(CarouselRequest carouselRequest) {
        Carousel carousel = new Carousel(carouselRequest);
        carouselDao.insertCarousel(carousel);
        return carousel;
    }

    @Override
    public PageInfo<Carousel> findCarousels(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Carousel> carousels = carouselDao.selectCarousels();
        return new PageInfo<Carousel>(carousels);
    }

    @Override
    public int updateCarousel(Carousel carousel) {
        carousel.setUpdateAt(new Date());
        return carouselDao.updateCarousel(carousel);
    }

    @Override
    public void deleteCarousel(Integer id) {
        carouselDao.deleteCarouselById(id);
    }
}
