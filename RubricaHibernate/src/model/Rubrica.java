package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Rubrica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_Rubrica;
	private String nome;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "rubrica", cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Voce> voci = new HashSet<Voce>();

	public Rubrica() {
		this.nome = "";
	}

	public Rubrica(String nome) {
		this.nome = nome;
	}

	public long getId_Rubrica() {
		return id_Rubrica;
	}
	public void setId_Rubrica(long id_Rubrica) {
		this.id_Rubrica = id_Rubrica;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Voce> getVoci() {
		return voci;
	}
	public void setVoci(Set<Voce> voci) {
		this.voci = voci;
	}
	public void aggiungiVoce(Voce v) {
		this.voci.add(v);
	}
}
