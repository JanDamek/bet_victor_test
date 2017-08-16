package eu.damek.entity;

import eu.damek.model.TextResponse;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Project: bet victor test
 * For:
 * Created by damekjan on 16/08/2017.
 */
@Entity
public class Result implements Serializable {

    private static final long serialVersionUID = 4028193716663267858L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long startTime;
    private Long endTime;

    private Integer paragraphFrom;
    private Integer paragraphTo;
    private Integer min;
    private Integer max;

    @ElementCollection
    private List<RandomTextResponce> responces;
    @ElementCollection
    private Map<String, Integer> words;
    private TextResponse response;

    public Map<String, Integer> getWords() {
        if (words == null) {
            words = new HashMap<>();
        }
        return words;
    }

    public void setWords(Map<String, Integer> words) {
        this.words = words;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    @Transient
    public Date getRequestDate() {
        return new Date(startTime);
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getParagraphFrom() {
        return paragraphFrom;
    }

    public void setParagraphFrom(Integer paragraphFrom) {
        this.paragraphFrom = paragraphFrom;
    }

    public Integer getParagraphTo() {
        return paragraphTo;
    }

    public void setParagraphTo(Integer paragraphTo) {
        this.paragraphTo = paragraphTo;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public TextResponse getResponse() {
        if (response == null) {
            response = new TextResponse();
        }
        return response;
    }

    public void setResponse(TextResponse response) {
        this.response = response;
    }

    public List<RandomTextResponce> getResponces() {
        if (responces == null) {
            responces = new ArrayList<>();
        }
        return responces;
    }

    public void setResponces(List<RandomTextResponce> responces) {
        this.responces = responces;
    }
}
