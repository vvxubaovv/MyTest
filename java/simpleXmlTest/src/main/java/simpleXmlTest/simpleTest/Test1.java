package simpleXmlTest.simpleTest;

import java.io.File;

import org.simpleframework.xml.core.Persister;

import simpleXmlTest.simpleBean.*;

public class Test1 {
	public static void main(String[] args) {
		Persister p = new Persister();
		
		Student stu1 = new Student();
		Student stu2 = new Student();
		Student stu3 = new Student();
		
		stu1.sid = "001";
		stu1.sname = "zs";
		stu1.sage = 21;
		stu1.addr = new Address("±±¾©","²ýÆ½");
		
		try {
			p.write(stu1, new File("e://temp//tempfile//stu1.xml"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Student stu11 = p.read(Student.class,new File("e://temp//tempfile//stu1.xml") );
			System.out.println("stu11="+stu11);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
