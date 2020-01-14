package com.prestashops.utilities;

import java.util.List;
import java.util.Map;

public class TestingExcelUtil {
	
	public static void main(String[] args) {
		
		// open file and create utility object which holds out excel data
		ExcelUtil excelObject = new ExcelUtil("myown.xlsx", "data");
		// SUPPOSED TO BE HERE: "src/test/resources/com/prestashop/testdata/myown.xlsx"
		
		System.out.println("Column count: "+excelObject.columnCount());
		System.out.println("Row count: " + excelObject.rowCount());
	
		// method to get all column names
		List<String> columnsNames = excelObject.getColumnsNames();
		System.out.println(columnsNames);
		
		// get all data in nested array
		String[][] dataArray = excelObject.getDataArray();
		
		for (String[] row : dataArray) {
			for (String value : row) {
				System.out.print(value + "\t");
			}
			System.out.println();
			
		}
		
		List<Map<String, String>> dataList = excelObject.getDataList();
		
		System.out.println(dataList);
		
		for(Map<String, String> row : dataList) {
			System.out.println(row);
		}
		
		//name of the product in the 2rd row
		System.out.println("Name of the Product in the 3rd row:");
		System.out.println(dataList.get(3).get("Product"));
		
		// data by index
		System.out.println(excelObject.getCellData(2, 2));
		
		
	}

}
