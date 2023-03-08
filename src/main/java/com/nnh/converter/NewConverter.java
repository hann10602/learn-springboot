package com.nnh.converter;

import org.springframework.stereotype.Component;

import com.nnh.dto.NewDTO;
import com.nnh.entity.NewEntity;

@Component
public class NewConverter {
	public NewEntity toEntity(NewDTO dto) {
		NewEntity entity = new NewEntity();
		entity.setTitle(dto.getTitle());
		entity.setShortDescription(dto.getShortDescription());
		entity.setContent(dto.getContent());
		entity.setThumbnail(dto.getThumbnail());
		
		return entity;
	}
	
	public NewDTO toDTO(NewEntity entity) {
		NewDTO newDTO = new NewDTO();
		if(entity.getId() != null) {
			newDTO.setId(entity.getId());
		}
		newDTO.setTitle(entity.getTitle());
		newDTO.setShortDescription(entity.getShortDescription());
		newDTO.setContent(entity.getContent());
		newDTO.setThumbnail(entity.getThumbnail());
		newDTO.setCreatedBy(entity.getCreatedBy());
		newDTO.setCreatedDate(entity.getCreatedDate());
		newDTO.setModifiedBy(entity.getModifiedBy());
		newDTO.setModifiedDate(entity.getModifiedDate());
		
		return newDTO;
	}
	
	public NewEntity toEntity(NewDTO dto, NewEntity entity) {
		entity.setTitle(dto.getTitle());
		entity.setShortDescription(dto.getShortDescription());
		entity.setContent(dto.getContent());
		entity.setThumbnail(dto.getThumbnail());
		
		return entity;
	}
	
}
