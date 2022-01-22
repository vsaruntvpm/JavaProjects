import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

public class Basic_Calculator {
	
//Global declaration;
	JFrame frame;
	JLabel maindisp, subdisp, titlelabel;
	JButton onebutton, twobutton, threebutton, fourbutton, fivebutton, sixbutton, sevenbutton,
	eightbutton, ninebutton, zerobutton, addbutton, subtractbutton, multiplybutton, divbutton,
	equalbutton, modbutton, pombutton, powerbutton, sqrtbutton, divxbutton, decimalbutton, cbutton,
	cebutton, backbutton, exitbutton, maxbutton, minbutton, memoryclear, memoryrecall,memoryadd,
	memorysub, memorystore, memory;
	
	Basic_Calculator(){
		
	//Base frame creation	
		JFrame frame=new JFrame();
		frame.setBounds(500, 100, 505, 550);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setOpacity(0.90f);
		
	//Main display creation
		JLabel maindisp=new JLabel("0", SwingConstants.RIGHT);
		maindisp.setBounds(0, 110, 505, 70);
		maindisp.setFont(new FontUIResource("segoe UI", Font.BOLD, 40));
		maindisp.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		frame.add(maindisp);
		
	//Sub display creation
        JLabel subdisp=new JLabel("0", SwingConstants.RIGHT);
        subdisp.setBounds(300, 40, 200, 70);
        subdisp.setFont(new FontUIResource("segoe UI", Font.PLAIN, 25));
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




        modbutton.setBackground(new Color(200, 211, 224));
        sqrtbutton.setBackground(new Color(200, 211, 224));
        powerbutton.setBackground(new Color(200, 211, 224));
        divxbutton.setBackground(new Color(200, 211, 224));
        cebutton.setBackground(new Color(200, 211, 224));
        cbutton.setBackground(new Color(200, 211, 224));
        backbutton.setBackground(new Color(200, 211, 224));
        divbutton.setBackground(new Color(200, 211, 224));
        sevenbutton.setBackground(new Color(255, 255, 255));
        eightbutton.setBackground(new Color(255, 255, 255));
        ninebutton.setBackground(new Color(255, 255, 255));
        multiplybutton.setBackground(new Color(200, 211, 224));
        fourbutton.setBackground(new Color(255, 255, 255));
        fivebutton.setBackground(new Color(255, 255, 255));
        sixbutton.setBackground(new Color(255, 255, 255));
        subtractbutton.setBackground(new Color(200, 211, 224));
        onebutton.setBackground(new Color(255, 255, 255));
        twobutton.setBackground(new Color(255, 255, 255));
        threebutton.setBackground(new Color(255, 255, 255));
        addbutton.setBackground(new Color(200, 211, 224));
        pombutton.setBackground(new Color(255, 255, 255));
        zerobutton.setBackground(new Color(255, 255, 255));
        decimalbutton.setBackground(new Color(255, 255, 255));
        equalbutton.setBackground(new Color(200, 211, 224));
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




		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}
