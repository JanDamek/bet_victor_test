package eu.damek.service;

import eu.damek.model.RandomText;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Project: bet victor test
 * For: Service for getting randomtext.me
 * Created by damekjan on 16/08/2017.
 */
@Singleton
public class RandomtextService {

    /**
     * url for request
     */
    private static final String RANDOMTEXT_URL_API = "http://www.randomtext.me/api/{type}/p-{paragraphs}/{min}-{max}";
    /**
     * type of request
     */
    private static final String GEBBERISH = "gibberish";

    /**
     * logger
     */
    @Inject
    private Logger logger;

    /**
     * get responce from randomtext.me
     *
     * @param paragraphs number of paragraph
     * @param min        words
     * @param max        words
     * @return RandomText
     */
    public RandomText request(Integer paragraphs, Integer min, Integer max) {
        logger.log(Level.INFO, "Randomtext.me request for type:{0} p-{1} min:{2} max:{3}",
                new Object[]{GEBBERISH, paragraphs, min, max});
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(RANDOMTEXT_URL_API)
                .resolveTemplate("type", GEBBERISH)
                .resolveTemplate("paragraphs", paragraphs)
                .resolveTemplate("min", min)
                .resolveTemplate("max", max);
        return target.request(MediaType.APPLICATION_JSON_TYPE)
                .get(RandomText.class);
    }

}
