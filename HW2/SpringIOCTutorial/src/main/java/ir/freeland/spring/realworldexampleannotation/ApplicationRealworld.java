package ir.freeland.spring.realworldexampleannotation;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import ir.freeland.spring.realworldexampleannotation.dao.DaoInterface;
import ir.freeland.spring.realworldexampleannotation.service.ApplicationService;

public class ApplicationRealworld {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		String database = "MySql"; // Oracle, MySql or MsSql

		// Read appContext file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext_realannotation.xml");
		// Get database bean from context.
		DaoInterface dao = context.getBean(database, DaoInterface.class);

		// This class is not managed bean. But we can use it in with other beans
		ApplicationService app = new ApplicationService(dao);

		app.create();
	}

}
