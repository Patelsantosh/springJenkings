package com.shop.myProducts.serviceImpl;



import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.myProducts.entity.ProductEntity;
import com.shop.myProducts.helper.Helper;
import com.shop.myProducts.model.ProductModel;
//import com.shop.myProducts.repository.FileRepository;
import com.shop.myProducts.repository.proRepo;
import com.shop.myProducts.service.proService;

@Service
public class proServiceImpl implements proService{

	@Autowired
	private proRepo repo;
	
	@Autowired
	private ModelMapper map;
	@Override
	public ProductModel addProducts(ProductModel model) {
		// TODO Auto-generated method stub
		ProductEntity entity=map.map(model, ProductEntity.class);
		ProductEntity entities=repo.save(entity);
		ProductModel models=map.map(entities, ProductModel.class);
		
		return models;
	}
	
	public void save(MultipartFile file){
	try {
		List<ProductEntity> products = Helper.convertExcelToProduct(file.getInputStream())	;
		this.repo.saveAll(products);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public List<ProductEntity> getAllProducts(){
		return this.repo.findAll();
	}

		
	}



