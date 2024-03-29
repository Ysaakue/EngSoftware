package domain.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

public class Contact  implements Comparable<Object>{
	protected int id;
	protected String name;
	protected String emailAddress;
	protected String faxNumber;
	protected String primaryContactMethod;
	
	public Contact(String name, String emailAddress, String faxNumber, String primaryContactMethod) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.faxNumber = faxNumber;
		this.primaryContactMethod = primaryContactMethod;
	}
	
	public Contact(int id,String name, String emailAddress, String faxNumber, String primaryContactMethod) {
		super();
		this.id = id;
		this.name = name;
		this.emailAddress = emailAddress;
		this.faxNumber = faxNumber;
		this.primaryContactMethod = primaryContactMethod;
	}
	
	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public String getPrimaryContactMethod() {
		return primaryContactMethod;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int compareTo(Object obj){
        Contact proximo = (Contact)obj;
        return this.name.compareTo(proximo.getName());
    }

	public int save() {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO public.contatos(name, email_address, fax_number, primary_contact_method) VALUES ('"+this.name+"', '"+this.emailAddress+"', '"+this.faxNumber+"', '"+this.primaryContactMethod+"');");
            ResultSet resultSet = statement.executeQuery("SELECT currval('contatos_id_seq');");
            resultSet.next();
            return resultSet.getInt("currval");
        }catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
            return 0;
        }
	}
	
	public void addToGroup(int groupId) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO public.contatos_grupos(contato_id, grupo_id) VALUES ('"+this.id+"', '"+groupId+"');");
        }catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
	}
	
	public static TreeSet<Contact> all() {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.contatos");
            TreeSet<Contact> contatos = new TreeSet<Contact>();
            while (resultSet.next()) {
            	contatos.add(new Contact(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("email_address"),resultSet.getString("fax_number") , resultSet.getString("primary_contact_method")));        	
            }
            return contatos;
 
        }catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
            return new TreeSet<Contact>();
        }
	}

}
