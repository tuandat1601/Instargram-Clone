package com.instagram.in48hours.util;

import java.util.function.Predicate;

import org.springframework.web.multipart.MultipartFile;

public class Predicates {
	public static Predicate<MultipartFile[]> isFileNotEmpty() {
        return file -> file != null &&  file.length > 0;
	}
}
