package controllers;


import java.util.Random;

import org.h2.engine.User;

import models.Rol;
import models.Usuario;
import play.data.validation.Required;
import play.mvc.Before;
import play.mvc.With;



public class Security extends Secure.Security {
	@Before
	public static void mostrarUsuario(){
		try{
			Usuario user = Usuario.find("byEmail", Security.connected()).first();
			//obteniendo datos del usuario que ha iniciado sesion
			if(Security.isConnected()) {
		        renderArgs.put("conectado", user.nombre+" "+user.apellido); 
		    }
			}catch(Exception ex){
				
			}
	}
	
	
	  public static boolean check(String a) {
		  Usuario user = Usuario.find("byEmail",Security.connected()).first();
		return user.isAdmin;
		
	}
	 
	public static void registro(){
		render();
	}
	
	static boolean authenticate(@Required String username, String password){
        Usuario user = Usuario.find("byEmail", username).first();
        return user != null && user.password.equals(password);
        
    }
	

	
	
	public static void guardarUsuario(String email,String nombre,String apellido,String password) throws Throwable{
		flash.put("nombre", nombre);
		flash.put("apellido", apellido);
		flash.put("email", email);
	

			
			//buscando si el usuario ya ha sido registrado
			Usuario user = Usuario.find("byEmail",email).first(); 
			
			if (user == null){
				//si aun no existe lo guardamos
				
				
				Usuario nuevo=new Usuario(email, nombre, apellido, password);
				nuevo.save();
				Secure.authenticate(email, password, true);
				//Secure.redirectToOriginalURL();
		
			}else{
				//en caso de que ya exista
			flash.put("existente", "Error: Esta cuenta ya esta en uso");
			redirect("/security/registro");
			}
	
}

}
