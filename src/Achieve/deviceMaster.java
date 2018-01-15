package Achieve;

import javax.swing.JFrame;
import javax.swing.JLabel;

import DeviceCatalog.DeviceCatalog;
import db.Cost_data;
import enviroment.Enviroment;
import fish.Fish;

public class deviceMaster extends achievement {

	public deviceMaster() 
	{
		this.setName("設贏師");
		this.setStatement("摸透C語言摸不透C罩杯，但如果你能摸透設備也買了超大杯(雖然Comebuy店員比較正)...");
		//老闆今天不再家，老闆跳樓大拍賣，狂抽猛送
		this.setGETstatement("*** 「你使用的設備老闆都在送你一套(耐損度歸0)，老闆瘋辣!!!」");
	}
	//設備大師 是重複稱號案件


	@Override
	public boolean checkGetAchievement(DeviceCatalog deviceCatalog, Fish[] fishs) {
		if(this.getHaveGET())
			return false;
		
		Cost_data costConnect = new Cost_data();
	
		System.out.println(costConnect.CountData());
		if(costConnect.CountData()>10) 
		{
			achieveBox button = new achieveBox("老闆今天不再家，老闆跳樓大拍賣，狂抽猛送");
			achieveBox button2 = new achieveBox("*** 「你使用的設備老闆都在送你一套(耐損度歸0)，老闆瘋辣!!!」***");
			deviceCatalog.feeder[deviceCatalog.getFeederSelector()].setDamageRateNow(0);
			deviceCatalog.filter[deviceCatalog.getFilterSelector()].setDamageRateNow(0);
			deviceCatalog.inflator[deviceCatalog.getInflatorSelector()].setDamageRateNow(0);
			deviceCatalog.heater[deviceCatalog.getHeaterSelector()].setDamageRateNow(0);
			deviceCatalog.flashLight[deviceCatalog.getFlashLightSelector()].setDamageRateNow(0);
			this.setHaveGET(true);
			return true;
		}
		return false;
	}

}
