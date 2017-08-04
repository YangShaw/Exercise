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
	private JTextField dispTxt;		//显示提示
	private JTextField dispTxt2;	//显示次数
	private JTextField dispTxt3;	//显示成绩
	private JButton cgButton;
	private JButton okButton;
	private JButton rankBtn;
	private JLabel theName; 
	private int randomNum; // 随机产生的随机数
	private static int count;// 尝试次数
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
			JOptionPane.showConfirmDialog (null, "用户人数已达上限！排行榜清空！", 
					"友情提示",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
			userNum=1;
			for(int i=0;i<MAXUSER;i++){
				ranklist[i]=null;
			}
		}
		String userName = JOptionPane.showInputDialog("请输入用户名","用户"+userNum); 
		if(userName.equals("")){
			userName="用户"+userNum;
		}
		ranklist[userNum-1]=new User();
		ranklist[userNum-1].setUserName(userName);
		count=0;
	}
	
	private void restartGame(){
		randomNum = generateRandomNum();
		count=0;
		System.out.println("Construtor=" + randomNum);
		this.dispTxt.setText("显示结果");
		this.dispTxt2.setText("显示次数");
		this.dispTxt3.setText("显示分数");
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
		this.okButton = new JButton("确定");
		this.cgButton=new JButton("切换用户");
		this.rankBtn = new JButton("排行榜");
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

				System.out.println("排行榜");
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
						str.append((i+1)+"、 "+ranklist[i]+"\n");
					}
				}
				String rankinfo=str.toString();
				JOptionPane.showMessageDialog(null, rankinfo, "ranklist", JOptionPane.PLAIN_MESSAGE);
											
			}
		});
	}

	private void generateNumber(String input) {

		if ("".equals(input) || input == null) {

			JOptionPane.showMessageDialog(this, "请输入数字");
			return;
		}
		
		if (Integer.parseInt(input)>9999||Integer.parseInt(input)<1000) {

			JOptionPane.showMessageDialog(this, "请输入合法的四位数！");
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
		dispTxt2.setText("尝试了"+count+"次");
		dispTxt3.setText(score+"分");
		
		
		if(aCnt==4){
			JOptionPane.showConfirmDialog (null, "恭喜你，你猜对了 !"+"你一共猜了"+count+"次，本轮成绩为"+score+"分！", 
					"友情提示",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showConfirmDialog (null, "下一轮游戏！", 
					"友情提示",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
			ranklist[userNum-1].setRounds(ranklist[userNum-1].getRounds()+1);
			ranklist[userNum-1].setTotal(ranklist[userNum-1].getTotal()+score);
			System.out.println(ranklist[userNum-1].getAvg());
			restartGame();
			
		}
		else if(count==MAXCOUNT){
			JOptionPane.showConfirmDialog (null, "很遗憾，你已经用光了所有的机会!正确答案为"+randomNum+"!", 
					 "友情提示",JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			JOptionPane.showConfirmDialog (null, "游戏已经重置！", 
					"友情提示",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
			ranklist[userNum-1].setRounds(ranklist[userNum-1].getRounds()+1);
			ranklist[userNum-1].setTotal(ranklist[userNum-1].getTotal()+score-1);
			System.out.println(ranklist[userNum-1].getAvg());
			restartGame();		
			}
		else{
			JOptionPane.showConfirmDialog (null, "你已经尝试了"+count+"次，还有"+(MAXCOUNT-count)+"次机会！", 
					 "友情提示",JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
		}
	}

	public void showMe() {
		setLocation(500, 500);
		setVisible(true);
		setSize(1000,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 运行主函数

	public static void main(String[] args) {

		new GuessNumberGUI().showMe();

	}

}
