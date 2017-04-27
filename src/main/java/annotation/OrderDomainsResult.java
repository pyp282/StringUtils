package annotation;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class OrderDomainsResult{
    Result result;
    Resdata resdata;

    public Result getResult() {
        return result;
    }

    @XmlElement(name = "result")
    public void setResult(Result result) {
        this.result = result;
    }

    public Resdata getResdata() {
        return resdata;
    }

    @XmlElement(name = "resdata")
    public void setResdata(Resdata resdata) {
        this.resdata = resdata;
    }

    public String getInnerXml(String xmlResponse){
        String innerXml = xmlResponse.split("<OrderDomainsResult>")[1].split("</OrderDomainsResult>")[0];

        return StringEscapeUtils.unescapeXml(innerXml);
    }
}
