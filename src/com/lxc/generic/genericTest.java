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
		
		System.out.println(list1.getClass()==list2.getClass());	//��ӡ���Ϊtrue,˵��������֮���Ϊ���ֽ�����û���˷���

		//��˿�����list2�����÷���洢String���͵��ַ���(��ʹ����ָʾ�����Ͳ�ͬ�����Ƿ��͵�����ʱ���Ѿ���ȥ��)
		list2.getClass().getMethod("add",Object.class).invoke(list2, "abc");
		System.out.println(list2);
	}
}