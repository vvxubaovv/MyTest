package funnyGame;

public class SimpleWay {
	public int A = 0;
	public int B = 1;
	public int C = 2;
	public int D = 3;
	
	public char[] chars = {'A','B','C','D'};

	//public int[] answers = new int[11];
	public int answer = 0;

	public int[] getNextAnswer() {
		if(answer>1048576) {
			return null;
		} 
		
		int temp1 = answer;
		
		int[] answers = new int[11];
		int i = 1;
		while (temp1 != 0 && i < 11) {
			int temp = temp1 % 4;
			answers[i] = temp;
			temp1 /= 4;
			i++;
		}
		
		answer++;

		return answers;
	}

	public boolean firstRight(int[] answers) {

		return true;
	}

	public boolean secondRight(int[] answers) {
		return true;
	}

	public boolean thirdRight(int[] answers) {
		int temp[] = new int[4];
		temp[answers[3]]++;
		temp[answers[6]]++;
		temp[answers[2]]++;
		temp[answers[4]]++;

		int index3 = -1;

		for (int i=0;i<temp.length;i++) {
			if(temp[i]==4) {
				return false;
			}
			if (temp[i] == 3) {
				index3 = i;
			}
		}

		if (index3 == -1) {
			return false;
		}

		if(answers[3]!=index3&&answers[3]==A) {
			return true;
		}
		if(answers[6]!=index3&&answers[3]==B) {
			return true;
		}
		if(answers[2]!=index3&&answers[3]==C) {
			return true;
		}
		if(answers[4]!=index3&&answers[3]==D) {
			return true;
		}
		


		return false;
	}

	public boolean fourRight(int[] answers) {
		int sum = 0;
		if (answers[1] == answers[5] && answers[4] == A) {
			sum++;
		}
		if (answers[2] == answers[7] && answers[4] == B) {
			sum++;
		}
		if (answers[1] == answers[9] && answers[4] == C) {
			sum++;
		}
		if (answers[6] == answers[10] && answers[4] == D) {
			sum++;
		}

		if (sum == 1) {
			return true;
		}

		return false;
	}

	public boolean fifthRight(int[] answers) {
		int sum = 0;
		if (answers[8] == answers[5] && answers[5] == A) {
			sum++;
		}
		if (answers[4] == answers[5] && answers[5] == B) {
			sum++;
		}
		if (answers[9] == answers[5] && answers[5] == C) {
			sum++;
		}
		if (answers[7] == answers[5] && answers[5] == D) {
			sum++;
		}

		if (sum == 1) {
			return true;
		}

		return false;
	}

	public boolean sixthRight(int[] answers) {
		int sum = 0;

		if (answers[2] == answers[4] && answers[2] == answers[8] && answers[6] == A) {
			sum++;
		}
		if (answers[1] == answers[6] && answers[1] == answers[8] && answers[6] == B) {
			sum++;
		}
		if (answers[3] == answers[10] && answers[3] == answers[8] && answers[6] == C) {
			sum++;
		}
		if (answers[5] == answers[9] && answers[5] == answers[8] && answers[6] == D) {
			sum++;
		}

		if (sum == 1) {
			return true;
		}

		return false;
	}

	public boolean seventhRight(int[] answers) {
		int[] temp = new int[4];
		for (int i = 1; i < 11; i++) {
			temp[answers[i]]++;
		}

		int min = 4;
		int index = 0;
		for (int i = 0; i < 4; i++) {
			if (temp[i] < min) {
				min = temp[i];
				index = i;
			}
		}

		int sum = 0;

		if (index == C && answers[7] == A) {
			sum++;
		}
		if (index == B && answers[7] == B) {
			sum++;
		}
		if (index == A && answers[7] == C) {
			sum++;
		}
		if (index == D && answers[7] == D) {
			sum++;
		}

		if (sum == 1) {
			return true;
		}

		return false;
	}

	public boolean eightRight(int[] answers) {
		int sum = 0;
		if (Math.abs(answers[7] - answers[1]) > 1 && answers[8] == A) {
			sum++;
		}
		if (Math.abs(answers[5] - answers[1]) > 1 && answers[8] == B) {
			sum++;
		}
		if (Math.abs(answers[2] - answers[1]) > 1 && answers[8] == C) {
			sum++;
		}
		if (Math.abs(answers[10] - answers[1]) > 1 && answers[8] == D) {
			sum++;
		}

		if (sum == 1) {
			return true;
		}

		return false;
	}

	public boolean ninthRight(int[] answers) {
		int sum = 0;
		if ((answers[1] == answers[6]) != (answers[6] == answers[5]) && answers[9] == A) {
			sum++;
		}
		if ((answers[1] == answers[6]) != (answers[10] == answers[5]) && answers[9] == B) {
			sum++;
		}
		if ((answers[1] == answers[6]) != (answers[2] == answers[5]) && answers[9] == C) {
			sum++;
		}
		if ((answers[1] == answers[6]) != (answers[9] == answers[5]) && answers[9] == D) {
			sum++;
		}
		
		if(sum==1) {
			return true;
		}
		return false;
	}

	public boolean tenthRight(int[] answers) {
		
		int[] temp = new int[4];
		for (int i = 1; i < 11; i++) {
			temp[answers[i]]++;
		}
		
		int min = 4;
		int max = -1;
		for (int i = 0; i < 4; i++) {
			if (temp[i] < min) {
				min = temp[i];
			}
			if(temp[i]>max) {
				max = temp[i];
			}
		}
		
		if(max-min==3&&answers[10]==A) {
			return true;
		}
		if(max-min==2&&answers[10]==B) {
			return true;
		}
		if(max-min==4&&answers[10]==C) {
			return true;
		}
		if(max-min==1&&answers[10]==D) {
			return true;
		}
		
		return false;
	}
	
	public void show(int[] answers) {
		for(int i = 1;i<11;i++) {
			System.out.print(chars[answers[i]]+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		SimpleWay sw = new SimpleWay();
		int[] answers = null;
		while((answers=sw.getNextAnswer())!=null) {
			//sw.show(answers);
			if(sw.firstRight(answers)
					&&sw.secondRight(answers)
					&&sw.thirdRight(answers)
					&&sw.fourRight(answers)
					&&sw.fifthRight(answers)
					&&sw.sixthRight(answers)
					&&sw.seventhRight(answers)
					&&sw.eightRight(answers)
					&&sw.ninthRight(answers)
					&&sw.tenthRight(answers)) {
				System.out.println("--------------------");
				sw.show(answers);
				  //break;
			}
		}
		
	}
}
