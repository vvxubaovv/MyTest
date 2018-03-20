package simpleXmlTest.simpleTest;

import java.io.File;
import java.util.ArrayList;

import org.simpleframework.xml.core.Persister;

import simpleXmlTest.simpleBean.Address;
import simpleXmlTest.simpleBean.Student;

public class Test2 {
	public static void main(String[] args) {
		Persister p = new Persister();
		Student stu1 = new Student();
		Student stu2 = new Student();
		
		stu1.sid = "001";
		stu1.sname = "zs";
		stu1.sage = 11;
		stu1.addr = new Address("江西","南昌");
		
		stu2.sid = "002";
		stu2.sname = "zs2";
		stu2.sage = 22;
		stu2.addr = new Address("江西","上饶");
		
		//引用递归则无限写 直到StackOverflowError
		stu1.friend = new ArrayList<Student>();
		stu1.friend.add(stu2);
		
		stu2.friend = new ArrayList<Student>();
		//stu2.friend.add(stu1);
		
		try {
			p.write(stu1, new File("e://temp//tempfile//stu2.xml"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			p.read(stu1.getClass(), new File("e://temp//tempfile//stu2.xml"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
