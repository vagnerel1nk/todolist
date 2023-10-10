package mz.com.vagnerl1nk.todolist.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired //Esta anotação serve para Manter o Ciclo de Vida da Interface
    private IUserRepository userRepository;

  

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByUsername(userModel.getUsername()); // Metodo para criar uma requisição 

        if(user !=null){
            // Retornar a uma mensagem de erro e o Status Code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" The user Already Exist");
        }

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }



    
}
