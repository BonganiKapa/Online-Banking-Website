package system.onlinebanking.bean;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EntityManagerHelper {

	private static final EntityManagerFactory emf;
	private static final ThreadLocal<EntityManager> tl;
	private static final Logger logger;
	
	
	static {
		emf = Persistence.createEntityManagerFactory("");
		tl = new ThreadLocal<EntityManager>();
		logger = Logger.getLogger("");
		logger.setLevel(Level.ALL);
	}
	
	public static EntityManager getEntityManager() {
		EntityManager manager = tl.get();
		if(manager == null || !manager.isOpen()){
			manager = emf.createEntityManager();
			tl.set(manager);
		}
		return manager;
	}
	
	public static void closeEntityManager() {
		EntityManager em = tl.get();
		tl.set(null);
		if(em != null) {
			em.close();
		}
	}
	
	public static void brgintransaction() {
		getEntityManager().getTransaction().begin();
	}
	
	public static void commit() {
		getEntityManager().getTransaction().commit();
		closeEntityManager();	
	}
	
	public static void rollback() {
		getEntityManager().getTransaction().rollback();
		closeEntityManager();
	}
	
	public static Query createQuery(String query) {
		return getEntityManager().createQuery(query);
	}
	
	public static void log(String infor, Level level, Throwable e) {
		logger.log(level, infor, e);
	}
}
