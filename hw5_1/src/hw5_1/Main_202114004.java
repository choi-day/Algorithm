package hw5_1;

import java.util.Scanner;

public class Main_202114004 {
	
	public static void main(String[] args) {
		System.out.println("hw5_1:�ִٿ�");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] array = new int[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = input.nextInt();
		}
		System.out.println(array[select(array, 0, n-1, 1)]); //���� ���� �� ��ȯ
		System.out.println(array[select(array, 0, n-1, n/2)]); //�߾Ӱ� ��ȯ
		System.out.println(array[select(array, 0, n-1, n)]); //���� ū �� ��ȯ
		
		input.close();
	}
	
	//���ϴ� ������ ��ġ�� ��ȯ�ϴ� �Լ�
	public static int select(int[] array, int p, int r, int i) {
		if(p == r) return array[p]; //���Ұ� �ϳ� ���̶�� �� ���� ��ġ�� ��ȯ

		int q = partition(array, p, r); //q�� ���ؿ��� ��ġ
		int k = q - p + 1; //���ؿ��Ұ� �迭���� �� �� ° ���� ������
		
		if(i < k) return select(array, p, q-1, i); // ���� ���ҷ� ������ ����
		else if (i == k) return array[q]; // �츮�� ã�� ����
		else return select(array, q+1, r, i-k); // ������ ���ҷ� ������ ����
	}
	
	//���ؿ��Ҹ� �������� ���ʿ��� ���� ���� ���� �ʿ��� ū ���� �־��ִ� �Լ�
	public static int partition(int[] array, int p, int r) {
		int i = p-1;// i�� ���� ���� �κ��� ������ ����
		for (int j = p; j < r; j++) {//j�� �˻����� ���� ���� �� ù ���� �����ϸ� �ϳ��� ���ؿ��ҿ� ����
			if (array[j]< array[r]) {//���Ұ� ���ؿ��Һ��� �۴ٸ�
				i++; //i�� �������� ū ���ҵ� �� ù ���Ҹ� ����Ű����
				swap(array, i, j); //i(ū ������ ù ����)�� j�� ��ġ�� �ٲ�
			}
		}
		swap(array, i+1, r); //���ؿ��Ҹ� ū ������ ù ���ҿ� �ٲ� ���� ���ҿ� ū ���� ���̿� �־���
		return i+1; //���ؿ����� ��ġ ��ȯ
	}
	//�� ������ ��ġ�� �ٲٴ� �Լ�
	private static void swap(int[] array, int i, int j) {
		int temp = array[i]; //temp�� i��° ���Ҹ� ����
		array[i] = array[j]; //i��° ���� �ڸ��� j��° ���Ҹ� ����
		array[j] = temp; // j��° ���� �ڸ��� i���� temp�� ����
	}
}