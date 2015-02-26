package controllers;

import models.Promocion;
import models.Usuario;
import play.mvc.Before;
import play.mvc.With;

@With(Secure.class)
@Check("isAdmin")
@CRUD.For(Promocion.class)
public class Promociones extends CRUD{
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
