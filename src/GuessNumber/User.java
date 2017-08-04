package GuessNumber;

public class User {
	private int rounds;
	private double total;
	private String userName;
	private double avg;
	
	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
		this.avg=total/rounds;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public User(){
		rounds=0;
		userName=null;
		avg=0;
		total=0;
	}

	@Override
	public String toString() {
		return " 用户名：" + userName +", 游戏回合数：" + rounds + ", 总分：" + total +  ", 平均分：" + avg;
	}

}
