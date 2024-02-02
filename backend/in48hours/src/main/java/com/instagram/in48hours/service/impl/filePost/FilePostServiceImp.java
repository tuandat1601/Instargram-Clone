package com.instagram.in48hours.service.impl.filePost;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.instagram.in48hours.service.filePost.FilePostService;
@Service
public class FilePostServiceImp implements FilePostService {
	@Value("${fileUpload.rootPath}")
	private String rootPath;
	private Path root;
	@Override
	public Resource loadFile(String fileName) {
		// TODO Auto-generated method stub
		 try {
			 try {
					root = Paths.get(rootPath);
			
					if(Files.notExists(root)) {
						Files.createDirectories(root);
					}
				}catch (Exception e) {
					System.out.println("Error create folder root: "+e.getMessage());
				}
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
