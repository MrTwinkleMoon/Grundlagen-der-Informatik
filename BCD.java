import javax.swing.JOptionPane;

public class BCD {
	
	private String x = GUI.getBCDx();
	private String y = GUI.getBCDy();
	private int l = findlength()/4;
	private int arrx[][] = stringToArr(x);
	private int arry[][] = stringToArr(y);
	private int arryKomp[][] = createKomp(arry);
	private int arrk[][] = createK();
	private int arrFertigAdd[][];
	private boolean f = false;
	private boolean sub = false;
	private int c = 0;
	int arrcg[];
	
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
				for(int k = 0; k < (l*4-s.length()); k++) {
					sb.append(0);
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
						JOptionPane.showMessageDialog(null, "Die Eingabe entspricht nicht dem Format einer BCD Zahl");
						f = true;
					}
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "Die Anzahl der Bits entspricht nicht dem Format einer BCD Zahl");
			f = true;
			}
		return arr;
	}
	
	private int[][] createKomp(int[][] arr){
		int[][] arrk = new int[l][4];
		for(int i = 0; i < l; i++) {
			for(int j = 0; j < 4; j++) {
				arrk[i][j] = 0;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < l; i++) {
			int sum = 0;
			for(int j = 3; j >= 0; j--) {
				if(arr[i][j] == 1) {
				sum = sum + (int)Math.pow(2, 3-j);
				}
			}
			sb.append(sum);
		}
		String s = sb.toString();
		int z = Integer.parseInt(s);
		int k = (int)Math.pow(10, s.length()) - z;
		String sk = Integer.toString(k);
		int skl = sk.length();
		for(int i = skl-1; i >= 0; i--) {
			char c = sk.charAt(i);
			String bin = Integer.toBinaryString(Character.getNumericValue(c));
			int m = bin.length()-1;
			for(int j = 3; j >= 0; j--) {
				if(m >= 0) {
					arrk[i][j] = Character.getNumericValue(bin.charAt(m));
					m--;
				}
			}
		}
		return arrk;
	}
	
	private int[][] createK(){
		int[][] arr = new int[l][4];
		for(int i = 0; i < l; i++) {
			for(int j = 0; j < 4; j++) {
				if(j == 0 || j == 3) {
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
	
	private int[] carryAddieren(int[] arr){
		for(int i = 3; i >= 0; i--) {
			if(c == 0) {
				if(arr[i] == 0) {
					arr[i] = 0;
				}else {
					arr[i] = 1;
				}
			}else if(c == 1) {
				if(arr[i] == 0) {
					arr[i] = 1;
					c = 0;
				}else {
					arr[i] = 0;
					c = 1;
				}
			}
		}
		return arr;
	}
	
	private boolean ueberschreiten(int[] arr) {
		int sum = 0;
		boolean b;
		if(arr[3] == 1) {
			sum = sum + 1;
		}
		if(arr[2] == 1) {
			sum = sum + 2;
		}
		if(arr[1] == 1) {
			sum = sum + 4;
		}
		if(arr[0] == 1) {
			sum = sum + 8;
		}
		if(sum > 9) {
			b = true;
		}else {
			b = false;
		}
		return b;
	}
	
	private void addieren(int[][] arr1, int[][] arr2){
		int[][] arr3 = new int[l][4];
		int[] arrc = new int[l];
		int[][] arr4 = new int[l+1][4];
		for(int i = l-1; i >= 0; i--) {
			arr3[i] = simpelAddieren(i, arr1, arr2);
			arrc[i] = c;
		}
		arrcg = arrc;
		c = 0;
		for(int i = l-1; i >= 0; i--) {
			if(c == 0 && ueberschreiten(arr3[i])) {
				arr3[i] = simpelAddieren(i, arr3, arrk);
			}else if(c == 0 && arrc[i] == 1) {
				arr3[i] = simpelAddieren(i, arr3, arrk);
			}else if(c == 1) {
				arr3[i] = carryAddieren(arr3[i]);
				if(ueberschreiten(arr3[i]) || arrc[i] == 1) {
					arr3[i] = simpelAddieren(i, arr3, arrk);
				}
			}
			
		}
		if(c == 1 || arrc[0] == 1) {
			for(int i = l; i > 0; i--) {
				arr4[i] = arr3[i-1];
			}
			for(int i = 0; i < 3; i++) {
				arr4[0][i] = 0;
			}
			arr4[0][3] = 1;
			arrFertigAdd = arr4;
			sub = true;
		}else {
			arrFertigAdd = arr3;
		}
	}
	
	public void getBCDAdd() {
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
		JOptionPane.showMessageDialog(null, "Die BCD Zahl lautet: " + s);
	}
	
	public void getBCDSub() {
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
		JOptionPane.showMessageDialog(null, "Die BCD Zahl lautet: " + s);
	}

}
