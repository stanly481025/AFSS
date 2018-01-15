package BGM;

import java.io.File;
import java.io.IOException;
import java.util.TimerTask;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/********************************************************/
/* @author yusiang                                      */
/* 當此物件被宣告出來時，宣告此物件的類別本身如果是 implements Runnable */
/* 呼叫此物件執行應使用run()，確保該物件的動作可加入排程(TimerTask)，        */
/* 如果不是，可呼叫play()，然後音樂的路徑要確認                                                          */
/********************************************************/
public class AFSSSound extends TimerTask implements LineListener {
	
	private String audioFilePath = "D:/Sound/"; //絕對路徑
	private int soundID; //曲目
	private int type; //種類(按鈕/警告/背景音樂)
	public Clip audioClip;
	private boolean playCompleted; //是否播完
	
	public AFSSSound(int soundID, int type) {
		this.soundID = soundID;
		this.type = type;
		this.playCompleted = false;
	}
	public AFSSSound() { //空建構元，用來清空
		
	}
	public void play() {
		//System.out.println(soundID);
		File audioFile = new File(audioFilePath + "Bang.wav"); //預設聲音
		switch (type) {
			case 1: //按鈕聲音
				audioFile = new File(audioFilePath + "btnSound/btn" + soundID + ".wav");
				break;
			case 2: //警告聲音
				audioFile = new File(audioFilePath + "warningSound/war" + soundID + ".wav");
				break;
			case 3: //背景音樂
				if(soundID == 0) {
					soundID = 31;
				}
				audioFile = new File(audioFilePath + "bgm/bgm" + soundID + ".wav");
				break;
			default: //Bang的聲音
				break;
		}
		
		try {
			if(type == 3){ //播放背景音樂
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
				AudioFormat format = audioStream.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				audioClip = (Clip) AudioSystem.getLine(info);
				audioClip.addLineListener(this); //註冊事件
				
				audioClip.open(audioStream); //開啟串流
				audioClip.start();// 開始播放
				audioClip.loop(Clip.LOOP_CONTINUOUSLY);
			} else { //另外2種
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
				AudioFormat format = audioStream.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				audioClip = (Clip) AudioSystem.getLine(info);
				audioClip.addLineListener(this); //註冊事件
				
				audioClip.open(audioStream); //開啟串流
				audioClip.start(); // 開始播放
				while (!playCompleted) { //還沒播放完
					try {
						Thread.sleep(100); //等待0.1秒
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
			//audioClip.close(); //關閉串流
		} catch (UnsupportedAudioFileException ex) { //不支援的音檔格式(非wav檔)
			System.out.println("The specified audio file is not supported.");
			ex.printStackTrace();
		} catch (LineUnavailableException ex) { //串流掛了
			System.out.println("Audio line for playing back is unavailable.");
			ex.printStackTrace();
		} catch (IOException ex) { //I/O錯誤
			System.out.println("Error playing the audio file.");
			ex.printStackTrace();
		}
		
	}
	@Override
	public void update(LineEvent event) {
		LineEvent.Type type = event.getType();
		//如果抓到開始播放音樂的串流事件
		if (type == LineEvent.Type.START) { //開播
			System.out.println("Playback started.");	
		} else if (type == LineEvent.Type.STOP) { //停播
			playCompleted = true;
			System.out.println("Playback completed.");
		}
	}

	@Override
	public void run() { //適用於多執行緒狀況
		play();
	}
	
	public Clip getClip(){ //回傳clip
		return audioClip;
	}
}
