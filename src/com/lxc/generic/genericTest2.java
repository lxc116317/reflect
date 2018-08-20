package com.lxc.generic;


import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Vector;

public class genericTest2 {
	//通过反射获得泛型的实际类型参数
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		//Vector<Date> v1=new Vector<>();
		
		//获取genericTest2的字节码，并从字节码获取方法
		Method applyMethod= genericTest2.class.getMethod("applyVector", Vector.class);
		
		//获取泛型的参数列表(因为字节码中没有泛型，所以获取参数列表)	getGenericParameterTypes()的返回值是Type[]数组
		Type[] type= applyMethod.getGenericParameterTypes();
		
		//ParameterizedType 表示参数化类型，如 Collection<String> (我们就是想获取这样的情况，这个参数是在Type[]列表下的，查询api可知)
		ParameterizedType ptype=(ParameterizedType) type[0]; 
		
		//获取原有的类型	输出结果为class java.util.Vector
		System.out.println(ptype.getRawType());
		//从一个泛型类型中获取第一个泛型参数的类型类，输出结果为class java.util.Date
		System.out.println(ptype.getActualTypeArguments()[0]);
		
	}
	public static void applyVector(Vector<Date> v1) {
		
	}
	
	
	
	


}
