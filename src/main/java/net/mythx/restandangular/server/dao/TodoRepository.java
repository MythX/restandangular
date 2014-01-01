/* Author Antoine Moser */

package net.mythx.restandangular.server.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

import net.mythx.restandangular.server.model.Todo;

public class TodoRepository {
	private static final Map<Long, Todo> REPOSITORY = new ConcurrentSkipListMap<Long, Todo>();
	private static final AtomicLong IDS = new AtomicLong(0);
	
	private static final TodoRepository INSTANCE = new TodoRepository();
	
	public TodoRepository() {
		
	}
	
	public static TodoRepository getInstance() {
		return INSTANCE;
	}
	
	public List<Todo> list() {
		return new ArrayList<>(REPOSITORY.values());
	}
	
	public Todo get(Long id) {
		return REPOSITORY.get(id);
	}
	
	public void create(Todo todo) {
		long id = IDS.getAndIncrement();
		todo.setId(id);
		REPOSITORY.put(id, todo);
	}
	
	public void update(Todo todo) {
		REPOSITORY.put(todo.getId(), todo);
	}
	
	public boolean delete(Long id) {
		return REPOSITORY.remove(id) != null;
	}
}
