package com.lxc.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class genericTest {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ArrayList<String> list1=new ArrayList<>();
		list1.add("abc");
		
		ArrayList<Integer> list2=new ArrayList<>();
		list2.add(1);
		list2.remove(0);
		
		System.out.println(list1.getClass()==list2.getClass());	//打印结果为true,说明编译完之后成为的字节码里没有了泛型

		//因此可以在list2中利用反射存储String类型的字符串(即使泛型指示了类型不同，但是泛型的作用时间已经过去了)
		list2.getClass().getMethod("add",Object.class).invoke(list2, "abc");
		System.out.println(list2);
	}
}