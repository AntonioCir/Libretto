package model;

public class TestModel 
{

	public static void main(String[] args) 
	{
		Model m = new Model();
		
		m.addEsame(new Esame("03Fx","Tecniche di programmazione", "Fulvio Corno"));
		m.addEsame(new Esame("233T","Ambient intelligence", "Fulvio Corno"));
		
		System.out.println(m.trovaEsame("03Fx"));
		System.out.println(m.trovaEsame("233T"));
		System.out.println(m.trovaEsame("03Ax"));
	}

}
