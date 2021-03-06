package com.demon.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.demon.config.CacheConfig;
import com.demon.domain.UserPlatform;
import com.demon.domain.enums.AdminRole;
import com.demon.repository.UserPlatformRepository;
import com.demon.service.UserPlatformService;
import com.demon.util.MD5Util;
/**   
* <p></p>
* @author ningzong.zeng
*/
@Service
public class UserPlatformServiceImpl implements UserPlatformService {
	public final UserPlatformRepository userPlatformRepository;
	public final String salt = "(t6$M#.?";
	
	@Autowired
	public UserPlatformServiceImpl(UserPlatformRepository userPlatformRepository) {
		this.userPlatformRepository = userPlatformRepository;
	}
	
	@Override
	public Page<UserPlatform> findAll(int page, int pageSize) {
		return this.userPlatformRepository.findAll(new PageRequest(page, pageSize, new Sort(Direction.DESC, new String[] { "gmtCreate" }) ));
	}
	
	/**
	 * https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-cache/
	 * 在支持Spring Cache的环境下，对于使用@Cacheable标注的方法，
	 * Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，
	 * 如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，
	 * 否则才会执行并将返回结果存入指定的缓存中。
	 * @CachePut也可以声明一个方法支持缓存功能。
	 * @Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，
	 * 而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
	 */
	
	@Override
	@Cacheable(value=CacheConfig.CACHE_VAL_FOR_USERPLATFORM,key="#id")
	public UserPlatform findById(Long id) {
		return userPlatformRepository.findById(id);
	}
	
	@Override
	@Cacheable(value=CacheConfig.CACHE_VAL_FOR_USERPLATFORM,key="#loginUsername")
	public UserPlatform findByLoginUsername(String loginUsername) {
		return this.userPlatformRepository.findByLoginUsername(loginUsername);
	}
	
	@Override
	@CachePut(value=CacheConfig.CACHE_VAL_FOR_USERPLATFORM,key="#record.getId()")
	public UserPlatform save(UserPlatform record) {
		record.setLoginPassword(md5Password(record.getLoginPassword()));
		record.setRole(AdminRole.ADMIN);
		record.setGmtCreate(new Date());
		record.setGmtMotify(new Date());
		return this.userPlatformRepository.save(record);
	}
	
	@Override
	@CacheEvict(value=CacheConfig.CACHE_VAL_FOR_USERPLATFORM,key="#id", allEntries=true)
	public int update(Long id, String loginUsername, String loginPassword) {
		return this.userPlatformRepository.setFixedFor(id, loginUsername, md5Password(loginPassword));
	}
	
	@Override
	@CacheEvict(value=CacheConfig.CACHE_VAL_FOR_USERPLATFORM,key="#id", allEntries=true)
	public Long deleteById(Long id) {
		return this.userPlatformRepository.deleteById(id);
	}
	
	// 这个缓存清理还有些问题
	@Override
	@CacheEvict(value=CacheConfig.CACHE_VAL_FOR_USERPLATFORM,key="#ids",allEntries=true)
	public Long deleteByIdIn(List<Long> ids) {
		return this.userPlatformRepository.deleteByIdIn(ids);
	}
	
	@Override
	public UserPlatform login(String loginUsername, String loginPassword) {
		UserPlatform userPlatform = this.findByLoginUsername(loginUsername);
		if(userPlatform != null && verifyMd5Password(loginPassword, userPlatform.getLoginPassword())) {
			return userPlatform;
		}
		return null;
	}
	
	private String md5Password(String password){
		return MD5Util.sign(password, salt);
	}
	
	private boolean verifyMd5Password(String password, String sign){
		return MD5Util.verify(password, sign, salt);
	}
	
}
