package eu.damek.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Project: bet victor test
 * For:
 * Created by damekjan on 16/08/2017.
 */
public class RandomText {

    @XmlElement(name = "type")
    private String type;
    @XmlElement(name = "amount")
    private Integer amount;
    @XmlElement(name = "number")
    private Integer number;
    @XmlElement(name = "number_max")
    private Integer numberMax;
    @XmlElement(name = "format")
    private String format;
    @XmlElement(name = "time")
    private String time;
    @XmlElement(name = "text_out")
    private String textOut;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumberMax() {
        return numberMax;
    }

    public void setNumberMax(Integer numberMax) {
        this.numberMax = numberMax;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTextOut() {
        return textOut;
    }

    public void setTextOut(String textOut) {
        this.textOut = textOut;
    }
}
