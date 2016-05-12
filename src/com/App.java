package com;

import java.awt.Dimension;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.tree.DefaultMutableTreeNode;

public class App {


	public static void main(String[] args) {
		OracleDBConnection currentConnection= new OracleDBConnection();
		JTreeTable myTreeTable= new JTreeTable(currentConnection);
		JSplitPane vpane= new JSplitPane(JSplitPane.VERTICAL_SPLIT,new JButton("abcd"),new JButton("abcd"));
		JSplitPane hpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, myTreeTable,vpane);
		
		JFrame frame = new JFrame("Oracle DataBase Connection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		frame.setContentPane(hpane);
		frame.setPreferredSize(new Dimension(500, 600));
		frame.pack();
		frame.setVisible(true);
		
		try {
			myTreeTable.populateTree();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

}
