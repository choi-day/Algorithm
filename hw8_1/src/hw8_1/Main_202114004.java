package hw8_1;

public class Main_202114004 {
	public static void main(String[] args) {
		System.out.println("lab8_1 : �ִٿ�");

// ��ȣ��Ÿ�� ������ �����ϴ� MyDisjointSet ��ü�� �����ϰ� �׽�Ʈ ������ ����
		MyDisjointSet set = new MyDisjointSet();
		set.test();  //Ʈ�� �����
		set.union(0, 1); //0�� 1 ��ġ��
		set.union(2, 0); //2�� 0�� ���� ���� ��ġ��
		set.union(3, 2); //3�� 2�� ���� ���� ��ġ��
		set.union(4, 3); //4�� 3�� ���� ���� ��ġ��
		set.union(5, 6); //5�� 6�� ���� ���� ��ġ��
		set.union(7, 8); //7�� 8�� ���� ���� ��ġ��
		set.union(5, 7); //5�� 7�� ���� ���� ��ġ��
		set.printSet(); //�θ� ���
		System.out.print("\n��ǥ��� = ");
		for(int i = 0; i < 10; i++) { //��ǥ��� ���
			System.out.print(set.findSet(i)+ " ");
		}
		set.printSet(); //�θ� ���
	}
}

// Ʈ���� �̿��Ͽ� ��ȣ��Ÿ�� ������ �����ϴ� Ŭ����
class MyDisjointSet {
	private int n = 10; // ���� ����(���Ҵ� 0, 1, 2, ..., n-1)

// private �ν��Ͻ� ���� ���� - Ʈ�� ������ ���� �ڷᱸ��
	private int[] parent;

	public MyDisjointSet() { // Ʈ�� ������ ���� �ʿ��� �ڷᱸ���� �ʱ�ȭ
		parent = new int[n];
	}

// �ϳ��� ���� x�� ������ ���� ����
	public void makeSet(int x) {
		parent[x] = x;
	}

// x�� ��ǥ ���Ҹ� �˾Ƴ� - lab8_1������ �������� ����
	public int findSet(int x) {
		if (x != parent[x]) parent[x] = findSet(parent[x]); //x�� ��Ʈ�� �ƴϸ� �θ��� ��Ʈ�� ã�� x�� ��Ʈ�� ����
		return parent[x]; //������ x ��ȯ
	}

// x�� ���� ���հ� y�� ���� ������ ��ħ - lab8_1������ �������� ����
	public void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}

	public void test() {// Ʈ�� ������ �׽�Ʈ�ϱ� ���� ���� ����
		// �� ����(0, 1, 2, ..., 9)���� �ϳ��� ���� ������ ���� ����(makeSet) - �� 10���� ���� ����
		for(int i = 0; i < n; i++) {
			makeSet(i);
		}
		// Ʈ�� ������ ����� �Ǿ����� Ȯ���ϱ� ���� �� ����� �θ� ���
		System.out.print("�θ� =");
		
		for(int i = 0; i < n; i++) {
			System.out.print(" " + parent[i]);
		}
	}
	public void printSet() { //�θ� ���
		System.out.print("\n�θ� =");
		
		for(int i = 0; i < n; i++) {
			System.out.print(" " + parent[i]);
		}
	}
}