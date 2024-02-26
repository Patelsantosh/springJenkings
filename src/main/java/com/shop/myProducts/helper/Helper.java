package com.shop.myProducts.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.shop.myProducts.entity.ProductEntity;

public class Helper {

	public static boolean checkExcelFormat(MultipartFile file) {
		
		String contentType=file.getContentType();
		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
			return true;
		
		}else {
			return false;
		}
	}
	public static List<ProductEntity> convertExcelToProduct(InputStream is) {
	    List<ProductEntity> entity = new ArrayList<>();

	    try {
	        XSSFWorkbook workbook = new XSSFWorkbook(is);  // Load the workbook from InputStream
	        XSSFSheet sheet = workbook.getSheet("data");

	        int rowNumber = 0;
	        Iterator<Row> iterator = sheet.iterator();

	        while (iterator.hasNext()) {
	            Row row = iterator.next();

	            if (rowNumber == 0) {
	                rowNumber++;
	                continue;
	            }

	            Iterator<Cell> cells = row.iterator();
	            int cid = 0;
	            ProductEntity pdct = new ProductEntity();

	            while (cells.hasNext()) {
	                Cell cell = cells.next();

	                switch (cid) {
	                    case 0:
	                        pdct.setPrice(cell.getNumericCellValue());
	                        break;
	                    case 1:
	                        pdct.setId((int) cell.getNumericCellValue());
	                        break;
	                    case 2:
	                        pdct.setProModel(cell.getStringCellValue());
	                        break;
	                    case 3:
	                        pdct.setProName(cell.getStringCellValue());
	                        break;
	                    default:
	                        break;
	                }
	                cid++;
	            }

	            entity.add(pdct);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return entity;
	}

}	