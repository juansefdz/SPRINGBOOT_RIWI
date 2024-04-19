package com.TaskBoard.TaskBoard.services;

import com.TaskBoard.TaskBoard.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksService {


    @Autowired
    private TasksRepository objCoderRepository;
}
