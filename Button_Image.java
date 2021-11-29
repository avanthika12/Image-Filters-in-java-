/*Java Program to Display Image when Button is Clicked*/
import javax.swing.*;
import javax.swing.ImageIcon.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
class Button_Image implements ActionListener
{
	static JFrame frame;
        static JLabel l;
	static String file_loc = " ";
	BufferedImage image,mimg;
 int width;
 int height;
	public static void main(String args[])
	{
		//Create a frame
		frame=new JFrame("Image on Click");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(new FlowLayout());
		l = new JLabel("<html><CENTER>Image Filter Operations</CENTER> <br></html>", SwingConstants.CENTER);
		
		//Create a button
		JButton button1=new JButton("Select");
		JButton button2=new JButton("Display");
		JButton button3=new JButton("Gray");
		JButton button4=new JButton("Red");
		JButton button5=new JButton("Blue");
		JButton button6=new JButton("Green");
		JButton button7=new JButton("Negative");
		JButton button8=new JButton("Mirror");
		JButton button9=new JButton("Sepia");
		frame.add(l);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.add(button6);
		frame.add(button7);
		frame.add(button8);
		frame.add(button9);
		//Create an object
		Button_Image obj=new Button_Image();
		//Associate ActionListener with button
		button1.addActionListener(obj);
		button2.addActionListener(obj);
		button3.addActionListener(obj);
		button4.addActionListener(obj);
		button5.addActionListener(obj);
		button6.addActionListener(obj);
		button7.addActionListener(obj);
		button8.addActionListener(obj);
		button9.addActionListener(obj);
		//Display the frame
		
		frame.setVisible(true);
	}
        //Function to display image
	public void actionPerformed(ActionEvent ae)
	{
		String com = ae.getActionCommand();
		if (com.equals("Select")) {
			// create an object of JFileChooser class
			JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			// invoke the showsOpenDialog function to show the open dialog
			int r = j.showOpenDialog(null);

			// if the user selects a file
			if (r == JFileChooser.APPROVE_OPTION)

			{
				// set the label to the path of the selected file
				
				file_loc = j.getSelectedFile().getAbsolutePath();
				
			}
			// if the user cancelled the operation
			else	
				
				l.setText("the user cancelled the operation");
		}

		else if (com.equals("Display")) {
		ImageIcon icon=new ImageIcon(file_loc);
		JLabel label=new JLabel(icon);
		frame.add(label);
		frame.pack();
		frame.setSize(800,800);
		}
		else if (com.equals("Gray")) {
		try {
  File input = new File(file_loc);
  image = ImageIO.read(input);
  width = image.getWidth();
  height = image.getHeight();
  for(int i=0; i<height; i++) {
   for(int j=0; j<width; j++) {
    Color c = new Color(image.getRGB(j, i));
    int red = (int)(c.getRed() * 0.299);
    int green = (int)(c.getGreen() * 0.587);
    int blue = (int)(c.getBlue() *0.114);
    Color newColor = new Color(red+green+blue,
    red+green+blue,red+green+blue);
    image.setRGB(j,i,newColor.getRGB());
   }
  }
  
 } catch (Exception e) {}	
		

ImageIcon icon=new ImageIcon(image);
		JLabel label=new JLabel(icon);
		frame.add(label);
		frame.pack();
		frame.setSize(800,800);
		}
		else if (com.equals("Red")) {
			try {
	  File input = new File(file_loc);
	  image = ImageIO.read(input);
	  width = image.getWidth();
	  height = image.getHeight();
	  for(int y = 0; y < height; y++){
          for(int x = 0; x < width; x++){
              int p = image.getRGB(x,y);
              
              int a = (p>>24)&0xff;
              int r = (p>>16)&0xff;
              
              //set new RGB
              p = (a<<24) | (r<<16) | (0<<8) | 0;
              
              image.setRGB(x, y, p);
          }
      }
	  
	 } catch (Exception e) {}	
			

	ImageIcon icon=new ImageIcon(image);
			JLabel label=new JLabel(icon);
			frame.add(label);
			frame.pack();
			frame.setSize(500,500);
			}
		else if (com.equals("Blue")) {
			try {
	  File input = new File(file_loc);
	  image = ImageIO.read(input);
	  width = image.getWidth();
	  height = image.getHeight();
	  for(int y = 0; y < height; y++){
          for(int x = 0; x < width; x++){
              int p = image.getRGB(x,y);
              
              int a = (p>>24)&0xff;
              int b = p&0xff;
              
              //set new RGB
              p = (a<<24) | (0<<16) | (0<<8) | b;
              
              image.setRGB(x, y, p);
          }
      }
	  
	 } catch (Exception e) {}	
			

	ImageIcon icon=new ImageIcon(image);
			JLabel label=new JLabel(icon);
			frame.add(label);
			frame.pack();
			frame.setSize(500,500);
			}
		else if (com.equals("Negative")) {
			try {
	  File input = new File(file_loc);
	  image = ImageIO.read(input);
	  width = image.getWidth();
	  height = image.getHeight();
	  for(int y = 0; y < height; y++){
          for(int x = 0; x < width; x++){
              int p = image.getRGB(x,y);
              
              int a = (p>>24)&0xff;
              int r = (p>>16)&0xff;
              int g = (p>>8)&0xff;
              int b = p&0xff;
              
              //subtract RGB from 255
              r = 255 - r;
              g = 255 - g;
              b = 255 - b;
              
              //set new RGB value
              p = (a<<24) | (r<<16) | (g<<8) | b;
              
              image.setRGB(x, y, p);
          }
      }
	  
	 } catch (Exception e) {}	
			

	ImageIcon icon=new ImageIcon(image);
			JLabel label=new JLabel(icon);
			frame.add(label);
			frame.pack();
			frame.setSize(500,500);
			}
		else if (com.equals("Green")) {
			try {
	  File input = new File(file_loc);
	  image = ImageIO.read(input);
	  width = image.getWidth();
	  height = image.getHeight();
	  for(int y = 0; y < height; y++){
          for(int x = 0; x < width; x++){
              int p = image.getRGB(x,y);
              
              int a = (p>>24)&0xff;
              int g = (p>>8)&0xff;
              
              //set new RGB
              p = (a<<24) | (0<<16) | (g<<8) | 0;
              
              image.setRGB(x, y, p);
          }
      }
	  
	 } catch (Exception e) {}	
			

	ImageIcon icon=new ImageIcon(image);
			JLabel label=new JLabel(icon);
			frame.add(label);
			frame.pack();
			frame.setSize(500,500);
			}
		else if (com.equals("Sepia")) {
			try {
	  File input = new File(file_loc);
	  image = ImageIO.read(input);
	  width = image.getWidth();
	  height = image.getHeight();
	  for(int y = 0; y < height; y++){
          for(int x = 0; x < width; x++){
              int p = image.getRGB(x,y);
              
              int a = (p>>24)&0xff;
              int r = (p>>16)&0xff;
              int g = (p>>8)&0xff;
              int b = p&0xff;
              
              //calculate tr, tg, tb
              int tr = (int)(0.393*r + 0.769*g + 0.189*b);
              int tg = (int)(0.349*r + 0.686*g + 0.168*b);
              int tb = (int)(0.272*r + 0.534*g + 0.131*b);
              
              //check condition
              if(tr > 255){
                  r = 255;
              }else{
                  r = tr;
              }
              
              if(tg > 255){
                  g = 255;
              }else{
                  g = tg;
              }
              
              if(tb > 255){
                  b = 255;
              }else{
                  b = tb;
              }
              
              //set new RGB value
              p = (a<<24) | (r<<16) | (g<<8) | b;
              
              image.setRGB(x, y, p);
          }
      }
      
	  
	 } catch (Exception e) {}	
			

	ImageIcon icon=new ImageIcon(image);
			JLabel label=new JLabel(icon);
			frame.add(label);
			frame.pack();
			frame.setSize(500,500);
			}
		else if (com.equals("Mirror")) {
			try {
	  File input = new File(file_loc);
	  image = ImageIO.read(input);
	  width = image.getWidth();
	  height = image.getHeight();
	  BufferedImage mimg = new BufferedImage(width*2, height, BufferedImage.TYPE_INT_ARGB);
      
      //create mirror image pixel by pixel
      for(int y = 0; y < height; y++){
          for(int lx = 0, rx = width*2 - 1; lx < width; lx++, rx--){
              //lx starts from the left side of the image
              //rx starts from the right side of the image
              
              //get source pixel value
              int p = image.getRGB(lx, y);
              
              //set mirror image pixel value - both left and right
              mimg.setRGB(lx, y, p);
              mimg.setRGB(rx, y, p);
          }
      }
      ImageIcon icon=new ImageIcon(mimg);
		JLabel label=new JLabel(icon);
		frame.add(label);
		frame.pack();
		frame.setSize(500,500);
	  
	 } catch (Exception e) {}	
			
			
	
			}
		
	}
}