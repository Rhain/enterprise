package com.rhain.enterprise.dao;

import com.rhain.enterprise.model.Carousel;
import com.rhain.enterprise.model.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarouselDao {
    int insertCarousel(@Param("carousel") Carousel carousel);

    List<Carousel> selectCarousels();

    int updateCarousel(@Param("carousel")Carousel category);

    void deleteCarouselById(Integer id);
}
