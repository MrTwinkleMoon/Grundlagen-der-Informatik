import javax.swing.JOptionPane;

public class Excess {
	
	private String x = GUI.getExcx();
	private String y = GUI.getExcy();
	private int l = findlength()/4;
	private int arrx[][] = stringToArr(x);
	private int arry[][] = stringToArr(y);
	private int arrEins[][] = createarrEins();
	private int arryKomp[][] = createKomp(arry);
	private int arrk1[][] = createK1();
	private int arrk2[][] = createK2();
	private int arrFertigAdd[][];
	private boolean f = false;
	private boolean sub = false;
	private int c = 0;
	
	private int findlength() {
		int a = 0;
		if(x.length() > y.length()) {
			a = x.length();
		}else {
			a = y.length();
		}
		return a;
	}
	
	private int[][] stringToArr(String s) {
		int[][] arr = null;
		int a = 0;
		if(s.length() % 4 == 0) {
			if(s.length()/4 < l) {
				StringBuilder sb = new StringBuilder();
				for(int k = 0; k < (l-s.length()/4); k++) {
					sb.append("0011");
				}
				sb.append(s);
				s = sb.toString();
			}
			arr = new int[l][4];
			for(int i = 0; i < l; i++) {
				for(int j = 0; j < 4; j++) {
					if(s.charAt(a) == '1') {
						arr[i][j] = 1;
						a++;
					}else if(s.charAt(a) == '0') {
						arr[i][j] = 0;
						a++;
					}else {
						JOptionPane.showMessageDialog(null, "Die Eingabe entspricht nicht dem Format einer Excess-3 Zahl");
						f = true;
					}
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "Die Anzahl der Bits entspricht nicht dem Format einer Excess-3 Zahl");
			f = true;
			}
		return arr;
	}
	
	private int[][] createKomp(int[][] arr){
		int[][] arrk = new int[l][4];
		for(int i = 0; i < l; i++) {
			System.out.print(" ");
			for(int j = 0; j < 4; j++) {
				if(arr[i][j] == 1) {
					arrk[i][j] = 0;
					System.out.print(arrk[i][j]);
				}else {
					arrk[i][j] = 1;
					System.out.print(arrk[i][j]);
				}
			}
		}
		for(int i = l-1; i >= 0; i--) {
			arrk[i] = simpelAddieren(i, arrk, arrEins);
		}
		return arrk;
	}
	
	private int[][] createarrEins(){
		int[][] arr = new int[l][4];
		for(int i = 0; i < l; i++) {
			for(int j = 0; j < 4; j++) {
				arr[i][j] = 0;
			}
		}
		arr[l-1][3] = 1;
		return arr;
	}
	
	private int[][] createK1(){
		int[][] arr = new int[l+1][4];
		for(int i = 0; i <= l; i++) {
			for(int j = 0; j < 4; j++) {
				if(j == 0 || j == 1) {
					arr[i][j] = 0;
				}else {
					arr[i][j] = 1;
				}
			}
		}
		return arr;
	}
	
	private int[][] createK2(){
		int[][] arr = new int[l+1][4];
		for(int i = 0; i < l; i++) {
			for(int j = 0; j < 4; j++) {
				if(j == 2) {
					arr[i][j] = 0;
				}else {
					arr[i][j] = 1;
				}
			}
		}
		return arr;
	}
	
	private int[] simpelAddieren(int a, int[][] arr1, int[][] arr2){
		int[] arr3 = new int[4];
		for(int i = 3; i >= 0; i--) {
			if(c == 0) {
				if(arr1[a][i] == 0 && arr2[a][i] == 0) {
					arr3[i] = 0;
				}else if(arr1[a][i] == 1 ^ arr2[a][i] == 1) {
					arr3[i] = 1;
				}
				else{
					arr3[i] = 0;
					c = 1;
				}
			}else if(c == 1) {
				if(arr1[a][i] == 0 && arr2[a][i] == 0) {
					arr3[i] = 1;
					c = 0;
				}else if(arr1[a][i] == 1 ^ arr2[a][i] == 1) {
					arr3[i] = 0;
				}
				else{
					arr3[i] = 1;
				}
			}
		}	
		return arr3;
	}
	
	private void addieren(int[][] arr1, int[][] arr2){
		int[][] arr3 = new int[l][4];
		int[] arrc = new int[l];
		int[][] arr4 = new int[l+1][4];
		for(int i = l-1; i >= 0; i--) {
			arr3[i] = simpelAddieren(i, arr1, arr2);
			arrc[i] = c;
		}
		if(c == 1) {
			for(int i = l; i > 0; i--) {
				arr4[i] = arr3[i-1];
			}
			for(int i = 0; i < 3; i++) {
				arr4[0][i] = 0;
			}
			arr4[0][3] = 1;
			sub = true;
			c = 0;
			for(int i = l; i > 0; i--) {
				if(arrc[i-1] == 1) {
					arr4[i] = simpelAddieren(i, arr4, arrk1);
					c = 0;
				}else {
					arr4[i] = simpelAddieren(i, arr4, arrk2);
					c = 0;
				}
			}
			arr4[0] = simpelAddieren(0, arr4, arrk1);
			arrFertigAdd = arr4;
		}else {
			c = 0;
			for(int i = l-1; i >= 0; i--) {
				if(arrc[i] == 1) {
					arr3[i] = simpelAddieren(i, arr3, arrk1);
					c = 0;
				}else {
					arr3[i] = simpelAddieren(i, arr3, arrk2);
					c = 0;
				}
			}
			arrFertigAdd = arr3;
		}
	}
	
	public void getExcAdd() {
		addieren(arrx, arry);
		String s;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arrFertigAdd.length; i++) {
			sb.append(' ');
			for(int j = 0; j < 4; j++) {
				sb.append(arrFertigAdd[i][j]);
			}
		}
		s = sb.toString();
		JOptionPane.showMessageDialog(null, "Die Excess-3 Zahl lautet: " + s);
	}
	
	public void getExcSub() {
		addieren(arrx, arryKomp);
		String s;
		StringBuilder sb = new StringBuilder();
		if(sub) {
			for(int i = 1; i < arrFertigAdd.length; i++) {
				sb.append(' ');
				for(int j = 0; j < 4; j++) {
					sb.append(arrFertigAdd[i][j]);
				}
			}
		}else {
			for(int i = 0; i < arrFertigAdd.length; i++) {
				sb.append(' ');
				for(int j = 0; j < 4; j++) {
					sb.append(arrFertigAdd[i][j]);
				}
			}
		}
		s = sb.toString();
		JOptionPane.showMessageDialog(null, "Die Excess-3 Zahl lautet: " + s);
	}

}