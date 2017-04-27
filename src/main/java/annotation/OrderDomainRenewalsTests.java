package annotation;

import javax.xml.bind.annotation.XmlElement;
import java.lang.reflect.Method;

public class OrderDomainRenewalsTests {

    public static void getAnnotationValue() throws NoSuchMethodException {
        Method method = OrderDomainsResult.class.getMethod("setResdata", Resdata.class);
        String name = method.getAnnotation(XmlElement.class).name();
        System.out.println(name);


    }

    public static void main(String[] args) throws Exception {
//        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><OrderDomainRenewalsResponse xmlns=\"http://wildwestdomains.com/webservices/\"><OrderDomainRenewalsResult>&lt;response user=\"970209\" clTRID=\"yFp5eOtJ6LkBEAfnGt70V2tBRn0kWMgyKxIre15Qc6B1a3Rkir\"&gt;\n" +
//                "  &lt;result code=\"1001\"&gt;\n" +
//                "    &lt;msg&gt;Failed processing item 1&lt;/msg&gt;\n" +
//                "  &lt;/result&gt;\n" +
//                "  &lt;resdata&gt;internal error&lt;/resdata&gt;\n" +
//                "&lt;/response&gt;</OrderDomainRenewalsResult></OrderDomainRenewalsResponse></soap:Body></soap:Envelope>";
//
//        OrderDomainsResult orderDomainsResult = ResolveClass.parse(xml, OrderDomainsResult.class, OrderDomainRenewalsTests.class);
//        System.out.println(orderDomainsResult.getResult().getCode());

        getAnnotationValue();
    }

}
