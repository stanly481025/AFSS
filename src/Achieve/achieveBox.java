package Achieve;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class achieveBox extends JFrame{

	private String statement;
	
	public achieveBox(String input) 
	{
		this.statement = input;
		JOptionPane.showMessageDialog(this,input,"¸ÑÂê¦¨´N",JOptionPane.INFORMATION_MESSAGE);
	}	
}
