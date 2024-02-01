package com.instagram.in48hours.service.filePost;

import java.nio.file.Path;

import org.springframework.core.io.Resource;

public interface FilePostService {
	Resource loadFile(String fileName);
}
