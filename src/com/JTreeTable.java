package com;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeTable extends JPanel {


	private DynamicTree treePanel;
	OracleDBConnection currentConnection;

	public JTreeTable(OracleDBConnection currentConnection) {
		super(new BorderLayout());

		this.currentConnection=currentConnection;
		treePanel=new DynamicTree();

		treePanel.setPreferredSize(new Dimension(200, 100));
		add(treePanel, BorderLayout.CENTER);
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		this.setOpaque(true); 


	}
	private DefaultMutableTreeNode findNode(String s) {

		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> e = treePanel.rootNode.depthFirstEnumeration();
		while (e.hasMoreElements()) {
			DefaultMutableTreeNode node = e.nextElement();
			if (node.toString().equalsIgnoreCase(s)) {
				return node;
			}
		}
		return null;
	}

	public void populateTree() throws SQLException {
		ResultSet rs =currentConnection.executeQuery("select unique  table_name  from user_tab_columns");

		while (rs.next()) {
			this.treePanel.addObject(null,rs.getString(1));
		}
		
		rs =currentConnection.executeQuery("select  table_name,column_name  from user_tab_columns");

		while (rs.next()) {
			this.treePanel.addObject(findNode(rs.getString(1)),rs.getString(2));
		}
		treePanel.collapseNode();
	}
	void createAndShowGUI() {
		
	}

	public DynamicTree getTreePanel() {
		return treePanel;
	}

	public void setTreePanel(DynamicTree treePanel) {
		this.treePanel = treePanel;
	}


}

