/* Author Antoine Moser */

package net.mythx.restandangular.server.rest.resource;

import java.io.IOException;

import net.mythx.restandangular.server.dao.TodoRepository;
import net.mythx.restandangular.server.model.Todo;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class TodoListResource extends ServerResource {
	private TodoRepository repository = TodoRepository.getInstance();
	
	@Get
	public Representation list() {
		return new JacksonRepresentation<>(repository.list());
	}
	
	@Post("json")
	public void create(Representation representation) throws IOException {
		JacksonRepresentation<Todo> jsonRepresentation = new JacksonRepresentation<Todo>(representation, Todo.class);
		Todo todo = jsonRepresentation.getObject();
		repository.create(todo);
	}
}
