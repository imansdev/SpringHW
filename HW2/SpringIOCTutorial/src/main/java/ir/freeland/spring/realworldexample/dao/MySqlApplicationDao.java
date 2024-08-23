package ir.freeland.spring.realworldexample.dao;

public class MySqlApplicationDao implements DaoInterface{

	@Override
	public void add() {
		System.out.println("Data added to MySql Database .");
		
	}

}
