package com.instagram.in48hours.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean2;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.instagram.in48hours.entities.Post;
import com.instagram.in48hours.service.GenericService;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
@Service
public class GenericServiceImp implements GenericService {

	@Override
	public <T> List<T> getAll(JpaRepository<T, Long> repository) {
	
		  return repository.findAll();
	}

	@Override
	public <T> Optional<T> getById(JpaRepository<T, Long> repository, Long id) {
		
		return repository.findById(id);
	}
	
	@Override
	 public <T> T update(JpaRepository<T, Long> repository, T entity) {
        return repository.save(entity);
    }
	@Override
	public <T> T  partialUpdate(JpaRepository<T, Long> repository, Long id, Map<String, Object> updates) {
	
		 Optional<T> optional = getById(repository, id);
		 
		  if (optional.isPresent()) {
	            T existingEntity =optional.get();
	            updates.forEach((fieldName, value) -> {         
	            	try {
						PropertyUtils.setProperty(existingEntity, fieldName, value);
					} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            });
	            return update(repository, existingEntity);
	        } else {
	            
	            throw new EntityNotFoundException("Entity not found with ID: " + id);
	        }
	}

	@Override
	public <T> void deleteById(JpaRepository<T, Long> repository, Long id) {
		Optional<T> optionalEntity = getById(repository, id);

        if (optionalEntity.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Entity not found with ID: " + id);
        }
		
	}

	@Override
	public <T,U> T create(JpaRepository<T, Long> repository, T entity,U type) {
		
	        return repository.save(entity);
	}
	

	
}
