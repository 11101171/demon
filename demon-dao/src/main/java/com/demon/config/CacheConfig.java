package com.demon.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**   
* <p></p>
* @author ningzong.zeng
*/
@Configuration
@EnableCaching//标注启动缓存.
public class CacheConfig {
	Logger logger = LoggerFactory.getLogger(CacheConfig.class);
	/*value属性表示使用哪个缓存策略，缓存策略在ehcache.xml */
    //public static final String CACHE_NAME_FOR_COMMON = "common";
	/*这里的单引号不能少，否则会报错，被识别是一个对象; */
    public static final String CACHE_VAL_FOR_USERPLATFORM= "cUserPlatform";
    
	/**
     *  ehcache 主要的管理器
     * @param bean
     * @return
     */
	@Bean
	public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
		logger.info("启动CacheConfiguration...");
		return new EhCacheCacheManager(bean.getObject());
	}

	/*
	 * 据shared与否的设置, Spring分别通过CacheManager.create() 或new
	 * CacheManager()方式来创建一个ehcache基地.
	 *
	 * 也说是说通过这个来设置cache的基地是这里的Spring独用,还是跟别的(如hibernate的Ehcache共享)
	 *
	 */
	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		logger.info("加载CacheConfiguration...");
		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("conf/ehcache.xml"));
		cacheManagerFactoryBean.setShared(true);
		return cacheManagerFactoryBean;
	}
}
