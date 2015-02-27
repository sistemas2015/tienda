package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Estadistica extends Model {
	
	@ManyToOne
	public Usuario usuario;
	@ManyToOne
	public Compra compra;
    
}
