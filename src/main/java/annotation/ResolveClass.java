package annotation;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;

public class ResolveClass {

    public static <T> T parse(String model, Class T, Class E)throws Exception{
        String innerXml = getInnerXml(model, E.getSimpleName());

        StringReader stringReader = new StringReader(innerXml);
        XMLInputFactory xif = XMLInputFactory.newInstance();
        XMLStreamReader streamReader = xif.createXMLStreamReader(stringReader);

        JAXBContext jaxbContext = JAXBContext.newInstance(T);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (T)unmarshaller.unmarshal(streamReader);

    }

    private static String getInnerXml(String xmlResponse, String tag){
        tag = tag.replace("Tests", "Result");
        String innerXml = xmlResponse.split(startTag(tag))[1].split(endTag(tag))[0];

        return  StringEscapeUtils.unescapeXml(innerXml);

    }

    private static String startTag(String tag){
        return "<" + tag + ">";
    }

    private static String endTag(String tag){
        return "</" + tag + ">";
    }


}
