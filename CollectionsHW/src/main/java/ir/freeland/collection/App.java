package ir.freeland.collection;

import ir.freeland.collection.model.AddToList;

public class App {

	public static void main(String[] args) {
		AddToList addToList = new AddToList();
		System.out.println("add");
		addToList.printPerson(addToList.addPerson());
		System.out.println("remove person whose name is ali");
		addToList.printPerson(addToList.removePerson());
		System.out.println("sort persons by its street address lenght");
		addToList.printPerson(addToList.sortPersonsByStreetLength());
	}
}
