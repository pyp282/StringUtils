package annotation;


import javax.xml.bind.annotation.XmlElement;

public class Resdata {
    int orderid = 0;

    public int getOrderid() {
        return orderid;
    }

    @XmlElement(name = "orderid")
    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
}
