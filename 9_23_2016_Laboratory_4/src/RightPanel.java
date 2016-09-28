import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class RightPanel extends JPanel {
	private static final long serialVersionUID = -1073170544184446100L;
	private BufferedImage img;

	public RightPanel(BufferedImage img){
		this.img = img;
	}

	public void paintComponent (Graphics g){
		super.paintComponent(g);
		g.drawImage(this.img, 0, 0 , null);		
	}

	public void clearImage(Graphics g) {
		int width = img.getWidth();
		int height = img.getHeight();
		for (int i=0; i<width; i++){
			for (int j=0; j<height; j++){
				img.setRGB(i,j,0xffffffff);
			}
		}
	}
	
	//
	// Transition by columns top to bottom left to right
    public void transitionTBLR(Graphics g, BufferedImage leftImage) {
        // Lab Q1: Your Code Here
        int width = leftImage.getWidth();
        int height = leftImage.getHeight();
        for (int i=0; i<width ; i++){
            for (int j=0 ; j<height ; j++){
                int pixelColor = leftImage.getRGB(i, j);
                img.setRGB(i, j, pixelColor);
            }
            repaint();
            try {Thread.sleep(10); } catch (InterruptedException e){};
        }
	}

	//
	// Transition by rows left to right top to bottom
	public void transitionLRTB(Graphics g, BufferedImage leftImage) {
		int width = leftImage.getWidth();
		int height = leftImage.getHeight();
		for (int j=0; j<height; j++){
			for (int i=0; i<width; i++){
				int pixelColor= leftImage.getRGB(i,j);
				img.setRGB(i, j, pixelColor);
			}
			repaint();
			try { Thread.sleep(10); } catch (InterruptedException e) { };
		}
	}
	
	//
	// Transition by diagonals bottom to top left to right
	public void transitionDiagonal45LR(Graphics g, BufferedImage leftImage) {

		int width = leftImage.getWidth();
		int height = leftImage.getHeight();

		if (width > height) {
			// Image with larger width than height		
			for (int row=0; row<height; row++){
				int diagonalRow = row;
				for (int col=0; col<=row; col++) {
					int pixelColor= leftImage.getRGB(col,diagonalRow);
					img.setRGB(col, diagonalRow, pixelColor);
					diagonalRow--;
				}
				repaint();
				try { Thread.sleep(10); } catch (InterruptedException e) { };
			}
			for (int i=0; i<(width-height); i++) {
				int row = height-1;
				int col = i+1;
				for (int j=0; j<height; j++) {
					int pixelColor= leftImage.getRGB(col,row);
					img.setRGB(col, row, pixelColor);
					col++; row--;
				}
				repaint();
				try { Thread.sleep(10); } catch (InterruptedException e) { };
			}
			for (int i=0; i<=(width); i++) {
				int diagonalRow = height-1;
				for (int col=(width-height+i); col<width; col++) {
					int pixelColor= leftImage.getRGB(col,diagonalRow);
					img.setRGB(col, diagonalRow, pixelColor);
					diagonalRow--;
				}
				repaint();
				try { Thread.sleep(10); } catch (InterruptedException e) { };
			}
		}
		else {
			// Lab Q3: Add code to consider image with larger height than width
			for (int row=0; row<width; row++){
				int diagonalRow = row;
				for (int col=0; col<=row; col++) {
					int pixelColor= leftImage.getRGB(col,diagonalRow);
					img.setRGB(col, diagonalRow, pixelColor);
					diagonalRow--;
				}
				repaint();
				try { Thread.sleep(10); } catch (InterruptedException e) { };
			}
			for (int i=0; i<(height-width); i++) {
				int row = width + i;
				int col = 0;
				for (int j=0; j<width; j++) {
					int pixelColor= leftImage.getRGB(col,row);
					img.setRGB(col, row, pixelColor);
					col++; row--;
				}
				repaint();
				try { Thread.sleep(10); } catch (InterruptedException e) { };
			}
			for (int i=0; i<=(height); i++) {
				int diagonalRow = height-1;
				for (int col=i; col<width; col++) {
					int pixelColor= leftImage.getRGB(col,diagonalRow);
					img.setRGB(col, diagonalRow, pixelColor);
					diagonalRow--;
				}
				repaint();
				try { Thread.sleep(10); } catch (InterruptedException e) { };
			}
		}
	}	

	//
	// Populate right frame with random pixel locations
	public void transitionRandom(Graphics g, BufferedImage leftImage){
		List<Integer> pixelList = new ArrayList<Integer>();
		
		int width = leftImage.getWidth();
		int height = leftImage.getHeight();
		int pixelCount = 0;
		
		while (pixelCount < height * width){
				pixelList.add(pixelCount);
				pixelCount ++;
		}
		
		Collections.shuffle(pixelList);	
		
		for (int listIndex = 0; listIndex < (pixelCount * 0.50); listIndex ++){
			int x = pixelList.get(listIndex) % width;
			int y = pixelList.get(listIndex) / width;
			for (int i = 0; i < 5000; i++){	
				int pixelColor = leftImage.getRGB(x, y);
				img.setRGB(x, y, pixelColor);
			}
			repaint();
			try {Thread.sleep(10); } catch (InterruptedException e){}
		}
		
		
	}
}
