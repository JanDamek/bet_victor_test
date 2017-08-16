package eu.damek.model;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Project: bet_victor
 * For: object for response on REST
 * Created by damekjan on 16/08/2017.
 */
@XmlType(propOrder = {
        "freqWord",
        "avgParagraphSize",
        "avgParagraphProcessingTime",
        "totalProcessingTime"
})
@Embeddable
public class TextResponse implements Serializable {

    /**
     * {@inheritDoc}
     */
    private static final long serialVersionUID = -3595445059057021090L;
    /**
     * freqWord
     */
    @XmlElement(name = "freq_word")
    private String freqWord;

    /**
     * avgParagraphSize
     */
    @XmlElement(name = "avg_paragraph_size")
    private Integer avgParagraphSize;

    /**
     * avgParagraphProcessingTime
     */
    @XmlElement(name = "avg_paragraph_processing_time")
    private Integer avgParagraphProcessingTime;

    /**
     * totalProcessingTime
     */
    @XmlElement(name = "total_processing_time")
    private Integer totalProcessingTime;

    /**
     * getter freqWord
     *
     * @return String
     */
    public String getFreqWord() {
        return freqWord;
    }

    /**
     * setter freqWord
     *
     * @param freqWord {@link String}
     */
    public void setFreqWord(String freqWord) {
        this.freqWord = freqWord;
    }

    /**
     * getter avgParagraphSize
     *
     * @return Integer
     */
    public Integer getAvgParagraphSize() {
        return avgParagraphSize;
    }

    /**
     * setter avgParagraphSize
     *
     * @param avgParagraphSize {@link Integer}
     */
    public void setAvgParagraphSize(Integer avgParagraphSize) {
        this.avgParagraphSize = avgParagraphSize;
    }

    /**
     * getter avgParagraphProcessingTime
     *
     * @return Integer
     */
    public Integer getAvgParagraphProcessingTime() {
        return avgParagraphProcessingTime;
    }

    /**
     * setter avgParagraphProcessingTime
     *
     * @param avgParagraphProcessingTime {@link Integer}
     */
    public void setAvgParagraphProcessingTime(Integer avgParagraphProcessingTime) {
        this.avgParagraphProcessingTime = avgParagraphProcessingTime;
    }

    /**
     * getter totalProcessingTime
     *
     * @return Integer
     */
    public Integer getTotalProcessingTime() {
        return totalProcessingTime;
    }

    /**
     * setter totalProcessingTime
     *
     * @param totalProcessingTime {@link Integer}
     */
    public void setTotalProcessingTime(Integer totalProcessingTime) {
        this.totalProcessingTime = totalProcessingTime;
    }
}
