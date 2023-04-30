package hw6_1;

import java.util.Scanner;

public class Main_202114004 {
	public static void main(String[] args) {
		System.out.println("lab6_1:최다연");

// (1) 정수 키값을 저장할 공백 이진검색트리 tree를 생성
		MyBinarySearchTree tree = new MyBinarySearchTree();

// (2) 사용자가 원하는 갯수의 정수 키값을 입력받아 tree에 삽입한 후, tree 출력
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			tree.add(input.nextInt()); //입력 받은 키 값을 트리에 삽입
		}
		System.out.println(tree); //출력

// (3) 정수 키값 x, y, z를 입력받아 각각 트리에 있는지 여부를 출력
		int x = input.nextInt();
		int y = input.nextInt();
		int z = input.nextInt();
		//키 값이 트리에 있는가
		System.out.println(tree.contains(x) + " " + tree.contains(y) + " " + tree.contains(z));
		
		tree.removeMax(); //최댓값 삭제
		System.out.println(tree); //트리 출력
		
		input.close();
	}
}

// 정수 키값을 갖는 이진검색트리를 구현하는 클래스
class MyBinarySearchTree {
// 루트 노드를 가리키는 인스턴스 변수 root (알고리즘 연습을 위해 root만 둘 것)
	private Node root = null;

// 노드의 구조를 정의하는 클래스 Node (알고리즘 연습을 위해 노드에 key, left, right 필드만 둘 것)
	private class Node {
		int key;
		Node left;
		Node right;
	}

// 키 값을 매개변수로 받아 그 키값이 존재하는지 여부(true/false)를 리턴
	public boolean contains(int n) {
		Node t = root;
		while(t != null) { //t가 null이 아닐 때까지 순회
			if(t.key == n) { //찾으면
				return true; //true
			}
			else if(t.key > n) t = t.left; //찾으려는 값이 루트보다 작으면 왼쪽으로
			else t = t.right; //찾으려는 값이 루트보다 크면 오른쪽으로
		}
		return false; //없으면 false
	}

// 매개변수로 받은 키값을 트리에 삽입
	public void add(int key) {
		root = treeInsert(root, key); //재귀적으로 삽입
	}

// t를 루트로 하는 트리에 key를 삽입하고, 삽입 후 루트 노드를 리턴하는 재귀 메소드
	private Node treeInsert(Node t, int key) {
		if(t == null) { //빈 트리일 경우
			Node r = new Node(); //노드 새로 생성
			r.key = key;
			return r;
		}
		else if(key < t.key) { //삽입할 값이 현재 노드보다 작을 경우
			t.left = treeInsert(t.left, key); //왼쪽으로 이동
			return t;
		}
		else if(key > t.key) { //클 경우
			t.right = treeInsert(t.right, key); //오른쪽으로 이동
			return t;
		}
		else {
			return t;  // 이미 존재하는 키값인 경우 삽입하지 않음
		}
	}
	//최댓값 삭제
	public void removeMax() {
		if (root == null) return; //root가 null일 경우 바로 리턴
		
		Node rootNext = root;
		Node parent = null;
		while (rootNext.right != null) { //오른쪽 자식이 null이 아닐 때까지
			parent = rootNext; 
			rootNext = rootNext.right; //오른 쪽으로 계속 내려감
		}
		
		if (parent == null) { //가장 오른쪽 노드가 루트 노드일 경우
			root = rootNext.left; // 루트노드를 그 노드의 왼쪽 자식으로 변경
		}
		else {
		parent.right = rootNext.left; } // 그 외에는 오른쪽 자식을 노드의 왼쪽 자식으로 변경
	}
	
// 트리의 키값들을 중순위 순회하여 오름차순으로 나열한 하나의 문자열을 만들어 리턴
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer("tree = "); //스트링버퍼 생성
		if(root != null) {
			inorder(result, root); //중순위순회
		}
		return result.toString();
	}

// t를 루트로 하는 트리를 중순위 순회
	private void inorder(StringBuffer result, Node t) {
		if(t != null) {
			inorder(result, t.left); //왼쪽 순회
			result.append(t.key + " "); //현재 노드값을 문자열에 추가
			inorder(result, t.right);// 오른쪽 순회
		}
	}
}
