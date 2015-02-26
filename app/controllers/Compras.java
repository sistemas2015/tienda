package controllers;

import java.util.List;

import models.Producto;
import models.Promocion;
import models.Usuario;
import play.mvc.Before;
import play.mvc.Controller;

public class Compras extends Controller {
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
    
    public static void listaPromociones(){
    	List<Promocion> promociones=Promocion.findAll();
    	
    	render(promociones);
    }
    
    public static void listaProductos(){
    	List<Producto> productos=Producto.findAll();
    	render(productos);
    }
    
    public static void stock(){
    	List<Producto> productos=Producto.findAll();
    	render(productos);
    }

}
