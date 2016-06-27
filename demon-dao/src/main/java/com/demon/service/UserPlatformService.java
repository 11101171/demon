package com.demon.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demon.domain.UserPlatform;

/**   
* <p></p>
* @author ningzong.zeng
*/
public interface UserPlatformService {
	UserPlatform findById(Long id);
	UserPlatform findByLoginUsername(String loginUsername);
	Page<UserPlatform> findAll(int page, int pageSize);
	int update(Long id, String loginUsername, String loginPassword);
	UserPlatform save(UserPlatform record);
	Long deleteById(Long id);
	Long deleteByIdIn(List<Long> ids);
	UserPlatform login(String loginUsername, String loginPassword);
}
