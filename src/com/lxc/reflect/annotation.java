package com.lxc.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Enumeration;
/*һ��ע������������������׶�
 * 		javaԴ�ļ��׶Σ�RetentionPolicy.SOURCE 
 * 		class�ļ��׶Σ�RetentionPolicy.CLASS
 * 		�ڴ��е��ֽ���׶Σ�RetentionPolicy.RUNTIME
 *javac��Դ�ļ������class�ļ����ܻ�ȥ���Ǹ�ע��
 *���������class�ļ����ص��ڴ��ʱ��Ҳ���ܻ�ȥ��ע��
 * 		Ĭ��ֵ����class�׶�
 */
@Retention(RetentionPolicy.RUNTIME)		//ע���ע�⣬Ԫע��
public @interface annotation {

		String color() default "blue";//����Ĭ�ϵ���ɫֵʱ����Ϊ��String value()�����Ե�д"abc"ʱ����û�������

		String value();
		
		
		//��ʾ�������͵�����
		int[] arr() default {1,2,3};
		
		
		//��ʾע�����͵�����
		MetaAnnotation annotationAttr()  default @MetaAnnotation("c");
		
}
