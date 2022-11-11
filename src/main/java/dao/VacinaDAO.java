package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidade.Vacina;
import util.JPAUtil;

public class VacinaDAO {
	public static void insert(Vacina v) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
	}
	public static void update(Vacina v) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(v);
		em.getTransaction().commit();
		em.close();
	}
	public static void remove(Vacina v) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		v = em.find(Vacina.class, v.getId());
		em.remove(v);
		em.getTransaction().commit();
		em.close();
	}
	public static Vacina buscarPorId(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		Vacina v1 = em.find(Vacina.class, id);
		em.close();
		return v1;
	}
	public static Vacina buscarMaior() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query ultimo = em.createNativeQuery("SELECT MAX(id) FROM vacina");
		Integer ul = (Integer) ultimo.getSingleResult();
		Vacina maior = buscarPorId(ul);
		return maior;
	}
	
	public static List<Vacina> lista(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select v from Vacina v");
		List<Vacina> lista = q.getResultList();
		em.close();
		return lista;
	}
}
