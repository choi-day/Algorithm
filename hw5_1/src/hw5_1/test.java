package hw5_1;

import java.util.Random;

/**
 * �� ����Ʈ �˰��� (Quick Select)
 * 
 * @author devetude
 */
public class test {
	public static void main(String args[]) {
		// ���� �迭
		int[] nums = { 5, 6, 3, 6, 7, 9, 2, 3, 3, 4 };

		// ��� �� ���
		System.out.println(quickSelect(nums, 0, nums.length - 1, 0));
	}

	/**
	 * �� ����Ʈ �޼ҵ�
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	private static int quickSelect(final int[] NUMS, int start, int end, int k) {
		if (start <= end) {
			int pivot = partition(NUMS, start, end);

			if (pivot == k) {
				return NUMS[k];
			}

			else if (pivot > k) {
				return quickSelect(NUMS, start, pivot - 1, k);
			}

			else {
				return quickSelect(NUMS, pivot + 1, end, k);
			}
		}

		return Integer.MIN_VALUE;
	}

	/**
	 * ���� �޼ҵ�
	 * 
	 * @param NUMS
	 * @param start
	 * @param end
	 * @return
	 */
	private static int partition(final int[] NUMS, int start, int end) {
		int pivot = start + new Random().nextInt(end - start + 1);

		swap(NUMS, end, pivot);

		for (int i = start; i < end; i++) {
			if (NUMS[i] < NUMS[end]) {
				swap(NUMS, i, start);
				start++;
			}
		}

		swap(NUMS, start, end);

		return start;
	}

	/**
	 * �迭�� �� ����� ���� �ٲٴ� �޼ҵ�
	 * 
	 * @param nums
	 * @param aIdx
	 * @param bIdx
	 */
	private static void swap(final int[] nums, final int aIdx, final int bIdx) {
		int tmp = nums[aIdx];
		nums[aIdx] = nums[bIdx];
		nums[bIdx] = tmp;
	}
}