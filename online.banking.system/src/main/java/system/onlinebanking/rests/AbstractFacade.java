package system.onlinebanking.rests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import system.onlinebanking.bean.EntityManagerHelper;

public abstract class AbstractFacade<T> {
	
	private Class<T> entityClass;
	
	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();
	
	public Response create(T client) {
		try {
			if(!getEntityManager().getTransaction().isActive()){
				getEntityManager().getTransaction().begin();
			}
			
			getEntityManager().persist(client);
			EntityManagerHelper.commit();
			return Response.ok().entity("Client Details Edited Successfully").build();
		}
		catch(Exception ex) {
			EntityManagerHelper.rollback();
			throw new WebApplicationException(ex, Response.Status.NOT_FOUND);
		}
		
		public Response remove(T client) {
			try {
				if (!getEntityManager().getTransaction().isActive()) {
					getEntityManager().getTransaction().begin();
				}
				getEntityManager().remove(getEntityManager().merge(client));
				EntityManagerHelper.commit();
				return Response.ok().entity("Client Successfully Deleted").build();
			} catch (Exception e) {
				EntityManagerHelper.rollback();
				throw new WebApplicationException(e, Response.Status.NOT_FOUND);
			}
		}
		
		public T find (Object clientIndex){
			T obj = getEntityManager().find(entityClass, clientIndex);
			EntityManagerHelper.closeEntityManager();
			return obj;
		}
		
		public List<T> findAll(){
			CreateQuery<Object> cq = ((Object) getEntityManager()).getCriteriaBuilder().createQuery();
			cq.select(cq.from(entityClass));
			List<T> list = (List<T>) getEntityManager().createQuery(cq).getResultList();
			EntityManagerHelper.closeEntityManager();
			return list; 
		}
	}
}
