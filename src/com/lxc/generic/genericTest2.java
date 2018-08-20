package com.lxc.generic;


import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Vector;

public class genericTest2 {
	//ͨ�������÷��͵�ʵ�����Ͳ���
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		//Vector<Date> v1=new Vector<>();
		
		//��ȡgenericTest2���ֽ��룬�����ֽ����ȡ����
		Method applyMethod= genericTest2.class.getMethod("applyVector", Vector.class);
		
		//��ȡ���͵Ĳ����б�(��Ϊ�ֽ�����û�з��ͣ����Ի�ȡ�����б�)	getGenericParameterTypes()�ķ���ֵ��Type[]����
		Type[] type= applyMethod.getGenericParameterTypes();
		
		//ParameterizedType ��ʾ���������ͣ��� Collection<String> (���Ǿ������ȡ����������������������Type[]�б��µģ���ѯapi��֪)
		ParameterizedType ptype=(ParameterizedType) type[0]; 
		
		//��ȡԭ�е�����	������Ϊclass java.util.Vector
		System.out.println(ptype.getRawType());
		//��һ�����������л�ȡ��һ�����Ͳ����������࣬������Ϊclass java.util.Date
		System.out.println(ptype.getActualTypeArguments()[0]);
		
	}
	public static void applyVector(Vector<Date> v1) {
		
	}
	
	
	
	


}
