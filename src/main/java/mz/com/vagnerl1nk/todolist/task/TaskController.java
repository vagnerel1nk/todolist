package mz.com.vagnerl1nk.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

     /*  este metodo permite criar uma nova tarefa vindo da classe TaskModel
      * sendo assim com a funcao taskrepository podemos salvar todos os dados
      que vem da Nova Tarefa cirada pelo TaskModel direto no banco de dados 
      e com a palavra return podemos exibir os mesmos dados 
      */
    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel) {  
        System.out.println("Arrived at Controller");
        var task = this.taskRepository.save(taskModel);
        return task;

    }
    
}
