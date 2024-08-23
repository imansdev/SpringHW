package ir.freeland.spring.realworldexample.dao;

public class MsSqlApplicationDao implements DaoInterface{

	@Override
	public void add() {
		System.out.println("Data added to MsSql Database .");
		
	}


}
