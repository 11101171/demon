package com.demon.access;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.demon.domain.enums.AdminRole;

/**
* <p></p>
* @author ningzhong.zeng
*
 */
@Target( { ElementType.METHOD, ElementType.TYPE, ElementType.PACKAGE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminAccess {
	AdminRole[] value() default {};
}