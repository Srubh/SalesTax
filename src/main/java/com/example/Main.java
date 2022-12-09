package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.example.service.Impl.ProductServiceImpl;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		List<String> data;
		
		//Read the file from resource folder
		for (File f : getResourceFolderFiles("asset")) {
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			data = new ArrayList<>();
			String st;
			while ((st = br.readLine()) != null)
				data.add(st);
			
			ProductServiceImpl productService = new ProductServiceImpl();
			productService.calculateTax(data);
		}
	}

	private static File[] getResourceFolderFiles(String folder) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		java.net.URL url = loader.getResource(folder);
		String path = url.getPath();
		return new File(path).listFiles();
	}
}
