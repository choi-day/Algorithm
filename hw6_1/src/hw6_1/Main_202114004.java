package hw6_1;

import java.util.Scanner;

public class Main_202114004 {
	public static void main(String[] args) {
		System.out.println("lab6_1:�ִٿ�");

// (1) ���� Ű���� ������ ���� �����˻�Ʈ�� tree�� ����
		MyBinarySearchTree tree = new MyBinarySearchTree();

// (2) ����ڰ� ���ϴ� ������ ���� Ű���� �Է¹޾� tree�� ������ ��, tree ���
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			tree.add(input.nextInt()); //�Է� ���� Ű ���� Ʈ���� ����
		}
		System.out.println(tree); //���

// (3) ���� Ű�� x, y, z�� �Է¹޾� ���� Ʈ���� �ִ��� ���θ� ���
		int x = input.nextInt();
		int y = input.nextInt();
		int z = input.nextInt();
		//Ű ���� Ʈ���� �ִ°�
		System.out.println(tree.contains(x) + " " + tree.contains(y) + " " + tree.contains(z));
		
		tree.removeMax(); //�ִ� ����
		System.out.println(tree); //Ʈ�� ���
		
		input.close();
	}
}

// ���� Ű���� ���� �����˻�Ʈ���� �����ϴ� Ŭ����
class MyBinarySearchTree {
// ��Ʈ ��带 ����Ű�� �ν��Ͻ� ���� root (�˰��� ������ ���� root�� �� ��)
	private Node root = null;

// ����� ������ �����ϴ� Ŭ���� Node (�˰��� ������ ���� ��忡 key, left, right �ʵ常 �� ��)
	private class Node {
		int key;
		Node left;
		Node right;
	}

// Ű ���� �Ű������� �޾� �� Ű���� �����ϴ��� ����(true/false)�� ����
	public boolean contains(int n) {
		Node t = root;
		while(t != null) { //t�� null�� �ƴ� ������ ��ȸ
			if(t.key == n) { //ã����
				return true; //true
			}
			else if(t.key > n) t = t.left; //ã������ ���� ��Ʈ���� ������ ��������
			else t = t.right; //ã������ ���� ��Ʈ���� ũ�� ����������
		}
		return false; //������ false
	}

// �Ű������� ���� Ű���� Ʈ���� ����
	public void add(int key) {
		root = treeInsert(root, key); //��������� ����
	}

// t�� ��Ʈ�� �ϴ� Ʈ���� key�� �����ϰ�, ���� �� ��Ʈ ��带 �����ϴ� ��� �޼ҵ�
	private Node treeInsert(Node t, int key) {
		if(t == null) { //�� Ʈ���� ���
			Node r = new Node(); //��� ���� ����
			r.key = key;
			return r;
		}
		else if(key < t.key) { //������ ���� ���� ��庸�� ���� ���
			t.left = treeInsert(t.left, key); //�������� �̵�
			return t;
		}
		else if(key > t.key) { //Ŭ ���
			t.right = treeInsert(t.right, key); //���������� �̵�
			return t;
		}
		else {
			return t;  // �̹� �����ϴ� Ű���� ��� �������� ����
		}
	}
	//�ִ� ����
	public void removeMax() {
		if (root == null) return; //root�� null�� ��� �ٷ� ����
		
		Node rootNext = root;
		Node parent = null;
		while (rootNext.right != null) { //������ �ڽ��� null�� �ƴ� ������
			parent = rootNext; 
			rootNext = rootNext.right; //���� ������ ��� ������
		}
		
		if (parent == null) { //���� ������ ��尡 ��Ʈ ����� ���
			root = rootNext.left; // ��Ʈ��带 �� ����� ���� �ڽ����� ����
		}
		else {
		parent.right = rootNext.left; } // �� �ܿ��� ������ �ڽ��� ����� ���� �ڽ����� ����
	}
	
// Ʈ���� Ű������ �߼��� ��ȸ�Ͽ� ������������ ������ �ϳ��� ���ڿ��� ����� ����
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer("tree = "); //��Ʈ������ ����
		if(root != null) {
			inorder(result, root); //�߼�����ȸ
		}
		return result.toString();
	}

// t�� ��Ʈ�� �ϴ� Ʈ���� �߼��� ��ȸ
	private void inorder(StringBuffer result, Node t) {
		if(t != null) {
			inorder(result, t.left); //���� ��ȸ
			result.append(t.key + " "); //���� ��尪�� ���ڿ��� �߰�
			inorder(result, t.right);// ������ ��ȸ
		}
	}
}
