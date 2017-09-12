package eu.damek.dao;

import eu.damek.entity.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: bet victor test
 * For: Data access object fro {@link Result} {@link javax.persistence.Entity}
 * Created by damekjan on 16/08/2017.
 */
@Service
public class ResultDAO {

  private List<Result> store = new ArrayList<>();

  /**
   * make new object of {@link Result}
   *
   * @return Result
   */
  public Result getNew() {
    return new Result();
  }

  /**
   * persist or merge entity. saved entity of {@link Result}
   *
   * @param entity {@link Result} entity to save
   */
  public void save(Result entity) {
    if (!store.contains(entity)) {
      store.add(entity);
    } else {
      int index = store.indexOf(entity);
      store.set(index, entity);
    }
  }

  /**
   * get last 10 request
   *
   * @return List of {@link Result}
   */
  public List<Result> getLastTen() {
    if (store.size() > 10) {
      return store.subList(store.size() - 10, 10);
    } else {
      return store;
    }
  }

  /**
   * get all stored request
   *
   * @return List of {@link Result}
   */
  public List<Result> getAll() {
    return store;
  }
}
