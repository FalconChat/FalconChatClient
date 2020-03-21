package falconchat;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class ImageLoadingTutorial extends Applet //Applet are drawn to the screen using paint method.
{ //Applet: Java program that can be embedded into a web page
	
	private Image interfac = null;
	
	public void paint(Graphics g)  //lets create a paint method
	{
		this.setSize(1280,720);
		
		if (interfac == null) //not assigned an image
		{
			interfac = getImage("interfac.png");
		}
		Graphics2D g2 = (Graphics2D)g; //cast Graphics g object to Graphics2D object g2.
		g2.drawImage(interfac, 25, 50, 1280, 720, this); //Parameters: (Image img, int x, int y, int width, int height, ImageObserver observer)
	}	
	
	//creating a new method that loads image from file system
	public Image getImage(String path) //this method gets the image from file system and return the image object
	{
		Image tempImage = null; //Image Tracker
		try //Catch for possibility image does not exist
		{
			URL imageURL = ImageLoadingTutorial.class.getResource(path); //store URL of image
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL); //using the java default kit to convert URL -> IMAGE
		}
		catch (Exception e)
		{
			System.out.println("An error occured - " + e.getMessage());
		}
		return tempImage;
	}
}
