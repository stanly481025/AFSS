package multiPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import aquarium.Aquarium;

@SuppressWarnings("serial")
public class DevicePanelModule extends JPanel
{
	private Aquarium aquarium;
	JTextArea fishfoodT = new JTextArea("餵食器:");
	JButton openfoodB = new JButton("開");
	JButton offfoodB = new JButton("關");
	JButton herbivorousB = new JButton("草食");
	JButton meatB = new JButton("肉食");
	JButton bigB = new JButton("大");
	JButton medB = new JButton("中");
	JButton smallB = new JButton("小");
	JButton powerB = new JButton("粉");
	JButton allB = new JButton("全天");
	JButton halfB = new JButton("半天");
	JTextArea waterfilterT = new JTextArea("過濾器:");
	JButton openwaterB = new JButton("開");
	JButton offwaterB = new JButton("關");
	JTextArea inflatorT = new JTextArea("氧氣泵:");
	JButton openinflatorB = new JButton("開");
	JButton offinflatorB = new JButton("關");
	JTextArea lighterT = new JTextArea("照明器:");
	JButton openlightB = new JButton("開");
	JButton offlightB = new JButton("關");
	JButton lighttimeB = new JButton("設定時間");
	JTextArea warmerT = new JTextArea("加溫器:");
	JButton openwarmerB = new JButton("開");
	JButton offwarmerB = new JButton("關");
	JButton warmtempB = new JButton("設定溫度");
	public DevicePanelModule(Aquarium a)
	{
		aquarium = a;
		setTextArea();
		setButton();
	}
	
	private void setTextArea()
	{
		fishfoodT.setFont(new Font(null, Font.BOLD, 20));
		fishfoodT.setForeground(Color.decode("#A52A2A"));
		fishfoodT.setBounds(90, 30, 100, 100);
		fishfoodT.setEditable(false);
		fishfoodT.setBackground(null);
		add(fishfoodT);
		waterfilterT.setFont(new Font(null, Font.BOLD, 20));
		waterfilterT.setForeground(Color.decode("#A52A2A"));
		waterfilterT.setBounds(90, 210, 100, 50);
		waterfilterT.setEditable(false);
		waterfilterT.setBackground(null);
		add(waterfilterT);
		inflatorT.setFont(new Font(null, Font.BOLD, 20));
		inflatorT.setForeground(Color.decode("#A52A2A"));
		inflatorT.setBounds(90, 270, 100, 50);
		inflatorT.setEditable(false);
		inflatorT.setBackground(null);
		add(inflatorT);
		lighterT.setFont(new Font(null, Font.BOLD, 20));
		lighterT.setForeground(Color.decode("#A52A2A"));
		lighterT.setBounds(90, 330, 100, 50);
		lighterT.setEditable(false);
		lighterT.setBackground(null);
		add(lighterT);
		warmerT.setFont(new Font(null, Font.BOLD, 20));
		warmerT.setForeground(Color.decode("#A52A2A"));
		warmerT.setBounds(90, 430, 100, 50);
		warmerT.setEditable(false);
		warmerT.setBackground(null);
		add(warmerT);
	}
	
	private void setButton()
	{
		openfoodB.setBounds(260, 30, 100, 30);
		openfoodB.addActionListener(bH);
		add(openfoodB);
		offfoodB.setBounds(380, 30, 100, 30);
		offfoodB.addActionListener(bH);
		add(offfoodB);
		allB.setBounds(260, 70, 100, 30);
		allB.addActionListener(bH);
		add(allB);
		halfB.setBounds(380, 70, 100, 30);
		halfB.addActionListener(bH);
		add(halfB);
		herbivorousB.setBounds(260, 110, 100, 30);
		herbivorousB.addActionListener(bH);
		add(herbivorousB);
		meatB.setBounds(380, 110, 100, 30);
		meatB.addActionListener(bH);
		add(meatB);
		bigB.setBounds(260, 150, 100, 30);
		bigB.addActionListener(bH);
		add(bigB);
		medB.setBounds(380, 150, 100, 30);
		medB.addActionListener(bH);
		add(medB);
		smallB.setBounds(500, 150, 100, 30);
		smallB.addActionListener(bH);
		add(smallB);
		powerB.setBounds(620, 150, 100, 30);
		powerB.addActionListener(bH);
		add(powerB);
		
		openwaterB.setBounds(260, 210, 100, 30);
		openwaterB.addActionListener(bH);
		add(openwaterB);
		offwaterB.setBounds(380, 210, 100, 30);
		offwaterB.addActionListener(bH);
		add(offwaterB);
		
		openinflatorB.setBounds(260, 270, 100, 30);
		openinflatorB.addActionListener(bH);
		add(openinflatorB);
		offinflatorB.setBounds(380, 270, 100, 30);
		offinflatorB.addActionListener(bH);
		add(offinflatorB);
		
		openlightB.setBounds(260, 330, 100, 30);
		openlightB.addActionListener(bH);
		add(openlightB);
		offlightB.setBounds(380, 330, 100, 30);
		offlightB.addActionListener(bH);
		add(offlightB);
		lighttimeB.setBounds(320, 370, 100, 30);
		lighttimeB.addActionListener(bH);
		add(lighttimeB);
		
		openwarmerB.setBounds(260, 430, 100, 30);
		openwarmerB.addActionListener(bH);
		add(openwarmerB);
		offwarmerB.setBounds(380, 430, 100, 30);
		offwarmerB.addActionListener(bH);
		add(offwarmerB);
		warmtempB.setBounds(320, 470, 100, 30);
		warmtempB.addActionListener(bH);
		add(warmtempB);
	}
	
	private void foodButtonTrue()
	{
		/*
		 * /////////////////////////////////////////////呼叫函式
		 * 設定按鈕顏色
		 * setForeground(Color.red);
		 * 
		 */
		herbivorousB.setEnabled(true);
		meatB.setEnabled(true);
		bigB.setEnabled(true);
		medB.setEnabled(true);
		smallB.setEnabled(true);
		powerB.setEnabled(true);
		allB.setEnabled(true);
		halfB.setEnabled(true);
		if(aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].getDietFavorite() == 1)
		{
			meatB.setForeground(Color.red);
		}
		else
		{
			herbivorousB.setForeground(Color.decode("#2E8B57"));
		}
		if(aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].getGrain() == 50)
			bigB.setForeground(Color.red);
		else if(aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].getGrain() == 10)
			medB.setForeground(Color.red);
		else if(aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].getGrain() == 5)
			smallB.setForeground(Color.red);
		else if(aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].getGrain() == 1)
			powerB.setForeground(Color.red);
		if(aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].getRegularTime() == 1)
			halfB.setForeground(Color.red);
		else if(aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].getRegularTime() == 2)
			allB.setForeground(Color.red);
	}
	
	private void foodButtonFalse()
	{
		herbivorousB.setForeground(Color.black);
		herbivorousB.setEnabled(false);
		meatB.setForeground(Color.black);
		meatB.setEnabled(false);
		bigB.setForeground(Color.black);
		bigB.setEnabled(false);
		medB.setForeground(Color.black);
		medB.setEnabled(false);
		smallB.setForeground(Color.black);
		smallB.setEnabled(false);
		powerB.setForeground(Color.black);
		powerB.setEnabled(false);
		allB.setForeground(Color.black);
		allB.setEnabled(false);
		halfB.setForeground(Color.black);
		halfB.setEnabled(false);
	}
	
	private void lightButtonTrue()
	{
		//////////////////////////////////函式
		lighttimeB.setEnabled(true);
	}
	
	private void lightButtonFalse()
	{
		lighttimeB.setEnabled(false);
	}
	
	private void warmerButtonTrue()
	{
		////////////////////////////////函式
		warmtempB.setEnabled(true);
	}
	
	private void warmerButtonFalse()
	{
		warmtempB.setEnabled(false);
	}
	
	private void resetButtonFalse()
	{
		openfoodB.setForeground(Color.black);
		openfoodB.setEnabled(false);
		offfoodB.setForeground(Color.black);
		offfoodB.setEnabled(false);
		herbivorousB.setForeground(Color.black);
		herbivorousB.setEnabled(false);
		meatB.setForeground(Color.black);
		meatB.setEnabled(false);
		bigB.setForeground(Color.black);
		bigB.setEnabled(false);
		medB.setForeground(Color.black);
		medB.setEnabled(false);
		smallB.setForeground(Color.black);
		smallB.setEnabled(false);
		powerB.setForeground(Color.black);
		powerB.setEnabled(false);
		allB.setForeground(Color.black);
		allB.setEnabled(false);
		halfB.setForeground(Color.black);
		halfB.setEnabled(false);
		openwaterB.setForeground(Color.black);
		openwaterB.setEnabled(false);
		offwaterB.setForeground(Color.black);
		offwaterB.setEnabled(false);
		openinflatorB.setForeground(Color.black);
		openinflatorB.setEnabled(false);
		offinflatorB.setForeground(Color.black);
		offinflatorB.setEnabled(false);
		openlightB.setForeground(Color.black);
		openlightB.setEnabled(false);
		offlightB.setForeground(Color.black);
		offlightB.setEnabled(false);
		lighttimeB.setEnabled(false);
		openwarmerB.setForeground(Color.black);
		openwarmerB.setEnabled(false);
		offwarmerB.setForeground(Color.black);
		offwarmerB.setEnabled(false);
		warmtempB.setEnabled(false);
	}
	
	public void setButtonChoose()
	{
		////////////////////////////////呼叫確認函式
		//check 
		/*
		 * if(check有)
		 * getopenoroff
		 * openoroffenabled
		 * if(open)
		 * open.setfore
		 * ButtonTrue()
		 * else
		 * off.setfore
		 */
		if(aquarium.getDevice().getFeederbuyer() != 0)
		{
			openfoodB.setEnabled(true);
			offfoodB.setEnabled(true);
			if(aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].getModleState())
			{
				openfoodB.setForeground(Color.red);
				foodButtonTrue();
			}
			else  // close
			{
				offfoodB.setForeground(Color.blue);
			}
		}
		if(aquarium.getDevice().getFilterbuyer() != 0)
		{
			openwaterB.setEnabled(true);
			offwaterB.setEnabled(true);
			if(aquarium.getDevice().filter[aquarium.getDevice().getFilterbuyer()].getModleState())
			{
				openwaterB.setForeground(Color.red);
			}
			else  // close
			{
				offwaterB.setForeground(Color.blue);
			}
		}
		if(aquarium.getDevice().getInflatorbuyer() != 0)
		{
			openinflatorB.setEnabled(true);
			offinflatorB.setEnabled(true);
			if(aquarium.getDevice().inflator[aquarium.getDevice().getInflatorbuyer()].getModleState())
			{
				openinflatorB.setForeground(Color.red);
			}
			else  // close
			{
				offinflatorB.setForeground(Color.blue);
			}
		}
		if(aquarium.getDevice().getFlashLightbuyer() != 0)
		{
			openlightB.setEnabled(true);
			offlightB.setEnabled(true);
			if(aquarium.getDevice().flashLight[aquarium.getDevice().getFlashLightbuyer()].getModleState())
			{
				openlightB.setForeground(Color.red);
			}
			else  // close
			{
				offlightB.setForeground(Color.blue);
			}
		}
		if(aquarium.getDevice().getHeaterbuyer() != 0)
		{
			openwarmerB.setEnabled(true);
			offwarmerB.setEnabled(true);
			if(aquarium.getDevice().heater[aquarium.getDevice().getHeaterbuyer()].getModleState())
			{
				openwarmerB.setForeground(Color.red);
				warmerButtonTrue();
			}
			else  // close
			{
				offwarmerB.setForeground(Color.blue);
			}
		}
	}
	
	public void refresh()
	{
		resetButtonFalse();
		setButtonChoose();
	}
	
	private ActionListener bH = new ActionListener()
    {
    	public void actionPerformed(ActionEvent ae)
    	{
    		if(ae.getSource() == openfoodB)
    		{
    			openfoodB.setForeground(Color.red);
    			offfoodB.setForeground(Color.black);
    			foodButtonTrue();
    			/////////////////呼叫函式
    			aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].changeModel(true);
    		}
    		else if(ae.getSource() == offfoodB)
    		{
    			offfoodB.setForeground(Color.blue);
    			openfoodB.setForeground(Color.black);
    			foodButtonFalse();
    			aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].changeModel(false);
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == openwaterB)
    		{
    			openwaterB.setForeground(Color.red);
    			offwaterB.setForeground(Color.black);
    			aquarium.getDevice().filter[aquarium.getDevice().getFilterbuyer()].changeModel(true);
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == offwaterB)
    		{
    			offwaterB.setForeground(Color.blue);
    			openwaterB.setForeground(Color.black);
    			aquarium.getDevice().filter[aquarium.getDevice().getFilterbuyer()].changeModel(false);
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == openinflatorB)
    		{
    			openinflatorB.setForeground(Color.red);
    			offinflatorB.setForeground(Color.black);
    			aquarium.getDevice().inflator[aquarium.getDevice().getInflatorbuyer()].changeModel(true);
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == offinflatorB)
    		{
    			offinflatorB.setForeground(Color.blue);
    			openinflatorB.setForeground(Color.black);
    			aquarium.getDevice().inflator[aquarium.getDevice().getInflatorbuyer()].changeModel(false);
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == openlightB)
    		{
    			openlightB.setForeground(Color.red);
    			offlightB.setForeground(Color.black);
    			aquarium.getDevice().flashLight[aquarium.getDevice().getFlashLightbuyer()].changeModel(true);
    			JOptionPane.showMessageDialog(openlightB,"必須設定照明時間才會啟動","提醒", JOptionPane.INFORMATION_MESSAGE);
    			lightButtonTrue();
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == offlightB)
    		{
    			offlightB.setForeground(Color.blue);
    			openlightB.setForeground(Color.black);
    			aquarium.getDevice().flashLight[aquarium.getDevice().getFlashLightbuyer()].changeModel(false);
    			lightButtonFalse();
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == openwarmerB)
    		{
    			openwarmerB.setForeground(Color.red);
    			offwarmerB.setForeground(Color.black);
    			aquarium.getDevice().heater[aquarium.getDevice().getHeaterbuyer()].changeModel(true);
    			JOptionPane.showMessageDialog(openwarmerB,"必須設定溫度上限才會啟動","提醒", JOptionPane.INFORMATION_MESSAGE);
    			warmerButtonTrue();
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == offwarmerB)
    		{
    			offwarmerB.setForeground(Color.blue);
    			openwarmerB.setForeground(Color.black);
    			aquarium.getDevice().heater[aquarium.getDevice().getHeaterbuyer()].changeModel(false);
    			warmerButtonFalse();
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == herbivorousB)
    		{
    			herbivorousB.setForeground(Color.decode("#2E8B57"));
    			meatB.setForeground(Color.black);
    			aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].setFavorite(2);
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == meatB)
    		{
    			meatB.setForeground(Color.red);
    			herbivorousB.setForeground(Color.black);
    			aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].setFavorite(1);
    			/////////////////呼叫函式
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == bigB)
    		{
    			bigB.setForeground(Color.red);
    			medB.setForeground(Color.black);
    			smallB.setForeground(Color.black);
    			powerB.setForeground(Color.black);
    			aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].setGrain(50);
    			/////////////////呼叫函式
    			////////////////////////呼叫函式
    		}
    		else if(ae.getSource() == medB)
    		{
    			bigB.setForeground(Color.black);
    			medB.setForeground(Color.red);
    			smallB.setForeground(Color.black);
    			powerB.setForeground(Color.black);
    			aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].setGrain(10);
    			///////////////////////呼叫函式
    		}
    		else if(ae.getSource() == smallB)
    		{
    			bigB.setForeground(Color.black);
    			medB.setForeground(Color.black);
    			smallB.setForeground(Color.red);
    			powerB.setForeground(Color.black);
    			aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].setGrain(5);
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == powerB)
    		{
    			bigB.setForeground(Color.black);
    			medB.setForeground(Color.black);
    			smallB.setForeground(Color.black);
    			powerB.setForeground(Color.red);
    			aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].setGrain(1);
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == lighttimeB)
    		{
    			/////////////////照明時間
    			int i = Integer.parseInt(JOptionPane.showInputDialog("輸入照明時間(小時)"));
    			aquarium.getDevice().flashLight[aquarium.getDevice().getFlashLightbuyer()].setLightHour(i);
    			/////////////////呼叫函式給時間
    		}
    		else if(ae.getSource() == warmtempB)
    		{
    			/////////////////溫度上限
    			int i = Integer.parseInt(JOptionPane.showInputDialog("輸入上限溫度(℃)"));
    			aquarium.getDevice().heater[aquarium.getDevice().getHeaterbuyer()].setMaxTemperature(i);
    			/////////////////呼叫函式給溫度
    		}
    		else if(ae.getSource() == allB)
    		{
    			allB.setForeground(Color.red);
    			halfB.setForeground(Color.black);
    			aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].setRegularTime(2);
    			/////////////////呼叫函式
    		}
    		else if(ae.getSource() == halfB)
    		{
    			halfB.setForeground(Color.red);
    			allB.setForeground(Color.black);
    			aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].setRegularTime(1);
    			/////////////////呼叫函式
    		}
        }
    };
}