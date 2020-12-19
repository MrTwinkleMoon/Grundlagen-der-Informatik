import javax.swing.JOptionPane;

public class BinaryString {
	
	private String Bin;
	
	private void getBin(int a) {
		if(a == 0) {
			Bin = GUI.getBin16();	
		}else {
			Bin = GUI.getBin32();
		}
	}
	
	public void getBinBCD(int a) {
		getBin(a);
		String[] BinSplit = Bin.split(" ");
		int Bin1 = Integer.parseInt(BinSplit[0], 2);
		int Bin2 = Integer.parseInt(BinSplit[1], 2);
		int Bin3 = Integer.parseInt(BinSplit[2], 2);
		int Bin4 = Integer.parseInt(BinSplit[3], 2);
		StringBuilder sb = new StringBuilder();
		sb.append(Bin1);
		sb.append(Bin2);
		sb.append(Bin3);
		sb.append(Bin4);
		if(Bin.length() == 39) {
			int Bin5 = Integer.parseInt(BinSplit[4], 2);
			int Bin6 = Integer.parseInt(BinSplit[5], 2);
			int Bin7 = Integer.parseInt(BinSplit[6], 2);
			int Bin8 = Integer.parseInt(BinSplit[7], 2);
			sb.append(Bin5);
			sb.append(Bin6);
			sb.append(Bin7);
			sb.append(Bin8);
		}
		String s = sb.toString();
		JOptionPane.showMessageDialog(null, "Die BCD Zahl lautet: " + s);
	}
	
	public void getBinZwei(int a) {
		getBin(a);
		String s = Bin.replaceAll(" ", "");
		long zwei = Long.parseLong(s, 2);
		JOptionPane.showMessageDialog(null, "Die Zahl zur Basis 2 lautet: " + zwei);
	}
	
	public void getBinVor(int a) {
		getBin(a);
		String sZahl;
		String s = Bin.replaceAll(" ", "");
		String sZeichen = s.substring(0, 1);
		System.out.println(sZeichen);
		if(a == 0) {
			sZahl = s.substring(1, 16);
		}else {
			sZahl = s.substring(1, 32);
		}
		System.out.println(sZahl);
		int dualZahl = Integer.parseInt(sZahl, 2);
		String sVorzeichen;
		if(sZeichen.charAt(0) == '0') {
			sVorzeichen = "+";
		}else {
			sVorzeichen = "-";
		}
		JOptionPane.showMessageDialog(null, "Die Zahl in Vorzeichen-Betrag-Darstellung lautet: " + sVorzeichen + dualZahl);
	}
	
	public void getBinGleit(int a) {
		if(a == 1) {
			getBin(a);
			String s = Bin.replaceAll(" ", "");
			char c = s.charAt(0);
			if(c == '0') {
				c = '+';
			}else {
				c = '-';
			}
			String sChar = s.substring(1, 9);
			String sMan = s.substring(9, 32);
			int iChar = Integer.parseInt(sChar, 2);
			int iMan = Integer.parseInt(sMan, 2);
			if(iChar == 0) {
				StringBuilder sb = new StringBuilder();
				sb.append("0.");
				sb.append(iMan);
				String sKomma = sb.toString();
				double dMan = Double.parseDouble(sKomma);
				double dErg = dMan*Math.pow(2, -126);
				JOptionPane.showMessageDialog(null, "Die Gleitpunktzahl lautet: " + c + dErg);
			}else if(iChar == 255) {
				if(iMan == 0) {
					JOptionPane.showMessageDialog(null, "Die Gleitpunktzahl lautet: " + c + "\u221E");
				}else {
					JOptionPane.showMessageDialog(null, "Die Gleitpunktzahl ist Not a Number");
				}
			}else {
				StringBuilder sb = new StringBuilder();
				sb.append("1.");
				sb.append(iMan);
				String sKomma = sb.toString();
				double dMan = Double.parseDouble(sKomma);
				double dErg = dMan*Math.pow(2, (iChar-127));
				JOptionPane.showMessageDialog(null, "Die Gleitpunktzahl lautet: " + c + dErg);
			}
		}
	}
	
	public void getBinEKD(int a) {
		boolean f = false;
		getBin(a);
		String s = Bin.replaceAll(" ", "");
		long zahl = Long.parseLong(s, 2);
		if(a == 0) {
			if(zahl == 0 || zahl == 65535) {
				JOptionPane.showMessageDialog(null, "Das Einerkomplement lautet: 0");
				f = true;
			}
		}else {
			if(zahl == 0 || zahl == 4294967295L) {
				JOptionPane.showMessageDialog(null, "Das Einerkomplement lautet: 0");
				f = true;
			}
		}
		if(f == false) {
			char c = s.charAt(0);
			if(c == '0') {
				c = '+';
			}else {
				c = '-';
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '0') {
					sb.append(1);
				}else {
					sb.append(0);
				}
			}
			s = sb.toString();
			long komp = Long.parseLong(s, 2);
			JOptionPane.showMessageDialog(null, "Das Einerkomplement lautet: " + c + komp);
		}
	}
	
	public void getBinZKD(int a) {
		boolean f = false;
		getBin(a);
		String s = Bin.replaceAll(" ", "");
		long zahl = Long.parseLong(s, 2);
		if(zahl == 0) {
			JOptionPane.showMessageDialog(null, "Das Einerkomplement lautet: 0");
			f = true;
		}
		if(f == false) {
			char c = s.charAt(0);
			if(c == '0') {
				c = '+';
			}else {
				c = '-';
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '0') {
					sb.append(1);
				}else {
					sb.append(0);
				}
			}
			s = sb.toString();
			long komp = Long.parseLong(s, 2) + 1;
			JOptionPane.showMessageDialog(null, "Das Zweierkomplement lautet: " + c + komp);
		}
	}
}
