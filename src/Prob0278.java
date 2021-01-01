package com.leetcode.explore;

/*

��һ������İ汾

���ǲ�Ʒ����Ŀǰ���ڴ���һ���Ŷӿ����µĲ�Ʒ�����ҵ��ǣ���Ĳ�Ʒ�����°汾û��ͨ��������⡣����ÿ���汾���ǻ���֮ǰ�İ汾�����ģ����Դ���İ汾֮������а汾���Ǵ�ġ�
�������� n ���汾 [1, 2, ..., n]�������ҳ�����֮�����а汾����ĵ�һ������İ汾��
�����ͨ������ bool isBadVersion(version) �ӿ����жϰ汾�� version �Ƿ��ڵ�Ԫ�����г���
ʵ��һ�����������ҵ�һ������İ汾����Ӧ�þ������ٶԵ��� API �Ĵ�����

ʾ��:
���� n = 5������ version = 4 �ǵ�һ������İ汾��

���� isBadVersion(3) -> false
���� isBadVersion(5) -> true
���� isBadVersion(4) -> true

���ԣ�4 �ǵ�һ������İ汾��  

*/

public class Prob0278 {
	class Solution extends VersionControl {
		public int firstBadVersion(int n) {
			int lo = 1, hi = n;
			while (lo < hi) {
				int mi = lo + (hi - lo) / 2;
				if (isBadVersion(mi)) hi = mi;
				else lo = mi + 1;
			}
			return lo;
		}
	}
}

// mock class
class VersionControl {
	public boolean isBadVersion(int version) {
		return true;
	}
}
