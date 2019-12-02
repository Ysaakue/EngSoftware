package domain.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

public class ContactGroup implements Comparable<Object>{
	protected int id;
	protected String name;
	private int father;
	private TreeSet<Contact> contacts = new TreeSet<Contact>();
	private TreeSet<ContactGroup> groups = new TreeSet<ContactGroup>();
	private int qntd_contatos;
	
	public ContactGroup(String name) {
		super();
		this.name = name;
	}
	
	public ContactGroup(int id,String name,int father,int qntd_contatos) {
		super();
		this.id = id;
		this.name = name;
		this.father = father;
		this.qntd_contatos = qntd_contatos;
	}
	
	public int getQntd_contatos() {
		return qntd_contatos;
	}

	public void setQntd_contatos(int qntd_contatos) {
		this.qntd_contatos = qntd_contatos;
	}

	public int getId() {
		return id;
	}

	public int getFather() {
		return father;
	}

	public void setFather(int father) {
		this.father = father;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public TreeSet<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(TreeSet<Contact> contacts) {
		this.contacts = contacts;
	}


	public TreeSet<ContactGroup> getGroups() {
		return groups;
	}


	public void setGroups(TreeSet<ContactGroup> groups) {
		this.groups = groups;
	}


	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}
	
	public int compareTo(Object obj){
        ContactGroup proximo = (ContactGroup)obj;
        return this.name.compareTo(proximo.getName());
    }
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int save() {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO public.grupos (name) VALUES ('"+this.name+"');");
            ResultSet resultSet = statement.executeQuery("SELECT currval('grupos_id_seq');");
            resultSet.next();
            return resultSet.getInt("currval");
		}catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
            return -1;
        }
	}
	
	public void addFather() {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE grupos SET father='"+this.father+"' WHERE id='"+this.id+"';");
        }catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
	}
	
	public static ContactGroup getById(int id) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *  FROM public.grupos where id = "+id+";");
            resultSet.next();
            return new ContactGroup(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("father"),resultSet.getInt("count"));
 
        }catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
            return new ContactGroup("");
        }
	}
	
	public static String getNameById(int id) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *  FROM public.grupos where id = "+id+";");
            if(resultSet.next()) {
            	return resultSet.getString("name");            	            	
            } else {
            	return "";
            }
 
        }catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
            return "";
        }
	}
	
	public static String getQntById(int id) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *  FROM public.grupos where id = "+id+";");
            resultSet.next();
            return resultSet.getString("name");
 
        }catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
            return "";
        }
	}
	
	public static TreeSet<ContactGroup> all() {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT grupos.* ,(select count(contatos_grupos.*) from public.contatos_grupos where contatos_grupos.grupo_id = grupos.id group by grupos.id)  FROM public.grupos ;");
            TreeSet<ContactGroup> grupos = new TreeSet<ContactGroup>();
            while (resultSet.next()) {
            	grupos.add(new ContactGroup(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("father"),resultSet.getInt("count")));
            }
            return grupos;
 
        }catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
            return new TreeSet<ContactGroup>();
        }
	}
}
