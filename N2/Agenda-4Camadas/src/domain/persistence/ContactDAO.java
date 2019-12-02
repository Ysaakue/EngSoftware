package domain.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

import domain.business.Contact;;;

public class ContactDAO {

	public int save(Contact contato) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO public.contatos(name, email_address, fax_number, primary_contact_method) VALUES ('"+contato.getName()+"', '"+contato.getEmailAddress()+"', '"+contato.getFaxNumber()+"', '"+contato.getPrimaryContactMethod()+"');");
            ResultSet resultSet = statement.executeQuery("SELECT currval('contatos_id_seq');");
            resultSet.next();
            return resultSet.getInt("currval");
        }catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
            return 0;
        }
	}
	
	public void addToGroup(Contact contato, int groupId) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO public.contatos_grupos(contato_id, grupo_id) VALUES ('"+contato.getId()+"', '"+groupId+"');");
        }catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
	}
	
	public TreeSet<Contact> all() {
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
