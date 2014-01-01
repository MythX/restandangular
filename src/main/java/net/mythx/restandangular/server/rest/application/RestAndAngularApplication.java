/* Author Antoine Moser */

package net.mythx.restandangular.server.rest.application;

import net.mythx.restandangular.server.rest.resource.TodoListResource;
import net.mythx.restandangular.server.rest.resource.TodoResource;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class RestAndAngularApplication extends Application {
	
	public RestAndAngularApplication() {
        setName("Rest and Angular");
        setDescription("RESTlet + AngularJS integration");
        setAuthor("Antoine Moser");
    }
	
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		
		router.attach("/rest/todos", TodoListResource.class);
		router.attach("/rest/todos/{todoId}", TodoResource.class);
		return router;
	}
}
