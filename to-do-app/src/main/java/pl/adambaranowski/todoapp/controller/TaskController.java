package pl.adambaranowski.todoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.adambaranowski.todoapp.repository.TaskRepository;

@RepositoryRestController
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //ma nie być żadnych parametrów
    @RequestMapping(value = "/tasks", method = RequestMethod.GET, params = {"!sort", "!page", "!size"})
    public ResponseEntity<?> readAllTask(){
        logger.warn("Exposing all the Tasks!");
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @GetMapping("/task")
    ResponseEntity<?> readAllTask(Pageable pageable){

        logger.info("Custom page!");
        return ResponseEntity.ok(taskRepository.findAll(pageable));
    }
}
