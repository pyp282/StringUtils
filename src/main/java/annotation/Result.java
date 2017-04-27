package annotation;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Result {
    int code = 0;
    String msg = null;

    public int getCode() {
        return code;
    }

    @XmlAttribute(name = "code")
    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    @XmlElement(name = "msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
