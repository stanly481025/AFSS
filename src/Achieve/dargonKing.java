package Achieve;

import DeviceCatalog.DeviceCatalog;
import enviroment.Enviroment;
import fish.Fish;

public class dargonKing extends achievement {

	public dargonKing() 
	{
		this.setName("深海龍王");
		this.setStatement("海納百川，安納貝爾，但卻容不下你那龐大的身軀，你只要一直胖下去就會......");
		//魚如其主，肥到不行，再吃下去就會被殺掉哦胖呆!
		this.setGETstatement("***獲得方法 「雙手萬能，養魚就像養女朋友餵食」 之後可以手動餵食了!!***");
	}
	

	@Override
	public boolean checkGetAchievement(DeviceCatalog deviceCatalog, Fish[] fishs) {
		//check arraylist 裡面所有的魚
		//如果達到最大體長則達成條件
		if(this.getHaveGET()==true)
			return false;
	
		int i=0;

		for(i=0 ;i<fishs.length;i++)
		{
			if(fishs[i]==null)
				return false;
			if(fishs[i].getMaxWeight() == fishs[i].getWeight())
			{
				achieveBox button3 = new achieveBox("魚如其主，肥到不行，再吃下去就會被殺掉哦胖呆!");
				achieveBox button4 = new achieveBox("***獲得方法 「雙手萬能，養魚就像養女朋友餵食」 之後可以手動餵食了!!***");
				for(int j=0;j<3;j++)
					deviceCatalog.feeder[j].setAchieve(true);
				this.setHaveGET(true);
				return true;
			}
		}
		return false;
	}

}
