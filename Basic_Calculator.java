import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Stack;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

public class Basic_Calculator implements ActionListener{
	
//Global declaration;
	JFrame frame;
	JLabel maindisp, subdisp, titlelabel;
	//----------------------------------------------------------------------------------------//
	JButton onebutton, twobutton, threebutton, fourbutton, fivebutton, sixbutton, sevenbutton,
	eightbutton, ninebutton, zerobutton, addbutton, subtractbutton, multiplybutton, divbutton,
	equalbutton, modbutton, pombutton, powerbutton, sqrtbutton, divxbutton, decimalbutton, cbutton,
	cebutton, backbutton, exitbutton, maxbutton, minbutton, memoryclear, memoryrecall,memoryadd,
	memorysub, memorystore, memory;
	//---------------------------------------------------------------------------------------//
	Boolean operator=false;
	String value, symbol, newvalue, lastoperator, nextinput, inputvalue, ACTION_KEY = "The Action";
	int choice = 0;
	float oldvaluef, newvaluef, result;
	//---------------------------------------------------------------------------------------//
	Point mouseDownScreenCoords, mouseDownCompCoords, currCoords;
	//---------------------------------------------------------------------------------------//
    Stack<String> stack_1 = new Stack<>();
    Stack<String> stack_2 = new Stack<>();
    Stack<String> stack_3 = new Stack<>();
    Stack<String> stack_4 = new Stack<>();    
    Stack<String> memstack = new Stack<>();
	//---------------------------------------------------------------------------------------//

	Basic_Calculator(){
		
	//Base frame creation	
		frame=new JFrame();
		frame.setBounds(500, 100, 505, 550);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setOpacity(0.90f);
		
	//Main display creation
		maindisp=new JLabel(" ", SwingConstants.RIGHT);
		maindisp.setBounds(0, 110, 505, 70);
		maindisp.setFont(new FontUIResource("segoe UI", Font.BOLD, 40));
		maindisp.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		frame.add(maindisp);
		
	//Sub display creation
        subdisp=new JLabel(" ", SwingConstants.RIGHT);
        subdisp.setBounds(300, 40, 200, 70);
        subdisp.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        frame.add(subdisp);
        
    //Title label
        titlelabel = new JLabel("Calculator");
        titlelabel.setBounds(15, 2, 100, 30);
        titlelabel.setFont(new FontUIResource("segoe UI", Font.ROMAN_BASELINE, 13));
        titlelabel.setForeground(Color.BLACK);
        titlelabel.setOpaque(false);
        frame.add(titlelabel);
        
    //Memory buttons
        memoryclear=new JButton("MC");
        memoryrecall=new JButton("MR");
        memoryadd=new JButton("M+");
        memorysub=new JButton("M-");
        memorystore=new JButton("MS");
        memory=new JButton("M");
        
        memoryclear.setBounds(5, 185, 78, 30);
        memoryrecall.setBounds(88, 185, 78, 30);
        memoryadd.setBounds(172, 185, 78, 30);
        memorysub.setBounds(255, 185, 78, 30);
        memorystore.setBounds(339, 185, 78, 30);
        memory.setBounds(422, 185, 78, 30);
        
        memoryclear.setFont(new FontUIResource("segoe UI", Font.BOLD, 11));
        memoryrecall.setFont(new FontUIResource("segoe UI", Font.BOLD, 11));
        memoryadd.setFont(new FontUIResource("segoe UI", Font.BOLD, 11));
        memorysub.setFont(new FontUIResource("segoe UI", Font.BOLD, 11));
        memorystore.setFont(new FontUIResource("segoe UI", Font.BOLD, 11));
        memory.setFont(new FontUIResource("segoe UI", Font.BOLD, 11));

        memoryclear.setBackground(new Color(200, 211, 224));
        memoryrecall.setBackground(new Color(200, 211, 224));
        memoryadd.setBackground(new Color(200, 211, 224));
        memorysub.setBackground(new Color(200, 211, 224));
        memorystore.setBackground(new Color(200, 211, 224));
        memory.setBackground(new Color(200, 211, 224));
        
        memoryclear.setOpaque(false);
        memoryrecall.setOpaque(false);
        memoryadd.setOpaque(false);
        memorysub.setOpaque(false);
        memorystore.setOpaque(false);
        memory.setOpaque(false);
        
        memoryclear.setEnabled(false);
        memoryrecall.setEnabled(false);
        memory.setEnabled(false);
        
        memoryclear.setBorderPainted(false);
        memoryrecall.setBorderPainted(false);
        memoryadd.setBorderPainted(false);
        memorysub.setBorderPainted(false);
        memorystore.setBorderPainted(false);
        memory.setBorderPainted(false);
        
        frame.add(memoryclear);
        frame.add(memoryrecall);
        frame.add(memoryadd);
        frame.add(memorysub);
        frame.add(memorystore);
        frame.add(memory);

    //Button creation
		onebutton=new JButton("1");
		twobutton=new JButton("2");
		threebutton=new JButton("3");
		fourbutton=new JButton("4");
		fivebutton=new JButton("5");
		sixbutton=new JButton("6");
		sevenbutton=new JButton("7");
		eightbutton=new JButton("8");
		ninebutton=new JButton("9");
		zerobutton=new JButton("0");
		addbutton=new JButton("\u002B");
		subtractbutton=new JButton("\u2212");
		multiplybutton=new JButton("\u00D7");
		divbutton=new JButton("\u00F7");
		equalbutton=new JButton("\u003D");
		pombutton=new JButton("\u00B1");
		modbutton=new JButton("\u0025");
		sqrtbutton=new JButton("\u221A");
		powerbutton=new JButton("x"+"\u00B2");
		divxbutton=new JButton("1/x");
		decimalbutton=new JButton(".");
		cbutton=new JButton("C");
		cebutton=new JButton("CE");
		backbutton=new JButton("\u2190");
        exitbutton=new JButton("\u00D7");
        maxbutton=new JButton("\u25A1");
        minbutton=new JButton("\u2212");
		
        modbutton.setBounds(5, 220, 120, 50);
        sqrtbutton.setBounds(130, 220, 120, 50);
        powerbutton.setBounds(255, 220, 120, 50);
        divxbutton.setBounds(380, 220, 120, 50);
        cebutton.setBounds(5, 275, 120, 50);
        cbutton.setBounds(130, 275, 120, 50);
        backbutton.setBounds(255, 275, 120, 50);
        divbutton.setBounds(380, 275, 120, 50);
        sevenbutton.setBounds(5, 330, 120, 50);
        eightbutton.setBounds(130, 330, 120, 50);
        ninebutton.setBounds(255, 330, 120, 50);
        multiplybutton.setBounds(380, 330, 120, 50);
        fourbutton.setBounds(5, 385, 120, 50);
        fivebutton.setBounds(130, 385, 120, 50);
        sixbutton.setBounds(255, 385, 120, 50);
        subtractbutton.setBounds(380, 385, 120, 50);
        onebutton.setBounds(5, 440, 120, 50);
        twobutton.setBounds(130, 440, 120, 50);
        threebutton.setBounds(255, 440, 120, 50);
        addbutton.setBounds(380, 440, 120, 50);
        pombutton.setBounds(5, 495, 120, 50);
        zerobutton.setBounds(130, 495, 120, 50);
        decimalbutton.setBounds(255, 495, 120, 50);
        equalbutton.setBounds(380, 495, 120, 50);
        exitbutton.setBounds(455, 0, 50, 30);
        maxbutton.setBounds(405, 0, 50, 30);
        minbutton.setBounds(355, 0, 50, 30);

        modbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        sqrtbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        powerbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        divxbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 15));
        cebutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 15));
        cbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 15));
        backbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        divbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        sevenbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        eightbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        ninebutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        multiplybutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        fourbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        fivebutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        sixbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        subtractbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        onebutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        twobutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        threebutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        addbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        pombutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        zerobutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        decimalbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        equalbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        exitbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        maxbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));
        minbutton.setFont(new FontUIResource("segoe UI", Font.PLAIN, 20));

        modbutton.setBackground(new Color(219, 217, 217));
        sqrtbutton.setBackground(new Color(219, 217, 217));
        powerbutton.setBackground(new Color(219, 217, 217));
        divxbutton.setBackground(new Color(219, 217, 217));
        cebutton.setBackground(new Color(219, 217, 217));
        cbutton.setBackground(new Color(219, 217, 217));
        backbutton.setBackground(new Color(219, 217, 217));
        divbutton.setBackground(new Color(219, 217, 217));
        sevenbutton.setBackground(new Color(255, 255, 255));
        eightbutton.setBackground(new Color(255, 255, 255));
        ninebutton.setBackground(new Color(255, 255, 255));
        multiplybutton.setBackground(new Color(219, 217, 217));
        fourbutton.setBackground(new Color(255, 255, 255));
        fivebutton.setBackground(new Color(255, 255, 255));
        sixbutton.setBackground(new Color(255, 255, 255));
        subtractbutton.setBackground(new Color(219, 217, 217));
        onebutton.setBackground(new Color(255, 255, 255));
        twobutton.setBackground(new Color(255, 255, 255));
        threebutton.setBackground(new Color(255, 255, 255));
        addbutton.setBackground(new Color(219, 217, 217));
        pombutton.setBackground(new Color(219, 217, 217));
        zerobutton.setBackground(new Color(255, 255, 255));
        decimalbutton.setBackground(new Color(255, 255, 255));
        equalbutton.setBackground(new Color(219, 217, 217));
        exitbutton.setBackground(new Color(225, 226, 227));
        maxbutton.setBackground(new Color(225, 226, 227));
        minbutton.setBackground(new Color(225, 226, 227));

        modbutton.setBorderPainted(false);
        sqrtbutton.setBorderPainted(false);
        powerbutton.setBorderPainted(false);
        divxbutton.setBorderPainted(false);
        cebutton.setBorderPainted(false);
        cbutton.setBorderPainted(false);
        backbutton.setBorderPainted(false);
        divbutton.setBorderPainted(false);
        sevenbutton.setBorderPainted(false); 
        eightbutton.setBorderPainted(false);
        ninebutton.setBorderPainted(false);
        multiplybutton.setBorderPainted(false);
        fourbutton.setBorderPainted(false);
        fivebutton.setBorderPainted(false);
        sixbutton.setBorderPainted(false);
        subtractbutton.setBorderPainted(false);
        onebutton.setBorderPainted(false);
        twobutton.setBorderPainted(false);
        threebutton.setBorderPainted(false);
        addbutton.setBorderPainted(false);
        pombutton.setBorderPainted(false);
        zerobutton.setBorderPainted(false);
        decimalbutton.setBorderPainted(false);
        equalbutton.setBorderPainted(false);
        exitbutton.setBorderPainted(false);
        maxbutton.setBorderPainted(false);
        minbutton.setBorderPainted(false);

        minbutton.setOpaque(false);
        maxbutton.setOpaque(false);
        exitbutton.setOpaque(false);
        
        frame.add(modbutton);
        frame.add(sqrtbutton);
        frame.add(powerbutton);
        frame.add(divxbutton);        
        frame.add(cebutton);
        frame.add(cbutton); 
        frame.add(backbutton);
        frame.add(divbutton);
        frame.add(sevenbutton);
        frame.add(eightbutton);
        frame.add(ninebutton);
        frame.add(multiplybutton);
        frame.add(fourbutton);
        frame.add(fivebutton);
        frame.add(sixbutton);
        frame.add(subtractbutton);
        frame.add(onebutton);
        frame.add(twobutton);
        frame.add(threebutton);
        frame.add(addbutton);
        frame.add(pombutton);
        frame.add(zerobutton);
        frame.add(decimalbutton);
        frame.add(equalbutton);
        frame.add(exitbutton);
        frame.add(maxbutton);
        frame.add(minbutton);
        
    //Action Listener 
        modbutton.addActionListener(this);
        sqrtbutton.addActionListener(this);
        powerbutton.addActionListener(this);
        divxbutton.addActionListener(this);
        cebutton.addActionListener(this);
        cbutton.addActionListener(this);
        backbutton.addActionListener(this);
        divbutton.addActionListener(this);
        sevenbutton.addActionListener(this);
        eightbutton.addActionListener(this);
        ninebutton.addActionListener(this);
        multiplybutton.addActionListener(this);
        fourbutton.addActionListener(this);
        fivebutton.addActionListener(this);
        sixbutton.addActionListener(this);
        subtractbutton.addActionListener(this);
        onebutton.addActionListener(this);
        twobutton.addActionListener(this);
        threebutton.addActionListener(this);
        addbutton.addActionListener(this);
        pombutton.addActionListener(this);
        zerobutton.addActionListener(this);
        decimalbutton.addActionListener(this);
        equalbutton.addActionListener(this);
        exitbutton.addActionListener(this);
        maxbutton.addActionListener(this);
        minbutton.addActionListener(this);
        memoryclear.addActionListener(this);
        memoryrecall.addActionListener(this);
        memoryadd.addActionListener(this);
        memorysub.addActionListener(this);
        memorystore.addActionListener(this);
        memory.addActionListener(this);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	//Changing button color on mouse hover
		exitbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 if (!exitbutton.isOpaque()) {
		                exitbutton.setOpaque(true);
				}
	                exitbutton.setBackground(Color.RED);
				}
	            public void mouseExited(MouseEvent evt) {
	                exitbutton.setOpaque(false);
	            }
		});
		minbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 if (!minbutton.isOpaque()) {
					 minbutton.setOpaque(true);
				}
				 minbutton.setBackground(new Color(215, 218, 222));
				}
	            public void mouseExited(MouseEvent evt) {
	            	minbutton.setOpaque(false);
	            }
		});
		maxbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 if (!maxbutton.isOpaque()) {
					 maxbutton.setOpaque(true);
				}
				 maxbutton.setBackground(new Color(215, 228, 245));
				}
	            public void mouseExited(MouseEvent evt) {
	            	maxbutton.setOpaque(false);
	            }
		});
		
		pombutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 pombutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	                pombutton.setBackground(new Color(219, 217, 217));
	            }
		});
		zerobutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 zerobutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	zerobutton.setBackground(new Color(255, 255, 255));
	            }
		});
		decimalbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 decimalbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	decimalbutton.setBackground(new Color(255, 255, 255));
	            }
		});
		equalbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 equalbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	                equalbutton.setBackground(new Color(219, 217, 217));
	            }
		});
		
		onebutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 onebutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	onebutton.setBackground(new Color(255, 255, 255));
	            }
		});
		twobutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 twobutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	twobutton.setBackground(new Color(255, 255, 255));
	            }
		});
		threebutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 threebutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	threebutton.setBackground(new Color(255, 255, 255));
	            }
		});
		addbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 addbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	                addbutton.setBackground(new Color(219, 217, 217));
	            }
		});
		
		fourbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 fourbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	                fourbutton.setBackground(new Color(255, 255, 255));
	            }
		});
		fivebutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 fivebutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	                fivebutton.setBackground(new Color(255, 255, 255));
	            }
		});
		sixbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 sixbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	                sixbutton.setBackground(new Color(255, 255, 255));
	            }
		});
		subtractbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 subtractbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	                subtractbutton.setBackground(new Color(219, 217, 217));
	            }
		});

		sevenbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 sevenbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	sevenbutton.setBackground(new Color(255, 255, 255));
	            }
		});
		eightbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 eightbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	eightbutton.setBackground(new Color(255, 255, 255));
	            }
		});
		ninebutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 ninebutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	ninebutton.setBackground(new Color(255, 255, 255));
	            }
		});
		multiplybutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 multiplybutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	multiplybutton.setBackground(new Color(219, 217, 217));
	            }
		});
		
		cebutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 cebutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	cebutton.setBackground(new Color(219, 217, 217));
	            }
		});
		cbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 cbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	cbutton.setBackground(new Color(219, 217, 217));
	            }
		});
		backbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 backbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	backbutton.setBackground(new Color(219, 217, 217));
	            }
		});
		divbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 divbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	divbutton.setBackground(new Color(219, 217, 217));
	            }
		});
		
		modbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 modbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	modbutton.setBackground(new Color(219, 217, 217));
	            }
		});
		sqrtbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 sqrtbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	sqrtbutton.setBackground(new Color(219, 217, 217));
	            }
		});
		powerbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 powerbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	powerbutton.setBackground(new Color(219, 217, 217));
	            }
		});
		divxbutton.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 divxbutton.setBackground(Color.LIGHT_GRAY);
				}
	            public void mouseExited(MouseEvent evt) {
	            	divxbutton.setBackground(new Color(219, 217, 217));
	            }
		});
		
		memoryclear.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 if (!memoryclear.isBorderPainted()) {
		                memoryclear.setBorderPainted(true);
		                memoryclear.setOpaque(true);
				}
					memoryclear.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
					memoryclear.setBackground(Color.LIGHT_GRAY);
			 }
	            public void mouseExited(MouseEvent evt) {
	                memoryclear.setBorderPainted(false);
	                memoryclear.setOpaque(false);
	            }
		});
		memoryrecall.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 if (!memoryrecall.isBorderPainted()) {
					 memoryrecall.setBorderPainted(true);
					 memoryrecall.setOpaque(true);
				}
				 memoryrecall.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
				 memoryrecall.setBackground(Color.LIGHT_GRAY);
			 }
	            public void mouseExited(MouseEvent evt) {
	            	memoryrecall.setBorderPainted(false);
	            	memoryrecall.setOpaque(false);
	            }
		});
		memoryadd.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 if (!memoryadd.isBorderPainted()) {
					 memoryadd.setBorderPainted(true);
					 memoryadd.setOpaque(true);
				}
				 memoryadd.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
				 memoryadd.setBackground(Color.LIGHT_GRAY);
			 }
	            public void mouseExited(MouseEvent evt) {
	            	memoryadd.setBorderPainted(false);
	            	memoryadd.setOpaque(false);
	            }
		});
		memorysub.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 if (!memorysub.isBorderPainted()) {
					 memorysub.setBorderPainted(true);
					 memorysub.setOpaque(true);
				}
				 memorysub.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
				 memorysub.setBackground(Color.LIGHT_GRAY);
			 }
	            public void mouseExited(MouseEvent evt) {
	            	memorysub.setBorderPainted(false);
	            	memorysub.setOpaque(false);
	            }
		});
		memorystore.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 if (!memorystore.isBorderPainted()) {
					 memorystore.setBorderPainted(true);
					 memorystore.setOpaque(true);
				}
				 memorystore.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
				 memorystore.setBackground(Color.LIGHT_GRAY);
			 }
	            public void mouseExited(MouseEvent evt) {
	            	memorystore.setBorderPainted(false);
	            	memorystore.setOpaque(false);
	            }
		});
		memory.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) {
				 if (!memory.isBorderPainted()) {
					 memory.setBorderPainted(true);
					 memory.setOpaque(true);
				}
				 memory.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
				 memory.setBackground(Color.LIGHT_GRAY);
			 }
	            public void mouseExited(MouseEvent evt) {
	            	memory.setBorderPainted(false);
	            	memory.setOpaque(false);
	            }
		});
		
    //To track mouse moves and mouse drags, use the MouseMotionListener
        mouseDownCompCoords=null;
        mouseDownScreenCoords=null;
        frame.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				   mouseDownCompCoords=null;
		            mouseDownScreenCoords=null;				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				mouseDownScreenCoords=e.getLocationOnScreen();
	            mouseDownCompCoords=e.getPoint();				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        frame.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {

                currCoords = e.getLocationOnScreen();
                frame.setLocation(mouseDownScreenCoords.x + (currCoords.x - mouseDownScreenCoords.x) - mouseDownCompCoords.x,
                mouseDownScreenCoords.y + (currCoords.y - mouseDownScreenCoords.y) - mouseDownCompCoords.y);				
			}
		});
        
    //Key binding
        ActionMap one_1 = onebutton.getActionMap();
        ActionMap two_2 = twobutton.getActionMap();
        ActionMap three_3 = threebutton.getActionMap();
        ActionMap four_4 = fourbutton.getActionMap();
        ActionMap five_5 = fivebutton.getActionMap();
        ActionMap six_6 = sixbutton.getActionMap();
        ActionMap seven_7 = sevenbutton.getActionMap();
        ActionMap eight_8 = eightbutton.getActionMap();
        ActionMap nine_9 = ninebutton.getActionMap();
        ActionMap zero_0 = zerobutton.getActionMap();
        ActionMap getmod = modbutton.getActionMap();
        ActionMap getsqrt = sqrtbutton.getActionMap();
        ActionMap getpower = powerbutton.getActionMap();
        ActionMap getdivx = divxbutton.getActionMap();
        ActionMap getclear = cbutton.getActionMap();
        ActionMap getback = backbutton.getActionMap();
        ActionMap getsub = subtractbutton.getActionMap();
        ActionMap getadd = addbutton.getActionMap();
        ActionMap getprod = multiplybutton.getActionMap();
        ActionMap getdiv = divbutton.getActionMap();
        ActionMap getres = equalbutton.getActionMap();
        ActionMap getmin = pombutton.getActionMap();
        ActionMap getdot = decimalbutton.getActionMap();
        
        one_1.put(ACTION_KEY, action);
        two_2.put(ACTION_KEY, action);
        three_3.put(ACTION_KEY, action);
        four_4.put(ACTION_KEY, action);
        five_5.put(ACTION_KEY, action);
        six_6.put(ACTION_KEY, action);
        seven_7.put(ACTION_KEY, action);
        eight_8.put(ACTION_KEY, action);
        nine_9.put(ACTION_KEY, action);
        zero_0.put(ACTION_KEY, action);
        getmod.put(ACTION_KEY, action);
        getsqrt.put(ACTION_KEY, action);
        getpower.put(ACTION_KEY, action);
        getdivx.put(ACTION_KEY, action);
        getclear.put(ACTION_KEY, action);
        getback.put(ACTION_KEY, action);
        getsub.put(ACTION_KEY, action);
        getadd.put(ACTION_KEY, action);
        getprod.put(ACTION_KEY, action);
        getdiv.put(ACTION_KEY, action);
        getres.put(ACTION_KEY, action);
        getmin.put(ACTION_KEY, action);
        getdot.put(ACTION_KEY, action);

        KeyStroke onepressed = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1,0);
        KeyStroke twopressed = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2,0);
        KeyStroke threepressed = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3,0);
        KeyStroke fourpressed = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4,0);
        KeyStroke fivepressed = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5,0);
        KeyStroke sixpressed = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6,0);
        KeyStroke sevenpressed = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7,0);
        KeyStroke eightpressed = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8,0);
        KeyStroke ninepressed = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9,0);
        KeyStroke zeropressed = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0,0);
        KeyStroke modpressed = KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.SHIFT_DOWN_MASK);
        KeyStroke sqrtpressed = KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.SHIFT_DOWN_MASK);
        KeyStroke powerpressed = KeyStroke.getKeyStroke(KeyEvent.VK_6, InputEvent.SHIFT_DOWN_MASK);
        KeyStroke divxpressed = KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.SHIFT_DOWN_MASK);
        KeyStroke clearpressed = KeyStroke.getKeyStroke(KeyEvent.VK_C,0);
        KeyStroke backpressed = KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE,0);
        KeyStroke subpressed = KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT,0);
        KeyStroke addpressed = KeyStroke.getKeyStroke(KeyEvent.VK_ADD,0);
        KeyStroke mulpressed = KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY,0);
        KeyStroke divpressed = KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE,0);
        KeyStroke equalpressed = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0);
        KeyStroke dotpressed = KeyStroke.getKeyStroke(KeyEvent.VK_DECIMAL,0);
        KeyStroke pompressed = KeyStroke.getKeyStroke(KeyEvent.VK_M, 0);
        
        InputMap one = onebutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap two = twobutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap three = threebutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap four = fourbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap five = fivebutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap six = sixbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap seven = sevenbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap eight = eightbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap nine = ninebutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap zero = zerobutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap mod = modbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap sqr = sqrtbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap power = powerbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap divx = divxbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap clear = cbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap backspace = backbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap sub = subtractbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap add = addbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap mul = multiplybutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap div = divbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap equal = equalbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap dot = decimalbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        InputMap pom = pombutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        one.put(onepressed, ACTION_KEY);
        two.put(twopressed, ACTION_KEY);
        three.put(threepressed, ACTION_KEY);
        four.put(fourpressed, ACTION_KEY);
        five.put(fivepressed, ACTION_KEY);
        six.put(sixpressed, ACTION_KEY);
        seven.put(sevenpressed, ACTION_KEY);
        eight.put(eightpressed, ACTION_KEY);
        nine.put(ninepressed, ACTION_KEY);
        zero.put(zeropressed, ACTION_KEY);
        mod.put(modpressed, ACTION_KEY);
        sqr.put(sqrtpressed, ACTION_KEY);
        power.put(powerpressed, ACTION_KEY);
        divx.put(divxpressed, ACTION_KEY);
        clear.put(clearpressed, ACTION_KEY);
        backspace.put(backpressed, ACTION_KEY);
        sub.put(subpressed, ACTION_KEY);
        add.put(addpressed, ACTION_KEY);
        mul.put(mulpressed, ACTION_KEY);
        div.put(divpressed, ACTION_KEY);
        equal.put(equalpressed, ACTION_KEY);
        dot.put(dotpressed, ACTION_KEY);
        pom.put(pompressed, ACTION_KEY);

        onebutton.setActionMap(one_1);
        twobutton.setActionMap(two_2);
        threebutton.setActionMap(three_3);
        fourbutton.setActionMap(four_4);
        fivebutton.setActionMap(five_5);
        sixbutton.setActionMap(six_6);
        sevenbutton.setActionMap(seven_7);
        eightbutton.setActionMap(eight_8);
        ninebutton.setActionMap(nine_9);
        zerobutton.setActionMap(zero_0);
        modbutton.setActionMap(getmod);
        sqrtbutton.setActionMap(getsqrt);
        powerbutton.setActionMap(getpower);
        divxbutton.setActionMap(getdivx);
        cbutton.setActionMap(getclear);
        cbutton.setActionMap(getback);
        subtractbutton.setActionMap(getsub);
        addbutton.setActionMap(getadd);
        multiplybutton.setActionMap(getprod);
        divbutton.setActionMap(getdiv);
        equalbutton.setActionMap(getres);
        decimalbutton.setActionMap(getdot);
        pombutton.setActionMap(getmin);

	}
	
	Action action = new AbstractAction() {
		
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton source = (JButton) e.getSource();
			if (source != null) {
		        maindisp.setBorder(null);
			}
			
			if (source.equals(ninebutton)) {
                keyPressed("9");
            }
			else if (source.equals(eightbutton)) {
                keyPressed("8");
            }
            else if (source.equals(sevenbutton)) {
                keyPressed("7");
            }
            else if (source.equals(sixbutton)) {
                keyPressed("6");
            }
            else if (source.equals(fivebutton)) {
                keyPressed("5");
            }
            else if (source.equals(fourbutton)) {
                keyPressed("4");
            }
            else if (source.equals(threebutton)) {
                keyPressed("3");
            }
            else if (source.equals(twobutton)) {
                keyPressed("2");
            }
            else if (source.equals(onebutton)) {
                keyPressed("1");
            }
            else if (source.equals(zerobutton)) {
                keyPressed("0");
            }
            else if (source.equals(addbutton)) {
                keyPressed("+");
            }
            else if (source.equals(subtractbutton)) {
                keyPressed("-");
            }
            else if (source.equals(multiplybutton)) {
                keyPressed("x");
            }
            else if (source.equals(divbutton)) {
                keyPressed("/");
            }
            else if (source.equals(cbutton)) {
                keyPressed("c");
            }
            else if (source.equals(decimalbutton)) {
                keyPressed(".");
            }
            else if (source.equals(pombutton)) {
                keyPressed("pm");
            }
            else if (source.equals(modbutton)) {
                keyPressed("p");
            }
            else if (source.equals(sqrtbutton)) {
                keyPressed("sr");
            }
            else if (source.equals(powerbutton)) {
                keyPressed("pw");
            }
            else if (source.equals(divxbutton)) {
                keyPressed("dx");
            }
            else if (source.equals(equalbutton)) {
                keyPressed("=");
            }
            else if (source.equals(backbutton)) {
                keyPressed("b");
            }			
		}
	};
	
	public void keyPressed(String num) {
	
		if (num == "9") {
            if (operator) {
                maindisp.setText("9");
                operator = false;
            }
            else{
                maindisp.setText(maindisp.getText()+"9");
            }
        }
		else if (num == "8") {
            if (operator) {
                maindisp.setText("8");
                operator = false;
            }
            else{
            	maindisp.setText(maindisp.getText()+"8");
            }
        }
		else if (num == "7") {
            if (operator) {
            	maindisp.setText("7");
                operator = false;
            }
            else{
            	maindisp.setText(maindisp.getText()+"7");
            }        
        }
		else if (num == "6") {
            if (operator) {
            	maindisp.setText("6");
                operator = false;
            }
            else{
            	maindisp.setText(maindisp.getText()+"6");
            }        
        }
		else if (num == "6") {
            if (operator) {
            	maindisp.setText("6");
                operator = false;
            }
            else{
            	maindisp.setText(maindisp.getText()+"6");
            }        
        }
		else if (num == "5") {
            if (operator) {
            	maindisp.setText("5");
                operator = false;
            }
            else{
            	maindisp.setText(maindisp.getText()+"5");
            }        
        }
		else if (num == "4") {
            if (operator) {
            	maindisp.setText("4");
                operator = false;
            }
            else{
            	maindisp.setText(maindisp.getText()+"4");
            }        
        }
		else if (num == "3") {
            if (operator) {
            	maindisp.setText("3");
                operator = false;
            }
            else{
            	maindisp.setText(maindisp.getText()+"3");
            }        
        }
		else if (num == "2") {
            if (operator) {
            	maindisp.setText("2");
                operator = false;
            }
            else{
            	maindisp.setText(maindisp.getText()+"2");
            }        
        }
		else if (num == "1") {
            if (operator) {
            	maindisp.setText("1");
                operator = false;
            }
            else{
            	maindisp.setText(maindisp.getText()+"1");
            }        
        }
		else if (num == "0") {
            if (operator) {
            	maindisp.setText("0");
                operator = false;
            }
            else{
            	maindisp.setText(maindisp.getText()+"0");
            }        
        }
		else if (num == "+") {
            operator = true;
            subdisp.setText(subdisp.getText()+maindisp.getText()+"+");
            value = maindisp.getText();
            symbol = "+";
            getValues(value, symbol);
        }
		else if (num == "-") {
            operator = true;
            subdisp.setText(subdisp.getText()+maindisp.getText()+"-");
            value = maindisp.getText();
            symbol = "-";
            getValues(value, symbol);
        }
		else if (num == "x") {
            operator = true;
            subdisp.setText(subdisp.getText()+maindisp.getText()+"x");
            value = maindisp.getText();
            symbol = "x";
            getValues(value, symbol);
        }
		else if (num == "/") {
            operator = true;
            subdisp.setText(subdisp.getText()+maindisp.getText()+"\u00F7");
            value = maindisp.getText();
            symbol = "/";
            getValues(value, symbol);
        }
		else if (num=="c") {
        	subdisp.setText("");
            oldvaluef = newvaluef = result = 0;
        	value = symbol = newvalue = "";
        	  stack_1.clear();
              stack_2.clear();
              stack_3.clear();
              stack_4.clear();
            maindisp.setText("");
    		maindisp.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            lastoperator = "";
        }
		else if (num==".") {
            if (operator) {
            	maindisp.setText(".");
            }
            else{
            	maindisp.setText(maindisp.getText()+".");
            }
        }
		else if (num=="b") {
        	maindisp.setText(maindisp.getText().substring(0, maindisp.getText().length()-1));
        }
		else if (num=="p") {
        	operator = true;
            subdisp.setText(subdisp.getText()+maindisp.getText()+"%");
            oldvaluef = Float.parseFloat(maindisp.getText());
            choice = 1;
        }
		else if (num=="pm") {
        	if (subdisp.getText()=="") {
				value = "0";
				symbol = "-";
				getValues(value, symbol);
			}
            subdisp.setText("0"+"-");
        }
        else if (num=="sr") {
        	operator = true;
            subdisp.setText("\u221A"+maindisp.getText());
            double x = Double.parseDouble(maindisp.getText());
            double result = Math.sqrt(x);
            maindisp.setText(result+"");
            subdisp.setText(" ");
        }
        else if (num=="pw") {
            operator = true;
            subdisp.setText(maindisp.getText()+"\u00B2");
            double y = Double.parseDouble(maindisp.getText());
            double result = Math.pow(y, 2);
            maindisp.setText(result+"");
            subdisp.setText(" ");
        }
        else if (num=="dx") {
        	operator = true;
            subdisp.setText("1"+"\u00F7"+maindisp.getText());
            float oldvalue = Float.parseFloat(maindisp.getText());
            Float result = 1/oldvalue;
            maindisp.setText(result+"");
            subdisp.setText(" ");
        }
        else if (num == "=") {
        	
            if (choice == 1) {
                newvalue = maindisp.getText();
                subdisp.setText(subdisp.getText()+newvalue);
                newvaluef = Float.parseFloat(newvalue);
                result = oldvaluef % newvaluef;
                maindisp.setText(result+"");
            }
            
            value = maindisp.getText();
            symbol = "=";
            getValues(value, symbol);

            while (!stack_1.empty()) {
                stack_2.push(stack_1.pop());
                lastoperator = "=";
            }

            while (!stack_2.empty()){
                nextinput = stack_2.pop();
                inputvalue = stack_2.pop();
                buttonHandler(inputvalue, nextinput);
            }
        }
		
	}
	
	//Accept input from buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() != null) {
	        maindisp.setBorder(null);
		}

		if (e.getSource()==onebutton) {
            if (operator) {
                maindisp.setText("1");
                operator = false;
            }
            else{
                maindisp.setText(maindisp.getText()+"1");
            }
        }
		else if (e.getSource()==twobutton) {
            if (operator) {
                maindisp.setText("2");
                operator = false;
            }
            else{
                maindisp.setText(maindisp.getText()+"2");
            }
        }
		else if (e.getSource()==threebutton) {
            if (operator) {
                maindisp.setText("3");
                operator = false;
            }
            else{
                maindisp.setText(maindisp.getText()+"3");
            }
        }
		else if (e.getSource()==fourbutton) {
            if (operator) {
                maindisp.setText("4");
                operator = false;
            }
            else{
                maindisp.setText(maindisp.getText()+"4");
            }
        }
		else if (e.getSource()==fivebutton) {
            if (operator) {
                maindisp.setText("5");
                operator = false;
            }
            else{
                maindisp.setText(maindisp.getText()+"5");
            }
        }
		else if (e.getSource()==sixbutton) {
            if (operator) {
                maindisp.setText("6");
                operator = false;
            }
            else{
                maindisp.setText(maindisp.getText()+"6");
            }
        }
		else if (e.getSource()==sevenbutton) {
            if (operator) {
                maindisp.setText("7");
                operator = false;
            }
            else{
                maindisp.setText(maindisp.getText()+"7");
            }
        }
		else if (e.getSource()==eightbutton) {
            if (operator) {
                maindisp.setText("8");
                operator = false;
            }
            else{
                maindisp.setText(maindisp.getText()+"8");
            }
        }
		else if (e.getSource()==ninebutton) {
            if (operator) {
                maindisp.setText("9");
                operator = false;
            }
            else{
                maindisp.setText(maindisp.getText()+"9");
            }
        }
		else if (e.getSource()==zerobutton) {
            if (operator) {
                maindisp.setText("0");
                operator = false;
            }
            else{
                maindisp.setText(maindisp.getText()+"0");
            }
        }
		else if (e.getSource()==cebutton) {
            maindisp.setText("");
        }
		else if (e.getSource()==cbutton) {
            subdisp.setText("");
            oldvaluef = newvaluef = result = 0;
        	value = symbol = newvalue = "";
        	  stack_1.clear();
              stack_2.clear();
              stack_3.clear();
              stack_4.clear();
            maindisp.setText("");
    		maindisp.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            lastoperator = "";
        }
		else if (e.getSource()==addbutton) {
            operator = true;
            subdisp.setText(subdisp.getText()+maindisp.getText()+"+");
            value = maindisp.getText();
            maindisp.setText(" ");
            symbol = "+";
            getValues(value, symbol);
        }
		else if (e.getSource()==subtractbutton) {
            operator = true;
            subdisp.setText(subdisp.getText()+maindisp.getText()+"-");
            value = maindisp.getText();
            maindisp.setText(" ");
            symbol = "-";
            getValues(value, symbol);
        }
		else if (e.getSource()==multiplybutton) {
            operator = true;
            subdisp.setText(subdisp.getText()+maindisp.getText()+"x");
            value = maindisp.getText();
            maindisp.setText(" ");
            symbol = "x";
            getValues(value, symbol);
        }
		else if (e.getSource()==divbutton) {
            operator = true;
            subdisp.setText(subdisp.getText()+maindisp.getText()+"\u00F7");
            value = maindisp.getText();
            maindisp.setText(" ");
            symbol = "/";
            getValues(value, symbol);
        }
		else if (e.getSource()==backbutton) {
        	if (maindisp.getText()=="") {
                subdisp.setText(subdisp.getText().substring(0, subdisp.getText().length()-1));
			}
        	else {
	            maindisp.setText(maindisp.getText().substring(0, maindisp.getText().length()-1));
			}
        }
		else if (e.getSource()==decimalbutton) {
            if (operator) {
                maindisp.setText(".");
            }
            else{
                maindisp.setText(maindisp.getText()+".");
            }
        }
		else if (e.getSource()==pombutton) {
            if (subdisp.getText()=="") {
				value = "0";
				symbol = "-";
				getValues(value, symbol);
			}
            subdisp.setText("0"+"-");
        }
		else if (e.getSource()==modbutton) {
            operator = true;
            subdisp.setText(subdisp.getText()+maindisp.getText()+"%");
            oldvaluef = Float.parseFloat(maindisp.getText());
            choice = 1;
        }
		else if (e.getSource()==sqrtbutton) {
            operator = true;
            subdisp.setText("\u221A"+maindisp.getText());
            double x = Double.parseDouble(maindisp.getText());
            double result = Math.sqrt(x);
            maindisp.setText(result+"");
            subdisp.setText(" ");
        }
		else if (e.getSource()==powerbutton) {
            operator = true;
            subdisp.setText(maindisp.getText()+"\u00B2");
            double y = Double.parseDouble(maindisp.getText());
            double result = Math.pow(y, 2);
            maindisp.setText(result+"");
            subdisp.setText(" ");
        }
		else if (e.getSource()==divxbutton) {
            operator = true;
            subdisp.setText("1"+"\u00F7"+maindisp.getText());
            float oldvalue = Float.parseFloat(maindisp.getText());
            Float result = 1/oldvalue;
            maindisp.setText(result+"");
            subdisp.setText(" ");
        }
		else if (e.getSource()==exitbutton) {
            System.exit(0);
        }
		else if (e.getSource()==minbutton) {
            frame.setState(JFrame.ICONIFIED);
        }
        else if (e.getSource() == equalbutton) {
            
        	if (choice == 1) {
                newvalue = maindisp.getText();
                subdisp.setText(subdisp.getText()+newvalue);
                newvaluef = Float.parseFloat(newvalue);
                result = oldvaluef % newvaluef;
                maindisp.setText(result+"");
            }
            
            value = maindisp.getText();
            symbol = "=";
            getValues(value, symbol);

            while (!stack_1.empty()) {
                stack_2.push(stack_1.pop());
                lastoperator = "=";
            }

            while (!stack_2.empty()){
                nextinput = stack_2.pop();
                inputvalue = stack_2.pop();
                buttonHandler(inputvalue, nextinput);
            }
        }
        else if (e.getSource()==memorystore) {
        	if (maindisp.getText() != "") {
                memoryclear.setEnabled(true);
                memoryrecall.setEnabled(true);
                memory.setEnabled(true);        		
    			memstack.push(maindisp.getText());
			}
		}
        else if (e.getSource()==memoryrecall) {
        	if (memstack.peek() != "") {
    			maindisp.setText(memstack.peek());
			}
		}
        else if (e.getSource()==memoryclear) {
        	memstack.clear();
            memoryclear.setEnabled(false);
            memoryrecall.setEnabled(false);
            memory.setEnabled(false);		
        }
        else if (e.getSource()==memoryadd) {
        	if (maindisp.getText() != "") {
    			float num1 = Float.parseFloat(memstack.peek());
    			float num2 = Float.parseFloat(maindisp.getText());
    			float out = num1 + num2;
    			memstack.push(out+"");
        	}
        }else if (e.getSource()==memorysub) {
        	if (maindisp.getText() != "") {
    			float num1 = Float.parseFloat(memstack.peek());
    			float num2 = Float.parseFloat(maindisp.getText());
    			float out = num1 - num2;
        	}
        }else if (e.getSource()==memory) {
        	if (!memstack.peek().isEmpty()) {
            	maindisp.setText(memstack.pop());
			}
        }
	}

	//store initial values to stack 1
	private void getValues(String value, String symbol) {
        stack_1.push(value);
        stack_1.push(symbol);
	}
	
	//method to find result
    private void buttonHandler(String buttonValue, String nexInput) {  
        
    	int choice = 0;
        if (lastoperator.equals("=")) {
            maindisp.setText("");
            subdisp.setText(" ");
        }
        
        if (buttonValue.length()>0) {
            try {
                if (!stack_3.empty()) {
                    if (stack_3.peek().equals("x")) {
                    	stack_3.pop();
                        float num1 = Float.parseFloat(stack_3.pop());
                        float num2 = Float.parseFloat(nexInput);
                        float result = num1 * num2;
                        nexInput = Float.toString(result);
                    }
                    else if (stack_3.peek().equals("/")) {
                    	stack_3.pop();
                        float num1 = Float.parseFloat(stack_3.pop());
                        float num2 = Float.parseFloat(nexInput);
                        if (num2 != 0) {
                        	float result = num1 / num2;
                            nexInput = Float.toString(result); 
						}
                        else {
                        	 choice = 1; 
                        }
                    }
                }
            }
            catch (Exception ex) {
                //System.out.println("something wrong in part 1");
            	maindisp.setText("Something went wrong");
            }
            if (!buttonValue.equals("=")) {
                stack_3.push(nexInput);
                stack_3.push(buttonValue);
            }
            else {
                if(!stack_3.empty()) {
                    try {
                        stack_3.push(nexInput);
                        while (!stack_3.empty()) {
                            stack_4.push(stack_3.pop());
                        }
                        while (!stack_4.empty()) {
                            String firstNumber = stack_4.pop();
                            if (stack_4.peek().equals("+")) {
                                stack_4.pop();
                                float num1 = Float.parseFloat(firstNumber);
                                float num2 = Float.parseFloat(stack_4.pop());
                                float result = num1 + num2;
                                nexInput = Float.toString(result);
                            }
                            else if (stack_4.peek().equals("-")) {
                                stack_4.pop();
                                float num1 = Float.parseFloat(firstNumber);
                                float num2 = Float.parseFloat(stack_4.pop());
                                float result = num1 - num2;
                                nexInput = Float.toString(result);
                            }
                            if (!stack_4.empty()) {
                                stack_4.push(nexInput);
                            }
                            else {
                                maindisp.setText(nexInput);
                            }
                        }
                    }
                    catch (Exception ex) {
                    //System.out.println("something wrong in part 2");
                    maindisp.setText("Something went wrong");
                }
            }
                else if(choice == 1) {
                	maindisp.setText("Cannot divided by zero");
                }
                else {
                    maindisp.setText(nexInput);
                }
        }
        }
    }
}
