
package gameCore;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
/**
 * Class which reads linked music resources and plays them 
 * @author dominikvintr
 *
 */
public class Sounds {

	private static String fileName;
	private static float num;
	
	public void setNum(int i) {
		num = (float)i;
		System.out.println(num);
	}
/**
 * Plays a song
 * Volume can be changed via settings
 * @param type
 */
	public synchronized void play(String type) {
		
		if (type.equals("impact")) {
			fileName = "ImpactSound.wav";
		} else if (type.equals("click")){
			fileName = "clickSound.wav";
		}

		new Thread(new Runnable() {

			public void run() {
				try {
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName));
					Clip clip = AudioSystem.getClip();
					clip.open(inputStream);
					
					if (fileName.equals("ImpactSound.wav") || fileName.equals("clickSound.wav")) {
					FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
					gainControl.setValue(0.0f - num); // Reduce volume by X decibels
					}
					clip.start();
				} catch (Exception e) {
					System.out.println("play sound error: " + e.getMessage() + " for " + fileName);
				}
			}
		}).start();
	}
}