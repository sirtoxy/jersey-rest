package com.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.model.User;
import com.service.UserService;

@Path("/user")
@Component
@Scope("singleton")
public class UserWebService {

    @Autowired
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public User getById(@PathParam("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create/{name}")
    public Long getById(@PathParam("name") String name) {
        return userService.createUser(name);
    }
}
