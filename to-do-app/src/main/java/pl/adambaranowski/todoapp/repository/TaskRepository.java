package pl.adambaranowski.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import pl.adambaranowski.todoapp.model.Task;

import java.util.List;


@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Override
    @RestResource(exported = false)
    void deleteById(Long aLong);

    @Override
    @RestResource(exported = false)
    void delete(Task task);

    @RestResource(path = "done", rel = "done")
    List<Task> findByDone(@Param(value = "done") boolean done);
}
