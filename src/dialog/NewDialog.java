package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class NewDialog extends JDialog
{
	//確認
	JButton confirmB = new JButton();
	JButton cancelB = new JButton();
	
	JLabel fishtankL = new JLabel();
	JLabel environmentL = new JLabel();
	
	JLabel fishtankW = new JLabel();
	JLabel environmentW = new JLabel();
	
	JButton two = new JButton();
	JButton three = new JButton();
	JButton four = new JButton();
	JButton freshwater = new JButton();
	JButton seawater = new JButton();
	
	private int[] set=new int[2];
	
	private int fishtank = -1;
	private int environment = -1;
	
	public NewDialog()
	{
		setDialog();
		setButton();
		setLabel();
		setChoose();
	}
	
	private void setDialog()
	{
		setTitle("開新模擬");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	private void setButton()
	{
		confirmB.setText("確認");
		cancelB.setText("取消");
		confirmB.setFont(new Font(null, Font.BOLD, 12));
		cancelB.setFont(new Font(null, Font.BOLD, 12));
		confirmB.setBounds(220, 300, 100, 30); //280, 430, 100, 50
		cancelB.setBounds(340, 300, 100, 30);
		confirmB.addActionListener(bH);
		cancelB.addActionListener(bH);
		add(confirmB);
		add(cancelB);
	}
	
	private void setLabel()
	{
		fishtankL.setText("選擇魚缸:");
		environmentL.setText("選擇水:");
		fishtankL.setFont(new Font(null, Font.BOLD, 15));
		environmentL.setFont(new Font(null, Font.BOLD, 15));
		fishtankL.setBounds(40, 50, 100, 50);
		environmentL.setBounds(40, 120, 100, 50);
		add(fishtankL);
		add(environmentL);
		
		fishtankW.setText("尚未選擇魚缸!!");
		environmentW.setText("尚未選擇水!!");
		fishtankW.setFont(new Font(null, Font.BOLD, 17));
		environmentW.setFont(new Font(null, Font.BOLD, 17));
		fishtankW.setForeground(Color.red);
		environmentW.setForeground(Color.red);
		fishtankW.setBounds(60, 200, 150, 25);
		environmentW.setBounds(60, 225, 150, 25);
		fishtankW.setVisible(false);
		environmentW.setVisible(false);
		add(fishtankW);
		add(environmentW);
	}
	
	private void setChoose()
	{
		two.setText("2尺缸");
		three.setText("3尺缸");
		four.setText("4尺缸");
		freshwater.setText("淡水");
		seawater.setText("海水");
		two.setFont(new Font(null, Font.BOLD, 15));
		three.setFont(new Font(null, Font.BOLD, 15));
		four.setFont(new Font(null, Font.BOLD, 15));
		freshwater.setFont(new Font(null, Font.BOLD, 15));
		seawater.setFont(new Font(null, Font.BOLD, 15));
		two.setBounds(150, 50, 100, 50);
		three.setBounds(260, 50, 100, 50);
		four.setBounds(370, 50, 100, 50);
		freshwater.setBounds(150, 120, 100, 50);
		seawater.setBounds(260, 120, 100, 50);
		two.addActionListener(bH);
		three.addActionListener(bH);
		four.addActionListener(bH);
		freshwater.addActionListener(bH);
		seawater.addActionListener(bH);
		add(two);
		add(three);
		add(four);
		add(freshwater);
		add(seawater);
	}
	
	private void resetChoose(int c)
	{
		resetWarning();
		if(c == 1)
		{
			two.setForeground(Color.black);
			three.setForeground(Color.black);
			four.setForeground(Color.black);
		}
		else
		{
			freshwater.setForeground(Color.black);
			seawater.setForeground(Color.black);
		}
	}
	
	private void resetWarning()
	{
		fishtankW.setVisible(false);
		environmentW.setVisible(false);
		
	}
	
	public int result()
	{
		if(fishtank != -1 && environment != -1)
			return fishtank;
		else
			return -1;
	}
	
	public int[] getSet() {
		return set;
	}

	public void setSet(int[] set) {
		this.set = set;
	}

	private ActionListener bH = new ActionListener()
    {
    	public void actionPerformed(ActionEvent ae) 
        {
    		if(ae.getSource() == confirmB)
    		{
    			if(fishtank != -1 && environment != -1)
    			{
    				//確認
    				//呼叫
    				setVisible(false);
    			}
    			else
    			{
    				if(fishtank == -1)
    				{
    					fishtankW.setVisible(true);
    				}
    				if(environment == -1)
    				{
    					environmentW.setVisible(true);
    				}
    			}
    		}
    		else if(ae.getSource() == cancelB)
    		{
    			fishtank = -1;
    			setVisible(false);
    		}
    		else if(ae.getSource() == two)
    		{
    			resetChoose(1);
    			two.setForeground(Color.blue);
    			fishtank = 0;
    			set[0]=1;
    		}
    		else if(ae.getSource() == three)
    		{
    			resetChoose(1);
    			three.setForeground(Color.blue);
    			fishtank = 1;
    			set[0]=2;
    		}
    		else if(ae.getSource() == four)
    		{
    			resetChoose(1);
    			four.setForeground(Color.blue);
    			fishtank = 2;
    			set[0]=3;
    		}
    		else if(ae.getSource() == freshwater)
    		{
    			resetChoose(2);
    			freshwater.setForeground(Color.blue);
    			environment = 0;
    			set[1]=1;
    		}
    		else if(ae.getSource() == seawater)
    		{
    			resetChoose(2);
    			seawater.setForeground(Color.blue);
    			environment = 1;
    			set[1]=2;
    		}
        }
    };
}