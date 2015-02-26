package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
	public String email;
	public String nombre;
	public String apellido;
	public String password;
	public boolean isAdmin;
	
	
	//Constructor
	public Usuario(String email, String nombre, String apellido,
			String password) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.isAdmin=false;
	}
	
	
    
}
