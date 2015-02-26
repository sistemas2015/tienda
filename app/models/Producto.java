package models;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Producto extends Model {

	@Required 
	public String nombre;
	@Required 
	public String descripcion;
	@Required
	public int  stock;
	@Required 
	public double  precio;
	
	
public String toString(){
		
		return this.nombre;
	}
	
	public String toAdicional1(){
		return "Precio: "+String.valueOf(precio)+" $";
	}
	
	public String toAdicional2(){
		
		return "Stock: "+String.valueOf(stock)+" unidades";
	}
	
	public void decreaseStock(int can){
		this.stock=this.stock-can;
		this.save();
	}


}
