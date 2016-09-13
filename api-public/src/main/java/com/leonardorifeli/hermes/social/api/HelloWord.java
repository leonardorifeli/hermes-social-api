package com.leonardorifeli.hermes.social.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWord
{

    @GET
    @Path("/{param}")
    public Response printMessage(@PathParam("param") String msg)
    {
        String result = "Hello, " + msg;
        return Response.status(200).entity(result).build();
    }

}