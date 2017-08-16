package eu.damek.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Project: bet victor test
 * For: parsing responce of randomtext.me
 * Created by damekjan on 16/08/2017.
 */
public class RandomText {

    /**
     * type
     */
    @XmlElement(name = "type")
    private String type;
    /**
     * amount
     */
    @XmlElement(name = "amount")
    private Integer amount;
    /**
     * number
     */
    @XmlElement(name = "number")
    private Integer number;
    /**
     * number_max
     */
    @XmlElement(name = "number_max")
    private Integer numberMax;
    /**
     * format
     */
    @XmlElement(name = "format")
    private String format;
    /**
     * time
     */
    @XmlElement(name = "time")
    private String time;
    /**
     * text_out
     */
    @XmlElement(name = "text_out")
    private String textOut;

    /**
     * getter type
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * setter type
     *
     * @param type {@link String}
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * getter amount
     *
     * @return Integer
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * setter amount
     *
     * @param amount {@link Integer}
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * getter number
     *
     * @return Integer
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * setter number
     *
     * @param number {@link Integer}
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * getter number_max
     *
     * @return Integer
     */
    public Integer getNumberMax() {
        return numberMax;
    }

    /**
     * setter number_max
     *
     * @param numberMax {@link Integer}
     */
    public void setNumberMax(Integer numberMax) {
        this.numberMax = numberMax;
    }

    /**
     * getter format
     *
     * @return String
     */
    public String getFormat() {
        return format;
    }

    /**
     * setter format
     *
     * @param format String
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * getter time
     *
     * @return String
     */
    public String getTime() {
        return time;
    }

    /**
     * setter time
     *
     * @param time {@link String}
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * getter text_out
     *
     * @return String
     */
    public String getTextOut() {
        return textOut;
    }

    /**
     * setter text_out
     *
     * @param textOut {@link String}
     */
    public void setTextOut(String textOut) {
        this.textOut = textOut;
    }
}
