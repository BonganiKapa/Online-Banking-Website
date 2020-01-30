package system.onlinebanking.model;

import java.sql.Connection;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import system.onlinebanking.bean.ClientDetailBean;

public class DatabaseUtil {

	private static SessionFactory sf;
	
	public static Connection con;
	
	public static SessionFactory getSf() {
		if (sf == null) {
			try {
				Configuration config = new Configuration();
				
				Properties settings = new Properties();
				
				settings.put(Environment.DRIVER, "org.h2.Driver");
				settings.put(Environment.URL, "jdbc:h2:~/test");
				settings.put(Environment.USER, "sa");
				settings.put(Environment.PASS, "");
				settings.put(Environment.DIALECT, "");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				config.setProperties(settings);
				config.addAnnotatedClass(ClientDetailBean.class);
				
				ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
				System.out.println("Created");
				sf = config.buildSessionFactory(sr);
				return sf;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sf;

	}

	public static Connection getCon() {
		// TODO Auto-generated method stub
		return con;
	}
	
}
