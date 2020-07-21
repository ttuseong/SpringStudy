package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	public String restore(MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		
		String saveDir = "C:\\javaStudy\\upload";
		
		String orgName = file.getOriginalFilename();
		
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		
		String filePath = saveDir+"\\"+saveName;
		
		long fileSize = file.getSize();
		
		System.out.println(orgName + "\n" + exName + "\n" + saveName + "\n" + fileSize + "\n" + filePath);
	
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			bout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return saveName;
	}
}
