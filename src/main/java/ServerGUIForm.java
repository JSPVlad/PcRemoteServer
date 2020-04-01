import javax.swing.*;

public class ServerGUIForm extends JFrame{
    private JPanel ServerGUIPanel;
    private JButton SampleButton;

    public  ServerGUIForm(){
        add(ServerGUIPanel);
        add(SampleButton);
        setTitle("Sample Title");
        setSize(400,500);
    }

    public static void main(String[] args) {
        ServerGUIForm serverGUIForm = new ServerGUIForm();
        serverGUIForm.setContentPane(serverGUIForm.ServerGUIPanel);
        serverGUIForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serverGUIForm.pack();
        serverGUIForm.setVisible(true);
    }
}
