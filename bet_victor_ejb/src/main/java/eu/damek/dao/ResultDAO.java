package eu.damek.dao;

import eu.damek.entity.Result;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Project: bet victor test
 * For:
 * Created by damekjan on 16/08/2017.
 */
@Stateless
public class ResultDAO {

    /**
     * entity manager
     */
    @Inject
    private EntityManager em;

    /**
     * make new object of {@link Result}
     *
     * @return Result
     */
    public Result getNew() {
        return new Result();
    }

    /**
     * persist or merge entity
     *
     * @param entity {@link Result} entity to save
     * @return saved entity of {@link Result}
     */
    public Result save(Result entity) {
        if (!em.contains(entity)) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        em.flush();
        return entity;
    }

    /**
     * get last 10 request
     *
     * @return List of {@link Result}
     */
    public List<Result> getLastTen() {
        TypedQuery<Result> query = em.createQuery("SELECT r FROM Result r ORDER BY r.id DESC ", Result.class);
        query.setMaxResults(10);
        return query.getResultList();
    }

    /**
     * get all stored request
     *
     * @return List of {@link Result}
     */
    public List<Result> getAll() {
        TypedQuery<Result> query = em.createQuery("SELECT r FROM Result r ORDER BY r.id DESC ", Result.class);
        return query.getResultList();
    }
}
