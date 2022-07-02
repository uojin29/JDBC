package Photoshop;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class MyActionListener extends JFrame implements ActionListener{
	JFileChooser filechooser = new JFileChooser();
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("Gray Scale")) {
			System.out.println("Gray Scale");
			for(int y = 0; y < MainFrame.image2.getHeight(); y++) {
				   for(int x = 0; x < MainFrame.image2.getWidth(); x++) {
				       Color colour = new Color(MainFrame.image2.getRGB(x, y));
				       int Y = (int) (0.2126 * colour.getRed() + 0.7152 * colour.getGreen() + 0.0722 * colour.getBlue());
				       MainFrame.image2.setRGB(x, y, new Color(Y, Y, Y).getRGB());
				   }
			}
			MainFrame.changed.repaint();
		}
		else if(s.equals("Edge")) {
			System.out.println("Edge");
		}
		else if(s.equals("Button 3")) {
			System.out.println("Button 3");
		}
		else if(s.equals("Button 4")) {
			System.out.println("Button 4");
		}
		else if(s.equals("Reset")) {
			MainFrame.image2 = MainFrame.image;
			MainFrame.origin.repaint();
			MainFrame.changed.repaint();
			System.out.println("reset");
		}
		
		else if(s.equals("Load")) {
			if(filechooser.showOpenDialog(MainFrame.origin) == JFileChooser.APPROVE_OPTION){
            	System.out.println("filePath"+filechooser.getSelectedFile().toString());
            	MainFrame.imgPath = filechooser.getSelectedFile().toString();
           	    try {
           	    	MainFrame.image = ImageIO.read(filechooser.getSelectedFile());
           	    	MainFrame.image2 = ImageIO.read(filechooser.getSelectedFile());
           	    } catch (IOException ex) {
           	        ex.printStackTrace();
           	    }
            	MainFrame.origin.repaint();
            	MainFrame.changed.repaint();
            }
		}
		else if(s.equals("Save")) {
			//ImageIO.write(MainFrame.resizeImage, "jpg", new File("C:/save/새 사진파일명.jpg"));
			System.out.println("Save");
		}
	}
}