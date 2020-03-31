import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Socket_Handler extends Thread {
	private Socket socket;
	private Robot robot;
	private Rectangle rectangle;

	Socket_Handler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			robot = new Robot();
			rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			while (true) {
				BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
				byte[] image_byte_arr = byteArrayOutputStream.toByteArray();
                objectOutputStream.writeObject(image_byte_arr);
            }
		} catch (AWTException | IOException e) {
			e.printStackTrace();
		}
	}
}
