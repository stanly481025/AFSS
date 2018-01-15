package Achieve;

import DeviceCatalog.DeviceCatalog;
import db.Fish_data;
import fish.Fish;

//稱號魚心不忍
public class cryFish extends achievement{

	public cryFish() 
	{
		this.setName("魚心不忍");
		this.setStatement("如果你不小心bang死牠們，雖然不能重振雄風但或許能因禍得福呢......");
		//平常都在夜市撈金魚，今天你可以在家裡撈金魚了
		this.setGETstatement("***獲得神器 「永遠不會壞夜市撈金魚網」 一只!!***");
	}


	@Override
	public boolean checkGetAchievement(DeviceCatalog deviceCatalog, Fish[] fishs) {
		//確認條件是否達成
		//已經拿到稱號 回傳false
		if(this.getHaveGET()==true)
			return false;
		Fish_data fishConnect = new Fish_data();
		if(fishConnect.SelectDiedFishNum()>=3) 
		{
			int i;
	
			achieveBox button5 = new achieveBox("平常都在夜市撈金魚，今天你可以在家裡撈金魚了");
			achieveBox button6 = new achieveBox("***獲得神器 「永遠不會壞夜市撈金魚網」 一只!!***");
			//拿到成就
			this.setHaveGET(true);
			//new frame
			return true;
		}
		return false;
	}
	
	
}
