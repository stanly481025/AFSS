package fishtankPanel;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ImageIcon;

import BGM.AFSSSound;
import BGM.ChooseBgmMenu;
import LandScape.Decoration;
import aquarium.Aquarium;
import insertImage.ImagePanel;
import fishSwing.fishtankThing;
import fish.Fish;
import fish.Fish.FishStatus;
import fish.FishCataLog;

@SuppressWarnings("serial")
public class FishtankPanel extends ImagePanel implements Runnable
{
	
	private AFSSSound backgroundMusic2=new AFSSSound(32,3); 
	private int nowPlaying = 0;
	
	//private fishtankThing testF;
	private String[] fishID = { "-1", "-1", "-1", "-1", "-1",
			 					"-1", "-1", "-1", "-1", "-1",
			 					"-1", "-1", "-1", "-1", "-1",
			 					"-1", "-1", "-1", "-1", "-1", };
	private fishtankThing[] testtF = { new fishtankThing("Right"), new fishtankThing("Right"),
			                           /*new fishtankThing("Right"), new fishtankThing("Right"),
			                           new fishtankThing("Right"), new fishtankThing("Right"),
			                           new fishtankThing("Right"), new fishtankThing("Right"),
			                           new fishtankThing("Right"), new fishtankThing("Right"),
			                           new fishtankThing("Right"), new fishtankThing("Right"),
			                           new fishtankThing("Right"), new fishtankThing("Right"),
			                           new fishtankThing("Right"), new fishtankThing("Right"),
			                           new fishtankThing("Right"), new fishtankThing("Right"),
			                           new fishtankThing("Right"), new fishtankThing("Right") */};
	private ArrayList<fishtankThing> fishs=new ArrayList<fishtankThing>();
	private ArrayList<fishtankThing> displays=new ArrayList<fishtankThing>();
	//private fishtankThing[] //設備
	//private int timerFlag = 1;///////////////?
	
	private int location = 100;
	private int locationh = 100;
	private final int SIZE = 300;
	private int moveDistance = 15;
	/*
	private int[][] locations = { {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0},
			                      {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0},
			                      {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0},
			                      {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, };
	private int[][] destinations = { {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0},
                                     {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0},
                                     {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0},
                                     {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, };
                                     */
	Thread Move;
	Decoration table[][];
	int sizeX=0,sizeY=0;
	//private int fishMaxAmount;
	
    public FishtankPanel(String im)
    {
    	super(im);
    	set();
    }
    
    public void addFishTankThing(Fish fish)
    {
    	this.fishs.add(new fishtankThing(fish));
    	fishs.get(fishs.size()-1).setBounds(0, 0, fish.getWeight(), fish.getWeight());
    	System.out.println(this.Move.getState());
    	add(fishs.get(fishs.size()-1));
    }
    
    public void addDisplay(Decoration table[][],int size)
    {
    	System.out.println(size);
    	int sizeX=0,sizeY=0;
    	if(size==1)
    	{
    		sizeX=2;sizeY=4;
    	}
    	else if(size==2)
    	{
    		sizeX=3;sizeY=6;
    	}
    	else if (size==3)
    	{
    		sizeX=3;sizeY=8;
    	}
    	for(int i=0;i<sizeX;i++)
    	{
    		for(int y=0;y<sizeY;y++)
    		{
    			if(table[i][y]!=null &&(table[i][y].getName().equals("假珊瑚") ||
    					table[i][y].getName().equals("稜角石") ||
    	    			table[i][y].getName().equals("水草") ||
    	    			table[i][y].getName().equals("沉木")))
    			{
    				System.out.println(table[i][y].getName());
    				displays.add(new fishtankThing(new ImageIcon("/pic/"+table[i][y].getName()+".png").getImage()));
    				displays.get(displays.size()-1).setDisplayX(y*15);
    				displays.get(displays.size()-1).setDisplayZ(i*15);
    				if(table[i][y].getName()=="假珊瑚")
    					displays.get(displays.size()-1).setBounds(120+y*200-table[i][y].getSizeY()*100, 600+i*45+45+10-table[i][y].getSizeX()*200, table[i][y].getSizeY()*200, table[i][y].getSizeX()*200);
    				else if(table[i][y].getName()=="沉木")
    					displays.get(displays.size()-1).setBounds(120+200+y*200-table[i][y].getSizeY()*75, 600+i*45+45+10-table[i][y].getSizeX()*150, table[i][y].getSizeY()*150, table[i][y].getSizeX()*150);
    				else
    					displays.get(displays.size()-1).setBounds(120+y*200-table[i][y].getSizeY()*100, 600+i*45+10-table[i][y].getSizeX()*200, table[i][y].getSizeY()*200, table[i][y].getSizeX()*200);
    				add(displays.get(displays.size()-1));
    				//System.out.println("yee");
    			}
    			//System.out.println(table[i][y].getName());
    		}
    	}
    	
 
    	this.table=table;
    	this.sizeX=sizeX;
    	this.sizeY=sizeY;
    	
    }
    
    
    public void bcMusicPlay()
    {
    	backgroundMusic2.play();
    }
    
    public void bcMusicStop()
    {
    	backgroundMusic2.audioClip.stop();
    }
    
    private void set()
    {
    	/*
        testtF[0].setBounds(200, 200, 100, 100);
        add(testtF[0]);
        
        //add(testtF); 調換可行
        //會一直執行
        //testMove();
        
       //Move = new Thread(this);
        //Move.start();
        //Move.stop();
        */
        //testF.setBounds(location, location, SIZE, SIZE);
        
        //testtF = new SwingFish(new ImageIcon("d://12345.gif").getImage());
        //testtF = new SwingFish("Right");
    	//testtF[0].setBounds(location+300, location, 100, 100);
    	//testtF[1].setBounds(location+300+200, location+200, 100, 100);
        //DynGifLabel stateLbl = new DynGifLabel(new ImageIcon(ThreadPanel.class.getResource("/startThread.gif")).getImage());
        //add(testtF[0]);
        //add(testtF[1]);
        //add(testF);
        //add(testtF); 調換可行
        
        //會一直執行
        //testMove();
    	
        Move = new Thread(this);
       Move.start();
       
    }
    
    public void refresh(int i)
    {
    	this.removeAll();
    	
    	
    	ArrayList<int[]> temp=new ArrayList<int[]>();
    	int y=0;
    	for(fishtankThing fish:fishs)
    	{
    		int[] tempArray=new int[4];
    		tempArray[0]=1;
    		tempArray[1]=y;
    		tempArray[2]=fish.getFish().getNowPosition()[0];
    		tempArray[3]=fish.getFish().getNowPosition()[2];
    		temp.add(tempArray);
    		y++;
    	}
    	y=0;
    	for(fishtankThing display:displays)
    	{
    		int[] tempArray=new int[4];
    		tempArray[0]=2;
    		tempArray[1]=y;
    		tempArray[2]=display.getDisplayX();
    		tempArray[3]=display.getDisplayZ();
    		temp.add(tempArray);
    		y++;
    	}
    	
    	Collections.sort(temp, new Comparator<int[]>(){
    		 @Override
    		 public int compare(int[] o1, int[] o2) {
    		  return o2[3]-o1[3];
    		 }   
    		});
    	
    	for(int[] temp1:temp)
    	{
    		if(temp1[0]==1)
    		{
    			this.add(fishs.get(temp1[1]));
    		}
    		else if(temp1[0]==2)
    		{
    			this.add(displays.get(temp1[1]));
    			System.out.println(displays.get(temp1[1]).getDisplayX());
    		}
    	}
    	
    	
    	/*
    	 * check 有無設備
    	 * setToolTipText 初中高
    	 * 
    	 * check 有無死魚
    	 * 
    	 */
    }
    
    public void changeBgm()
    {
    	backgroundMusic2.audioClip.stop();
		ChooseBgmMenu myMenu = new ChooseBgmMenu();
		myMenu.setBounds(300, 300, 300, 150);
		myMenu.setModal(true);
		myMenu.setVisible(true);
		myMenu.dispose();
		
		System.out.println("now1:" + nowPlaying);
		if(myMenu.isVisible() == false) {
			nowPlaying = myMenu.getNowPlaying();
			System.out.println("now2:" + nowPlaying);
			backgroundMusic2 = new AFSSSound(nowPlaying, 3);
			backgroundMusic2.play();
		}
		System.out.print("hi");
    }
    
    public void removeFish(ArrayList<Fish> removeFish)
    {
    	for(Fish fish:removeFish)
    	{
    		for(int i=0;i<fishs.size();i++)
    		{
    			if(fishs.get(i).getFish().getFishStatus()==FishStatus.DEATH && fishs.get(i).getFish().getFishNO()==fish.getFishNO()) {
    				fishs.remove(fishs.get(i));
    			}
    		}
    	}
    	refresh(0);
    	this.repaint();
    }
    
    public void reset()
    {
    	this.removeAll();
    	fishs.clear();
    	displays.clear();
    	this.repaint();
    	
    }
    
    public void removeDisplay()
    {
    	displays.clear();
    }
    
    public void loadDb(Aquarium aquarium)
    {
    	for(int i=0;i<aquarium.getnFishs();i++)
    	{
    		addFishTankThing(aquarium.getFishs()[i]);
    	}
    	addDisplay(aquarium.getLandSpace().getTable(),aquarium.getEnviroment().getFishTankSize());
    	refresh(0);
    }
    
    public void run()
    {
    	//int i = this.getHeight(); 可行
    	/*
    	 * check有無死魚
    	 * 呼叫mainframe add netB
    	 */
    		//if timerFlag
    		//
    		//if timerFlag
    	//移動魚(實際加入後的魚)
    	refresh(0);
  	  int i;
  	
        for(i = 0; i < 100; i++)
        {
      	  //
      	  try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        	  if(fishs.size()!=0) {
        		  for(fishtankThing moveFish:fishs)
        		  {
        			  int moveX,moveY,moveZ;
        			  int size;	//Z軸放大縮小多少
        			  moveZ=(moveFish.getFish().getNowPosition()[2]/6)*4-
        					  (moveFish.getSize().height-moveFish.getFish().getWeight());
        			  size=moveFish.getSize().height+
        					  (int)((((double)moveZ/100))*((i+1)));
        			  moveFish.setSize(size,size);
            		  moveX=moveFish.getFish().getNowPosition()[0]*14
            				  -moveFish.getX();
            		  moveY=moveFish.getFish().getNowPosition()[1]*12
            				  -moveFish.getY();
            		  moveFish.turn(moveX);
            		
            		  moveFish.setLocation(moveFish.getX()+moveX/100,
            				moveFish.getY()+moveY/100);
        		  }
        		 
        			
        		  //  System.out.println(moveX);
        		  //  System.out.println(moveY);
        	  }
        	  
        }
    	/*
    		try
    	       {
    	    	  int i;
    	          for(i = 1; i < 200; i++)
    	          {
    	        	  //
    	        	  Thread.sleep(10);
    	        	  //testF.setLocation(location += moveDistance, locationh += moveDistance);
    	        	 // location += (moveDistance/15);
    	        	 // locationh +=(moveDistance/15);
    	          	 // testtF[0].setLocation(location + 300, locationh);
    	        	  
    	        	  
    	        	  
    	        	  
    	        	  
    	          	  if(fishs.size()!=0) {
    	          		  int moveX,moveY;
    	          		  moveX=fishs.get(fishs.size()-1).getFish().getNowPosition()[0]*14
    	          				  -fishs.get(fishs.size()-1).getX();
    	          		  moveY=fishs.get(fishs.size()-1).getFish().getNowPosition()[0]*12
    	          				  -fishs.get(fishs.size()-1).getY();
    	          		fishs.get(fishs.size()-1).setLocation(moveX,moveY);
    	          			
    	          	
    	          	  }
    	          }
    	          for(i = 1; i < 200; i++)
    	          {
    	        	  Thread.sleep(10);
    	        	  //testF.setLocation(location += moveDistance, locationh -= moveDistance);
    	        	 // location += (moveDistance/15);
    	        	  //locationh -= (moveDistance/15);
    	          	 // testtF[0].setLocation(location + 300, locationh);
    	          	if(fishs.size()!=0) {
    	          	  int moveX,moveY;
	          		  moveX=fishs.get(fishs.size()-1).getFish().getNowPosition()[0]*14
	          				  -fishs.get(fishs.size()-1).getX();
	          		  moveY=fishs.get(fishs.size()-1).getFish().getNowPosition()[0]*12
	          				  -fishs.get(fishs.size()-1).getY();
	          		fishs.get(fishs.size()-1).setLocation(moveX,moveY);
    	          	}
    	          }
    	          testtF[0].turn();
    	          for(i = 1; i < 200; i++)
    	          {
    	        	  Thread.sleep(10);
    	        	  //testF.setLocation(location -= moveDistance, locationh -= moveDistance);
    	        	 // location -= (moveDistance/15);
    	        	 // locationh -= (moveDistance/15);
    	          	 // testtF[0].setLocation(location + 300, locationh);
    	          	if(fishs.size()!=0)
    	          	{
    	          	  int moveX,moveY;
	          		  moveX=fishs.get(fishs.size()-1).getFish().getNowPosition()[0]*14
	          				  -fishs.get(fishs.size()-1).getX();
	          		  moveY=fishs.get(fishs.size()-1).getFish().getNowPosition()[0]*12
	          				  -fishs.get(fishs.size()-1).getY();
	          		fishs.get(fishs.size()-1).setLocation(moveX,moveY);
	          			
    	          	}
    	          }
    	          for(i = 1; i < 200; i++)
    	          {
    	        	  Thread.sleep(10);
    	        	  //testF.setLocation(location -= moveDistance, locationh += moveDistance);
    	        	 // location -= (moveDistance/15);
    	        	 // locationh += (moveDistance/15);
    	          	 // testtF[0].setLocation(location + 300, locationh);
    	          	  //移動魚
    	          	if(fishs.size()!=0)
    	          	{
    	          	  int moveX,moveY;
	          		  moveX=fishs.get(fishs.size()-1).getFish().getNowPosition()[0]*14
	          				  -fishs.get(fishs.size()-1).getX();
	          		  moveY=fishs.get(fishs.size()-1).getFish().getNowPosition()[0]*12
	          				  -fishs.get(fishs.size()-1).getY();
	          		fishs.get(fishs.size()-1).setLocation(moveX,moveY);
	          			
    	          	}
    	          }
    	          testtF[0].turn();
    	       }catch (InterruptedException e) {}*/
    		this.run();
    		
    }
}