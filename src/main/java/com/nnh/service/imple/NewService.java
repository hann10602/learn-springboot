package com.nnh.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnh.converter.NewConverter;
import com.nnh.dto.NewDTO;
import com.nnh.entity.CategoryEntity;
import com.nnh.entity.NewEntity;
import com.nnh.repository.CategoryRepository;
import com.nnh.repository.NewRepository;
import com.nnh.service.INewService;

@Service
public class NewService implements INewService{

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId() != null) {
			List<NewEntity> newList = newRepository.findAll();
			for(NewEntity eachNew : newList) {
				if(eachNew.getId() == newDTO.getId()) {
					newEntity = eachNew;
					break;
				}
			}
			newEntity = newConverter.toEntity(newDTO, newEntity);
		} else {
			newEntity = newConverter.toEntity(newDTO);
		}
		CategoryEntity category = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(category);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}
}
