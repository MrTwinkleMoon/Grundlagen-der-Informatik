import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Normalformen {

	private int n = GUI.getvar();
	
	private int[][] wahr = createdata();
	
	private int[][] createdata(){
		Object[][] o = new Object[(int)Math.pow(2, n)][n+1];
		int[][] iarr = new int[(int)Math.pow(2, n)][n+1];
		for(int i = 0; i < (int)Math.pow(2, n); i++) {
			for(int j = 0; j <= n; j++) {
				o[i][j] = GUI.table.getValueAt(i, j);
				if(o[i][j] instanceof Integer) {
					iarr[i][j] = (int)o[i][j];
				}
				else if(o[i][j] instanceof Boolean) {
					if((boolean)o[i][j]) {
						iarr[i][j] = 1;
					} else {
						iarr[i][j] = 0;
					}
				}	
			}
		}
		return iarr;
	}
	
	private int zaehleneinsmenge(){
		int k = 0;
		for(int i=0; i<(int)Math.pow(2, n);i++) {
			int j = wahr[i][n];
			if(j==1) {
				k++;
			}
		}
		return k;
	}
	
	private int[][] aufstelleneinsmenge(){
		int k = zaehleneinsmenge();
		int[][] arr1 = new int[k][n];
		int[][] arr2 = new int[k][n];
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i=0; i<(int)Math.pow(2, n);i++) {
			for(int b = 0; b < n; b++) {
				int m = wahr[i][n];
					if (m == 1) {
						l.add(wahr[i][b]);
					}
			}
		}
		int a = 0;
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < n; j++) {
				arr1[i][j] = l.get(a);
				a++;
			}
		}
		for(int i = 0; i < n; i++) {
    		for(int b = 0; b < k; b++) {
    			arr2[b][(n-1-i)] = arr1[b][i];
    		}
    	}
		return arr2;
	}

	private int[][] aufstellennullmenge(){
		int e = zaehleneinsmenge();
		int k = (int)Math.pow(2, n)-e;
		int[][] arr1 = new int[k][n];
		int[][] arr2 = new int[k][n];
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i=0; i<(int)Math.pow(2, n);i++) {
			for(int b = 0; b < n; b++) {
				int m = wahr[i][n];
					if (m == 0) {
						l.add(wahr[i][b]);
					}
			}
		}
		int a = 0;
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < n; j++) {
				arr1[i][j] = l.get(a);
				a++;
			}
		}
		for(int i = 0; i < n; i++) {
    		for(int b = 0; b < k; b++) {
    			arr2[b][(n-1-i)] = arr1[b][i];
    		}
    	}
		return arr2;
	}
	
	private String[][] dnfaufstellen(){
		int k = zaehleneinsmenge();
		int[][] arr1 = aufstelleneinsmenge();
		String [][] dnf = new String[k][n];
		String [][] dnf2 = new String[k][2*n+2];
		
		for(int i=0; i<k; i++) {
			for(int j=0; j<n; j++) {
				if(arr1[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					sb.append("X");
					sb.append(j+1);
					dnf[i][j] = sb.toString();
					}
				if(arr1[i][j] == 0) {
					StringBuilder sb = new StringBuilder();
					sb.append("\u00AC");
					sb.append("X");
					sb.append(j+1);
					dnf[i][j] = sb.toString();
					}
				} 
			}
		
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < 2*n+2; j++) {
				dnf2[i][0] = "(";
				dnf2[i][2*n] = ")";
				dnf2[i][2*n+1] = "\u2228";
				int b = 0; 
				for(int m = 1; m < 2*n; m++) {
					if(m%2 == 1) {
						dnf2[i][m] = dnf[i][b];
						b++;
					}else {
						dnf2[i][m] = "\u2227";
					}
				}
				b = 0;
			}
		}
		
		if(k != 0) {
			dnf2[k-1][2*n+1] = "";
		}
		
		return dnf2;	
		}
	
	private String[][] knfaufstellen(){
		int e = zaehleneinsmenge();
		int k = (int)Math.pow(2, n) - e;
		int[][] arr1 = aufstellennullmenge();
		String [][] knf = new String[k][n];
		String [][] knf2 = new String[k][2*n+2];
		
		for(int i=0; i<k; i++) {
			for(int j=0; j<n; j++) {
				if(arr1[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					sb.append("\u00AC");
					sb.append("X");
					sb.append(j+1);
					knf[i][j] = sb.toString();
					}
				if(arr1[i][j] == 0) {
					StringBuilder sb = new StringBuilder();
					sb.append("X");
					sb.append(j+1);
					knf[i][j] = sb.toString();
					}
				} 
			}
		
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < 2*n+2; j++) {
				knf2[i][0] = "(";
				knf2[i][2*n] = ")";
				knf2[i][2*n+1] = "\u2227";
				int b = 0; 
				for(int m = 1; m < 2*n; m++) {
					if(m%2 == 1) {
						knf2[i][m] = knf[i][b];
						b++;
					}else {
						knf2[i][m] = "\u2228";
					}
				}
				b = 0;
			}
		}
		
		if(k != 0) {
			knf2[k-1][2*n+1] = "";
		}
		
		return knf2;	
	}
	
	private String[][] dnfarr = dnfaufstellen();
	
	private String[][] knfarr = knfaufstellen();
	
	private String dnfstringbauen() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < zaehleneinsmenge(); i++) {
			for(int j = 0; j < 2*n+2; j++) {
				sb.append(dnfarr[i][j]);
			}
		}
		String s = sb.toString();
		return s;
	}
	
	private String knfstringbauen() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < ((int)Math.pow(2, n) - zaehleneinsmenge()); i++) {
			for(int j = 0; j < 2*n+2; j++) {
				sb.append(knfarr[i][j]);
			}
		}
		String s = sb.toString();
		return s;
	}
	
	public void getDNF(){
		if(zaehleneinsmenge() != 0) {
			JOptionPane.showMessageDialog(null, dnfstringbauen());
		} else {
			JOptionPane.showMessageDialog(null, "Keine Funktionswerte gleich 1.");
		}
	}
	
	public void getKNF(){
		if((int)Math.pow(2, n) - zaehleneinsmenge() != 0) {
			JOptionPane.showMessageDialog(null, knfstringbauen());
		} else {
			JOptionPane.showMessageDialog(null, "Keine Funktionswerte gleich 0.");
		}
	}
	
}
