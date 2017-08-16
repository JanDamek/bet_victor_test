package eu.damek.service;

import eu.damek.dao.ResultDAO;
import eu.damek.entity.RandomTextResponce;
import eu.damek.entity.Result;
import eu.damek.model.RandomText;
import eu.damek.model.TextResponse;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Project: bet_victor
 * For:
 * Created by damekjan on 16/08/2017.
 */
@Stateless
public class TextService {

    private static final Pattern TAG_REGEX = Pattern.compile("<p>(.+?)</p>");
    @Inject
    private Logger logger;
    @Inject
    private RandomtextService randomtextService;
    @Inject
    private ResultDAO resultDAO;

    public TextResponse text(Integer pStart, Integer pEnd, Integer minCount, Integer maxCount) {
        logger.log(Level.INFO, "REST request for paragraf from:{0} to:{1} with min:{2} max:{3}",
                new Object[]{pStart, pEnd, minCount, maxCount});
        Result result = resultDAO.getNew();
        result.setParagraphFrom(pStart);
        result.setParagraphTo(pEnd);
        result.setMin(minCount);
        result.setMax(maxCount);
        result.setStartTime(new Date().getTime());
        List<Integer> range = IntStream.range(pStart, pEnd).boxed().collect(Collectors.toList());
        range.parallelStream().forEach(i -> getRandomTextAndStore(minCount, maxCount, i, result));
        result.setResponse(calcResponseText(result));
        result.setEndTime(new Date().getTime());
        resultDAO.save(result);
        return result.getResponse();
    }

    private void getRandomTextAndStore(Integer minCount, Integer maxCount, Integer i,
                                       Result result) {
        RandomTextResponce randomTextResponce = new RandomTextResponce();
        randomTextResponce.setRequestStart(new Date().getTime());
        randomTextResponce.setRandomText(randomtextService.request(i, minCount, maxCount));
        randomTextResponce.setRequestEnd(new Date().getTime());
        result.getResponces().add(randomTextResponce);
    }

    private TextResponse calcResponseText(Result responses) {
        logger.log(Level.INFO, "Calculation response");
        TextResponse result = new TextResponse();
        final Integer[] amount = {0};
        final Long[] totalProcessingTime = {0L};
        responses.getResponces().forEach(r -> {
            addEachResponceToTextResponse(r.getRandomText(), responses);
            amount[0] += r.getRandomText().getAmount();
            totalProcessingTime[0] += r.getRequestEnd() - r.getRequestStart();
        });
        final String[] fregWord = {""};
        final Integer[] cnt = {0};
        responses.getWords().forEach((k, v) -> {
            if (v > cnt[0]) {
                cnt[0] = v;
                fregWord[0] = k;
            }
        });

        result.setFreqWord(fregWord[0]);
        result.setAvgParagraphSize(amount[0] / responses.getResponces().size());
        result.setAvgParagraphProcessingTime((int) (totalProcessingTime[0] / responses.getResponces().size()));
        result.setTotalProcessingTime(Math.toIntExact(totalProcessingTime[0]));

        return result;
    }

    private void addEachResponceToTextResponse(RandomText r, Result result1) {
        List<String> values = getTagValues(r.getTextOut());
        values.forEach(p -> {
            List<String> words = Arrays.asList(p.split(" "));
            words.forEach(w -> {
                if (result1.getWords().containsKey(w)) {
                    Integer cnt = result1.getWords().get(w);
                    cnt++;
                    result1.getWords().put(w, cnt);
                } else {
                    result1.getWords().put(w, 1);
                }
            });
        });
    }

    private List<String> getTagValues(final String str) {
        final List<String> tagValues = new ArrayList<>();
        final Matcher matcher = TAG_REGEX.matcher(str);
        while (matcher.find()) {
            tagValues.add(matcher.group(1));
        }
        return tagValues;
    }

    public List<TextResponse> history() {
        return resultDAO.getLastTen().stream().map(Result::getResponse).collect(Collectors.toList());
    }
}
