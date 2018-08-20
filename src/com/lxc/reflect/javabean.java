package com.lxc.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class javabean {
/*
 * 1.获取reflectPoint类
 * 2.利用反射得到类的方法
 * 3.利用反射得到类的方法的属性
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
	//获取methodGetX方法
	Method methodGetX=pd.getReadMethod();
	//得到类的方法的属性
	Object retVal=methodGetX.invoke(pt1);
	return retVal;*/
	
	//复杂化的解答
	/*
	 * 采用beaninfo的所有属性方式来查找和设置某个reflectPoint对象的x属性。
	 * 在程序中把一个类当作javabean来看
	 * 		就是调用Introspector.getBeanInfo方法，得到的BeanInfo对象封装了把这个类当作javabean看的结果信息
	 */
	BeanInfo beaninfo=Introspector.getBeanInfo(pt1.getClass());
	PropertyDescriptor[] pds=beaninfo.getPropertyDescriptors();	//获取类里面的所有属性
	Object retVal = null;
	for(PropertyDescriptor pd:pds) {		//对所有属性进行遍历
		if(pd.getName().equals(propertyName)) {		//如果属性和要的属性名相同
			Method methodGetX=pd.getReadMethod();	//获取获取methodGetX方法
			retVal=methodGetX.invoke(pt1);			//得到类的方法的属性	
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
