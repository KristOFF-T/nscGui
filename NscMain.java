package main;

import java.awt.Color;
import java.awt.Font;
//import java.awt.Point;
//import java.awt.event.WindowStateListener;
//import java.util.Random;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.JTextField;

public class NscMain {
	public static void main(String[] args) {
		//Random rand = new Random();
		
		int FW=500, CFW=FW/2,
			W=1280, CX=W/2,
			H=720;//, CY=H/2;

		Font font = new Font("Comic Sans", Font.BOLD, 60);

		JTextField inputNsField = new JTextField();
		inputNsField.setBounds(CX-CFW,120,CFW-30,60);
		inputNsField.setFont(font);

		JTextField outputNsField = new JTextField();
		outputNsField.setBounds(CX+30,120,CFW-30,60);
		outputNsField.setFont(font);
		
		JTextField numField = new JTextField();
		numField.setBounds(CX-CFW, 200, FW, 60);
		numField.setFont(font);
		
		JTextField resultField = new JTextField();
		resultField.setBounds(390, 380, 500, 60);
		resultField.setEditable(false);
		resultField.setFont(font);
		
		JButton convertButton = new JButton();
		convertButton.setBackground(Color.black);
		convertButton.setForeground(Color.white);
		convertButton.setBounds(390, 300, 500, 70);
		convertButton.setFont(font);
		convertButton.setText("Convert");
		convertButton.setFocusable(false);
		convertButton.addActionListener(e -> {
			try {
				int ins = Integer.valueOf(inputNsField.getText()),
						ons = Integer.valueOf(outputNsField.getText());
				
				String num = numField.getText();
				
				String result = Second.convert(ins, ons, num);
				resultField.setText(result);
				
			} catch(NumberFormatException e2) {
				
			}
		});
		
		JFrame window = new JFrame();
		window.setSize(W, H);
		window.setTitle("GUI");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		window.getContentPane().setBackground(new Color(0,0,50));
		
		window.add(convertButton);
		
		window.add(inputNsField);
		window.add(outputNsField);
		window.add(numField);
		window.add(resultField);
		
		window.setVisible(true);
	}
}
