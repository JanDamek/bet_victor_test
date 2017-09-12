package eu.damek.rest;

import eu.damek.model.TextResponse;
import eu.damek.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Project: bet victor test
 * For:
 * Created by damekjan on 05/09/2017.
 */
@RestController
public class RandomTextRestController {

  /**
   * textService
   */
  @Autowired
  private TextService textService;

  /**
   * REST method GET
   *
   * @param pStart   start paragraph
   * @param pEnd     end paragraph
   * @param minCount min count of words
   * @param maxCount max count of words
   * @return Response
   */

  @RequestMapping("/text")
  public TextResponse text(@RequestParam("p_start") Integer pStart,
                           @RequestParam("p_end") Integer pEnd,
                           @RequestParam("w_count_min") Integer minCount,
                           @RequestParam("w_count_max") Integer maxCount) {

    return textService.text(pStart, pEnd, minCount, maxCount);
  }

  /**
   * REST method GET fro return last 10 request
   *
   * @return List
   */
  @RequestMapping("/history")
  public List<TextResponse> history() {
    return textService.history();
  }

}
