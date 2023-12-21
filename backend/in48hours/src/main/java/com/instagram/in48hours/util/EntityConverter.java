package com.instagram.in48hours.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Service
public class EntityConverter {
	 public static <T, U> T convertToEntity(U source, Class<T> targetClass) {
	        if (source == null) {
	            return null;
	        }

	        try {
	            T target = targetClass.getDeclaredConstructor().newInstance();
	            BeanUtils.copyProperties(source, target);
	            return target;
	        } catch (Exception e) {
	            // Handle exception (e.g., log it) or throw a custom runtime exception
	            throw new RuntimeException("Error converting object to entity", e);
	        }
	    }
}
