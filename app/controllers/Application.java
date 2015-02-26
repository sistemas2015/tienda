package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {
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
	

    public static void index() {
        render();
    }
    
    public static void contactos() {
        render();
    }
    
    public static void mision() {
        render();
    }
    
    public static void historia() {
        render();
    }
    
    public static void galeria() {
        render();
    }

}