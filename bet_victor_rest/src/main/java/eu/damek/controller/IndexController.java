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
 * For: controller for home page
 * Created by damekjan on 16/08/2017.
 */
@ManagedBean
public class IndexController {

    /**
     * resultDAO
     */
    @Inject
    private ResultDAO resultDAO;

    /**
     * getter for get all request
     *
     * @return List
     */
    public List<Result> getHistory() {
        return resultDAO.getAll();
    }

    /**
     * sorted list of words with count
     *
     * @param inWords Result for get the words
     * @return List
     */
    public List<Map.Entry> words(Result inWords) {
        List<Map.Entry> result = new ArrayList<>(inWords.getWords().entrySet());
        result.sort(Comparator.comparingInt(o -> (Integer) ((Map.Entry) o).getValue()).reversed());
        return result;
    }
}
