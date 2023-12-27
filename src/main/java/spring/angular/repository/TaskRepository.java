package spring.angular.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.angular.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {}

