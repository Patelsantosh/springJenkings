package com.shop.myProducts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.myProducts.entity.FileModal;
import com.shop.myProducts.entity.ProductEntity;
import com.shop.myProducts.model.ProductModel;

public interface proRepo extends JpaRepository<ProductEntity, Long> {

	//List<ProductModel> saveAll(List<ProductModel> invoices);

	//List<FileModal> saveAll(List<FileModal> invoices);

}
