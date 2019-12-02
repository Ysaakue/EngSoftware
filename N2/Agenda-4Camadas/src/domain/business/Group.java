package domain.business;

public class Group implements Comparable<Object>{
	protected int id;
	protected String name;
	private int father;
	private int qntd_contatos;
	
	public Group(String name) {
		this.name = name;
	}
	
	public Group(int id, String name, int father, int qntd_contatos) {
		super();
		this.id = id;
		this.name = name;
		this.father = father;
		this.qntd_contatos = qntd_contatos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFather() {
		return father;
	}

	public void setFather(int father) {
		this.father = father;
	}

	public int getQntd_contatos() {
		return qntd_contatos;
	}

	public void setQntd_contatos(int qntd_contatos) {
		this.qntd_contatos = qntd_contatos;
	}
	
	public int compareTo(Object obj){
        Group proximo = (Group)obj;
        return this.name.compareTo(proximo.getName());
    }
}
