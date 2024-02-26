package com.shop.myProducts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shop.myProducts.entity.ProductEntity;
import com.shop.myProducts.helper.Helper;
import com.shop.myProducts.model.ProductModel;
import com.shop.myProducts.service.proService;

@RestController
@RequestMapping("api/users")
public class SaveProducts {
	
	@Autowired
	private proService service;

	@PostMapping("saveProducts")
	public ProductModel addPducts(@RequestBody ProductModel model) {
		ProductModel models=service.addProducts(model);
		ProductEntity inv = new ProductEntity();
		return models;
	}

	@GetMapping("testing")
	public String test() {
		return "hello wolrd";
	}

	@PostMapping("uploadExcel")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
		
		if(Helper.checkExcelFormat(file)) {
			
			this.service.save(file);
			return ResponseEntity.ok("succes");
			
		}
		return (ResponseEntity<?>) ResponseEntity.badRequest();
	    // Your code logic here
	}

	
	@GetMapping("getAll")
		public List<ProductEntity> getAll(){
		return this.service.getAllProducts();
	}

}
