package mz.com.vagnerl1nk.todolist.users;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;





/*Esta é a camada de interface que serve para representar o modelo de uma classe na web
sendo assim usamos a palava extends JpaRepository que é uma Classe que necessita
de dois atributos, nesse caso usamo a classe UserModel e o atributo UUID

*/
public interface IUserRepository extends JpaRepository <UserModel, UUID> { 
  UserModel findByUsername(String username);


    
}
