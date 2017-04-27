package annotation;

import com.sun.tools.corba.se.idl.StringGen;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bys on 16/03/2017.
 */
public class Tenp {

    private static String getInnerXml(String xmlResponse, String tag){
        if(xmlResponse.contains("InfoResult")){
            tag = tag.replace("Tests", "Response");
        }else {
            tag = tag.replace("Tests", "Result");
        }

        String innerXml = xmlResponse.split(startTag(xmlResponse, tag))[1].split(endTag(tag))[0];

        return StringEscapeUtils.unescapeXml(innerXml);
    }

    private static String startTag(String tag){
        return "<" + tag + ">";
    }

    private static String startTag(String xmlResponse, String tag){
        int start = xmlResponse.indexOf("<" + tag);

        xmlResponse = xmlResponse.substring(start);

        start = xmlResponse.indexOf("<" + tag);
        int end = xmlResponse.indexOf(">") + 1;

        tag = xmlResponse.substring(start, end);

        return tag;
    }

    public static void getInnerXmlWithRegex(String xmlData, String tag){
        String regex = "(?<=<InfoResponse)[\\s\\S]+";
        String subregex = "(<InfoResponse).+\">";
        String expre = useRegex(xmlData, subregex);

//(?<=<'<InfoResponse xmlns="http://wildwestdomains.com/webservices/">')[\s\S]+(?=</InfoResponse>)
        String regexD = "(?<=" + expre + ")[\\s\\S]+(?=</" + tag + ">)";

        System.out.println(useRegex(xmlData, regexD));

    }

    private static String useRegex(String str, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            return matcher.group();
        }else {
            return null;
        }

    }

    public static String regexAd(String str){
        String regexz = "(?<=<InfoResponse[\\s\\S]+>)[\\s\\S]+(?=</InfoResponse>)";
        String regex = "(?<=<InfoResponse[^>]+>\\$)[\\s\\S]+(?=</InfoResponse>)";
//        String regex = "<InfoResponse[^>]+>";
        String regax = "(?<=<InfoResponse[^>]{1,100}>)[\\s\\S]+(?=</InfoResponse>)";
        Pattern pattern = Pattern.compile(regax);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            return matcher.group();
        }else {
            return null;
        }
    }

    private static String endTag(String tag){
        return "</" + tag + ">";
    }


    public static void main(String[] args) {
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><InfoResponse xmlns=\"http://wildwestdomains.com/webservices/\"><InfoResult>&lt;response&gt;\n" +
                "  &lt;result code=\"1001\"/&gt;\n" +
                "  &lt;resdata&gt;\n" +
                "&lt;error msg=\"Domain 'ApiResellerS2d0ITdA5V.com' not found.\"/&gt;\n" +
                "  &lt;/resdata&gt;\n" +
                "&lt;/response&gt;</InfoResult></InfoResponse></soap:Body></soap:Envelope>\n";

//        String innerXml = getInnerXml(str, "InfoTests");
//        System.out.println(innerXml);

//        getInnerXmlWithRegex(str, "InfoResponse");

        System.out.println(regexAd(str));
    }
}
