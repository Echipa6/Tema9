package com;

import java.sql.SQLException;

import javax.swing.JFrame;

public class App {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
				InternalFrame iFrame= new InternalFrame();
				iFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				iFrame.setSize(640,480);
				iFrame.setVisible(true);
				
				//iFrame.add(iFrame.tableGenerator.getTableForQuery(iFrame.dbcon.connection.createStatement().executeQuery("SELECT * FROM studenti")));
		
	}

}
