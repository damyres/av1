package jogadaDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Jogada;
import util.JPAUtil;

//acessa o banco
public class JogadaDao {

	public static void salvar(Jogada jogada) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		em.persist(jogada);
		em.getTransaction().commit();
		em.close();

	}

	public static List<Jogada> listar() {
		EntityManager em = JPAUtil.createEntityManager();
		Query q = em.createQuery("select j from jogada j");
		List<Jogada> lista = q.getResultList();
		em.close();
		return lista;

	}

	public static void editar(Jogada jogada) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		em.merge(jogada);
		em.getTransaction().commit();
		em.close();
	}

	public static void excluir(Jogada id) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		Jogada jogada = em.find(Jogada.class, id.getId());
		em.remove(jogada);
		em.getTransaction().commit();
		em.close();
	}

}
