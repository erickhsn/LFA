package pacote;

import java.io.IOException;

public class Principal {

	public static void main(String[] args) 
	{
		try
		{
			AFD a = new AFD("D:/entrada2.txt");
			
			Estados e = new Estados(a);
			e.separaEstadoFinal();
			e.minimizaEstados();
		}
		catch(IOException e)
		{
			System.out.println("Arquivo não encontrado");
		}
		
		

	}

}
