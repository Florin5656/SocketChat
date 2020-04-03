import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.client_frame;
import Server.server_frame;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldServer;
	private JTextField textFieldClient;
	private JTextPane commandPane ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	int numClient = 0 , numServer = 0;
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnServer = new JButton("Start Server GUI");
		btnServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (numServer == 0 ) {
				 new server_frame().setVisible(true);
				 numServer = numServer+1;
				 setTextServer("Started");
				 }else {
				
					 commandPane.setForeground(Color.red);
					 commandPane.setText("Server is started");
				 }
			}
		});
		btnServer.setBounds(196, 56, 154, 23);
		contentPane.add(btnServer);
	
		JButton btnClient = new JButton("Start New Client GUI");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new client_frame().setVisible(true);
				numClient = numClient + 1;
				 setTextClient("Client: "+ numClient);
				 commandPane.setText("Client " + numClient +" : Conected" );
			}
		});
		btnClient.setBounds(196, 130, 154, 23);
		contentPane.add(btnClient);
		
		textFieldServer = new JTextField();
		textFieldServer.setEditable(false);
		textFieldServer.setBounds(39, 57, 121, 20);
		contentPane.add(textFieldServer);
		textFieldServer.setColumns(10);
		textFieldServer.setText("Not Started");
		
		textFieldClient = new JTextField();
		textFieldClient.setEditable(false);
		textFieldClient.setBounds(39, 131, 121, 20);
		contentPane.add(textFieldClient);
		textFieldClient.setColumns(10);
		textFieldClient.setText("Client: 0");
		
	    commandPane = new JTextPane();
		commandPane.setEditable(false);
		commandPane.setBounds(10, 164, 414, 86);
		contentPane.add(commandPane);
		commandPane.setText("Info...");
	}
	
	public void setTextServer(String s ) {
		textFieldServer.setText(s);
	}
	
	public void setTextClient(String s ) {
		textFieldClient.setText(s);
	}
	
	public void setCommand(String s ) {
		commandPane.setText(s);
	}
	
}
