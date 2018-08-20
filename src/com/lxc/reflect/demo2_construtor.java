package com.lxc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class demo2_construtor {

	public static void main(String[] args) throws Exception {
				
				Constructor cons1=String.class.getConstructor(StringBuffer.class);//string类的class文件里包含getConstructor方法，来获取一个构造方法
				//创建实例对象的通常方式
				String str=new String(new StringBuffer("abc"));
				
				//创建实例对象的反射方式
				String s1=(String)cons1.newInstance(new StringBuffer("abc"));//new StringBuffer应该与StringBuffer相对应（调用获得的方法时要用到上面相同类型的实例对象）
		
		//String s2=String.class.newInstance();
		//System.out.println(s1);
		
		reflectPoint pt1=new reflectPoint(3,5);
		Field fieldY=pt1.getClass().getField("y");//getFields()：获得某个类的所有的公共（public）的字段，包括父类中的字段。 
		//因为x被私有了，所以会有这个方法getDeclaredField(),getDeclaredFields()：获得某个类的所有声明的字段，即包括public、private和protected，但是不包括父类的申明字段。
		Field fieldX=pt1.getClass().getDeclaredField("x");//
		
		fieldX.setAccessible(true);//成员变量(x)为private,故必须执行此操作
		//System.out.println(fieldY.get(pt1));//fieldY不是对象身上的值，而是类上，要用它去取某个对象上对应的值
		//System.out.println(fieldX.get(pt1));
		
		changeStringValue(pt1);
		System.out.println(pt1);
		
	}

	private static void changeStringValue(Object obj) throws Exception {
		Field[] field=obj.getClass().getFields();
		for (Field field2 : field) {
			if(field2.getType()==String.class) {
				String oldValue=(String)field2.get(obj);
				String newValue=oldValue.replace('b', 'a');
				field2.set(obj, newValue);
			}
		}
		
	}
}
