package com.demon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demon.domain.TurnImg;
import com.demon.repository.TurnImgRepository;
import com.demon.service.TurnImgService;

/**   
* @author wangjunbiao
*/
@Service
public class TurnImgServiceImpl implements  TurnImgService{
	
	public final TurnImgRepository turnImgRepository;
	
	@Autowired
	public TurnImgServiceImpl(TurnImgRepository turnImgRepository) {
		this.turnImgRepository = turnImgRepository;
	}

	@Override
	public List<TurnImg> getTurnImgByType(int i) {
		return this.turnImgRepository.findTurnImgByType(i);
	}

	

}
