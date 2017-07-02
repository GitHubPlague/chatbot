package com.pankova.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pankova.chatbot.model.Task;
import com.pankova.chatbot.repository.TaskRepository;

@RestController
@RequestMapping(path = "/todo")
public class TodoController {

	@Autowired
	private TaskRepository taskRepository;

	@RequestMapping(path = "", method = RequestMethod.POST)
	public Task create(@RequestBody Task task) {
		return taskRepository.save(task);
	}

	@RequestMapping(path = "", method = RequestMethod.GET)
	public Iterable<Task> readAll() {
		return taskRepository.findAll();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Task read(@PathVariable long id) {
		return taskRepository.findOne(id);
	}

	@RequestMapping(path = "/{id}", method = { RequestMethod.PUT,
			RequestMethod.PATCH })
	public Task update(@RequestBody Task task, @PathVariable long id) {
		Task existingTask = taskRepository.findOne(id);
		Task result = null;
		if (existingTask != null) {
			task.setId(existingTask.getId());
			result = taskRepository.save(task);
		}
		return result;
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		taskRepository.delete(id);
	}
}
