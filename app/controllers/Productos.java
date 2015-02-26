package controllers;

import models.Producto;
import models.Usuario;
import play.mvc.Before;
import play.mvc.With;

@With(Secure.class)
@Check("isAdmin")
@CRUD.For(Producto.class)
public class Productos extends CRUD {
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



}
