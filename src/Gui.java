import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledDocument;

import simulator.FireSimulation;
import simulator.MotionSimulation;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Gui extends JFrame {

	private JPanel contentPane;
	public boolean smokeFlag = false;
	public boolean motionFlag = false;
	FireSimulation fire;
	MotionSimulation motion;
	private JButton undoSmoke;
	private JButton undoMotion;
	BufferedReader br;
	private JTextArea textArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void readTxt() {
		ArrayList<String> myList = new ArrayList<>();
	
		String st;
		  try {
			while ((st = br.readLine()) != null) {
				myList.add(st+"\n");
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
		  for(int i = 0; i < myList.size() ; i++) {
			 textArea.append(myList.get(i));
		  }
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		File file = new File("log.txt"); 
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			 br = new BufferedReader(new FileReader(file));
			 
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		 
		

				
		JLabel lblNewLabel = new JLabel("Compound Design Patterns");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 438, 16);
		contentPane.add(lblNewLabel);
		
		JButton smokeTrigger = new JButton("Trigger");
		smokeTrigger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fire = new FireSimulation();
				if(smokeFlag != true) {
					fire.simulate();
					smokeTrigger.setVisible(false);
					undoSmoke.setVisible(true);
					smokeFlag = true;
					readTxt();
				}
				
			}
		});
		smokeTrigger.setBounds(89, 34, 117, 29);
		contentPane.add(smokeTrigger);
		
		JButton motionTrigger = new JButton("Trigger");
		motionTrigger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				motion = new MotionSimulation();
				if(motionFlag != true) {
					motion.simulate();
					motionFlag = true;
					motionTrigger.setVisible(false);
					undoMotion.setVisible(true);
					readTxt();
				}
			}
		});
		motionTrigger.setBounds(89, 64, 117, 29);
		contentPane.add(motionTrigger);
		
		JLabel lblNewLabel_1 = new JLabel("Smoke : ");
		lblNewLabel_1.setBounds(16, 39, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Motion :");
		lblNewLabel_2.setBounds(16, 69, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		undoSmoke = new JButton("Undo");
		undoSmoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(smokeFlag == true) {
					fire.undo();
					smokeFlag = false;
					undoSmoke.setVisible(false);
					smokeTrigger.setVisible(true);
					readTxt();
				}
			}
		});
		
		
		undoSmoke.setBounds(89, 34, 117, 29);
		contentPane.add(undoSmoke);
		
		undoMotion = new JButton("Undo");
		undoMotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(motionFlag == true) {
					motion.undo();
					motionFlag = false;
					undoMotion.setVisible(false);
					motionTrigger.setVisible(true);
					readTxt();
				}
				
			}
		});
		undoMotion.setBounds(89, 64, 117, 29);
		contentPane.add(undoMotion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 96, 658, 247);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		undoSmoke.setVisible(false);
		undoMotion.setVisible(false);

	}
}
