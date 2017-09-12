package eu.damek.service;

import eu.damek.model.RandomText;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Project: bet victor test
 * For: Service for getting randomtext.me
 * Created by damekjan on 16/08/2017.
 */
@Service
public class RandomtextServiceImpl implements RandomtextService {

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
  private Logger logger = Logger.getLogger(RandomtextService.class.getSimpleName());

  /**
   * get response from randomtext.me
   *
   * @param paragraphs number of paragraph
   * @param min        words
   * @param max        words
   * @return RandomText
   */
  @Override
  public RandomText request(Integer paragraphs, Integer min, Integer max) throws URISyntaxException {
    logger.log(Level.INFO, "Randomtext.me request for type:{0} p-{1} min:{2} max:{3}",
        new Object[]{GEBBERISH, paragraphs, min, max});

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    String url = "http://www.randomtext.me/api/" + GEBBERISH + "/p-" + paragraphs + "/" + min + "-" + max;

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
    ResponseEntity<RandomText> responseEntity = restTemplate.exchange(
        url,
        HttpMethod.GET,
        entity,
        RandomText.class);
    return responseEntity.getBody();
  }

}
