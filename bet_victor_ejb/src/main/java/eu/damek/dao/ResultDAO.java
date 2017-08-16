package eu.damek.dao;

import eu.damek.entity.Result;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

/**
 * Project: bet victor test
 * For:
 * Created by damekjan on 16/08/2017.
 */
@Stateless
public class ResultDAO {

    @Inject
    private EntityManager em;

    @Inject
    private Logger logger;

    public Result getNew() {
        return new Result();
    }

    public Result save(Result entity) {
        if (!em.contains(entity)) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        em.flush();
        return entity;
    }

    public List<Result> getLastTen() {
        TypedQuery<Result> query = em.createQuery("SELECT r FROM Result r ORDER BY r.id DESC ", Result.class);
        query.setMaxResults(10);
        return query.getResultList();
    }

    public List<Result> getAll() {
        TypedQuery<Result> query = em.createQuery("SELECT r FROM Result r ORDER BY r.id DESC ", Result.class);
        return query.getResultList();
    }
}
