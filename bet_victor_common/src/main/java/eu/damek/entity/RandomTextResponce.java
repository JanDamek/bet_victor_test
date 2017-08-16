package eu.damek.entity;

import eu.damek.model.RandomText;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * Project: bet victor test
 * For:
 * Created by damekjan on 16/08/2017.
 */
@Embeddable
public class RandomTextResponce implements Serializable {

    /**
     * timestamp of start request to randomtext.me
     */
    private Long requestStart;
    /**
     * timestamp of end request to randomtext.me
     */
    private Long requestEnd;
    /**
     * temporary store of Entity responce from randomtext.me
     */
    @Transient
    private RandomText randomText;

    /**
     * getter for requestStart
     *
     * @return Long
     */
    public Long getRequestStart() {
        return requestStart;
    }

    /**
     * setter for requestStart
     *
     * @param requestStart Long
     */
    public void setRequestStart(Long requestStart) {
        this.requestStart = requestStart;
    }

    /**
     * getter of requestEnd
     *
     * @return Long
     */
    public Long getRequestEnd() {
        return requestEnd;
    }

    /**
     * setter of requestEnd
     *
     * @param requestEnd Long
     */
    public void setRequestEnd(Long requestEnd) {
        this.requestEnd = requestEnd;
    }

    /**
     * getter of {@link RandomText}
     *
     * @return RandomText
     */
    public RandomText getRandomText() {
        return randomText;
    }

    /**
     * setter for randomText
     *
     * @param randomText {@link RandomText}
     */
    public void setRandomText(RandomText randomText) {
        this.randomText = randomText;
    }

    /**
     * getter for converted timestamp to {@link Date} of requestStart
     *
     * @return Date
     */
    @Transient
    public Date getRequestStartDate() {
        return new Date(requestStart);
    }

    /**
     * getter for converted timestamp to {@link Date} of requestEnd
     *
     * @return Date
     */
    @Transient
    public Date getRequestEndDate() {
        return new Date(requestEnd);
    }
}
