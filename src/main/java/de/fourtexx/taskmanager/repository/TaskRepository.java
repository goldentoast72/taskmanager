package de.fourtexx.taskmanager.repository;

import de.fourtexx.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {

}