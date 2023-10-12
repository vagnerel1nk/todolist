package mz.com.vagnerl1nk.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

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
    public ResponseEntity create(@RequestBody TaskModel taskModel,HttpServletRequest request) {  
        System.out.println("Arrived at Controller");
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);
        var currentDate  = LocalDateTime.now();

        if(currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).
           body("Date start, and date End   need to Bigger Than actualy date ");

        }

        if (taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
            body("Date start, need to smaller Than End date ");
        }


        var task = this.taskRepository.save(taskModel);
        return  ResponseEntity.status(HttpStatus.OK).body(task);

    }
    
}
