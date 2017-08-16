package eu.damek.service;

import eu.damek.dao.ResultDAO;
import eu.damek.entity.RandomTextResponse;
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
 * For: Main service for process REST API request and get manage response from randomtext.me
 * Created by damekjan on 16/08/2017.
 */
@Stateless
public class TextService {

    /**
     * regular express for get text of paragraph
     */
    private static final Pattern TAG_REGEX = Pattern.compile("<p>(.+?)</p>");
    /**
     * logger
     */
    @Inject
    private Logger logger;
    /**
     * {@link RandomtextService}
     */
    @Inject
    private RandomtextService randomtextService;
    /**
     * {@link ResultDAO}
     */
    @Inject
    private ResultDAO resultDAO;

    /**
     * request from REST service
     *
     * @param pStart   of paragraph
     * @param pEnd     of paragraph
     * @param minCount words in paragraph
     * @param maxCount words in paragraph
     * @return TextResponse
     */
    public TextResponse text(Integer pStart, Integer pEnd, Integer minCount, Integer maxCount) {
        logger.log(Level.INFO, "REST request for paragraph from:{0} to:{1} with min:{2} max:{3}",
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

    /**
     * make request to API
     *
     * @param minCount  min count
     * @param maxCount  max count
     * @param paragraph paragraph
     * @param result    final object of request {@link Result}
     */
    private void getRandomTextAndStore(Integer minCount, Integer maxCount, Integer paragraph,
                                       Result result) {
        RandomTextResponse randomTextResponse = new RandomTextResponse();
        randomTextResponse.setRequestStart(new Date().getTime());
        randomTextResponse.setRandomText(randomtextService.request(paragraph, minCount, maxCount));
        randomTextResponse.setRequestEnd(new Date().getTime());
        result.getResponses().add(randomTextResponse);
    }

    /**
     * calculation of response
     *
     * @param responses final object of request {@link Result}
     * @return TextResponse
     */
    private TextResponse calcResponseText(Result responses) {
        logger.log(Level.INFO, "Calculation response");
        TextResponse result = new TextResponse();
        final Integer[] amount = {0};
        final Long[] totalProcessingTime = {0L};
        responses.getResponses().forEach(r -> {
            addEachResponseToTextResponse(r.getRandomText(), responses);
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
        result.setAvgParagraphSize(amount[0] / responses.getResponses().size());
        result.setAvgParagraphProcessingTime((int) (totalProcessingTime[0] / responses.getResponses().size()));
        result.setTotalProcessingTime(Math.toIntExact(totalProcessingTime[0]));

        return result;
    }

    /**
     * counting mach words in each paragraph on {@link RandomTextResponse}
     *
     * @param randomText test from API
     * @param result     final result of request
     */
    private void addEachResponseToTextResponse(RandomText randomText, Result result) {
        List<String> values = getTagValues(randomText.getTextOut());
        values.forEach(p -> {
            List<String> words = Arrays.asList(p.split(" "));
            words.forEach(w -> {
                if (result.getWords().containsKey(w)) {
                    Integer cnt = result.getWords().get(w);
                    cnt++;
                    result.getWords().put(w, cnt);
                } else {
                    result.getWords().put(w, 1);
                }
            });
        });
    }

    /**
     * parse string to List of text in paragraph
     *
     * @param string to pars
     * @return List
     */
    private List<String> getTagValues(final String string) {
        final List<String> tagValues = new ArrayList<>();
        final Matcher matcher = TAG_REGEX.matcher(string);
        while (matcher.find()) {
            tagValues.add(matcher.group(1));
        }
        return tagValues;
    }

    /**
     * return list of 10 last request
     *
     * @return List
     */
    public List<TextResponse> history() {
        return resultDAO.getLastTen().stream().map(Result::getResponse).collect(Collectors.toList());
    }
}
