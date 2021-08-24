package com.example.demo.Storage;


import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repository.UploadRepository;
import com.example.demo.modal.Upload;

import org.springframework.util.StringUtils;



@Service
public class DBFileStorageService {

	@Autowired
	private UploadRepository uploadRepository;

	public Upload storeFile(MultipartFile file) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			Upload dbFile = new Upload(fileName, file.getContentType(), file.getBytes());

			return uploadRepository.save(dbFile);
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public Upload getFile(String fileId) {
		return uploadRepository.findById(fileId)
				.orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
	}
}








