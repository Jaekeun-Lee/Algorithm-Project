package project.test7_KeywordSearching;

public class AutomataMatch {

	public void findPattern(String TextSeq, char inchar[], int TM[][]) {
		int i = 0, status = 0, nextst = 0, count = 0, position;
		int goalst = TM.length - 1;
		// ��ǥ ���ޱ����� ���¼� = pattern.length()

		while (i < TextSeq.length()) {
			nextst = nextState(TextSeq.charAt(i), status, inchar, TM);
			if (nextst == (status + 1)) {
				if (nextst == goalst) {
					status = 0;
					count++;
					position = i - goalst + 1;
					System.out.print(" " +position);
				} else
					status++;
			} else
				status = nextst; // reset status
			i++; // get next character
		}
	}

	int nextState(char in, int status, char inchar[], int TM[][]) {
		int index = 0, flag = 0;
		for (int i = 0; i < inchar.length; i++) {
			if (inchar[i] == in) {
				index = i;
				flag++;
			} else
				continue;
		}
		if (flag > 0)
			return TM[status][index];
		else
			return 0; // 0 state
	}

	public void printTM(char inchar[], int TM[][]) {
		int i, j, cnum = inchar.length;

		System.out.println("ã�� ������ ���� ���� �Լ� ����Դϴ�.");
		System.out.printf("��� ����: ");
		for (i = 0; i < cnum; i++)
			System.out.printf("   %c  ", inchar[i]);
		for (i = 0; i < TM.length; i++) { // �ʱ� 0 ���µ� ���Ե�
			System.out.printf("\n����  %2d: ", i);
			for (j = 0; j < cnum; j++)
				System.out.printf(" %4d ", TM[i][j]);
		}
		System.out.printf("\n���� ���� ���̺��� Ȯ���ϼ���.\n\n");
	}
}