package mz.com.vagnerl1nk.todolist.users;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data //Esta anotação serve para criar Metodos Getters e Setters automaticamente
@Entity(name = "tb_users") //Esta anotação serve para personalizar os nomes na tabela do banco de dados
public class UserModel {

  
    @Id // Esta anotação serve para identificar o usuario no banco de dados
    @GeneratedValue(generator = "UUID")
    private UUID id; // Este atributo  serve para identificar o usuario no banco de dados de Forma Unica 
   
    @Column(unique =true) //Serve para evitar duplicações de dados  dentro da nossa base de dados
    public String name;
    public String username;
    public String password;
   
    @CreationTimestamp // A anotação e o atributo servem para registrar o momento em que o a conta do usuario foi criada
    private LocalDateTime createdAt; 

      //Usando Getters e Setters Dentro da Applicação


    
}
