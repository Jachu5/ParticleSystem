package com.jachu.particles;

import javax.swing.*;

public class ParticleSystem {

	private static int MAX_PARTICLE = 3000;
	
	private static ParticlePanel mParticlePanel;
	private static Emitter mEmitter;



    public static void main(String[] args) {
		init();
		createPanel();
		loop();
        
	}
	
	private static void loop() {
		while(true){
			mEmitter.update();
			mParticlePanel.repaint();
			try {
	            Thread.sleep(10);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
		}
		
	}

	private static void init() {
		mParticlePanel = new ParticlePanel();
		mEmitter = new Emitter(mParticlePanel.getPreferredSize(),MAX_PARTICLE);	
		mParticlePanel.addParticleList(mEmitter.createParticlePool());
	}
	
	private static void createPanel() {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndShowUI();
			}
		});	
	}

	private static void createAndShowUI() {
		System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());

        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(mParticlePanel);
        f.pack();
        f.setVisible(true);
	}
	
	
}
