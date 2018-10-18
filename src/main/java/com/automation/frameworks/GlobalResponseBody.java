/**
 *
 */
package com.automation.frameworks;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GlobalResponseBody {

	public boolean success() default true;

	public String methodName() default "";
}