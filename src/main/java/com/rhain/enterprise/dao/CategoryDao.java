package com.rhain.enterprise.dao;

import com.rhain.enterprise.model.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryDao {
    int insertCategory(@Param("category")Category category);

    List<Category> selectCategories();

    int updateCategory(@Param("category")Category category);

    Category getByName(String name);

    void deleteCategoryById(Integer id);
}
