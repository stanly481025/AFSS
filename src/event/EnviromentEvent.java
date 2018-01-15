package event;

import DeviceCatalog.DeviceCatalog;
import LandScape.LandScape;
import enviroment.Enviroment;
import fish.Fish;
import timer.Timerr;

public abstract class EnviromentEvent {
	public abstract void check(Fish[] fishs,Enviroment enviroment,Timerr timer,int nFishs,LandScape landSpace,DeviceCatalog device
			,int[] eventArray,String[] eventArrayDescription,int[] nEvent);
	protected abstract void description(Fish[] fishs,Enviroment enviroment,Timerr timer,int nFishs,LandScape landSpace,DeviceCatalog device
			,int[] eventArray,String[] eventArrayDescription,int[] nEvent);
}
