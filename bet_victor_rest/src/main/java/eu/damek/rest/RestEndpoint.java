package eu.damek.rest;

import eu.damek.service.TextService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Endpoint for REST
 */
@Stateless
@Path("/")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class RestEndpoint {

    /**
     * textService
     */
    @Inject
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
    @GET
    @Path("text")
    @Produces(APPLICATION_JSON)
    public Response text(@QueryParam("p_start") Integer pStart,
                         @QueryParam("p_end") Integer pEnd,
                         @QueryParam("w_count_min") Integer minCount,
                         @QueryParam("w_count_max") Integer maxCount) {

        return Response.ok().entity(textService.text(pStart, pEnd, minCount, maxCount)).build();
    }

    /**
     * REST method GET fro return last 10 request
     *
     * @return List
     */
    @GET
    @Path("history")
    @Produces(APPLICATION_JSON)
    public Response history() {
        return Response.ok().entity(textService.history()).build();
    }
}
