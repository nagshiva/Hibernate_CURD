package KLEF.Hibernate_CURD;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Patient {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String Fn,Ln;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFn() {
		return Fn;
	}
	public void setFn(String fn) {
		Fn = fn;
	}
	public String getLn() {
		return Ln;
	}
	public void setLn(String ln) {
		Ln = ln;
	}
	@Override
	  public String toString() {
	    String n;
		return "id=" + id + ", fn=" + Fn + ", ln=" + Ln;
	  }
	

}
