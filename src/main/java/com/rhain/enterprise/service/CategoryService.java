package com.rhain.enterprise.service;

import com.github.pagehelper.PageInfo;
import com.rhain.enterprise.model.Category;
import com.rhain.enterprise.model.Product;
import com.rhain.enterprise.payload.CategoryRequest;
import com.rhain.enterprise.payload.ProductRequest;

import java.util.List;

public interface CategoryService {
    Category addCategory(CategoryRequest categoryRequest);

    PageInfo<Category> findCategories(int pageNum, int pageSize);

    int updateCategory(Category category);

    Boolean checkCategoryNameExist(String name);

    void deleteCategory(Integer id);
}
