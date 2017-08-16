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

    /**
     * {@inheritDoc}
     */
    private static final long serialVersionUID = 4028193716663267858L;
    /**
     * identification of stored request
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * timestamp of start request
     */
    private Long startTime;
    /**
     * timestamp of end request
     */
    private Long endTime;

    /**
     * requested paragraph from
     */
    private Integer paragraphFrom;
    /**
     * requested paragraph to
     */
    private Integer paragraphTo;
    /**
     * min count of request
     */
    private Integer min;
    /**
     * max count of request
     */
    private Integer max;

    /**
     * list of {@link RandomTextResponce} responces
     */
    @ElementCollection
    private List<RandomTextResponce> responces;
    /**
     * map of words in all paragraphs of all responces
     */
    @ElementCollection
    private Map<String, Integer> words;
    /**
     * responce for REST
     */
    private TextResponse response;

    /**
     * getter of words
     *
     * @return Map
     */
    public Map<String, Integer> getWords() {
        if (words == null) {
            words = new HashMap<>();
        }
        return words;
    }

    /**
     * setter of words
     *
     * @param words Map
     */
    public void setWords(Map<String, Integer> words) {
        this.words = words;
    }

    /**
     * getter of id
     *
     * @return Long
     */
    public Long getId() {
        return id;
    }

    /**
     * setter of if
     *
     * @param id Long
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter of start time
     *
     * @return Long
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * setter of start time
     *
     * @param startTime Long
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * getter of convertet timestamp of request to {@link Date}
     *
     * @return Date
     */
    @Transient
    public Date getRequestDate() {
        return new Date(startTime);
    }

    /**
     * getter of endTime
     *
     * @return Long
     */
    public Long getEndTime() {
        return endTime;
    }

    /**
     * setter of endTime
     *
     * @param endTime Long
     */
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    /**
     * getter of paragraphFrom
     *
     * @return Integer
     */
    public Integer getParagraphFrom() {
        return paragraphFrom;
    }

    /**
     * setter of paragraphFrom
     *
     * @param paragraphFrom {@link Integer}
     */
    public void setParagraphFrom(Integer paragraphFrom) {
        this.paragraphFrom = paragraphFrom;
    }

    /**
     * getter of paragraphTo
     *
     * @return Integer
     */
    public Integer getParagraphTo() {
        return paragraphTo;
    }

    /**
     * setter of paragraphTo
     *
     * @param paragraphTo {@link Integer}
     */
    public void setParagraphTo(Integer paragraphTo) {
        this.paragraphTo = paragraphTo;
    }

    /**
     * getter of min of count of words in paragraph
     *
     * @return Integer
     */
    public Integer getMin() {
        return min;
    }

    /**
     * setter of min of count of words in paragraph
     *
     * @param min {@link Integer}
     */
    public void setMin(Integer min) {
        this.min = min;
    }

    /**
     * getter of max of count
     *
     * @return Integer
     */
    public Integer getMax() {
        return max;
    }

    /**
     * setter of max count
     *
     * @param max {@link Integer}
     */
    public void setMax(Integer max) {
        this.max = max;
    }

    /**
     * getter of response
     *
     * @return TextResponse
     */
    public TextResponse getResponse() {
        if (response == null) {
            response = new TextResponse();
        }
        return response;
    }

    /**
     * setter of response
     *
     * @param response {@link TextResponse}
     */
    public void setResponse(TextResponse response) {
        this.response = response;
    }

    /**
     * getter of list of {@link RandomTextResponce}
     *
     * @return RandomTextResponce
     */
    public List<RandomTextResponce> getResponces() {
        if (responces == null) {
            responces = new ArrayList<>();
        }
        return responces;
    }

    /**
     * setter of list of {@link RandomTextResponce}
     *
     * @param responces {@link RandomTextResponce}
     */
    public void setResponces(List<RandomTextResponce> responces) {
        this.responces = responces;
    }
}
