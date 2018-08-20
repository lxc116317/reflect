package com.lxc.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class javabean {
/*
 * 1.��ȡreflectPoint��
 * 2.���÷���õ���ķ���
 * 3.���÷���õ���ķ���������
 */
	public static void main(String[] args) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		reflectPoint pt1=new reflectPoint(3, 5);
		//"x"-->"X"-->getX-->MethodGetX
		String propertyName="x";
		Object retVal = getproperty(pt1, propertyName);
		System.out.println(retVal);
		
		Object value=7;
		setproperty(pt1, propertyName, value);
		System.out.println(pt1.getX());
	}



private static Object getproperty(reflectPoint pt1, String propertyName)
		throws IntrospectionException, IllegalAccessException, InvocationTargetException {
	/*PropertyDescriptor pd=new PropertyDescriptor(propertyName, pt1.getClass());
	//��ȡmethodGetX����
	Method methodGetX=pd.getReadMethod();
	//�õ���ķ���������
	Object retVal=methodGetX.invoke(pt1);
	return retVal;*/
	
	//���ӻ��Ľ��
	/*
	 * ����beaninfo���������Է�ʽ�����Һ�����ĳ��reflectPoint�����x���ԡ�
	 * �ڳ����а�һ���൱��javabean����
	 * 		���ǵ���Introspector.getBeanInfo�������õ���BeanInfo�����װ�˰�����൱��javabean���Ľ����Ϣ
	 */
	BeanInfo beaninfo=Introspector.getBeanInfo(pt1.getClass());
	PropertyDescriptor[] pds=beaninfo.getPropertyDescriptors();	//��ȡ���������������
	Object retVal = null;
	for(PropertyDescriptor pd:pds) {		//���������Խ��б���
		if(pd.getName().equals(propertyName)) {		//������Ժ�Ҫ����������ͬ
			Method methodGetX=pd.getReadMethod();	//��ȡ��ȡmethodGetX����
			retVal=methodGetX.invoke(pt1);			//�õ���ķ���������	
			break;
		}
		
	}
	return retVal;
}



private static void setproperty(reflectPoint pt1, String propertyName, Object value)
		throws IntrospectionException, IllegalAccessException, InvocationTargetException {
	PropertyDescriptor pd=new PropertyDescriptor(propertyName, pt1.getClass());
	Method methodSetX=pd.getWriteMethod();
	methodSetX.invoke(pt1, value);
	
	
	
}







	
	

	
}
