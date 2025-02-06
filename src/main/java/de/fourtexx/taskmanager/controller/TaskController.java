package de.fourtexx.taskmanager.controller;

import de.fourtexx.taskmanager.entity.Task;
import de.fourtexx.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // Alle Aufgaben anzeigen
    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
    }

    // Aufgabe hinzufügen
    @PostMapping
    public String addTask(@RequestParam String description) {
        Task task = new Task();
        task.setDescription(description);
        task.setCompleted(false);
        taskRepository.save(task);
        return "redirect:/tasks";
    }

    // Aufgabe als erledigt markieren
    @PostMapping("/{id}/complete")
    public String completeTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(true);
        taskRepository.save(task);
        return "redirect:/tasks";
    }
}