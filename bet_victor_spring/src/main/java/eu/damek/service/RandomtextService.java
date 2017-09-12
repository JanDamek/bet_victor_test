package eu.damek.service;

import eu.damek.model.RandomText;

import java.net.URISyntaxException;

/**
 * Project: bet victor test
 * For:
 * Created by damekjan on 05/09/2017.
 */
public interface RandomtextService {

  RandomText request(Integer paragraphs, Integer min, Integer max) throws URISyntaxException;
}
