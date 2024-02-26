package com.shop.myProducts.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.myProducts.entity.ProductEntity;
import com.shop.myProducts.model.ProductModel;

@Service
public interface proService {

	ProductModel addProducts(ProductModel model);

	void save(MultipartFile file);

	List<ProductEntity> getAllProducts();

	
}
