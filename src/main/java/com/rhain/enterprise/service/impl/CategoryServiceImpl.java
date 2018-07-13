package com.rhain.enterprise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rhain.enterprise.dao.CategoryDao;
import com.rhain.enterprise.model.Category;
import com.rhain.enterprise.payload.CategoryRequest;
import com.rhain.enterprise.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category addCategory(CategoryRequest categoryRequest) {
        Category category = new Category(categoryRequest);
        categoryDao.insertCategory(category);
        return category;
    }

    @Override
    public PageInfo<Category> findCategories(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> categories = categoryDao.selectCategories();
        return new PageInfo<Category>(categories);
    }

    @Override
    public int updateCategory(Category category) {
        category.setUpdateAt(new Date());
        return categoryDao.updateCategory(category);
    }

    @Override
    public Boolean checkCategoryNameExist(String name) {
        return categoryDao.getByName(name) != null;
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryDao.deleteCategoryById(id);
    }
}
