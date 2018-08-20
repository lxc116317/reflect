package com.lxc.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
//不懂
public class demo3_struct1 {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		InputStream is=new FileInputStream("config.properties");
		Properties pt=new Properties();
		pt.load(is);			//加载文件
		is.close();				//关流
		String classname=pt.getProperty("className");
		Collection collection=(Collection)Class.forName(classname).newInstance();
		
		
		
		reflectPoint pt1=new reflectPoint(3,5);
		reflectPoint pt2=new reflectPoint(1,1);
		reflectPoint pt3=new reflectPoint(2,4);
		
		collection.add(pt1);
		collection.add(pt2);
		collection.add(pt3);
		collection.add(pt1);
		
		System.out.println(collection.size());
		

	}

}
