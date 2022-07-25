/* Authors: Omar  Solis, Naydel Lopez
 * CSE: 360 Final Group Project
 * December 02,2020
 * 
 * 
 */




import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JLabel;


public class Frame1 extends JFrame  {
	private static final long serialVersionUID = 6294689542092367723L;


	public JFrame frame;
	public JMenuBar menuBar;
	public JMenu NewMenu;
	public JMenu mnNewMenu;
	public JPanel panel;
	public JTable table;
	public JTable table2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		panel = new JPanel();
		frame.setBounds(200, 200, 1050, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CSE360 Final Project");

		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		NewMenu = new JMenu("Menu");
		menuBar.add(NewMenu);
		
		mnNewMenu = new JMenu("File");
		NewMenu.add(mnNewMenu);
		
		
		JMenuItem about = new JMenuItem("About");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame2 = new JFrame();
				frame2.setVisible(true);
				frame2.setBounds(80, 80, 400, 250);
				frame2.setTitle("About");
				frame2.getContentPane().add(panel);
				
				JPanel panel2 = new JPanel();
				panel2.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("<html>Project Information<br/><br/>Team Members: Omar Solis, Naydel Lopez</html>");
				lblNewLabel.setBounds(0, -25, 300, 100);
				panel.add(lblNewLabel);
				
				JLabel lblNewLabel2 = new JLabel("<html>Date: November 23, 2020<br/>CSE 360 Fall 2020<br/></html>");
				lblNewLabel2.setBounds(0, 15, 300, 100);
				panel.add(lblNewLabel2);
			}
		});
		NewMenu.add(about);
		
		
		
		JMenuItem roster = new JMenuItem("Load a Roster");
		roster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JTable table;
				JButton open = new JButton();
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("."));
				fc.setDialogTitle("Choose File");
				if (fc.showOpenDialog (open) == JFileChooser.APPROVE_OPTION){
					//
				}
				 String path = fc.getSelectedFile().getAbsolutePath();
				 String line = "";
				 BufferedReader br;
				 String[][] array;
				 String[] header = { "ID", "First Name", "Last Name" , "Program", "Level" , "ASURITE" };
				 
				 try {
					br = new BufferedReader(new FileReader(path));
					
					
					List<String[]> lines = new ArrayList<String[]>();
					while ((line = br.readLine()) != null) {
					     lines.add(line.split(","));
					}

					array = new String[lines.size()][0];
					lines.toArray(array);


					br.close();
					DefaultTableModel model = new DefaultTableModel(array,header);
			        //final JTable table = new JTable(model);
			        table = new JTable(model);
			        JScrollPane scroll = new JScrollPane(table);
			      frame.getContentPane().add("Center",scroll);
			      frame.setSize(650, 400);
			      frame.setVisible(true);

			frame.getContentPane().add(panel);
			panel.setLayout(null);

				
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


				
			}
			
		});
		mnNewMenu.add(roster);
		
		
		
		JMenuItem attendance = new JMenuItem("Add Attendance");
		attendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			    JFrame frame2 = new JFrame("InputDialog Example #1");

			    String name = JOptionPane.showInputDialog(frame2, "Enter a Date of file (ex. Jan-04):");
			try {
				Frame1 exp = new Frame1();
			                    String [][] combinedArray = exp.combineValues(table);
			                    ArrayList<String> ar = new ArrayList<String>();
			                    int headerLenght = table.getColumnCount();
			                    //System.out.println(headerLenght);
			                    for(int u = 0; u < headerLenght; u++)
			                    {
			                        ar.add(table.getColumnModel().getColumn(u).getHeaderValue().toString());
			                    }
			                    ar.add(name);
			                    String hrnames[]=ar.toArray(new String[ar.size()]);
			                    System.out.println(ar);
			                    DefaultTableModel model1 = new DefaultTableModel(combinedArray,hrnames);

			                              frame.getContentPane().removeAll();
			        frame.repaint();
			                    table = new JTable(model1);
			                    JScrollPane scroll = new JScrollPane(table);
			                    frame.getContentPane().add("Center",scroll);
			                    frame.setSize(850, 600);
			                    frame.setVisible(true);

			                    frame.getContentPane().add(panel);
			                    panel.setLayout(null);
			                   
			                   
			                } catch (IOException ex) {
			                    System.out.println(ex.getMessage());
			                    ex.printStackTrace();
			                }

			}
			});
		mnNewMenu.add(attendance);
		
		
		//On SAVE Button Click  **********************************************
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		        //exportTable(table,new File("results.xls"));
		try {
			Frame1 exp = new Frame1();
		                    exp.exportTable(table, new File("results.csv"));
		                } catch (IOException ex) {
		                    System.out.println(ex.getMessage());
		                    ex.printStackTrace();
		                }

		}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		//End Save Button  **********************************************
		
		
		//On PLOT Data Click **********************************************
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Plot Data");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Frame1 exp = new Frame1();
				    exp.exportTable2(table, new File("resultsPlot.csv"));
				     } catch (IOException ex) {
				     ex.printStackTrace();
				     } catch (NullPointerException x)
				{
				    	 JOptionPane.showMessageDialog(frame, "Roster and Attendance Files must be imported before Plotting Data"); 
				}
				
			    	Frame1 example = new Frame1("Scatter Chart");
			        example.setSize(800, 400);
			        example.setLocationRelativeTo(null);
			        example.setVisible(true);
			}

		});
		mnNewMenu.add(mntmNewMenuItem_3);
		//End Plot Data Button    **********************************************
	
		

		
	}   //END INITIALLIZE METHODS BELOW *****************************************************
	
	  public Frame1(String title) {
		    super(title);
	
		        XYDataset dataset = createDataset();
	
		    // Create chart
	    JFreeChart chart = ChartFactory.createScatterPlot(
	        "Attendance Chart", 
	        "X-Axis", "Y-Axis", dataset);
	
	    
	    //Changes background color
	    XYPlot plot = (XYPlot)chart.getPlot();
	    plot.setBackgroundPaint(new Color(255,228,196));
	    
	   
	    // Create Panel
	    ChartPanel panel = new ChartPanel(chart);
	    setContentPane(panel);
	  }

	
	private XYDataset createDataset() {
	    XYSeriesCollection dataset = new XYSeriesCollection();

	     String path = "resultsPlot.csv";
		 String line = "";
		 BufferedReader br;
		 String[][] array;
		// XYSeries series1 = new XYSeries("Attendance"); 
		 
		 try {
			 
			 XYSeries series1 = new XYSeries("Attendance"); 

			br = new BufferedReader(new FileReader(path));
			
			List<String[]> lines = new ArrayList<String[]>();
			while ((line = br.readLine()) != null) {
			     lines.add(line.split(","));
			}

			// convert our list to a String array.
			array = new String[lines.size()][0];
			lines.toArray(array);
			
			int i = 0;
			int j = 0;
			int col = 6;
	//System.out.println(array.length);
			
			//FREQUENCY CHECKER
			int [] arr = new int [] {1, 2, 8, 3, 2, 2, 2, 5, 1};  
			//Array fr will store frequencies of element  
			int [] fr = new int [arr.length];  
			int visited = -1;  
			for(int p = 0; p < arr.length; p++){  
			    int count = 1;  
			    for(int l = p+1; l < arr.length; l++){  
			        if(arr[p] == arr[l]){  
			            count++;  
			            //To avoid counting same element again  
			            fr[l] = visited;  
			        }  
			    }  
			    if(fr[p] != visited)  
			        fr[p] = count;  
			}
			//END FREQUENCY CHECKER

			for (i = 0; i < array.length; i++) {
				
				
				series1.addOrUpdate(Integer.parseUnsignedInt(array[j][6]), j+1);


				//series1.add(Integer.parseUnsignedInt(array[j][6]), j+1);
			
				j++;
				
				
			}
			

			dataset.addSeries(series1); 
	  }
		 
		 catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		 //dataset.addSeries(series1); 
		 
		 return dataset;
		 }
	
	//START COMBINEVALUES METHOD	
	public static String[][] combineValues(JTable table) throws IOException {
	   // TableModel model = table.getModel();
	    JButton open = new JButton();
	    JFileChooser fc = new JFileChooser();
	    fc.setCurrentDirectory(new java.io.File("."));
	    fc.setDialogTitle("Choose File");
	    if (fc.showOpenDialog (open) == JFileChooser.APPROVE_OPTION){
	        //
	        }
	    String path = fc.getSelectedFile().getAbsolutePath();
	    String line = "";
	    BufferedReader br;
	    String[][] attendanceData = null; //attendance file array
	    String [][] arrayFinal = null; //Combined final results between attendance file and JTable.
	    //String[] header = { "ID", "First Name", "Last Name" , "Academic Level" , "ASURITE" , todayAsString};
	    int lengthData = 1;
	    
	//BUILD ARRAY FROM ATTENDANCE FILE

	    try {
	        br = new BufferedReader(new FileReader(path));
	        List<String[]> lines = new ArrayList<String[]>();
	       
	        while ((line = br.readLine()) != null)
	        {
	            lines.add(line.split(","));
	        }

	        attendanceData = new String[lines.size()][0];
	        lines.toArray(attendanceData);
	       
	        lengthData = lines.size();
	        
	        br.close();
	   
	    }  
	    catch (FileNotFoundException e1)
	    {
	        e1.printStackTrace();
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    }

	//Create array from JTable ***
	    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
	    int xRow = lengthData;
	    Object[][] tableData = new Object[nRow][nCol];
	    String[][] tableDataFn = new String[nRow][nCol];
	    arrayFinal = new String[nRow][nCol+1];
	    int tableCol = nCol-1;
	    for (int i = 0 ; i < nRow ; i++)
	        for (int j = 0 ; j < nCol ; j++)
	        {
	            tableData[i][j] = dtm.getValueAt(i,j);
	            tableDataFn[i][j] = dtm.getValueAt(i,j).toString();
	        }
	    int headerLenght = table.getColumnCount();
	       
	    for (int a = 0 ; a < nRow ; a++)
	    {

	        for (int b = 0 ; b < xRow ; b++)
	        {
	        	
	        	if (tableDataFn[a][5].contains(attendanceData[b][0]))
	            {
	                
	                for (int c = 0 ; c < headerLenght; c++)
	                {
	                    arrayFinal [a][c] = tableDataFn[a][c];
	                }
	                arrayFinal [a][tableCol+1] = attendanceData[b][1];
	                break;
	            }
	            if (!(tableDataFn[a][5].equalsIgnoreCase(attendanceData[b][0]))){
                	String subValue = tableDataFn[a][5].substring(1,4);
                	String subValue2 = attendanceData[b][0].substring(1,4);
                	
    	        	if (subValue2.contains(subValue))
    	            {
    	                for (int c = 0 ; c < headerLenght; c++)
    	                {
    	                    arrayFinal [a][c] = tableDataFn[a][c];
    	                }
    	                arrayFinal [a][tableCol+1] = attendanceData[b][1];
    	                break;
    	            } else
    	            {
		                for (int c = 0 ; c < headerLenght; c++)
		                {
		                    arrayFinal [a][c] = tableDataFn[a][c];
		                }
		            
		                
		                arrayFinal [a][tableCol+1] = "0";
    	            }
	                
	            }
	            
	           
	           
	        }

	    }

	       
	    return arrayFinal;
	    }
	
	
	public void exportTable(JTable table, File file) throws IOException {
       TableModel model = table.getModel();
       FileWriter out = new FileWriter(file);

       for(int i=0; i < model.getColumnCount(); i++) {
           out.write(model.getColumnName(i) + ",");
       }
       out.write("\n");
       for(int i=0; i< model.getRowCount(); i++) {
           for(int j=0; j < model.getColumnCount(); j++) {
               out.write(model.getValueAt(i,j).toString()+",");
           }
           out.write("\n");
       }
       out.close();
       System.out.println("write out to: " + file);
   }
	
	public void exportTable2(JTable table, File file) throws IOException {
	       TableModel model = table.getModel();
	       FileWriter out = new FileWriter(file);
	       for(int i=0; i< model.getRowCount(); i++) {
	           for(int j=0; j < model.getColumnCount(); j++) {
	               out.write(model.getValueAt(i,j).toString()+",");
	           }
	           out.write("\n");
	       }
	       out.close();
	       System.out.println("write out to: " + file);
	   }
	}

