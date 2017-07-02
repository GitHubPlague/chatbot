package com.pankova.chatbot.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pankova.chatbot.model.Task;

@RestController
@RequestMapping(path = "/todo")
public class TodoController {
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public Task create(@RequestBody Task task){
		return task;
	}
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<Task> readAll(){
		return null;
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Task read(@PathParam(value = "id") Long id){
		return null;
	}
	
	@RequestMapping(path = "/{id}", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public Task update(@RequestBody Task task, @PathParam(value = "id") Long id){
		return task;
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public Void delete(@PathParam(value = "id") Long id){
		return null;
	}
}
