package lab8_1;

public class Main_202114004 {
	public static void main(String[] args) {
		System.out.println("lab8_1 : �ִٿ�");

// ��ȣ��Ÿ�� ������ �����ϴ� MyDisjointSet ��ü�� �����ϰ� �׽�Ʈ ������ ����
		MyDisjointSet set = new MyDisjointSet();
		set.test();
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
		return 0;
	}

// x�� ���� ���հ� y�� ���� ������ ��ħ - lab8_1������ �������� ����
	public void union(int x, int y) {
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
}