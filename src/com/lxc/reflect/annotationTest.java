package com.lxc.reflect;
@annotation(annotationAttr=@MetaAnnotation(value = "fly"),  color="red",value="abc",arr= {1,2,4})//��˿���д��@annocation("abc"),���������ֻ��һ��Ԫ��ʱ����ʱ������ֵ�Ϳ���ʡ�Դ�����
public class annotationTest {
	
	@SuppressWarnings("deprecation")//��ʱ��ע��
	public static void main(String[] args) {
		System.runFinalizersOnExit(true);
	
		if(annotationTest.class.isAnnotationPresent(annotation.class)) {//��������Ƿ���annotation��ע�⣬�����
			annotation Annotation=annotationTest.class.getAnnotation(annotation.class);//��ȡ���ע��
			System.out.println(Annotation.value());
			System.out.println(Annotation.color());
			System.out.println(Annotation.arr().length);
			System.out.println(Annotation.annotationAttr().value());
		}
	}
}
