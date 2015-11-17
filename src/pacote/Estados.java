package pacote;

import java.util.ArrayList;

public class Estados 
{
	private ArrayList<ArrayList> estados = new ArrayList<ArrayList>();
	private ArrayList<String> estadoFinal = new ArrayList<String>();
	private ArrayList<String[]> transicoes = new ArrayList<String[]>();
	private AFD afd;
	
		public Estados(AFD afd)
	{
		this.afd = afd;
	}
	
	public void minimizaEstados()
	{
		ArrayList<String> estado = this.estados.get(0);
	
		minimizaGeral(estado);
		minimizaFinal();
		//this.estados.add(estadoFinal);
		uniOsSemelhantes();
		
		
		for(int i = 0; i < this.estados.size(); i++)
			this.transicoes.add(geraTransicoes(i));
		
		System.out.println(this.estados);
		for(int i = 0; i < this.transicoes.size(); i++)
			System.out.println(this.transicoes.get(i)[0] +" - " + this.transicoes.get(i)[1]);
	}
	
	public String[] geraTransicoes(int i)
	{
		String[] s = new String[3];
		s[0] = this.afd.getTransicoes().get(-1+Integer.parseInt(this.estados.get(i).get(0).toString()))[0];
		s[1] = this.afd.getTransicoes().get(-1+Integer.parseInt(this.estados.get(i).get(0).toString()))[1];
			//System.out.println(s[0]+" - "+s[1]);
		return s;

	}
	
	public void uniOsSemelhantes()
	{
		for(int i = 0; i < this.estados.size(); i++)
		{
		
			for(int j = i+1; j < this.estados.size(); j++)
			{
				
				if(this.afd.getTransicoes().get(-1+Integer.parseInt(this.estados.get(i).get(0).toString()))[0].equals(this.afd.getTransicoes().get(-1+Integer.parseInt(estados.get(j).get(0).toString()))[0]) && 
				   this.afd.getTransicoes().get(-1+Integer.parseInt(this.estados.get(i).get(0).toString()))[1].equals(this.afd.getTransicoes().get(-1+Integer.parseInt(estados.get(j).get(0).toString()))[1]) && this.estados.get(i).get(0) != this.estados.get(j).get(0))
					{
						this.estados.get(i).add(estados.get(j).get(0));
						this.estados.remove(j);
					}
			}
		}
	}
	
	public void separaEstadoFinal()
	{		
		for(int i = 0; i < this.afd.getEstado().size(); i++)
		{
			for(int j = 0; j < this.afd.getEstadoFinal().size(); j++)
			{
				if(this.afd.getEstado().get(i).equals(this.afd.getEstadoFinal().get(j)))
				{
					this.estadoFinal.add(afd.getEstado().get(i));
					this.afd.getEstado().remove(i);
					i = 0;
				}
			}
		}
		this.estados.add(this.afd.getEstado());
	}
	
	private void minimizaGeral(ArrayList<String> estado)
	{
		ArrayList<String> temp;
		int cont = 0,cont2 = 0;
		for(int i = 0; i < estado.size(); i++)
		{
			for(int j = 0; j <  estado.size(); j++)
			{
				if(estado.get(j).equals(this.afd.getTransicoes().get(-1+Integer.parseInt(estado.get(i).toString()))[0]))cont++;
				else if(estado.get(j).equals(this.afd.getTransicoes().get(-1+Integer.parseInt(estado.get(i).toString()))[1]))cont2++;
			}
			//System.out.println("Cont1: "+ cont + " Cont 2: "+ cont2);
			if(cont+cont2 < 2 && estado.size() > 1)
			{
				temp =  new ArrayList<String>();
				temp.add(estado.get(i));
				this.estados.add(1, temp);
		
				estado.remove(i);
				i = -1;
			}
			cont = 0;
			cont2 = 0;
		}
		
	}
	
	private void minimizaFinal()
	{
		ArrayList<String> estado = this.estadoFinal;
		ArrayList<String> estadoFinal = new ArrayList<String>();
		ArrayList<String> temp;
		int cont = 0,cont2 = 0;
		for(int i = 0; i <= estado.size(); i++)
		{
			for(int j = 0; j <  estado.size(); j++)
			{
				if(estado.get(j).equals(this.afd.getTransicoes().get(-1+Integer.parseInt(estado.get(i).toString()))[0]))cont++;
				else if(estado.get(j).equals(this.afd.getTransicoes().get(-1+Integer.parseInt(estado.get(i).toString()))[1]))cont2++;
			}
			if(cont+cont2 < 2)
			{
				temp =  new ArrayList<String>();
				temp.add(estado.get(i));
				this.estados.add(1,temp);
		
				estado.remove(i);
				i = -1;
			}
			if(estado.size() < 1)break;
			cont = 0;
			cont2 = 0;
		}
	
		
	}

	public ArrayList<ArrayList> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<ArrayList> estados) {
		this.estados = estados;
	}
}
