//package game;

//Import package

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameWindow extends JFrame implements ActionListener {
    JButton a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;
    JLabel lblword, lblmessage;
    JPanel keypad, key1, key2, key3, screen, notify;

    // Variable declaration
    int len, count, rnd, chance, flag;
    String word[] = { "JAPAN", "QATAR", "SYRIA", "MONGOLIA", "RUSSIA", "INDIA", "PAKISTAN", "AUSTRALIA",
            "AFGHANISTAN", "CHINA" };
    Random rd;
    StringBuffer blanks;

    public GameWindow() {
        a = new JButton("A");
        b = new JButton("B");
        c = new JButton("C");
        d = new JButton("D");
        e = new JButton("E");
        f = new JButton("F");
        g = new JButton("G");
        h = new JButton("H");
        i = new JButton("I");
        j = new JButton("J");
        k = new JButton("K");
        l = new JButton("L");
        m = new JButton("M");
        n = new JButton("N");
        o = new JButton("O");
        p = new JButton("P");
        q = new JButton("Q");
        r = new JButton("R");
        s = new JButton("S");
        t = new JButton("T");
        u = new JButton("U");
        v = new JButton("V");
        w = new JButton("W");
        x = new JButton("X");
        y = new JButton("Y");
        z = new JButton("Z");

        lblmessage = new JLabel("Guess a Country Name");
        lblmessage.setFont(new Font("Serif", Font.PLAIN, 20));

        lblword = new JLabel();
        lblword.setFont(new Font("Serif", Font.PLAIN, 35));

        notify = new JPanel();
        notify.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        screen = new JPanel();
        screen.setBackground(Color.WHITE);
        screen.setSize(0, 200);

        keypad = new JPanel();
        keypad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        keypad.setBackground(Color.BLACK);

        key1 = new JPanel();
        key1.setBackground(Color.BLACK);

        key2 = new JPanel();
        key2.setBackground(Color.BLACK);

        key3 = new JPanel();
        key3.setBackground(Color.BLACK);

        // Variable initialization
        count = 0;
        chance = 0;
        rd = new Random();
        blanks = new StringBuffer();

        setTitle("Hangman Game");
        setSize(500, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add listeners
        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        e.addActionListener(this);
        f.addActionListener(this);
        g.addActionListener(this);
        h.addActionListener(this);
        i.addActionListener(this);
        j.addActionListener(this);
        k.addActionListener(this);
        l.addActionListener(this);
        m.addActionListener(this);
        n.addActionListener(this);
        o.addActionListener(this);
        p.addActionListener(this);
        q.addActionListener(this);
        r.addActionListener(this);
        s.addActionListener(this);
        t.addActionListener(this);
        u.addActionListener(this);
        v.addActionListener(this);
        w.addActionListener(this);
        x.addActionListener(this);
        y.addActionListener(this);
        z.addActionListener(this);

    }

    public void addComponent() {
        GridBagConstraints gc = new GridBagConstraints();

        notify.setLayout(new FlowLayout());
        notify.add(lblmessage);

        screen.setLayout(new GridBagLayout());
        screen.add(lblword, gc);

        keypad.setLayout(new GridBagLayout());

        key1.setLayout(new FlowLayout());
        key1.add(q);
        key1.add(w);
        key1.add(e);
        key1.add(r);
        key1.add(t);
        key1.add(y);
        key1.add(u);
        key1.add(i);
        key1.add(o);
        key1.add(p);

        gc.gridx = 0;
        gc.gridy = 0;
        keypad.add(key1, gc);

        key2.setLayout(new FlowLayout());
        key2.add(a);
        key2.add(s);
        key2.add(d);
        key2.add(f);
        key2.add(g);
        key2.add(h);
        key2.add(j);
        key2.add(k);
        key2.add(l);

        gc.gridx = 0;
        gc.gridy = 1;
        keypad.add(key2, gc);

        key3.setLayout(new FlowLayout());
        key3.add(z);
        key3.add(x);
        key3.add(c);
        key3.add(v);
        key3.add(b);
        key3.add(n);
        key3.add(m);

        gc.gridx = 0;
        gc.gridy = 2;
        keypad.add(key3, gc);

        setLayout(new BorderLayout());
        add(notify, BorderLayout.NORTH);
        add(screen, BorderLayout.CENTER);
        add(keypad, BorderLayout.SOUTH);

    }

    // startGame method
    public void startGame() {
        addComponent();

        rnd = rd.nextInt(10);
        len = word[rnd].length();

        for (int j = 0; j < len; j++) {
            blanks.append("_  ");
        }

        lblword.setText(blanks.toString());
    }

    // Event handler
    public void actionPerformed(ActionEvent ae) {

        JButton jb = (JButton) ae.getSource();
        String letter = ae.getActionCommand();

        flag = 0;

        for (int loop = 0; loop < len; loop++) {
            if (letter.charAt(0) == word[rnd].charAt(loop)) {
                flag = 1;
                blanks.replace((loop * 3), ((loop * 3) + 1), letter);
                count++;
            }
        }

        if (flag == 1) {
            lblword.setText(blanks.toString());
            jb.setBackground(Color.GREEN);
            jb.setForeground(Color.BLACK);
            jb.setEnabled(false);
        } else {
            jb.setBackground(Color.RED);
            jb.setEnabled(false);
            chance++;
        }

        if (count == len) {
            JOptionPane.showMessageDialog(this, "Congrats You Guessed the Word correctly");
            int n = JOptionPane.showConfirmDialog(this, "Do you want to play again?", "Restart Game",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (n == JOptionPane.YES_OPTION) {
                GameWindow obj = new GameWindow();
                obj.startGame();
                this.dispose();

            } else {
                this.dispose();
                Menu obj = new Menu();
                obj.addComponent();

            }
        }
        if (chance > 5) {
            JOptionPane.showMessageDialog(this, "Sorry You Lost Your Chances");
            int n = JOptionPane.showConfirmDialog(this, "Do you want to play again?", "Restart Game",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (n == JOptionPane.YES_OPTION) {
                GameWindow obj = new GameWindow();
                obj.startGame();
                this.dispose();

            } else {
                this.dispose();
                Menu obj = new Menu();
                obj.addComponent();

            }
        }

    }

}
