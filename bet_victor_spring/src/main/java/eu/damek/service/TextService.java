package eu.damek.service;

import eu.damek.model.TextResponse;

import java.util.List;

/**
 * Project: bet victor test
 * For:
 * Created by damekjan on 05/09/2017.
 */
public interface TextService {

  TextResponse text(Integer pStart, Integer pEnd, Integer minCount, Integer maxCount);

  List<TextResponse> history();
}
