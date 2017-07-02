package com.pankova.chatbot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pankova.chatbot.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}
