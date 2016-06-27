package com.demon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demon.domain.MediaType;
import com.demon.repository.MediaTypeRepository;
import com.demon.service.MediaTypeService;

/**   
* @author wangjunbiao
*/
@Service
public class MediaTypeServiceImpl implements  MediaTypeService{
	
	public final MediaTypeRepository mediaTypeRepository;
	
	@Autowired
	public MediaTypeServiceImpl(MediaTypeRepository mediaTypeRepository) {
		this.mediaTypeRepository = mediaTypeRepository;
	}

	@Override
	public List<MediaType> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MediaType> getIndexMediaType(int i) {
		return this.mediaTypeRepository.findIndexMediaType(i);
	}

}
