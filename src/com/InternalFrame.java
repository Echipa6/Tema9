package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class InternalFrame extends JFrame {

	JDesktopPane desktopPane= new JDesktopPane();
	
	OracleDBConnection dbcon=new OracleDBConnection();
	TableQueryResult tableGenerator;
	
	public InternalFrame() throws SQLException, ClassNotFoundException{
		tableGenerator=new TableQueryResult();
		ResultSet resultSet;
		dbcon.connect("localhost:1521", "student", "student");
		resultSet=dbcon.connection.createStatement().executeQuery("SELECT * FROM studenti");
		
		Vector <String> columnNames=new Vector<String>();
		for(int i=0; i<resultSet.getMetaData().getColumnCount();i++)
		{
			columnNames.add(resultSet.getMetaData().getColumnName(i + 1));
			
		}
		
		Report reportGenerator =new Report();
		
		reportGenerator.makeReport(dbcon.connection, "select * from studenti", "select * from studenti", columnNames);
		reportGenerator.makeReport(dbcon.connection, "select * from studenti", "select * from studenti", columnNames);
		
		reportGenerator.writeReport("report");
		
				
		desktopPane.add(tableGenerator.getTableForQuery(resultSet));
		add(desktopPane);
		
	}
	
	

}
