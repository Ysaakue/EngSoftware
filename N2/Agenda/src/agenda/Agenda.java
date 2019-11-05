package agenda;

import java.util.LinkedList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
  
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Agenda {
	LinkedList<Contato> contatos;
	
	public Agenda() {
		this.contatos = new LinkedList<Contato>();
	}
	
	public static void menu() {
		System.out.println("_________________________________");
		System.out.println("| 1) Mostrar Contados da agenda  |");
		System.out.println("| 2) Adicionar contato a agenda  |");
		System.out.println("|                                |");
		System.out.println("| 0) Sair                        |");
		System.out.println("|________________________________|");
	}
	
	public void adicionarContato(Contato contato) {
		this.contatos.add(contato);
	}
	
	
}
