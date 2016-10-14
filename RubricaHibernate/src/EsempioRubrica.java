import model.Rubrica;
import model.Voce;
import dao.RubricaDao;
import servizi.ServizioRubrica;

public class EsempioRubrica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServizioRubrica sRub= new ServizioRubrica();
		
//		System.out.println("rubrica stato creato ? "+sRub.registraRubrica("Fabrizio"));

		RubricaDao rDao = new RubricaDao();

		Rubrica r = rDao.readRubrica(1);

//		System.out.println(r.getNome() + " " + r.getId_Rubrica());

//		sRub.aggiungiVoce(r, "aaa", "aaa", "1111");
//		sRub.aggiungiVoce(r, "bbb", "bbb", "2222");
//		sRub.aggiungiVoce(r, "ccc", "ccc", "3333");
		
//		Voce v1 = sRub.getVoce(r, "bbb", "bbb");
//		System.out.println(v1.getId_voce()+" "+v1.getNome() + " " + v1.getCognome()+" "+v1.getTel()+" "+v1.getRubrica().getId_Rubrica());
		
//		for(Voce v: sRub.getAll(r)){
//			System.out.println(v.getId_voce()+" "+v.getNome() + " " + v.getCognome()+" "+v.getTel());
//		}
		
		Voce v2 = sRub.getVoce(r, "ccc", "ccc");
		
		System.out.println("Voce aggiornata ? "+sRub.aggiornaVoce(r, v2, "ddd", "ddd", "4444"));
		
		sRub.rimuoviVoce(v2);	
		
		
	}

}
