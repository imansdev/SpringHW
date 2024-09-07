package ir.freeland.lambda;

import ir.freeland.lambda.model.AddToList;

public class App {

	public static void main(String[] args) {
		AddToList addToList = new AddToList();
		addToList.printStudent(addToList.sortStudents());
		addToList.printStudent(addToList.reverseSortStudents());
		addToList.groupStudentsByGradeUpper10();
		addToList.groupStudentsByAge();
		addToList.averageGrade();
		addToList.averageGradeAbove18yearsOld();
	}
}
