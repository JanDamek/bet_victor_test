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

    private Long requestStart;
    private Long requestEnd;
    @Transient
    private RandomText randomText;

    public Long getRequestStart() {
        return requestStart;
    }

    public void setRequestStart(Long requestStart) {
        this.requestStart = requestStart;
    }

    public Long getRequestEnd() {
        return requestEnd;
    }

    public void setRequestEnd(Long requestEnd) {
        this.requestEnd = requestEnd;
    }

    public RandomText getRandomText() {
        return randomText;
    }

    public void setRandomText(RandomText randomText) {
        this.randomText = randomText;
    }

    @Transient
    public Date getRequestStartDate() {
        return new Date(requestStart);
    }

    @Transient
    public Date getRequestEndDate() {
        return new Date(requestEnd);
    }
}
