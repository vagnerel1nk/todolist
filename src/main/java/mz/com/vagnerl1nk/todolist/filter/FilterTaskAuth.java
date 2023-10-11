package mz.com.vagnerl1nk.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter  {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                // Quero que a aplicação pege a autenticacao do usuario e a senha
              var authorization =   request.getHeader("Authorization");
              var authEncoded = authorization.substring("Basic".length()).trim();  

              byte[] authDecode = Base64.getDecoder().decode(authEncoded) ;

              String authString = new String (authDecode);

              System.out.println("Authorization ");
          

              String[] credentials = authString.split(":");
              String username = credentials[0];
              String password = credentials[1];
              System.out.println(username);
              System.out.println(password);


                
                // substring serve 
               


                // Fiz uma condição para validar o nome do usuario
                // Fiz uma condição para validar o nome do usuari
                // Se a aplicação tiver como senha e usuarios validos pode prosseguir
        
        filterChain.doFilter(request, response) ;           
        
        

        } 
        
}