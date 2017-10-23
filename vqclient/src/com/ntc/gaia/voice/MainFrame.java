package com.ntc.gaia.voice;


import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

/**
 * 
 * @author William
 * @date 2017/09/26
 */
public class MainFrame extends JFrame{

	//主视窗面板
	private JPanel vsv;
	
	File imagepath=new File("res/voice.png");
	
	Image image;
	
	protected static Logger log = Logger.getLogger(MainFrame.class);
	
	public MainFrame(){
		super("语音查询");
		try {
			image=ImageIO.read(imagepath);
		} catch (IOException e) {
			log.info(e.getStackTrace());
			e.printStackTrace();
		}
		this.setIconImage(image);
		vsv=new VoiceSpeechView();
		add(vsv);
		setSize(vsv.getSize());
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
	
		new MainFrame();
	}

}
