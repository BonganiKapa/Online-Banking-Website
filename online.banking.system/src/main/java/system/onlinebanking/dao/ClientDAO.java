package system.onlinebanking.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.classic.Session;

import system.onlinebanking.bean.ClientDetailBean;
import system.onlinebanking.model.DatabaseUtil;

public class ClientDAO {
	
	//Save new Client
	public void saveClient(ClientDetailBean client) {
	
		Transaction trans = null;
		
		try (Session session = DatabaseUtil.getSf().openSession()){
			
			//Start Transaction
			trans = session.beginTransaction();
			
			//Save Client
			session.save(client);
			
			//Commit Transaction
			trans.commit();
		}
		catch (Exception e) {
			if(trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	
	//Update Client Details
	public void updateClient(ClientDetailBean client) {
		Transaction trans = null;
		
		try(Session session = DatabaseUtil.getSf().openSession()){
			
			//Start Transaction
			trans = session.beginTransaction();
			
			//Save Updates
			session.update(client);
			
			//Commit Transaction
			trans.commit();
		}
		catch (Exception e) {
			if(trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	
	//DELETE Client
	@SuppressWarnings("deprecation")
	public void deleteClient(int id) {
		
		Transaction trans = null;
		
		try(Session session = DatabaseUtil.getSf().openSession()){
			
			//Start Session
			trans = session.beginTransaction();
			
			//Delete Client Details
			ClientDetailBean client = session.get(ClientDetailBean.class, id);
			if (client != null) {
				session.delete(client);
				System.out.println("Client is Successfully Deleted!!");
			}
			
			//Commit Transaction
			trans.commit();
			//if(client)
		}
		catch(Exception e) {
			if(trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	
	
	//Get User BY ID NUMBER
	//@SuppressWarnings("deprecation")
	@SuppressWarnings("deprecation")
	public ClientDetailBean getIdNum(String idNum) {
		
		Transaction trans = null;
		
		ClientDetailBean client = null;
		
		try (Session session = DatabaseUtil.getSf().openSession()){
			
			//Start Transaction
			trans = session.beginTransaction();
			
			//Get Client
			client = session.get(ClientDetailBean.class, idNum);
			
			//Commit
			trans.commit();
		}
		catch(Exception e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return client;
	}
	
	
}
