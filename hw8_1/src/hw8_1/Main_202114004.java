package hw8_1;

public class Main_202114004 {
	public static void main(String[] args) {
		System.out.println("lab8_1 : 최다연");

// 상호배타적 집합을 구현하는 MyDisjointSet 객체를 생성하고 테스트 연산을 수행
		MyDisjointSet set = new MyDisjointSet();
		set.test();  //트리 만들기
		set.union(0, 1); //0에 1 합치기
		set.union(2, 0); //2에 0이 속한 집합 합치기
		set.union(3, 2); //3에 2이 속한 집합 합치기
		set.union(4, 3); //4에 3이 속한 집합 합치기
		set.union(5, 6); //5에 6이 속한 집합 합치기
		set.union(7, 8); //7에 8이 속한 집합 합치기
		set.union(5, 7); //5에 7이 속한 집합 합치기
		set.printSet(); //부모 출력
		System.out.print("\n대표노드 = ");
		for(int i = 0; i < 10; i++) { //대표노드 출력
			System.out.print(set.findSet(i)+ " ");
		}
		set.printSet(); //부모 출력
	}
}

// 트리를 이용하여 상호배타적 집합을 구현하는 클래스
class MyDisjointSet {
	private int n = 10; // 원소 개수(원소는 0, 1, 2, ..., n-1)

// private 인스턴스 변수 선언 - 트리 구현을 위한 자료구조
	private int[] parent;

	public MyDisjointSet() { // 트리 구현을 위해 필요한 자료구조를 초기화
		parent = new int[n];
	}

// 하나의 원소 x로 구성된 집합 생성
	public void makeSet(int x) {
		parent[x] = x;
	}

// x의 대표 원소를 알아냄 - lab8_1에서는 구현하지 않음
	public int findSet(int x) {
		if (x != parent[x]) parent[x] = findSet(parent[x]); //x가 루트가 아니면 부모의 루트를 찾아 x의 루트로 삼음
		return parent[x]; //맞으면 x 반환
	}

// x가 속한 집합과 y가 속한 집합을 합침 - lab8_1에서는 구현하지 않음
	public void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}

	public void test() {// 트리 구현을 테스트하기 위한 연산 수행
		// 각 원소(0, 1, 2, ..., 9)마다 하나의 노드로 구성된 집합 생성(makeSet) - 총 10개의 집합 생성
		for(int i = 0; i < n; i++) {
			makeSet(i);
		}
		// 트리 구현이 제대로 되었는지 확인하기 위해 각 노드의 부모를 출력
		System.out.print("부모 =");
		
		for(int i = 0; i < n; i++) {
			System.out.print(" " + parent[i]);
		}
	}
	public void printSet() { //부모 출력
		System.out.print("\n부모 =");
		
		for(int i = 0; i < n; i++) {
			System.out.print(" " + parent[i]);
		}
	}
}