package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//cria o objeto que acessa o banco
//gerenciador de entitades
public class JPAUtil {

	private static final EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("integracaoPU");

		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);

		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

}
