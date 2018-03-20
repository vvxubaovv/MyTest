package simpleXmlTest.simpleBean;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

@Root //使用@Root注解,没有使用注解的属性被忽略
public class Address {
	//使用了@Root注解但没有字段时表现为<saddr/>
	
	//类没有用@Root注解且类中没有可以使用的属性时报错
	//Transform of class simpleXmlTest.simpleBean.Address not supported
	
	//private的属性也可以通过反射获取

	@Transient // 使用这个注释默认忽略本字段 但如果本类没有其他未忽略字段则报错 Transform of class
				// simpleXmlTest.simpleBean.Address not supported
	public final String guoji = "中国";

	//final域如果不是static也不忽略,读写都报错,需要忽略
	// Default constructor can not accept read only
	// @org.simpleframework.xml.Element(name=, type=void, data=false,
	// required=false) on field 'testfinal' public final java.lang.String
	// simpleXmlTest.simpleBean.Address.testfinal in class
	// simpleXmlTest.simpleBean.Address
	@Transient
	public final String testFinal = "testFinal";
	//static 默认直接忽略 加@Element注解会写入文件 加final读取时不改变原值也不报错
	//@Element
	public static String testStaticFinal = "testStaticFinal";
	@Element
	public String shengfen = "江西";
	@Element
	public String diqu = "南昌";
	
	//必须要有无餐构造方法
	//属性通过反射直接设置
	public Address() {
	}

	public Address(String shengfen, String diqu) {
		super();
		this.shengfen = shengfen;
		this.diqu = diqu;
	}

	@Override
	public String toString() {
		return "Address [guoji=" + guoji + ", testFinal=" + testFinal + ", shengfen=" + shengfen + ", diqu=" + diqu
				+ "]";
	}

	
	

}
