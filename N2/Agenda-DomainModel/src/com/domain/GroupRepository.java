package com.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

public class GroupRepository {
	public int save(Group grupo) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO public.grupos (name) VALUES ('"+grupo.getName()+"');");
            ResultSet resultSet = statement.executeQuery("SELECT currval('grupos_id_seq');");
            resultSet.next();
            return resultSet.getInt("currval");
		}catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
            return -1;
        }
	}
	
	public void addFather(Group grupo) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE grupos SET father='"+grupo.getFather()+"' WHERE id='"+grupo.getId()+"';");
        }catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
	}
	
	public Group getById(int id) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *  FROM public.grupos where id = "+id+";");
            resultSet.next();
            return new Group(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("father"),resultSet.getInt("count"));
 
        }catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
            return new Group("");
        }
	}
	
	public String getNameById(int id) {
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
	
	public TreeSet<Group> all() {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "isaac", "password")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT grupos.* ,(select count(contatos_grupos.*) from public.contatos_grupos where contatos_grupos.grupo_id = grupos.id group by grupos.id)  FROM public.grupos ;");
            TreeSet<Group> grupos = new TreeSet<Group>();
            while (resultSet.next()) {
            	grupos.add(new Group(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("father"),resultSet.getInt("count")));
            }
            return grupos;
 
        }catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
            return new TreeSet<Group>();
        }
	}
}
