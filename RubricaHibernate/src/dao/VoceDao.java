package dao;

import hibernateUtil.HibernateUtil;
import model.Rubrica;
import model.Voce;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VoceDao {

	// 1- Create
	public boolean creaVoce(Voce v) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.persist(v);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	//2- Read
	public Voce readVoce(long v_id){
		Voce v = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			v = session.get(Voce.class, v_id);
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}	
		return v;	
	} 
	
	public Voce readVoce(Rubrica r, String nome, String cognome){
		Voce v = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Voce where rubrica_id_rubrica=:rubricaScelta and nome=:nomeInserito and cognome=:cognomeInserito");
			query.setLong("rubricaScelta", r.getId_Rubrica());
			query.setString("nomeInserito", nome);
			query.setString("cognomeInserito", cognome);
			v = (Voce) query.uniqueResult();
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}	
		return v;	
	}
	
	//3- Update
	public boolean updateVoce(Voce v) {
		boolean token = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			session.update(v);
			tx.commit();
			token = true;
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return token;	
	}
	
	//4-Delete
	public boolean deleteVoce(Voce v){
		boolean token = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			session.delete(v);
			tx.commit();
			token = true;
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return token;
	}
}
