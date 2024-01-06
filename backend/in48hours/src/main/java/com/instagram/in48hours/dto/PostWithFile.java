package com.instagram.in48hours.dto;

import org.springframework.web.multipart.MultipartFile;

public class PostWithFile {
	private String caption;

	private long user;
	private MultipartFile[] file;
	
	public PostWithFile(String caption, long user, MultipartFile[] file) {
		super();
		this.caption = caption;
		this.user = user;
		this.file = file;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public long getUser() {
		return user;
	}
	public void setUser(long user) {
		this.user = user;
	}
	public MultipartFile[] getFile() {
		return file;
	}
	public void setFile(MultipartFile[] file) {
		this.file = file;
	}
	
}
