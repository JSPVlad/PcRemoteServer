import java.io.*;
import java.awt.Robot;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.imageio.ImageIO;


public class Main_Capture{
	public static void main(String[] args){
		try{
			Robot robot = new Robot();
			Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			while(true){
				BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
				byte[] bytearr = byteArrayOutputStream.toByteArray();
				BufferedImage second = ImageIO.read(new ByteArrayInputStream(bytearr));
				File file = new File("screen-capture.png");
				boolean status = ImageIO.write(second, "png", file);
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				System.out.println(screenSize);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}