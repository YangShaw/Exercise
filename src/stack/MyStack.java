package stack;

public class MyStack {
	int[] data;
	int size;

	public MyStack(int i) {
		data = new int[i];
		size = 0;
	}

	public void push(int t) {
		data[size] = t;
		size++;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int pop() {
		if (!isEmpty()) {
			int t = data[size - 1];
			data[size - 1] = 0;
			size--;
			return t;
		} else {
			System.out.println("Empty stack!");
			return 0;
		}
	}

	public void print() {
		if (!isEmpty()) {
			for (int i = size - 1; i >= 0; i--) {
				System.out.println(data[i]);
			}
		}
		else
			System.out.println("Empty stack!");
	}

}
