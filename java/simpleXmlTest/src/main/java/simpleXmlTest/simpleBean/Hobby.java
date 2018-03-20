package simpleXmlTest.simpleBean;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.core.Validate;
import org.simpleframework.xml.transform.Transform;

//@Element
public class Hobby {
	@Validate
	public String name;
	
	@Attribute
	public String chengdu;
	
	public Hobby() {
		System.out.println("hobby 无参");
	}
	
	public Hobby(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hobby [name=" + name + ", chengdu=" + chengdu + "]";
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//自定义解析方式
	public static class HobbyTransformer implements Transform<Hobby>{

	public Hobby read(String value) throws Exception {
		// TODO Auto-generated method stub
		return new Hobby(value);
	}

	public String write(Hobby value) throws Exception {
		// TODO Auto-generated method stub
		return value.getName();
	}
	
}
}

