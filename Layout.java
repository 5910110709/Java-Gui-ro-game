import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.border.EmptyBorder;

//@SuppressWarnings("serial")

public class Layout extends JFrame
{
    private Novice charactor;
    String Hp,Level,Exp,Mana,status,count="0"; //for rouge
    String[] mHp;
    String[] mDmage;
    String[] mName;
    JTextField jtf3,jtf7,jtf,jtf5,jtf6,jtf8,jtf9,jtfCounter,jtf10,jtf11,jtf12,jtf13,jtf14,jtf15;
    JButton b1,b2,b3,b4,mb1,mb2,mb3;
    JPanel gridPanel,gridPanel2;
    JPanel monster,child1,child2,child3,child4;
    Monster m1,m2,m3;
    JButton bt1;
    JLabel counter;
    int dMage,btMon,btMon2,btMon3;
    

    public Layout(String title){
        super(title);
        this.setSize(700,300);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container containerMain = this.getContentPane();
        containerMain.setLayout(new BorderLayout(8,6));
        containerMain.setBackground(Color.GREEN);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLUE));

        //property Novice

        charactor = new Novice("Rouge");
        Hp = Integer.toString(charactor.getHealthPoint());
        Level = Integer.toString(charactor.getLevel());
        Exp = Integer.toString(charactor.getExperience());
        Mana = Integer.toString(charactor.getManaPoint());
        status = charactor.status();

        //Panel Top
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK, 2));
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(new FlowLayout(5));
        containerMain.add(topPanel, BorderLayout.NORTH);
        
        //Set Label
        JLabel jl = new JLabel("HP");
        jtf  = new JTextField(10);
        jtf.setText(Hp);
        jtf.setEditable(false); //non Edible

        JLabel jl2 = new JLabel("Level");
        JTextField jtf2  = new JTextField(10);
        jtf2.setText(Level);
        jtf2.setEditable(false);


        JLabel jl3 = new JLabel("Exp");
        jtf3  = new JTextField(10);
        jtf3.setText(Exp);
        jtf3.setEditable(false);

        JLabel jl4 = new JLabel("Mana");
        JTextField jtf4  = new JTextField(10);
        jtf4.setText(Mana);
        jtf4.setEditable(false);


        JLabel jl5 = new JLabel("Status");
        jtf5  = new JTextField(10);
        jtf5.setText(status);
        jtf5.setEditable(false);
       
        jtf7 = new JTextField();
        jtf6 = new JTextField();
        jtf8 = new JTextField();
        jtf9 = new JTextField();

        

        bt1 = new JButton("Relife !");
        click clicks = new click();
        bt1.addActionListener(clicks);
        bt1.setVisible(false);

        counter = new JLabel("counter: ");
        jtfCounter = new JTextField(count);
		jtfCounter.setEditable(false);

        jtf.setPreferredSize( new Dimension( 10, 25 ) );
        jtf2.setPreferredSize( new Dimension( 10, 25 ) );
        jtf3.setPreferredSize( new Dimension( 10, 25 ) );
        jtf4.setPreferredSize( new Dimension( 10, 25 ) );
        jtf5.setPreferredSize( new Dimension( 10, 25 ) );
        jtf6.setPreferredSize( new Dimension( 50, 25 ) );
        jtf7.setPreferredSize( new Dimension( 100, 25 ) );
        jtf8.setPreferredSize( new Dimension( 50, 25 ) );
        jtf9.setPreferredSize( new Dimension( 50, 25 ) );
        jtfCounter.setPreferredSize( new Dimension( 50, 25 ) );
        
       // jtf7.setPreferredSize( new Dimension( 10, 25 ) );

        

        topPanel.add(jl);
        topPanel.add(jtf);
        topPanel.add(jl2);
        topPanel.add(jtf2);
        topPanel.add(jl3);
        topPanel.add(jtf3);
        topPanel.add(jl4);
        topPanel.add(jtf4);
        topPanel.add(jl5);
        topPanel.add(jtf5);
        
		topPanel.add(counter);
        topPanel.add(jtfCounter);
        topPanel.add(bt1);
        
// initail button Attack 
        monsterAttack att = new monsterAttack();
        monsterAttack2 att2 = new monsterAttack2();
        monsterAttack3 att3 = new monsterAttack3();

        

        //Panel middle
        JPanel midlePanel = new JPanel();
        midlePanel.setBorder(new LineBorder(Color.BLACK,1));
        midlePanel.setLayout(new FlowLayout(4,4,4));
        midlePanel.setBackground(Color.WHITE);

        gridPanel = new JPanel();
        gridPanel.setBorder(new LineBorder(Color.BLACK,1));
        gridPanel.setLayout(new GridLayout(8,1,5,5));
        gridPanel.setBackground(Color.PINK);
        
        m1 = new Monster("Alligator", 10,10, 10); // create monster one
        m2 = new Monster("Anacondaq", 20, 10, 5); // create monster two
        m3 = new Monster("Bigfoot", 100, 50, 10); // create monster three

        JTextField statusMon = new JTextField("Monsters");
        JTextField statusSt = new JTextField("Stored");

        statusMon.setEditable(false);
        statusMon.setHorizontalAlignment(SwingConstants.CENTER);
        statusSt.setEditable(false);
        statusSt.setHorizontalAlignment(SwingConstants.CENTER);
        statusSt.setBorder(new EmptyBorder(10, 10, 10, 10));

        b1 = new JButton(m1.getName()); //button in side bar
        b2 = new JButton(m2.getName());
        b3 = new JButton(m3.getName());
        b4 = new JButton("Store");

        // view hide button
        view v = new view();
        hide h = new hide();
        seek s = new seek();
        b1.addActionListener(v);
        b2.addActionListener(h);
        b3.addActionListener(s);

//Panel for adding three monster
        monster = new JPanel();
        // monster.setBorder(new LineBorder(Color.BLACK,1));
        monster.setLayout(new FlowLayout());
        monster.setBackground(Color.WHITE);

        mHp = new String[3];
        mDmage = new String[3];
        mName = new String[3];
        mb1 = new JButton("Attack!"); //button
        mb1.addActionListener(att);
        mb2 = new JButton("Attack!");
        mb2.addActionListener(att2);
        mb3 = new JButton("Attack!");
        mb3.addActionListener(att3);
        

//panel for monster 1
        child1 = new JPanel();
        child1.setLayout(new FlowLayout(5));
        child1.setBorder(new LineBorder(Color.BLACK,1));
        child1.setVisible(true);
//panel for monster 2
        child2 = new JPanel();
        child2.setLayout(new FlowLayout(5));
        child2.setBorder(new LineBorder(Color.BLACK,1));
        child2.setVisible(false);
//panel for monster 3
        child3 = new JPanel();
        child3.setLayout(new FlowLayout(5));
        child3.setBorder(new LineBorder(Color.BLACK,1));
        child3.setVisible(false);
//panel for stored
        child4 = new JPanel();
        child4.setLayout(new FlowLayout(5));
        child4.setBorder(new LineBorder(Color.BLACK,1));
        child4.setVisible(false);
//create Monster1
            //initail Monster obj;


        
        mName[0] = m1.getName();
        mDmage[0] = Integer.toString(m1.getDamagePoint());
        mHp[0] = Integer.toString(m1.getHealthPoint());
        btMon = Integer.parseInt(mHp[0]);

        


        JLabel jl8 = new JLabel("Monster Name");
        JLabel jl6 = new JLabel("Monster Hp");
        JLabel jl7 = new JLabel("Damage");
        jtf7.setText(mName[0]);
        jtf7.setEditable(false);
        jtf6.setText(mDmage[0]);
        jtf6.setEditable(false);
        jtf8.setText(mHp[0]);
        jtf8.setEditable(false);

        

        

        child1.add(jl8);    //Llabel
        child1.add(jtf7);
        child1.add(jl7);  //Label
        child1.add(jtf6);
        child1.add(jl6); //Label
        child1.add(jtf8);

        mName[1] = m2.getName();
        mDmage[1] = Integer.toString(m2.getDamagePoint());
        mHp[1] = Integer.toString(m2.getHealthPoint());
        btMon2 = Integer.parseInt(mHp[1]);

        JLabel jlm2 = new JLabel("Monster Name");
        JLabel jlm21 = new JLabel("Monster Hp");
        JLabel jl22 = new JLabel("Damage");

        jtf10 = new JTextField();
        jtf11 = new JTextField();
        jtf12 = new JTextField();

        jtf10.setPreferredSize( new Dimension( 100, 25 ) );
        jtf11.setPreferredSize( new Dimension( 50, 25 ) );
        jtf12.setPreferredSize( new Dimension( 50, 25 ) );

        jtf10.setText(mName[1]);
        jtf10.setEditable(false);
        jtf11.setText(mDmage[1]);
        jtf11.setEditable(false);
        jtf12.setText(mHp[1]);
        jtf12.setEditable(false);

        child2.add(jlm2);    //Llabel name
        child2.add(jtf10);
        child2.add(jlm21);  //Label hp
        child2.add(jtf12);
        child2.add(jl22); //Label damage
        child2.add(jtf11);

        mName[2] = m3.getName();
        mDmage[2] = Integer.toString(m3.getDamagePoint());
        mHp[2] = Integer.toString(m3.getHealthPoint());
        btMon3 = Integer.parseInt(mHp[2]);

        JLabel jlm3 = new JLabel("Monster Name");
        JLabel jlm31 = new JLabel("Monster Hp");
        JLabel jl32 = new JLabel("Damage");
        
        jtf13 = new JTextField();
        jtf14 = new JTextField();
        jtf15 = new JTextField();
        
        jtf13.setText(mName[2]);
        jtf13.setEditable(false);
        jtf15.setText(mDmage[2]);
        jtf15.setEditable(false);
        jtf14.setText(mHp[2]);
        jtf14.setEditable(false);

        child3.add(jlm3);    //Llabel name
        child3.add(jtf13);
        child3.add(jlm31);  //Label hp
        child3.add(jtf14);
        child3.add(jl32); //Label damage
        child3.add(jtf15);


        jtf13.setPreferredSize( new Dimension( 100, 25 ) );
        jtf14.setPreferredSize( new Dimension( 50, 25 ) ); /// ?????
        jtf15.setPreferredSize( new Dimension( 50, 25 ) );

        child1.setPreferredSize(new Dimension(350,300));
        child2.setPreferredSize(new Dimension(350,300));
        child1.setVisible(true);
        child1.setPreferredSize(new Dimension(640, 480));
        child2.setVisible(false);
        child2.setPreferredSize(new Dimension(640, 480));
        child3.setPreferredSize(new Dimension(640, 480));
        //image monster1
        BufferedImage wPic = null;
        BufferedImage wPic2 = null;
        BufferedImage wPic3 = null;

        try{
            wPic = ImageIO.read(this.getClass().getResource("alligator.png"));
            wPic2 = ImageIO.read(this.getClass().getResource("EEE.jpg"));
            wPic3 = ImageIO.read(this.getClass().getResource("AAA.jpg"));
        }
        catch (IOException e) {
        }

        JLabel wIcon = new JLabel(new ImageIcon(wPic));
        JLabel wIcon2 = new JLabel(new ImageIcon(wPic2));
        JLabel wIcon3 = new JLabel(new ImageIcon(wPic3));

        child1.add(wIcon);
        child1.add(mb1);

        child2.add(wIcon2);
        child2.add(mb2);

        child3.add(wIcon3);
        child3.add(mb3);


        //monster.setPreferredSize(new Dimension(50,50));

         
        // monster.add(child2,BorderLayout.CENTER);
        // monster.add(child1,BorderLayout.WEST);
        monster.add(child2);
        monster.add(child1);
        monster.add(child3);

        gridPanel.add(statusMon);
        gridPanel.add(b1);
        gridPanel.add(b2);
        gridPanel.add(b3);
        gridPanel.add(statusSt);
        gridPanel.add(b4);

        JLabel label = new JLabel("Center Box", SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBorder(new LineBorder(Color.BLACK,2));

        midlePanel.add(gridPanel);
        containerMain.add(label);
        containerMain.add(midlePanel, BorderLayout.WEST);
        containerMain.add(monster, BorderLayout.CENTER);

        
    }
    private class monsterAttack implements ActionListener{
        public void actionPerformed(ActionEvent event){
            int a;
            int counter;
			counter = Integer.parseInt(count);
            String mons;
            a = Integer.parseInt(Hp);
            
            if(a == 0){
                bt1.setVisible(true);
            }
            else if(a == 100){
                bt1.setVisible(false);
            }
            
			if((btMon - 5) == 0){
                btMon = m1.getHealthPoint();
                    if(a > 0){
                        counter++;
						count = ""+counter;
						jtfCounter.setText(count); 
                    }
						
				}
			else{
                if(a >0){
                    btMon = btMon - 5;   
                }
						
				if(a<=100){
					if(a>0){
                        a = a - m1.getDamagePoint();
						if(a >=90){
							jtf5.setText("Good");
        
						}
						else if(a >=70 && a < 90){
							 jtf5.setText("Normal");
        
						}
						else if(a >=50 && a <70){
							jtf5.setText("Warnnig");
						}
						else if(a>=1 && a<50){
							jtf5.setText("Danger");
						}
						else if(a == 0){
							jtf5.setText("Death");
         
						}
					}
					}
				}
					
                
            Hp = ""+a;
            mons = ""+btMon;
            jtf.setText(Hp);
            jtf8.setText(mons);
        }
    }
    private class monsterAttack2 implements ActionListener{
        public void actionPerformed(ActionEvent event){
            int a;
            int counter;
			counter = Integer.parseInt(count);
            String mons;
            a = Integer.parseInt(Hp); //change string to integer

            if(a == 0){
                bt1.setVisible(true);
            }
            else if(a == 100){
                bt1.setVisible(false);
            }
			if((btMon2 - 10) <= 0){
                btMon2 = m2.getHealthPoint();
                    if(a > 0){
                        counter++;
						count = ""+counter;
						jtfCounter.setText(count); 
                    }
						
				}
			else{
                if(a >0){
                    btMon2 = btMon2 - 10;   
                }
			}		
				if(a<=100){
					if(a>0){
                        a = a - m2.getDamagePoint(); // update Hp
						if(a >=90){
							jtf5.setText("Good");
        
						}
						else if(a >=70 && a < 90){
							 jtf5.setText("Normal");
        
						}
						else if(a >=50 && a <70){
							jtf5.setText("Warnnig");
						}
						else if(a>=1 && a<50){
							jtf5.setText("Danger");
						}
						else if(a == 0){
							jtf5.setText("Death");
         
						}
					}
            }
            
				
					
            
            Hp = ""+a;
            mons = ""+btMon2;
            jtf.setText(Hp);
            jtf12.setText(mons);
        }
    }
    private class monsterAttack3 implements ActionListener{
        public void actionPerformed(ActionEvent event){
            int a;
            int counter;
			counter = Integer.parseInt(count);
            String mons;
            a = Integer.parseInt(Hp); //change string to integer

            if(a == 0){
                bt1.setVisible(true);
            }
            else if(a == 100){
                bt1.setVisible(false);
            }
            
			if((btMon3 - 10) <= 0){
                btMon3 = m3.getHealthPoint();
                    if(a > 0){
                        counter++;
						count = ""+counter;
						jtfCounter.setText(count); 
                    }
						
				}
			else{
                if(a >0){
                    btMon3 = btMon3 - 10;   
                }
			}		
				if(a<=100){
					if(a>0){
                        a = a - m3.getDamagePoint(); // update Hp
						if(a >=90){
							jtf5.setText("Good");
        
						}
						else if(a >=70 && a < 90){
							 jtf5.setText("Normal");
        
						}
						else if(a >=50 && a <70){
							jtf5.setText("Warnnig");
						}
						else if(a>=1 && a<50){
							jtf5.setText("Danger");
						}
						else if(a == 0){
							jtf5.setText("Death");
         
						}
					}
					}
				
					
                
            Hp = ""+a;
            mons = ""+btMon3;
            jtf.setText(Hp);
            jtf14.setText(mons);
        }
    }
    private class view implements ActionListener{
        public void actionPerformed(ActionEvent event){
            child2.setVisible(false);
            child1.setVisible(true);
            child3.setVisible(false);
        }
    }
    private class hide implements ActionListener{
        public void actionPerformed(ActionEvent event){
            child1.setVisible(false);
            child2.setVisible(true);
            child3.setVisible(false);
        }
    }
    private class seek implements ActionListener{
        public void actionPerformed(ActionEvent event){
            child1.setVisible(false);
            child2.setVisible(false);
            child3.setVisible(true);
        }
    }
    private class click implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Hp = ""+100;
            jtf.setText(Hp);
            
        }
    }
}
    
