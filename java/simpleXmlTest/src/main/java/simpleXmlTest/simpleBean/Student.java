package simpleXmlTest.simpleBean;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Student {
	//默认字段名称为标签名称 可以通过name属性设置
	@Element
	public String sid;
	@Element
	public String sname;
	@Element
	public int sage;
	@Element
	public Address addr;
	@ElementList(required = false)
	public List<Student> friend;
	
	@Element
	public Hobby hobby;

	@Element // 只能用于get/set方法,使用方法设置和获取属性值
	//标签名规则为get{小} {小} get{大} {小} get{大大} {大大} get{大小} {小小} get{小小} {小小}
	// 只注解get方法
	// Default constructor can not accept read only
	// @org.simpleframework.xml.Element(name=, type=void, data=false, required=true)
	// on method 'hh' in class simpleXmlTest.simpleBean.Student
	public String getH() {
		return "haha";
	}

	 @Element
	// 只注解set方法
	// No matching get method for public void
	// simpleXmlTest.simpleBean.Student.setHh(java.lang.String) in class
	// simpleXmlTest.simpleBean.Student
	public void setH(String xx) {
		System.out.println("xx=" + xx);
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddr=" + addr + ", friend=" + friend
				+ "]";
	}

}
