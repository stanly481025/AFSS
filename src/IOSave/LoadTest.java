package IOSave;

import java.io.IOException;

import aquarium.Aquarium;

public class LoadTest {
	private static  Aquarium a;
	private Load load = new Load();
	public static void main(String args[]) 
	{
		Load load = new Load();
		try {
			a=load.LoadData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		save();
	}
	public static void save() {
		Save save=new Save(a);
			try {
			save.SaveData("savetest666.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
