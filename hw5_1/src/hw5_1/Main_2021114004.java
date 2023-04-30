package hw5_1;

import java.util.Scanner;

public class Main_2021114004 {
	
	public static void main(String[] args) {
		System.out.println("hw5_1:최다연");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] array = new int[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = input.nextInt();
		}
		System.out.println(array[select(array, 0, n-1, 0)]); //가장 작은 수 반환
		System.out.println(array[select(array, 0, n-1, n/2)]); //중앙값 반환
		System.out.println(array[select(array, 0, n-1, n-1)]); //가장 큰 수 반환
		
		input.close();
	}
	
	//원하는 원소의 위치를 반환하는 함수
	public static int select(int[] array, int p, int r, int i) {
		if(p == r) return array[p]; //원소가 하나 뿐이라면 그 원소 위치를 반환
		
		int q = partition(array, p, r); //q는 기준원소 위치
		int k = q - p + 1; //기준원소가 배열에서 몇 번 째 작은 수인지
		
		if(i < k) return select(array, p, q-1, i); // 왼쪽 분할로 범위를 좁힘
		else if (i == k) return array[q]; // 우리가 찾는 원소
		else return select(array, q+1, r, i-k); // 오른쪽 분할로 범위를 좁힘
		
	}
	
	//기준원소를 기준으로 왼쪽에는 작은 수를 오른 쪽에는 큰 수를 넣어주는 함수
	public static int partition(int[] array, int p, int r) {
		int i = p-1;// i는 작은 원소 부분의 마지막 원소
		for (int j = p; j < r; j++) {//j는 검사하지 않은 원소 중 첫 원소 증가하며 하나씩 기준원소와 비교함
			if (array[j]< array[r]) {//원소가 기준원소보다 작다면
				i++; //i를 증가시켜 큰 원소들 중 첫 원소를 가리키게함
				swap(array, i, j); //i(큰 원소중 첫 원소)와 j의 위치를 바꿈
			}
		}
		swap(array, i+1, r); //기준원소를 큰 원소중 첫 원소와 바꿔 작은 원소와 큰 원소 사이에 넣어줌
		return i+1; //기준원소의 위치 반환
	}
	//두 원소의 위치를 바꾸는 함수
	private static void swap(int[] array, int i, int j) {
		int temp = array[i]; //temp에 i번째 원소를 넣음
		array[i] = array[j]; //i번째 원소 자리에 j번째 원소를 넣음
		array[j] = temp; // j번째 원소 자리에 i였던 temp를 넣음
	}
}