package project.test7_KeywordSearching;

public class NaiveMatch {
	void findPattern(String TextSeq, String pattern) {
		int i = 0, j, num, find;
		num = pattern.length();

		while (i < TextSeq.length()) {
			if (pattern.charAt(0) == TextSeq.charAt(i)) {
				find = 0;
				for (j = 1; j < num; j++) {
					if (pattern.charAt(j) == TextSeq.charAt(i + j))
						continue;
					else {
						find = 1;
						break;
					}
				}
				if (find == 0) {
					System.out.print(" " + i);
					i = i + num - 1; // ���� ���� ã�� ��ġ, ���� ���� -1 ��ŭ ����
				}
			}
			i++; // ���� �ڸ�
		}

	}
}
