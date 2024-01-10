package com.instagram.in48hours.service.impl.filePost;

import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.instagram.in48hours.service.filePost.FilePostService;

public class FilePostServiceImp implements FilePostService {

	@Override
	public Resource loadFile(String fileName, Path root) {
		// TODO Auto-generated method stub
		 try {
		      Path file = root.resolve(fileName);
		      Resource resource = new UrlResource(file.toUri());

		      if (resource.exists() || resource.isReadable()) {
		        return resource;
		      } else {
		        throw new RuntimeException("Could not read the file!");
		      }
		    } catch (MalformedURLException e) {
		      throw new RuntimeException("Error: " + e.getMessage());
		    }
	}

}
