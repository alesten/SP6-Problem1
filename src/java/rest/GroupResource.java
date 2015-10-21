/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.Group;
import facade.GroupFacade;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author Alexander
 */
@Path("group")
public class GroupResource {

    @Context
    private UriInfo context;
    private GroupFacade groupFacade;
    private static List<Group> groups;
    
    public GroupResource() {
        groupFacade = new GroupFacade();
    }

    /**
     * Retrieves representation of an instance of rest.GroupResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public List<Group> getJson() throws Exception {
        if(groups == null){
            groups = groupFacade.getGroups();
        }
        return groups;
    }

}
