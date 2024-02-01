package com.instagram.in48hours.service.impl.post;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import com.instagram.in48hours.dto.PostRequest;
import com.instagram.in48hours.entities.FilePost;
import com.instagram.in48hours.entities.Post;
import com.instagram.in48hours.repository.FilePostRepository;
import com.instagram.in48hours.repository.PostRepository;
import com.instagram.in48hours.service.GenericService;
import com.instagram.in48hours.service.filePost.FilePostService;
import com.instagram.in48hours.service.post.PostService;
import com.instagram.in48hours.util.Predicates;

import jakarta.persistence.EntityExistsException;
@Service
public class PostServiceImp implements PostService {
@Autowired
PostRepository postRepository;

@Autowired
FilePostRepository filePostRepository; 

@Autowired
GenericService genericService;


@Value("${fileUpload.rootPath}")
private String rootPath;
private Path root;
public void initFile() {
	try {
		root = Paths.get(rootPath);
		System.out.println(root);
		if(Files.notExists(root)) {
			Files.createDirectories(root);
		}
	}catch (Exception e) {
		System.out.println("Error create folder root: "+e.getMessage());
	}

}

public <T> List<T> getAll(JpaRepository<T, Long> repository) {
	// TODO Auto-generated method stub
	return genericService.getAll(repository);
}
@Override
public <T,U> T create(JpaRepository<T, Long> repository, T entity,U listFile ) {
	T post = genericService.create(repository, entity, null);
	 Predicate<MultipartFile[]> condition = Predicates.isFileNotEmpty();
	if (condition.test((MultipartFile[]) listFile)) {
		saveFilePost( (Post) post, (MultipartFile[]) listFile);
	}
     // Save the new entity to the database
     return post;
}

public <T> Optional<T> getById(JpaRepository<T, Long> repository, Long id) {
	// TODO Auto-generated method stub
	return null;
}

public <T> T update(JpaRepository<T, Long> repository, T entity) {
	// TODO Auto-generated method stub
	return null;
}

public <T> T partialUpdate(JpaRepository<T, Long> repository, Long id, Map<String, Object> updates) {
	// TODO Auto-generated method stub
	return null;
}



@Override
public boolean saveFilePost(Post post, MultipartFile[] files) {
	try {
		initFile();
		 Date currentDate = new Date();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
		 String currentDateTime = dateFormat.format(currentDate);
		 for(MultipartFile file: files) {
			 
			
			 FilePost filePost = new FilePost();
			 filePost.setName(currentDateTime+file.getOriginalFilename());
			 filePost.setType(file.getContentType());
			 filePost.setPost(post);
			filePost.setPath(root.toString()+ "\\" +filePost.getName());
			filePost.setType(file.getContentType());
			filePostRepository.save(filePost);
			 Files.copy(file.getInputStream(),root.resolve(currentDateTime+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			
		 }
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return true;
}
@Override
public <T> void deleteById(JpaRepository<T, Long> repository, Long id) {
	// TODO Auto-generated method stub
	
}









	
	
}
