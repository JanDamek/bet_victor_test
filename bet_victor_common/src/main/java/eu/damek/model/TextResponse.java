package eu.damek.model;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Project: bet_victor
 * For:
 * Created by damekjan on 16/08/2017.
 */
@XmlType(propOrder = {
        "freqWord",
        "avgParagraphSize",
        "avgParagraphProcessingTime",
        "totalProcessingTime"
})
@Embeddable
public class TextResponse {

    @XmlElement(name = "freq_word")
    private String freqWord;

    @XmlElement(name = "avg_paragraph_size")
    private Integer avgParagraphSize;

    @XmlElement(name = "avg_paragraph_processing_time")
    private Integer avgParagraphProcessingTime;

    @XmlElement(name = "total_processing_time")
    private Integer totalProcessingTime;

    public String getFreqWord() {
        return freqWord;
    }

    public void setFreqWord(String freqWord) {
        this.freqWord = freqWord;
    }

    public Integer getAvgParagraphSize() {
        return avgParagraphSize;
    }

    public void setAvgParagraphSize(Integer avgParagraphSize) {
        this.avgParagraphSize = avgParagraphSize;
    }

    public Integer getAvgParagraphProcessingTime() {
        return avgParagraphProcessingTime;
    }

    public void setAvgParagraphProcessingTime(Integer avgParagraphProcessingTime) {
        this.avgParagraphProcessingTime = avgParagraphProcessingTime;
    }

    public Integer getTotalProcessingTime() {
        return totalProcessingTime;
    }

    public void setTotalProcessingTime(Integer totalProcessingTime) {
        this.totalProcessingTime = totalProcessingTime;
    }
}
