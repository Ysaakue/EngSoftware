package domain.business;

import java.util.HashMap;
import java.util.TreeSet;

import domain.persistence.GroupDAO;

public class GroupController {
	private GroupDAO dao;
	
	public GroupController() {
		this.dao = new GroupDAO();
	}
	
	public TreeSet<Group> all(){
		return dao.all();
	}
	
	public String getNameById(int id) {
		return dao.getNameById(id);
	}
	
	public String create(HashMap<String, String> mapaGroup) {
		try{
			Group newGroup = new Group((String)mapaGroup.get("nome"));
			dao.save(newGroup);
			return " -- Successfully Created Contact Group -- ";
		} catch (SaveException e) {
			new SaveException();
			return " -- Error Trying to Save Contact Group -- ";
		}
	}
	
	public String create(HashMap<String, String> mapaGroup, int opcao, Group gF) {
		Group newGroup = new Group((String)mapaGroup.get("nome"));
		if(opcao == 0) {
			return " -- Canceled -- ";
		} else if(opcao == 1) {
			dao.save(newGroup);
			return " -- Successfully Created Contact Group -- ";
		} else {
			newGroup.setFather(gF.getId());
			int id = dao.save(newGroup);
			newGroup.setId(id);
			dao.addFather(newGroup);
			return " -- Successfully Created Contact Group on "+gF.getName()+" -- ";
		}
	}
}
