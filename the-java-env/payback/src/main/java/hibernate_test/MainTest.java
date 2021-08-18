package hibernate_test;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class MainTest {

	
	
	//session
	
	
	
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(Users.class);
		//i can clean this up later 
		
		
		//displayListUsers();
		//seeUser(session, 1);
		//createRequest();
		//showRequests(session, 1);
		criteriaStuff(cr);
		
		session.close();
	}
		
		
		//session factory from configuaration object
		
	
	private static void criteriaStuff(Criteria cr) {
		
		//this way has to be the obeject user and joins are weird
		//needs the object
		
		//when user objects are upadated you also havet to update the config file
		
		//restirctions are like where clauses
		
		cr.add(Restrictions.eq("f_name" ,"nick"));
		List<Users> results = cr.list();
		for(Users u : results) {
			System.out.println(u.getF_name());
		}
		
		
	}
	
	
		
	private static void seeUser(Session session, int id) {
		//use the session for querying and other operations
		Users user = (Users)session.get(Users.class, id);
		System.out.println(user.getId());
		System.out.println(user.getF_name());
		System.out.println(user.getL_name());
		
	}
		//HQL: hibernate query language 
		
		
		//get list of users
	private static void displayListUsers(Session session) {
		List<Users> users = session.createQuery("FROM Users").list();
		for(Users u : users) {
			System.out.println(u.getF_name() + " | " + u.getL_name());
		}
		
	}
	
		private void hqlQuery(Session session) {
		Query query = session.createQuery("FROM Users WHERE role = :role");
		//like a prepared statement
		//execpt with a colon flag
		query.setString("role", "Employee");
		List<Users> users = query.list();
		}
		
		//this creates a record
		//need to make the trasnaction then commit it.
		private void createNewUser(Session session) {
			Transaction tx = null;
		try {
			
			//begins transaction 
			tx = session.beginTransaction();
			Users newUser = new Users("nick", "card");
			int id = (Integer) session.save(newUser);
			
			//commits transaction
			tx.commit();
			System.out.println("new employee ID:" +  id);
			
		}catch (HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
		}
	
		
	private static void showRequests(Session session, int id) {
		
		Users usr = (Users) session.get(Users.class, id);
		System.out.println(usr.getF_name());
		System.out.println(usr.getL_name());
		Set<Request> requests = usr.getRequests();
		for(Request r : requests) {
			System.out.println("THis that emplyee request do" + r.getStatus());
		}
		
		
		
		
		
		
	}
		
		
	private void updateUser(Session session) {
		Transaction tx = null;
		try {
			
			//begins transaction 
			tx = session.beginTransaction();
			
			Users user = (Users) session.get(Users.class, 3);
			
			user.setF_name("kyle");
			
			//can call save or update but better to call update
			
			//doesnt return any values
			session.update(user);
			
			//commits transaction
			tx.commit();
			System.out.println("Employee name updated:");
			
		}catch (HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
	}
		//without commit but its not working
		
		
		
	private void createUser(Session session) {
		Users newUser = new Users("heyo", "card");
		int id = (Integer) session.save(newUser);
		System.out.println("(WITHOUT TRANSACTION new employee ID:" +  id);
		
		//session.close();
	}
		
	
		
	private void deleteUser(Session session) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Users user = (Users) session.get(Users.class, 3);
			session.delete(user);
			tx.commit();
		}catch (HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}
		
	}
	
	private static void createRequest(Session session) {
		//this creates a link for the requests to add an employee id to them when made
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Users u = new Users("ben", "dover");
			session.save(u);
			Request req = new Request("pending", 50);
			//adds the employee id
			req.setUsers(u);
			session.save(req);
			tx.commit();
			
			
		}catch (HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}
	
	}
}
