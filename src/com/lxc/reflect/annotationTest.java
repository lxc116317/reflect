package com.lxc.reflect;
@annotation(annotationAttr=@MetaAnnotation(value = "fly"),  color="red",value="abc",arr= {1,2,4})//因此可以写成@annocation("abc"),如果数组中只有一个元素时，这时候属性值就可以省略大括号
public class annotationTest {
	
	@SuppressWarnings("deprecation")//过时的注解
	public static void main(String[] args) {
		System.runFinalizersOnExit(true);
	
		if(annotationTest.class.isAnnotationPresent(annotation.class)) {//这个类中是否有annotation的注解，如果有
			annotation Annotation=annotationTest.class.getAnnotation(annotation.class);//获取这个注解
			System.out.println(Annotation.value());
			System.out.println(Annotation.color());
			System.out.println(Annotation.arr().length);
			System.out.println(Annotation.annotationAttr().value());
		}
	}
}
