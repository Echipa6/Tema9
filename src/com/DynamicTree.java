package com;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

class DynamicTree extends JPanel {
	  protected DefaultMutableTreeNode rootNode;
	  protected DefaultTreeModel treeModel;
	  protected JTree tree;
	  private Toolkit toolkit = Toolkit.getDefaultToolkit();

	  public DynamicTree() {
	    super(new GridLayout(1, 0));

	    rootNode = new DefaultMutableTreeNode("Oracle DataBase");
	    treeModel = new DefaultTreeModel(rootNode);

	    tree = new JTree(treeModel);
	    tree.setEditable(true);
	    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	    tree.setShowsRootHandles(true);

	    JScrollPane scrollPane = new JScrollPane(tree);
	    add(scrollPane);
	  }
	  
	  public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent, Object child) {
	    return addObject(parent, child, true);
	  }

	  public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,Object child, boolean shouldBeVisible) {
	    DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

	    if (parent == null) {
	      parent = rootNode;
	    }
	    
	    treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

	    if (shouldBeVisible) {
	      tree.scrollPathToVisible(new TreePath(childNode.getPath()));
	    }
	    return childNode;
	  }
	  
	  public void collapseNode()
	  {
		  for (int i = 1; i < tree.getRowCount(); i++) {
		         tree.collapseRow(i);
		}
	  }
	}