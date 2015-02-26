package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Promocion extends Model {
	@Required
	public String descripcion;
	@Required
	@ManyToOne
	public Producto producto;

	public Promocion(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	
	public String toString(){
		
		return this.descripcion;
	}
	
	public String toAdicional1(){
		
		return "";
	}
	
	public String toAdicional2(){
		
		return "";
	}
	

    
}
