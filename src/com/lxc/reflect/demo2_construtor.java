package com.lxc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class demo2_construtor {

	public static void main(String[] args) throws Exception {
				
				Constructor cons1=String.class.getConstructor(StringBuffer.class);//string���class�ļ������getConstructor����������ȡһ�����췽��
				//����ʵ�������ͨ����ʽ
				String str=new String(new StringBuffer("abc"));
				
				//����ʵ������ķ��䷽ʽ
				String s1=(String)cons1.newInstance(new StringBuffer("abc"));//new StringBufferӦ����StringBuffer���Ӧ�����û�õķ���ʱҪ�õ�������ͬ���͵�ʵ������
		
		//String s2=String.class.newInstance();
		//System.out.println(s1);
		
		reflectPoint pt1=new reflectPoint(3,5);
		Field fieldY=pt1.getClass().getField("y");//getFields()�����ĳ��������еĹ�����public�����ֶΣ����������е��ֶΡ� 
		//��Ϊx��˽���ˣ����Ի����������getDeclaredField(),getDeclaredFields()�����ĳ����������������ֶΣ�������public��private��protected�����ǲ���������������ֶΡ�
		Field fieldX=pt1.getClass().getDeclaredField("x");//
		
		fieldX.setAccessible(true);//��Ա����(x)Ϊprivate,�ʱ���ִ�д˲���
		//System.out.println(fieldY.get(pt1));//fieldY���Ƕ������ϵ�ֵ���������ϣ�Ҫ����ȥȡĳ�������϶�Ӧ��ֵ
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
