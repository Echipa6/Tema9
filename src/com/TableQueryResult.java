package com;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableQueryResult {

	private JTable table;
	

	public JInternalFrame getTableForQuery(ResultSet resultSet) throws SQLException {

		Vector<String> columnNames = new Vector<String>();
		Vector<String> newRow=new Vector<String>();
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		
		for(int i=0; i<resultSet.getMetaData().getColumnCount();i++)
		{
			columnNames.add(resultSet.getMetaData().getColumnName(i + 1));
			
		}
		
		
		
		while(resultSet.next())
		{
			newRow=new Vector<String>();
			for(int i=0; i<resultSet.getMetaData().getColumnCount();i++)
			{
				newRow.addElement(resultSet.getString(i+1));
				
			}
			rowData.addElement(newRow);
			

		}
		

		table = new JTable(rowData, columnNames);
		
		
		
		table.getTableHeader().setResizingAllowed(true);
		//System.out.println(table.toString());
		JScrollPane scrollPane = new JScrollPane();

		

		scrollPane.setViewportView(table);
		scrollPane.setVisible(true);
		JInternalFrame intFrame = new JInternalFrame("result",true,true,true,true);
		intFrame.add(scrollPane);
		intFrame.setSize(320,240);
		
		intFrame.setVisible(true);
		return intFrame;

		
	}


}