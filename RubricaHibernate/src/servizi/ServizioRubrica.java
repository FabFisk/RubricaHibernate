package servizi;

import java.util.Set;

import dao.RubricaDao;
import dao.VoceDao;
import model.Rubrica;
import model.Voce;

public class ServizioRubrica {

	private VoceDao vDao = new VoceDao();
	private RubricaDao rDao = new RubricaDao();

	public boolean registraRubrica(String nome) {
		boolean res = false;
		Rubrica r = new Rubrica(nome);
		res = rDao.creaRubrica(r);
		return res;
	}

	public boolean aggiungiVoce(Rubrica r, String nome, String cognome,
			String tel) {
		boolean res = false;
		Voce v = new Voce(nome, cognome, tel);
		v.setRubrica(r);
		r.aggiungiVoce(v);
		vDao.creaVoce(v);
		rDao.aggiornaRubrica(r);
		return res;
	}
	
	public boolean aggiornaVoce(Rubrica r, Voce v, String nome, String cognome, String tel){
		Voce v1 = vDao.readVoce(v.getId_voce());
		v1.setNome(nome);
		v1.setCognome(cognome);
		v1.setTel(tel);
		return vDao.updateVoce(v1);
	}
	
	public Voce getVoce(Rubrica r, String nome, String cognome){
		return vDao.readVoce(r, nome, cognome);
	}
	
	public Set<Voce> getAll(Rubrica r){
		return r.getVoci();
	}
	
	public boolean rimuoviVoce(Voce v){
		return vDao.deleteVoce(v);
	}

}
