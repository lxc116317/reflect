package com.lxc.reflect;

import com.lxc.bean.person;
//通过三种方式获得字节码对象
public class demo1_reflect {

	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz1=Class.forName("com.lxc.bean.person");
		Class clazz2=person.class;
	
		
		

		
		

		person p=new person();
		Class clazz3=p.getClass();
		
		System.out.println(clazz1==clazz2);
		System.out.println(clazz2==clazz3);
	}

}
