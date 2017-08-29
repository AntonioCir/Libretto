package model;

import java.time.LocalDate;

public class TestEsame 
{

	public static void main(String[] args) 
	{
		Esame tdp = new Esame("03Fx","Tecniche di programmazione", "Fulvio Corno");
		System.out.println(tdp);
		Esame ami = new Esame("233T","Ambient intelligence", "Fulvio Corno");
		System.out.println(ami);
		System.out.println(ami.equals(tdp));
		
		tdp.supera(30, LocalDate.now());
		System.out.println(tdp);
	}

}
