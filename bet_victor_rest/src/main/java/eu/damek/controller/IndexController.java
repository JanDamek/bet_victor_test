package eu.damek.controller;

import eu.damek.dao.ResultDAO;
import eu.damek.entity.Result;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Project: bet victor test
 * For:
 * Created by damekjan on 16/08/2017.
 */
@ManagedBean
public class IndexController {

    @Inject
    private ResultDAO resultDAO;

    public List<Result> getHistory() {
        return resultDAO.getAll();
    }

    public List<Map.Entry> words(Result r) {
        List<Map.Entry> result = new ArrayList<>(r.getWords().entrySet());
        result.sort(Comparator.comparingInt(o -> (Integer) ((Map.Entry) o).getValue()).reversed());
        return result;
    }
}
