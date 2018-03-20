package simpleXmlTest.simpleTest;

import java.io.File;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.Matcher;
import org.simpleframework.xml.transform.Transform;

import simpleXmlTest.simpleBean.Address;
import simpleXmlTest.simpleBean.Hobby;
import simpleXmlTest.simpleBean.Hobby.HobbyTransformer;
import simpleXmlTest.simpleBean.Student;


public class Test3 {
	public static void main(String[] args) {
		Matcher match = new Matcher() {

			HobbyTransformer htf = new HobbyTransformer();
			public Transform match(Class type) throws Exception {
				// TODO Auto-generated method stub
				return type==Hobby.class?htf:null;
			}
			
		};
		Persister p = new Persister();//match

		Student stu1 = new Student();
		stu1.sid = "001";
		stu1.sname = "name";
		stu1.sage = 33;
		stu1.addr = new Address("江西","南昌");
		
		stu1.hobby = new Hobby("读书");
		stu1.hobby.chengdu = "非常喜爱";
		
		try {
			p.write(stu1, new File("e://temp//tempfile//stu3.xml"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
