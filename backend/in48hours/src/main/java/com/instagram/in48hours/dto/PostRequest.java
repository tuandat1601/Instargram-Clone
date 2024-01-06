package com.instagram.in48hours.dto;

import org.springframework.web.multipart.MultipartFile;

public class PostRequest {
private String caption;

private long user;

public PostRequest(String caption, long user) {
	super();
	this.caption = caption;

	this.user = user;
}

public void setCaption(String caption) {
	this.caption = caption;
}



public void setUser(long user) {
	this.user = user;
}

public String getCaption() {
	return caption;
}


public long getUser() {
	return user;
}


}
