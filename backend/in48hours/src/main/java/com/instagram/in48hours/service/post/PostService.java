package com.instagram.in48hours.service.post;


import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.instagram.in48hours.entities.Post;
import com.instagram.in48hours.service.GenericService;
@Service
public interface PostService extends GenericService{
 boolean saveFilePost(Post post,MultipartFile[] file);
}
