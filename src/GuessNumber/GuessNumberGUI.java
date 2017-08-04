package GuessNumber;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class GuessNumberGUI extends JFrame {
	
	private static final long serialVersionUID = 3032156620755941716L;
	private final int MAXCOUNT=10;
	private final static int MAXUSER=5;
	
	private JTextField inputTxt;
	private JTextField dispTxt;		//��ʾ��ʾ
	private JTextField dispTxt2;	//��ʾ����
	private JTextField dispTxt3;	//��ʾ�ɼ�
	private JButton cgButton;
	private JButton okButton;
	private JButton rankBtn;
	private JLabel theName; 
	private int randomNum; // ��������������
	private static int count;// ���Դ���
	private static int userNum=0;
	private static User[] ranklist=new User[MAXUSER];

	public GuessNumberGUI() {
		super("Guess Number Game");
		
		resetUser();
		initComponent();
		restartGame();
		componentAddListener();
		
	}
	
	private void resetUser(){
		userNum++;
		if(userNum>MAXUSER){
			JOptionPane.showConfirmDialog (null, "�û������Ѵ����ޣ����а���գ�", 
					"������ʾ",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
			userNum=1;
			for(int i=0;i<MAXUSER;i++){
				ranklist[i]=null;
			}
		}
		String userName = JOptionPane.showInputDialog("�������û���","�û�"+userNum); 
		if(userName.equals("")){
			userName="�û�"+userNum;
		}
		ranklist[userNum-1]=new User();
		ranklist[userNum-1].setUserName(userName);
		count=0;
	}
	
	private void restartGame(){
		randomNum = generateRandomNum();
		count=0;
		System.out.println("Construtor=" + randomNum);
		this.dispTxt.setText("��ʾ���");
		this.dispTxt2.setText("��ʾ����");
		this.dispTxt3.setText("��ʾ����");
		this.inputTxt.setText("");
		this.theName.setText(ranklist[userNum-1].getUserName());
	}

	private int generateRandomNum() {
		int a, b, c, d;
		Random gener = new Random();
		a = gener.nextInt(10);
		while (a == 0) {
			a = gener.nextInt(10);
		}
		b = gener.nextInt(10);
		while (b == a) {
			b = gener.nextInt(10);
		}
		c = gener.nextInt(10);
		while (c == b || c == a) {
			c = gener.nextInt(10);
		}
		d = gener.nextInt(10);
		while (d == c || d == b || d == a) {
			d = gener.nextInt(10);
		}
		String str = Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d);
		int guessNum = Integer.parseInt(str);
		return guessNum;
	}

	private void initComponent() {
		setLayout(new FlowLayout());
		this.theName=new JLabel();
		this.inputTxt = new JTextField();
		this.dispTxt = new JTextField();
		this.dispTxt2 = new JTextField();
		this.dispTxt3 = new JTextField();
		this.okButton = new JButton("ȷ��");
		this.cgButton=new JButton("�л��û�");
		this.rankBtn = new JButton("���а�");
		this.inputTxt.setColumns(6);
		this.dispTxt.setColumns(6);
		this.dispTxt2.setColumns(6);
		this.dispTxt3.setColumns(6);

		add(theName);
		add(inputTxt);
		add(dispTxt);
		add(dispTxt2);
		add(dispTxt3);
		add(okButton);
		add(cgButton);
		add(rankBtn);
		pack();
	}

	private void componentAddListener() {

		this.okButton.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				String input = inputTxt.getText();
				generateNumber(input);
			}
		});

		this.cgButton.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				resetUser();
				restartGame();
			}
		});

		this.rankBtn.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				System.out.println("���а�");
				StringBuilder str=new StringBuilder();
				for(int i=0;i<userNum-1;i++){
					for(int j=i+1;j<userNum;j++){
						if(ranklist[j].getAvg()>ranklist[i].getAvg()){
							User temp=ranklist[i];
							ranklist[i]=ranklist[j];
							ranklist[j]=temp;
						}
					}
				}
				
				for(int i=0;i<userNum;i++){
					if(ranklist[i]!=null){
						str.append((i+1)+"�� "+ranklist[i]+"\n");
					}
				}
				String rankinfo=str.toString();
				JOptionPane.showMessageDialog(null, rankinfo, "ranklist", JOptionPane.PLAIN_MESSAGE);
											
			}
		});
	}

	private void generateNumber(String input) {

		if ("".equals(input) || input == null) {

			JOptionPane.showMessageDialog(this, "����������");
			return;
		}
		
		if (Integer.parseInt(input)>9999||Integer.parseInt(input)<1000) {

			JOptionPane.showMessageDialog(this, "������Ϸ�����λ����");
			return;
		}
		

		String result = "";
		int aCnt = 0;
		int bCnt = 0;

		String randNumStr = String.valueOf(this.randomNum);
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			for (int j = 0; j < randNumStr.length(); j++) {
				char jch = randNumStr.charAt(j);
				if (jch == ch) {
					bCnt++;
					if (i == j) {
						aCnt++;
						bCnt--;
					}
				}
			}
		}
		count++;
		int score=MAXCOUNT+1-count;

		result += aCnt + "A" + bCnt + "B";
		System.out.println(result);
		dispTxt.setText(result);
		dispTxt2.setText("������"+count+"��");
		dispTxt3.setText(score+"��");
		
		
		if(aCnt==4){
			JOptionPane.showConfirmDialog (null, "��ϲ�㣬��¶��� !"+"��һ������"+count+"�Σ����ֳɼ�Ϊ"+score+"�֣�", 
					"������ʾ",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showConfirmDialog (null, "��һ����Ϸ��", 
					"������ʾ",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
			ranklist[userNum-1].setRounds(ranklist[userNum-1].getRounds()+1);
			ranklist[userNum-1].setTotal(ranklist[userNum-1].getTotal()+score);
			System.out.println(ranklist[userNum-1].getAvg());
			restartGame();
			
		}
		else if(count==MAXCOUNT){
			JOptionPane.showConfirmDialog (null, "���ź������Ѿ��ù������еĻ���!��ȷ��Ϊ"+randomNum+"!", 
					 "������ʾ",JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			JOptionPane.showConfirmDialog (null, "��Ϸ�Ѿ����ã�", 
					"������ʾ",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
			ranklist[userNum-1].setRounds(ranklist[userNum-1].getRounds()+1);
			ranklist[userNum-1].setTotal(ranklist[userNum-1].getTotal()+score-1);
			System.out.println(ranklist[userNum-1].getAvg());
			restartGame();		
			}
		else{
			JOptionPane.showConfirmDialog (null, "���Ѿ�������"+count+"�Σ�����"+(MAXCOUNT-count)+"�λ��ᣡ", 
					 "������ʾ",JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
		}
	}

	public void showMe() {
		setLocation(500, 500);
		setVisible(true);
		setSize(1000,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ����������

	public static void main(String[] args) {

		new GuessNumberGUI().showMe();

	}

}
