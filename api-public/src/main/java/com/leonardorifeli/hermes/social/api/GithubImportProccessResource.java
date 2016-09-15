package com.leonardorifeli.hermes.social.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Path("/import/github")
public class GithubImportProccessResource
{	
    @POST
    @Path("")
    public Response builderProccess(@PathParam("user") String user)
    {
        String result = "Hello, " + user;
        return Response.status(200).entity(result).build();
    }

}