package Achieve;

import DeviceCatalog.DeviceCatalog;
import fish.Fish;

//成就系統
public abstract class achievement {
	
	private String name; //稱號
	private String statement; //引導條件說明
	private String GETstatement;//拿到當下顯示出的提醒
	private boolean haveGET; //是否拿過稱號了
	
	
	//確認拿到獎勵的條件
	public abstract boolean checkGetAchievement(DeviceCatalog d, Fish[] fishs);
	
	public achievement() 
	{
		this.setName("稱號");
		this.setStatement("引導條件");
		this.setGETstatement("獲得成就");
		this.setHaveGET(false);
	}
	
	//set
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setStatement(String statement) 
	{
		this.statement = statement;
	}
	public void setGETstatement(String GETstatement) 
	{
		this.GETstatement = GETstatement;
	}
	public void setHaveGET(boolean input) 
	{
		this.haveGET = input;
	}
	
	//get
	//輸出條件說明
	public String getStatement() 
	{
		return this.statement;
	}
	public String getName() 
	{
		return this.name;
	}
	public String gerGetStatement() 
	{
		return this.GETstatement;
	}
	public boolean getHaveGET() 
	{
		return this.haveGET;
	}
	
	
}
