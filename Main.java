import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Main extends JFrame implements ActionListener{
	//nama form
	
	//deklarasi panel
	JPanel northPanel,centerPanel,southPanel;
	JLabel labels[]= {
			new JLabel("Registrasi"),
			new JLabel("Full Name"),
			new JLabel("Email"),
			new JLabel("Password"),
			new JLabel("Age"),
			new JLabel("Gender"),
			new JLabel("Address"),
			new JLabel("Member")
	};
	JTextField textFields[]= new JTextField[7];
	JTextArea txtAddress;
	JPasswordField txtPassword;
	JRadioButton rbMale, rbFemale;
	ButtonGroup bgGender;  
	JComboBox cbMember;
	String members[]= {
			"Silver","Gold","Diamond","Platinum"
			};
	JButton buttons[] =
		{
				new JButton("Register"),
				new JButton("Reset")
		};
	
	void Components()
	{
		northPanel = new JPanel();
		centerPanel = new JPanel(null);
		southPanel = new JPanel();
		
		northPanel.setBackground(Color.CYAN);
		centerPanel.setBackground(Color.LIGHT_GRAY);
		southPanel.setBackground(Color.YELLOW);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		north();
		center();
		south();
	}
	
	void north()
	{
		northPanel.add(labels[0]);
		labels[0].setFont(new Font("Arial", Font.BOLD, 24));
	}
	void center()
	{
		centerPanel.add(labels[1]);
		labels[1].setBounds(20, 80, 150, 30);
		centerPanel.add(textFields[0]);
		textFields[0].setBounds(150,80,150,30);
		
		centerPanel.add(labels[2]);
		labels[2].setBounds(20, 120, 150, 30);
		centerPanel.add(textFields[1]);
		textFields[1].setBounds(150,120,150,30);
		
		centerPanel.add(labels[3]);
		labels[3].setBounds(20, 160, 150, 30);
		txtPassword = new JPasswordField();
		txtPassword.setBounds(150, 160, 150, 30);
		centerPanel.add(txtPassword);
		
		centerPanel.add(labels[4]);
		labels[4].setBounds(20, 200, 150, 30);
		centerPanel.add(textFields[3]);
		textFields[3].setBounds(150,200,150,30);
		
		centerPanel.add(labels[5]);
		labels[5].setBounds(20, 240, 150, 30);
		rbMale = new JRadioButton("Male");
		rbFemale = new JRadioButton("Female");
		centerPanel.add(rbMale);
		rbMale.setBounds(150,240,70,30);
		centerPanel.add(rbFemale);
		rbFemale.setBounds(225,240,75,30);
		//biar gak kepilih dua duanya jadi hanya bisa salah satu
		bgGender = new ButtonGroup();
		bgGender.add(rbFemale);
		bgGender.add(rbMale);
		
		centerPanel.add(labels[6]);
		labels[6].setBounds(20, 280, 150, 30);
		txtAddress = new JTextArea();
		centerPanel.add(txtAddress);
		txtAddress.setBounds(150,280,150,50);
		
		centerPanel.add(labels[7]);
		labels[7].setBounds(20, 340, 150, 30);
		cbMember = new JComboBox(members);
		centerPanel.add(cbMember);
		cbMember.setBounds(150,340,150,30);
	}
	void south()
	{
		southPanel.setLayout(new FlowLayout());
		for(int i = 0;i<buttons.length;i++)
		{
			southPanel.add(buttons[i]);
		}
		buttons[0].addActionListener(this);
		buttons[1].addActionListener(this);
		//Alt+leftClick
		//Cara pertama tanpa implements ActionListener
//		buttons[0].addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
//				//menit ke 38:10
//				String fullName, email, age, password, address, gender, member;
//				fullName = textFields[0].getText().toString();
//				email = textFields[1].getText().toString();
//				age = textFields[3].getText().toString();
//				password = txtPassword.getText().toString();
//				address = txtAddress.getText().toString();
//				if(rbMale.isSelected())
//				{
//					gender = "Male";
//				}
//				else
//				{
//					gender = "Female";
//				}
//				member = cbMember.getSelectedItem().toString();
//				JOptionPane.showMessageDialog(null, "Your Account" + "\n"
//						+ "Full Name : " + fullName +"\n"
//						+ "Email	 : " + email + "\n"
//						+ "Password  : " + password + "\n"
//						+ "Age		 : " + age + "\n"
//						+ "Gender	 : " + gender + "\n"
//						+ "Member	 : " + member + "\n");
//			}
//		});
//		buttons[1].addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				textFields[0].setText(null);
//				textFields[1].setText(null);
//				txtPassword.setText(null);
//				textFields[3].setText(null);
//				txtAddress.setText(null);
//				bgGender.clearSelection();
//				cbMember.setSelectedIndex(0);
//			}
//		});
	}
	
	public Main()
	{
		//beri nama form
		this.setTitle("Form Registrasi");
		//container
		setVisible(true);
		for(int i = 0;i<textFields.length;i++)
		{
			textFields[i] = new JTextField();
		}
		setLayout(new BorderLayout());
		Components();
		setSize(400, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Register"))
		{
			String fullName, email, age, password, address, gender, member;
			fullName = textFields[0].getText().toString();
			email = textFields[1].getText().toString();
			age = textFields[3].getText().toString();
			password = txtPassword.getText().toString();
			address = txtAddress.getText().toString();
			if(rbMale.isSelected())
			{
				gender = "Male";
			}
			if(rbFemale.isSelected())
			{
				gender = "Female";
			}
			else
			{
				gender= "";
			}
			member = cbMember.getSelectedItem().toString();
			JOptionPane.showMessageDialog(null, "Your Account" + "\n"
					+ "Full Name : " + fullName +"\n"
					+ "Email	 : " + email + "\n"
					+ "Password  : " + password + "\n"
					+ "Age		 : " + age + "\n"
					+ "Gender	 : " + gender + "\n"
					+ "Member	 : " + member + "\n");
		}
		if(e.getActionCommand().equals("Reset"))
		{
			textFields[0].setText(null);
			textFields[1].setText(null);
			txtPassword.setText(null);
			textFields[3].setText(null);
			txtAddress.setText(null);
			bgGender.clearSelection();
			cbMember.setSelectedIndex(0);
		}
		
	}

}
