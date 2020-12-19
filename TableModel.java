import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
        
		private int var = GUI.getvar();
		private int varP = (int)Math.pow(2, var);
		//private Object[] varY = createvarY();
		private Object[] var1 = createvar1();
		private Object[] var2 = createvar2();
		private Object[] var3 = createvar3();
		private Object[] var4 = createvar4();
		private Object[] var5 = createvar5();
		private Object[] var6 = createvar6();
		private Object[] var7 = createvar7();
		private Object[] var8 = createvar8();
		
		/*public int[][] getdata(){
			int[][] o = new int[varP][var+1];
			for(int i = 0; i < varP; i++) {
				for(int j = 0; j <= var; j++) {
					if(data[i][j] == "0") {
						o[i][j] = 0;
					}
					else if(data[i][j] == "1") {
						o[i][j] = 1;
					}
					else if(data[i][j] == "false") {
						o[i][j] = 0;
					}
					else if(data[i][j] == "true") {
						o[i][j] = 1;
					}	
				}
			}

			for(int i = 0; i < varP; i++) {
				for(int j = 0; j <= var; j++) {
					System.out.print(o[i][j]);
					System.out.println();
				}
			}	
			
			return o;
		}*/
		
		/*private Object[] createvarY(){
			Object[] o = new Object[varP];
			for(int i = 0; i < varP; i++) {
				o[i] = false;
			}
			return o;
		}*/
		
		private Object[] createvar1(){
			Object[] o = new Object[varP];
			for(int i = 0; i < varP; i++) {
				if((i % 2) != 0) {
					o[i] = 1;
				} else {
					o[i] = 0;
				}
			}
			return o;
		}
		
		private Object[] createvar2(){
			Object[] o = new Object[varP];
			int j = 0;
			for(int i = 0; i < varP; i++) {
				if(j<2) {
					o[i] = 0;
					j++;
				} 
				else if(j<4) {
					o[i] = 1;
					j++;
				} else {
					j = 0;
					i--;
				}
			}
			return o;
		}
		
		private Object[] createvar3(){
			Object[] o = new Object[varP];
			int j = 0;
			for(int i = 0; i < varP; i++) {
				if(j<4) {
					o[i] = 0;
					j++;
				} 
				else if(j<8) {
					o[i] = 1;
					j++;
				} else {
					j = 0;
					i--;
				}
			}
			return o;
		}
		
		private Object[] createvar4(){
			Object[] o = new Object[varP];
			int j = 0;
			for(int i = 0; i < varP; i++) {
				if(j<8) {
					o[i] = 0;
					j++;
				} 
				else if(j<16) {
					o[i] = 1;
					j++;
				} else {
					j = 0;
					i--;
				}
			}
			return o;
		}
		
		private Object[] createvar5(){
			Object[] o = new Object[varP];
			int j = 0;
			for(int i = 0; i < varP; i++) {
				if(j<16) {
					o[i] = 0;
					j++;
				} 
				else if(j<32) {
					o[i] = 1;
					j++;
				} else {
					j = 0;
					i--;
				}
			}
			return o;
		}
		
		private Object[] createvar6(){
			Object[] o = new Object[varP];
			int j = 0;
			for(int i = 0; i < varP; i++) {
				if(j<32) {
					o[i] = 0;
					j++;
				} 
				else if(j<64) {
					o[i] = 1;
					j++;
				} else {
					j = 0;
					i--;
				}
			}
			return o;
		}
		
		private Object[] createvar7(){
			Object[] o = new Object[varP];
			int j = 0;
			for(int i = 0; i < varP; i++) {
				if(j<64) {
					o[i] = 0;
					j++;
				} 
				else if(j<128) {
					o[i] = 1;
					j++;
				} else {
					j = 0;
					i--;
				}
			}
			return o;
		}
		
		private Object[] createvar8(){
			Object[] o = new Object[varP];
			int j = 0;
			for(int i = 0; i < varP; i++) {
				if(j<128) {
					o[i] = 0;
					j++;
				} 
				else if(j<256) {
					o[i] = 1;
					j++;
				} else {
					j = 0;
					i--;
				}
			}
			return o;
		}
		
        private String[] createColumns() {
        	String[] s = new String[(var+1)];
        	String[] sw = new String[(var+1)];
        	for(int i = 0; i < var; i++) {
        		StringBuilder sb = new StringBuilder();
        		sb.append("X");
        		sb.append(i+1);
        		String spalte = sb.toString();
        		s[i] = spalte;
        	}
        	for(int i = 0; i < var; i++) {
        		sw[(var-1-i)] = s[i];
        	}
        	sw[var] = "Y";
        	//JOptionPane.showMessageDialog(null, var);
        	return sw;
        }
        
        private Object[][] createData(){
        	Object[][] o = new Object[varP][(var+1)];
        	Object[][] ow = new Object[varP][(var+1)];
        	for(int i = (var-1); i >= 0; i--) {
        		if(i==0) {
        			for(int j = 0; j < varP; j++) {
        				o[j][i] = var1[j];
        			}
        		}
        		else if(i==1) {
        			for(int j = 0; j < varP; j++) {
        				o[j][i] = var2[j];
        			}
        		}
        		else if(i==2) {
        			for(int j = 0; j < varP; j++) {
        				o[j][i] = var3[j];
        			}
        		}
        		else if(i==3) {
        			for(int j = 0; j < varP; j++) {
        				o[j][i] = var4[j];
        			}
        		}
        		else if(i==4) {
        			for(int j = 0; j < varP; j++) {
        				o[j][i] = var5[j];
        			}
        		}
        		else if(i==5) {
        			for(int j = 0; j < varP; j++) {
        				o[j][i] = var6[j];
        			}
        		}
        		else if(i==6) {
        			for(int j = 0; j < varP; j++) {
        				o[j][i] = var7[j];
        			}
        		}
        		else if(i==7) {
        			for(int j = 0; j < varP; j++) {
        				o[j][i] = var8[j];
        			}
        		}
        	}
        	for(int i = 0; i < var; i++) {
        		for(int j = 0; j < varP; j++) {
        			ow[j][(var-1-i)] = o[j][i];
        		}
        	}
        	for(int i = 0; i < varP; i++) {
        		ow[i][var] = false;
        	}
        	return ow;
        }
        
        private String[] columnNames = createColumns();
        
        private Object[][] data = createData();
        
 
        public int getColumnCount() {
            return columnNames.length;
        }
 
        public int getRowCount() {
            return data.length;
        }
 
        public String getColumnName(int col) {
            return columnNames[col];
        }
 
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
 
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
 
        public boolean isCellEditable(int row, int col) {
            if (col < var) {
                return false;
            } else {
                return true;
            }
        }
 
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
            }
        }
