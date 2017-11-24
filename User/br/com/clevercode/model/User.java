package br.com.clevercode.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="APP_USER")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;

	 

	@Column(name="SALDO", nullable=false)
	private double saldo;
	
	@Transient
	private String notas;
	
	@Transient
	public String getNotas() {
		return notas;
	}
	@Transient
	public void setNotas(String notas) {
		this.notas=notas;
	}
	
	@Transient
	 public double getSaque() {
		 return saldo;
	 }
	@Transient
	 public void setSaque(double restante) {
		 saldo=restante;
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSaldo() {
		return getSaque();
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		   
		return (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))?			  false : true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", saldo=" + saldo + "]";
	}

 


}
