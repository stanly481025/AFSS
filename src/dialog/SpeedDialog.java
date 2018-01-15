package dialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SpeedDialog extends JDialog
{
	private JLabel speedL = new JLabel("選擇加速時間:");
	
	private JButton hourB = new JButton("一小時");
	private JButton dayB = new JButton("一天");
	private JButton weekB = new JButton("一個禮拜");
	
	private JLabel eventL = new JLabel("選擇顯示事件:");
	
	private JCheckBox[] test = { new JCheckBox("魚打架"), new JCheckBox("自然死亡"), new JCheckBox("非自然死亡"),
								 new JCheckBox("魚生病"), new JCheckBox("魚生長至最大"), new JCheckBox("餵食器壞掉"),
								 new JCheckBox("過濾器壞掉"), new JCheckBox("氧氣泵壞掉"), new JCheckBox("照明器壞掉"),
								 new JCheckBox("加溫器壞掉"), new JCheckBox("水質不良"), new JCheckBox("水質糟糕"),
								 new JCheckBox("溫度偏高"), new JCheckBox("溫度過高"), new JCheckBox("溫度偏低"),
								 new JCheckBox("溫度過低"), new JCheckBox("含氧量偏低"), new JCheckBox("含氧量過低"),
								 new JCheckBox("含氧量極低") };
	
	private JButton confirmB = new JButton("確認");
	private JButton cancelB = new JButton("取消");
	
	private final int LEFT = 80;
	private final int TOP = 130;
	private final int WEIGHT = 120;
	private final int HEIGHT = 20;
	private final int LSPACE = 120;
	private final int TSPACE = 30;
	
	private int[] set = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			   			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
 	
	public SpeedDialog()
	{
		setDialog();
		setLabel();
		setTime();
		setEvent();
	}
	
	private void setDialog()
	{
		setTitle("加速時間");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	private void setLabel()
	{
		speedL.setBounds(30, 15, 100, 25);
		add(speedL);
		eventL.setBounds(30, 95, 120, 25);
		add(eventL);
	}
	
	private void setTime()
	{
		hourB.setBounds(80, 55, 100, 25);
		hourB.addActionListener(bH);
		add(hourB);
		dayB.setBounds(190, 55, 100, 25);
		dayB.addActionListener(bH);
		add(dayB);
		weekB.setBounds(300, 55, 100, 25);
		weekB.addActionListener(bH);
		add(weekB);
		confirmB.setBounds(270, 340, 75, 25);
		confirmB.addActionListener(bH);
		add(confirmB);
		cancelB.setBounds(370, 340, 75, 25);
		add(cancelB);
		cancelB.addActionListener(bH);
	}
	
	private void setEvent()
	{
		for(int i = 0; i < 19; i++)
		{
			test[i].setBounds(LEFT + LSPACE * (i % 3), TOP + TSPACE * (i / 3), WEIGHT, HEIGHT);
			add(test[i]);
		}
	}
	
	private void resetTimeButton()
	{
		hourB.setForeground(Color.black);
		dayB.setForeground(Color.black);
		weekB.setForeground(Color.black);
	}
	
	public int[] result()
	{
		return set;
	}
	
	private ActionListener bH = new ActionListener()
    {
    	public void actionPerformed(ActionEvent ae) 
        {
    		if(ae.getSource() == hourB)
    		{
    			resetTimeButton();
    			hourB.setForeground(Color.blue);
    			set[0] = 1;
    		}
    		else if(ae.getSource() == dayB)
    		{
    			resetTimeButton();
    			dayB.setForeground(Color.blue);
    			set[0] = 2;
    		}
    		else if(ae.getSource() == weekB)
    		{
    			resetTimeButton();
    			weekB.setForeground(Color.blue);
    			set[0] = 3;
    		}
    		else if(ae.getSource() == confirmB)
    		{
    			for(int i = 0; i < 19; i++)
    			{
    				if(test[i].isSelected())
    					set[i + 1] = 1;
    			}
    			setVisible(false);
    		}
    		else if(ae.getSource() == cancelB)
    		{
    			set[0] = 0;
    			setVisible(false);
    		}
        }
    };
}
