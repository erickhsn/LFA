package pacote;

import java.io.IOException;


public class Principal {

	public static void main(String[] args) 
	{
		try
		{
			AFD a = new AFD("Arquivos/afd.txt");
			
			Estados e = new Estados(a);
			e.separaEstadoFinal();
			e.minimizaEstados();
			// MOura viado
		}
		catch(IOException e)
		{
			System.out.println("Arquivo n�o encontrado");
		}
		
		

	}

}
