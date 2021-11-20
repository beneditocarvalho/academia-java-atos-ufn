package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.Fornecedor;

public class FornecedorCRUD {
	protected SessionFactory sessionFactory;

	public void setup() {
		// code to load Hibernate Session factory
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		// .configure() // configures settings from hibernate.cfg.xml
		// .build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			// sessionFactory = configuration.buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);

		}
	}

	public void exit() {
		// code to close Hibernate Session factory
	}

	public void create(Fornecedor fornecedor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(fornecedor);

		session.getTransaction().commit();
		session.close();
	}

	public Fornecedor read(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Fornecedor fornecedor = session.get(Fornecedor.class, id);

		session.close();
		return fornecedor;
	}

	public void update(Fornecedor fornecedor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(fornecedor);

		session.getTransaction().commit();
		session.close();
	}

	public void delete(int id) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(id);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(fornecedor);

		session.getTransaction().commit();
		session.close();
	}

	public List<Fornecedor> listAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// leitura via Hibernate Query Language (HQL).
		List<Fornecedor> fornecedores = session.createQuery("from Fornecedor", Fornecedor.class).getResultList();

		session.getTransaction().commit();
		session.close();

		return fornecedores;
	}

	public Object queryWhere(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Object object = session.createQuery("from Fornecedor where id=" + id, Fornecedor.class).getSingleResult();

		session.close();
		return object;
	}

	/*
	 * public Pessoa queryWhere(int id) { Session session =
	 * sessionFactory.openSession(); session.beginTransaction();
	 * 
	 * Pessoa pessoa = session.createQuery("from Pessoa where id="+id,
	 * Pessoa.class).getSingleResult();
	 * 
	 * session.close(); return pessoa; }
	 */

}