package com.rhain.enterprise.dao;

import com.rhain.enterprise.model.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDao {
    int insertProduct(@Param("product")Product product);

    List<Product> selectProducts();

    List<Product> selectProductsByName(@Param("name") String name);

    int updateProduct(@Param("product")Product product);

    void deleteProductById(Integer id);
}
