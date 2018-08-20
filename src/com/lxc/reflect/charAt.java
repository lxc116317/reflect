package com.lxc.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class charAt {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String s="li";
		Method methodcharAt=String.class.getMethod("charAt",int.class);		//charAt返回指定索引处的 char值
		System.out.println(methodcharAt.invoke(s, 1));						//invoke()：调用类中的方法
		
	}	

}