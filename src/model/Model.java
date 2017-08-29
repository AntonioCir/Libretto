package model;

import java.util.ArrayList;
import java.util.List;

public class Model 
{
	private List<Esame> esami;
	
	public Model() 
	{
		this.esami = new ArrayList<Esame>();
	}
	
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami presenti
	 * verificando che non ci sia già
	 * @param e
	 * @return true se l'esame è stato insierito, false se l'esame già esisteva
	 */
	public boolean addEsame(Esame e)
	{
		if(!esami.contains(e))
		{
			esami.add(e);
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * ricerca un esame con il codice specificato
	 * Se esiste lo restituisce, altrimenti restituisce null
	 * @param codice codice dell'esame da cercare
	 * @return esame trovato oppure null
	 */
	public Esame trovaEsame(String codice)
	{
		// creo un esame fittizio con codice uguale al parametro e lo confronto con tutti gli esami presenti già nella lista
		int pos = this.esami.indexOf(new Esame (codice, null, null));
		
		if (pos ==-1)
		{
			return null;
		}
		else
		{
			return esami.get(pos);
		}
	}
	
}
