package com.nnh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnh.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
}
