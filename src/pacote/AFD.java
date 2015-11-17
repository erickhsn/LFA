package pacote;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AFD 
{
	private ArrayList<String> estado = new ArrayList<String>();
	private ArrayList<String> alfabeto = new ArrayList<String>();
	private ArrayList<String[]> transicoes = new ArrayList<String[]>();
	private ArrayList<String> estadoInicial = new ArrayList<String>();
	private ArrayList<String> estadoFinal = new ArrayList<String>();
	
	private FileInputStream stream;
	private InputStreamReader reader;
	private BufferedReader br;
	
	private boolean controle = false;
	
	public AFD(String caminho)throws IOException
	{	
		stream = new FileInputStream(caminho);
		reader = new InputStreamReader(stream);
		br = new BufferedReader(reader);
		
		String linha;
		
		linhaEstados(br.readLine());
		linhaAlfabeto(br.readLine());
		linha = br.readLine();
		if(linha == " ")linha = br.readLine();
		while(linha != " ")
		{
			this.transicoes.add(linhaTransicoes(linha));
			linha = br.readLine();
			if(this.controle)break;
		}
		//linha = br.readLine();
		if(linha.equals(" "))linha = br.readLine();
		linhaEstadoInicial(linha);
		linhaEstadoFinal(br.readLine());
		//System.out.println(this.estadoFinal.toString());
	
	}
	
	private void linhaEstados(String linha)
	{
		String[] linhaSplit;
		linhaSplit = linha.split(" ");
		for(int i = 0; i < linha.length(); i++)
		{
			if(linhaSplit[i].equals(";") || linhaSplit[i].equals(","))
			{
				break;
			}
			this.estado.add(linhaSplit[i]);
		}
	}
	
	private void linhaAlfabeto(String linha)
	{
		String[] linhaSplit;
		linhaSplit = linha.split(" ");
		for(int i = 0; i < linha.length(); i++)
		{
			if(linhaSplit[i].equals(";") || linhaSplit[i].equals(","))
			{
				break;
			}
			this.alfabeto.add(linhaSplit[i]);
		}
	}
	
	private String[] linhaTransicoes(String linha)
	{
		String[] linhaSplit;
		String[] s = new String[2];
		linhaSplit = linha.split(" ");
		s[0] = linhaSplit[0];
		s[1] = linhaSplit[1];
	
		if(linhaSplit[2].equals(";"))
			this.controle = true;
		return s;
	}
	
	private void linhaEstadoInicial(String linha)
	{
		String[] linhaSplit;
		linhaSplit = linha.split(" ");
		for(int i = 0; i < linha.length(); i++)
		{
			if(linhaSplit[i].equals(";") || linhaSplit[i].equals(","))
			{
				break;
			}
			this.estadoInicial.add(linhaSplit[i]);
		}
	}
	
	private void linhaEstadoFinal(String linha)
	{
		String[] linhaSplit;
		linhaSplit = linha.split(" ");
		for(int i = 0; i < linha.length(); i++)
		{
			if(linhaSplit[i].equals(";") || linhaSplit[i].equals(","))
			{
				break;
			}
			this.estadoFinal.add(linhaSplit[i]);
		}
	}
	
	public ArrayList<String> getEstado() {
		return estado;
	}

	public void setEstado(ArrayList<String> estado) {
		this.estado = estado;
	}

	public ArrayList<String> getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(ArrayList<String> alfabeto) {
		this.alfabeto = alfabeto;
	}

	public ArrayList<String[]> getTransicoes() {
		return transicoes;
	}

	public void setTransicoes(ArrayList<String[]> transicoes) {
		this.transicoes = transicoes;
	}

	public ArrayList<String> getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(ArrayList<String> estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public ArrayList<String> getEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(ArrayList<String> estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	
}

