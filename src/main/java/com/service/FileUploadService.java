package com.service;

import java.awt.font.MultipleMaster;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	public void uploadImage(MultipartFile masterImage){
		System.out.println(masterImage.getOriginalFilename());
		String path = "C:\\sts\\24-web-spring-mix-6\\src\\main\\webapp\\images\\products";
		
		try {
			byte b[] = masterImage.getBytes();
			
			File file = new File(path,masterImage.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file,b);
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	
	}
	
	public void uploadUserImage(MultipartFile masterImage,String email){
		System.out.println(masterImage.getOriginalFilename());
		String path = "C:\\sts\\24-web-spring-mix-6\\src\\main\\webapp\\images\\profilepic";
		
		File dr = new File(path,email); 
		dr.mkdir();
		
		try {
			byte b[] = masterImage.getBytes();
			
			File file = new File(dr,masterImage.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file,b);
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	
	}
	
	
}
