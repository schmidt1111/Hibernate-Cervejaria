package com.qintess.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qintess.config.HibernateConfig;
import com.qintess.model.EntidadeBase;

//<coloca nome generic para domain(entidade)
	public class GenericDAO <T extends EntidadeBase> {

		//(salvar objeto na entidade)
		public void salvar (T Objeto) {
			
			//capturar uma sessao aberta
			Session session = HibernateConfig.getSessionFactory().openSession();

			//declarar um objeto do tipo Transaçao(Org.hibernate)
			Transaction transaction = null;
			
			//tentar
			try {
				//abrir transaçao
				transaction = session.beginTransaction();
				System.out.println(Objeto);
				//faça alguma coisa, no caso salvar
				session.save(Objeto);
				//confirmar a transacao
				transaction.commit();
				
			}catch (Exception e) { //desfazer
				
				//se a transacao for diferente de nula
				if(transaction != null) {
					
					//ele desfaz a transacao
					transaction.rollback();
					
				} //printar o erro
				e.printStackTrace();
				
			} finally { //ele sempre executa
				
				//finalizar sessao
				session.close();
			}
		}
		
		public T buscaPorId (Class<T> clazz, int id) {
			Session session = HibernateConfig.getSessionFactory().openSession();
			Transaction transaction = null;
			
			return session.find(clazz, id);
		}
		
		public void deletar (T Object) {
			Session session = HibernateConfig.getSessionFactory().openSession();
			Transaction transaction = null;
			
			try {
				transaction = session.beginTransaction();
				session.remove (Object);
				session.getTransaction().commit();
				
			}catch (Exception e) {
				if(transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
				
			} finally {
				session.close();
			}
		}
}