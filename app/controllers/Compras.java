package controllers;

import java.util.List;

import models.Compra;
import models.Estadistica;
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
    

    public static void prods(Long id) {
    	System.out.println("se llamo");
    	Producto p = Producto.findById(id);    
        render(p);
    }
    
    
    public static void comprar(Long id, int cantidad) {
    	Usuario usu = Usuario.find("byEmail", Security.connected()).first();
		Producto pro = Producto.findById(id);
		if (cantidad <= pro.stock) {
			pro.decreaseStock(cantidad);			
			Compra com = new Compra(usu, pro, cantidad);
			Estadistica e=new Estadistica();
			e.compra=com;
			e.usuario=usu;
			
			
			com.save();
			e.save();
			
			flash.success("Compra Exitosa");
		} else {			
				flash.error("Lo sentimos ha excedido el stock verifique que la cantidad sea correcta ");			
		}

		redirect("/compras/listaProductos#tit");
	}
    
    public static void repo(){
		Usuario usu = Usuario.find("byEmail", Security.connected()).first();
		List<Compra> com= Compra.find("cliente_id=?",usu.id).fetch();
		//res.get(1).lista.valor
		render(com);
	}


    public static void estadisticas(){
    	List<Usuario> usuarios=Usuario.findAll();
    	List<Estadistica> estadisticas=Estadistica.findAll();
    	
    	
    	render(usuarios,estadisticas);
    }
    
    public static void estadisticasCliente(Long id){
    	Usuario usuario=Usuario.findById(id);
    	List<Estadistica> estadisticas=Estadistica.find("byUsuario_id",usuario.id).fetch();
    	List<Compra> com= Compra.find("cliente_id=?",usuario.id).fetch();
		//res.get(1).lista.valor
    	
    	render(estadisticas,usuario,com);  
    }


}
