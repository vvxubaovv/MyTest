
package com.xubao.test.simpleTest.webService.remote;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.xubao.test.simpleTest.webService.remote package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Hello_QNAME = new QName("http://webService.simpleTest.test.xubao.com/", "hello");
    private final static QName _SetInfo_QNAME = new QName("http://webService.simpleTest.test.xubao.com/", "setInfo");
    private final static QName _SetInfoResponse_QNAME = new QName("http://webService.simpleTest.test.xubao.com/", "setInfoResponse");
    private final static QName _NihaoResponse_QNAME = new QName("http://webService.simpleTest.test.xubao.com/", "nihaoResponse");
    private final static QName _GetInfoResponse_QNAME = new QName("http://webService.simpleTest.test.xubao.com/", "getInfoResponse");
    private final static QName _GetInfo_QNAME = new QName("http://webService.simpleTest.test.xubao.com/", "getInfo");
    private final static QName _Nihao_QNAME = new QName("http://webService.simpleTest.test.xubao.com/", "nihao");
    private final static QName _HelloResponse_QNAME = new QName("http://webService.simpleTest.test.xubao.com/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.xubao.test.simpleTest.webService.remote
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInfoResponse }
     * 
     */
    public GetInfoResponse createGetInfoResponse() {
        return new GetInfoResponse();
    }

    /**
     * Create an instance of {@link GetInfo }
     * 
     */
    public GetInfo createGetInfo() {
        return new GetInfo();
    }

    /**
     * Create an instance of {@link Nihao }
     * 
     */
    public Nihao createNihao() {
        return new Nihao();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link SetInfo }
     * 
     */
    public SetInfo createSetInfo() {
        return new SetInfo();
    }

    /**
     * Create an instance of {@link SetInfoResponse }
     * 
     */
    public SetInfoResponse createSetInfoResponse() {
        return new SetInfoResponse();
    }

    /**
     * Create an instance of {@link NihaoResponse }
     * 
     */
    public NihaoResponse createNihaoResponse() {
        return new NihaoResponse();
    }

    /**
     * Create an instance of {@link Info }
     * 
     */
    public Info createInfo() {
        return new Info();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.simpleTest.test.xubao.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.simpleTest.test.xubao.com/", name = "setInfo")
    public JAXBElement<SetInfo> createSetInfo(SetInfo value) {
        return new JAXBElement<SetInfo>(_SetInfo_QNAME, SetInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.simpleTest.test.xubao.com/", name = "setInfoResponse")
    public JAXBElement<SetInfoResponse> createSetInfoResponse(SetInfoResponse value) {
        return new JAXBElement<SetInfoResponse>(_SetInfoResponse_QNAME, SetInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NihaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.simpleTest.test.xubao.com/", name = "nihaoResponse")
    public JAXBElement<NihaoResponse> createNihaoResponse(NihaoResponse value) {
        return new JAXBElement<NihaoResponse>(_NihaoResponse_QNAME, NihaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.simpleTest.test.xubao.com/", name = "getInfoResponse")
    public JAXBElement<GetInfoResponse> createGetInfoResponse(GetInfoResponse value) {
        return new JAXBElement<GetInfoResponse>(_GetInfoResponse_QNAME, GetInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.simpleTest.test.xubao.com/", name = "getInfo")
    public JAXBElement<GetInfo> createGetInfo(GetInfo value) {
        return new JAXBElement<GetInfo>(_GetInfo_QNAME, GetInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Nihao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.simpleTest.test.xubao.com/", name = "nihao")
    public JAXBElement<Nihao> createNihao(Nihao value) {
        return new JAXBElement<Nihao>(_Nihao_QNAME, Nihao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.simpleTest.test.xubao.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}
