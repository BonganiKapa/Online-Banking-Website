package system.onlinebanking.rests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import system.onlinebanking.bean.ClientDetailBean;
import system.onlinebanking.bean.EntityManagerHelper;

@javax.inject.Singleton
@Path("ClientDetailBean")
public class ClientREST extends AbstractFacade<ClientDetailBean> {
	
	private EntityManager em;

	public ClientREST() {
		super(ClientDetailBean.class);
	}
	
	//SAVING THE CLIENT
	@PUT
	//@Override
	@Consumes({"application/xml", "application/json"})
	public Response edit(ClientDetailBean client) {
		if(client.getFirstName().length() <= 0) {
			return Response.status(Status.CONFLICT).entity("Client Name is too short").type(MediaType.TEXT_PLAIN).build();
			
		}
		return super.edit(client);
	}
	
	//REMOVING THE CLIENT FROM THE DATABASE USING THE INDEX
	@DELETE
	@Path("remove/{clientIndex}")
	public Response remove(@PathParam("clientIndex") Integer clientIndex) {
		return super.remove(super.find(clientIndex));	
	}
	
	//SEARCH USING CLIENT INDEX
	@GET
	@Path({"clientIndex"})
	@Produces({"application/json"})
	public ClientDetailBean find(@PathParam("clientIndex") Integer clientIndex) {
		return super.find(clientIndex);
	}
	
	@GET
	//@Override
	@Produces({"application/json"})
	public List <ClientDetailBean> findAll(){
		return super.findAll();
	}
	
	//@Override
	protected EntityManager getEntityManager() {
		em = EntityManagerHelper.getEntityManager();
		return em;
	}
	
}
