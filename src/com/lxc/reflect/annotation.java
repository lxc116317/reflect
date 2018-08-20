package com.lxc.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Enumeration;
/*一个注解的生命周期有三个阶段
 * 		java源文件阶段：RetentionPolicy.SOURCE 
 * 		class文件阶段：RetentionPolicy.CLASS
 * 		内存中的字节码阶段：RetentionPolicy.RUNTIME
 *javac把源文件翻译成class文件可能会去掉那个注解
 *类加载器把class文件加载到内存的时候也可能会去掉注解
 * 		默认值是在class阶段
 */
@Retention(RetentionPolicy.RUNTIME)		//注解的注解，元注解
public @interface annotation {

		String color() default "blue";//设置默认的颜色值时，因为有String value()，所以当写"abc"时，是没有问题的

		String value();
		
		
		//演示数组类型的属性
		int[] arr() default {1,2,3};
		
		
		//演示注解类型的属性
		MetaAnnotation annotationAttr()  default @MetaAnnotation("c");
		
}
