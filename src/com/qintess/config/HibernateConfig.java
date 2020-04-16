package com.qintess.config;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.qintess.Test.Test;
import com.qintess.dao.GenericDAO;
import com.qintess.dao.GenericDaoTfk;
import com.qintess.model.Cerveja;
import com.qintess.model.Cidade;
import com.qintess.model.Cliente;
import com.qintess.model.EntidadeBase;
import com.qintess.model.Estado;
import com.qintess.model.Estilo;
import com.qintess.model.Grupo;
import com.qintess.model.ItemVenda;
import com.qintess.model.Permissao;
import com.qintess.model.SchemaVersion;
import com.qintess.model.Usuario;
import com.qintess.model.Venda;

public class HibernateConfig {
	
	private static SessionFactory sessionFactory; //sessionFactory:Lê o arquivo de configuracao do hibernate, obtem conexao com o BD
	                                                //e cria os objetos de sessao(session)     
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				
				Properties prop = new Properties();
				
				prop.put(Environment.DRIVER, "org.h2.Driver");
				prop.put(Environment.URL, "jdbc:h2:~/desafio3_hibernate");
				prop.put(Environment.USER, "sa");
				prop.put(Environment.PASS, "");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
				
				prop.put(Environment.SHOW_SQL, "true");
				prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				configuration.setProperties(prop);
				
				configuration.addAnnotatedClass(SchemaVersion.class);
				configuration.addAnnotatedClass(Estilo.class);
				configuration.addAnnotatedClass(Cerveja.class);
				configuration.addAnnotatedClass(Cidade.class);
				configuration.addAnnotatedClass(Cliente.class);
				configuration.addAnnotatedClass(EntidadeBase.class);
				configuration.addAnnotatedClass(Estado.class);
				configuration.addAnnotatedClass(Estilo.class);
				configuration.addAnnotatedClass(Grupo.class);
				configuration.addAnnotatedClass(ItemVenda.class);
				configuration.addAnnotatedClass(Permissao.class);
				configuration.addAnnotatedClass(Usuario.class);
				configuration.addAnnotatedClass(Venda.class);
				//configuration.addAnnotatedClass(GenericDAO.class);
				//configuration.addAnnotatedClass(GenericDaoTfk.class);
				//configuration.addAnnotatedClass(Test.class);
				
				
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
													.applySettings(configuration.getProperties())
													.build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		}
			return sessionFactory;
	}
}
