// Biblioteki wymagane do utworzenia sudoku
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SudokuGUI extends javax.swing.JFrame {

    private JButton[][] klawisze;
    private ActionListener[][] wyborAkcji;
    private JPanel[][] pola;
    private Sudoku sudoku;
    private int trybGry;
    private int grid;
    private boolean wstrzymany;
    private final Stoper stoper;

    public SudokuGUI() {
        sudoku = new Sudoku();
        trybGry = Sudoku.TRYB_GRY_ZAAWANSOWANY;
        grid = Sudoku.SUDOKU_9x9;
        stoper = new Stoper();
        wstrzymany = false;
        podstawoweKomponenty();
        wystartuj();
        startStopera();
    }

    private void podstawoweKomponenty() {

        podstawa = new javax.swing.JPanel();
        opcje = new javax.swing.JPanel();
        nowaGraBUT = new javax.swing.JButton();
        przyciskRESET = new javax.swing.JButton();
        zatrzymaj = new javax.swing.JButton();
        pasekCzasu = new javax.swing.JLabel();
        wznow = new javax.swing.JButton();
        zatwierdz = new javax.swing.JButton();
        opcjaWstrzymaj = new javax.swing.JPanel();
        Plansza = new javax.swing.JPanel();
        menue = new javax.swing.JMenuBar();
        gra = new javax.swing.JMenu();
        NowaGRA = new javax.swing.JMenuItem();
        NowaGRA6X6 = new javax.swing.JMenuItem();
        restartGRY = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        wyjście = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        nowicjusz = new javax.swing.JRadioButtonMenuItem();
        zaawansowany = new javax.swing.JRadioButtonMenuItem();
        ekspert = new javax.swing.JRadioButtonMenuItem();
        pomoc = new javax.swing.JMenu();
        dodinfo = new javax.swing.JMenuItem();
// Stworzenie tytułu wraz z ulkowaniem w applecie
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(500, 350));

        podstawa.setBackground(new java.awt.Color(255, 255, 255));
        podstawa.setAlignmentX(0.0F);
        podstawa.setAlignmentY(0.0F);

        opcje.setBackground(new java.awt.Color(55, 55, 55));
// Stworzenie przycisku wraz z ulkowaniem w applecie
        nowaGraBUT.setBackground(new java.awt.Color(255, 255, 255));
        nowaGraBUT.setFont(new java.awt.Font("Verdana", 0, 12));
        nowaGraBUT.setText("Nowa Gra");
        nowaGraBUT.setMargin(new java.awt.Insets(0, 0, 0, 0));
        nowaGraBUT.setMaximumSize(new java.awt.Dimension(63, 19));
        nowaGraBUT.setMinimumSize(new java.awt.Dimension(63, 19));
        nowaGraBUT.setPreferredSize(new java.awt.Dimension(63, 19));
        nowaGraBUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nowaGraBUTActionPerformed(evt);
            }
        });
// Stworzenie przycisku wraz z ulkowaniem w applecie
        przyciskRESET.setBackground(new java.awt.Color(255, 255, 255));
        przyciskRESET.setFont(new java.awt.Font("Verdana", 0, 12));
        przyciskRESET.setText("Restart Gry");
        przyciskRESET.setMargin(new java.awt.Insets(0, 0, 0, 0));
        przyciskRESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przyciskRESETActionPerformed(evt);
            }
        });
// Stworzenie przycisku wraz z ulkowaniem w applecie
        zatrzymaj.setBackground(new java.awt.Color(255, 255, 255));
        zatrzymaj.setFont(new java.awt.Font("Verdana", 0, 12));
        zatrzymaj.setText("Wstrzymaj");
        zatrzymaj.setMargin(new java.awt.Insets(0, 0, 0, 0));
        zatrzymaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zatrzymajActionPerformed(evt);
            }
        });
// Stworzenie przycisku wraz z ulkowaniem w applecie
        pasekCzasu.setFont(new java.awt.Font("Verdana", 0, 24));
        pasekCzasu.setForeground(new java.awt.Color(255, 255, 255));
        pasekCzasu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pasekCzasu.setText("00:00:000");
        pasekCzasu.setIconTextGap(0);
// Stworzenie przycisku wraz z ulkowaniem w applecie
        wznow.setBackground(new java.awt.Color(255, 255, 255));
        wznow.setFont(new java.awt.Font("Verdana", 0, 12));
        wznow.setText("Wznów");
        wznow.setMargin(new java.awt.Insets(0, 0, 0, 0));
        wznow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wznowActionPerformed(evt);
            }
        });

        zatwierdz.setBackground(new java.awt.Color(255, 255, 255));
        zatwierdz.setFont(new java.awt.Font("Verdana", 0, 12));
        zatwierdz.setText("Zatwierdź");
        zatwierdz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zatwierdzActionPerformed(evt);
            }
        });
// Ulkowanie w applecie
        javax.swing.GroupLayout optionsLayout = new javax.swing.GroupLayout(opcje);
        opcje.setLayout(optionsLayout);
        optionsLayout.setHorizontalGroup(
                optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(optionsLayout.createSequentialGroup()
                                .addComponent(nowaGraBUT, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(przyciskRESET, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zatrzymaj, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wznow, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zatwierdz, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pasekCzasu)
                                .addContainerGap())
        );
        optionsLayout.setVerticalGroup(
                optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nowaGraBUT, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addComponent(przyciskRESET, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addComponent(zatrzymaj, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addComponent(wznow, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addComponent(zatwierdz, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pasekCzasu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
        );

        opcjaWstrzymaj.setBackground(new java.awt.Color(255, 255, 255));
        opcjaWstrzymaj.setAlignmentX(0.0F);
        opcjaWstrzymaj.setAlignmentY(0.0F);
        opcjaWstrzymaj.setLayout(new java.awt.GridLayout(1, 1));

        Plansza.setBackground(new java.awt.Color(255, 255, 255));
        Plansza.setAlignmentX(0.0F);
        Plansza.setAlignmentY(0.0F);
        Plansza.setMinimumSize(new java.awt.Dimension(100, 100));
        Plansza.setPreferredSize(new java.awt.Dimension(100, 100));
        Plansza.setLayout(new java.awt.GridLayout(9, 9));
        opcjaWstrzymaj.add(Plansza);

        javax.swing.GroupLayout baseLayout = new javax.swing.GroupLayout(podstawa);
        podstawa.setLayout(baseLayout);
        baseLayout.setHorizontalGroup(
                baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, baseLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(opcjaWstrzymaj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                                        .addComponent(opcje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        baseLayout.setVerticalGroup(
                baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(baseLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(opcje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(opcjaWstrzymaj, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                                .addContainerGap())
        );


        gra.setText("Gra");

        NowaGRA.setText("Nowa gra 9 X 9");
        NowaGRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NowaGRAActionPerformed(evt);
            }
        });
        gra.add(NowaGRA);

        NowaGRA6X6.setText("Nowa gra 6 X 6");
        NowaGRA6X6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NowaGRA6X6ActionPerformed(evt);
            }
        });
        gra.add(NowaGRA6X6);

        restartGRY.setText("Restart");
        restartGRY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartGRYActionPerformed(evt);
            }
        });
        gra.add(restartGRY);
        gra.add(jSeparator1);

        wyjście.setText("Wyjście");
        wyjście.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        gra.add(wyjście);

        menue.add(gra);

        jMenu2.setText("Poziomy");

        nowicjusz.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        nowicjusz.setText("Początkujący");
        nowicjusz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nowicjuszActionPerformed(evt);
            }
        });
        jMenu2.add(nowicjusz);

        zaawansowany.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        zaawansowany.setSelected(true);
        zaawansowany.setText("Zaawansowany");
        zaawansowany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zaawansowanyActionPerformed(evt);
            }
        });
        jMenu2.add(zaawansowany);

        ekspert.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        ekspert.setText("Expert");
        ekspert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekspertActionPerformed(evt);
            }
        });
        jMenu2.add(ekspert);

        menue.add(jMenu2);

        pomoc.setText("Pomoc");

        dodinfo.setText("Info");
        dodinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodinfoActionPerformed(evt);
            }
        });
        pomoc.add(dodinfo);

        menue.add(pomoc);

        setJMenuBar(menue);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(podstawa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(podstawa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void NowaGRAActionPerformed(java.awt.event.ActionEvent evt) {
        grid = Sudoku.SUDOKU_9x9;
        int[][] puzzle = sudoku.stworzNoweSudoku(grid, trybGry);
        createPlansza(puzzle);
    }

    private void restartGRYActionPerformed(java.awt.event.ActionEvent evt) {
        int[][] puzzle = sudoku.resetPuzzle();
        createPlansza(puzzle);
    }

    private void zaawansowanyActionPerformed(java.awt.event.ActionEvent evt) {
        trybGry = Sudoku.TRYB_GRY_ZAAWANSOWANY;
        int[][] puzzle = sudoku.stworzNoweSudoku(grid, trybGry);
        createPlansza(puzzle);
    }

    private void ekspertActionPerformed(java.awt.event.ActionEvent evt) {
        trybGry = Sudoku.POZIOM_GRY_EXP;
        int[][] puzzle = sudoku.stworzNoweSudoku(grid, trybGry);
        createPlansza(puzzle);
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void nowicjuszActionPerformed(java.awt.event.ActionEvent evt) {
        trybGry = Sudoku.POZIOM_GRY_LATWY;
        int[][] puzzle = sudoku.stworzNoweSudoku(grid, trybGry);
        createPlansza(puzzle);
    }

    private void NowaGRA6X6ActionPerformed(java.awt.event.ActionEvent evt) {
        grid = Sudoku.SUDOKU_6x6;
        int[][] puzzle = sudoku.stworzNoweSudoku(grid, trybGry);
        createPlansza(puzzle);
    }

    private void zatrzymajActionPerformed(java.awt.event.ActionEvent evt) {
        stoper.zatrzymaj();
        wstrzymany = true;
        pokazTresc("Zatrzymano.");
    }

    private void wznowActionPerformed(java.awt.event.ActionEvent evt) {
        stoper.wznow();
        wstrzymany = false;
        opcjaWstrzymaj.removeAll();
        opcjaWstrzymaj.add(Plansza);
        opcjaWstrzymaj.repaint();
        this.setVisible(true);
    }

    private void przyciskRESETActionPerformed(java.awt.event.ActionEvent evt) {
        int[][] puzzle = sudoku.resetPuzzle();
        createPlansza(puzzle);
    }

    private void nowaGraBUTActionPerformed(java.awt.event.ActionEvent evt) {
        int[][] puzzle = sudoku.stworzNoweSudoku(grid, trybGry);
        createPlansza(puzzle);
    }

    private void zatwierdzActionPerformed(java.awt.event.ActionEvent evt) {
        if (!czyKompletny()) {
            JOptionPane.showMessageDialog(this, "Proszę uzupełnić wszystkie pola.");
        } else {
            stoper.stop();
            boolean isAnsCorrect = sudoku.sprawdz(getAns());
            String messageStr = "";
            if (isAnsCorrect) {
                messageStr = "Gratulacje, sudoku zostało ukończone w: " + pasekCzasu.getText();
            } else {
                messageStr = "Niestety, nie udało się.";
            }
            pokazTresc(messageStr);
        }
    }

    private void dodinfoActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Gra utworzona w celu zaliczenia przedmiotu :).");
    }

    private void createPlansza(int[][] puzzle) {
        Plansza.removeAll();
        grid = puzzle.length;
        pola = new JPanel[grid][grid];
        klawisze = new JButton[grid][grid];
        wyborAkcji = new ActionListener[grid][grid];
        Plansza.setLayout(new GridLayout(grid, grid, 3, 3));

        int rowsInGrid = grid == 9 ? 3 : 2;


        for (int i = 0; i < grid; i++) {
            for (int j = 0; j < grid; j++) {
                pola[i][j] = new JPanel();
                klawisze[i][j] = new JButton();
                String text = "";
                if (0 < puzzle[i][j] && puzzle[i][j] <= grid) {
                    text += puzzle[i][j];
                } else {
                    final JButton tempbutton = klawisze[i][j];
                    final JPanel tempBlock = pola[i][j];
                    wyborAkcji[i][j] = new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            pokazPrzyciski(tempBlock, tempbutton, grid);
                        }
                    };
                    klawisze[i][j].addActionListener(wyborAkcji[i][j]);
                }
                klawisze[i][j].setText(text);
                klawisze[i][j].setFont(new Font("Verdana", 0, 24));

                if (((0 <= i && i < rowsInGrid) || (rowsInGrid * 2 <= i && i < grid)) && (3 <= j && j < 6)) {
                    klawisze[i][j].setBackground(new Color(255, 255, 255));
                } else if ((rowsInGrid <= i && i < rowsInGrid * 2) && ((0 <= j && j < 3) || (6 <= j && j < 9))) {
                    klawisze[i][j].setBackground(new Color(255, 255, 255));
                } else {
                    klawisze[i][j].setBackground(new Color(255, 255, 255));

                }
                pola[i][j].setLayout(new GridLayout(1, 1));
                pola[i][j].add(klawisze[i][j]);
                Plansza.add(pola[i][j]);

            }

        }


        opcjaWstrzymaj.removeAll();
        opcjaWstrzymaj.add(Plansza);
        Plansza.repaint();
        opcjaWstrzymaj.repaint();
        this.setVisible(true);
        stoper.start();
    }

    private void wystartuj() {
        int[][] puzzle = sudoku.stworzNoweSudoku(grid, trybGry);
        createPlansza(puzzle);
    }

    private void pokazPrzyciski(JPanel block, JButton inputButtton, int numOfInput) {
       JPanel inputs = new Inputs(this, block, inputButtton, numOfInput);
     block.remove(inputButtton);
     block.add(inputs);
      this.setVisible(true);
    }

    public void ustawPrzyciski(String ans, JPanel block, JButton inputButtton) {
        block.removeAll();
        inputButtton.setText(ans);
        inputButtton.setFont(new java.awt.Font("Verdana", 1, 24));
        block.add(inputButtton);
        this.repaint();
    }

    private int[][] getAns() {
        int ans[][] = new int[grid][grid];

        for (int i = 0; i < grid; i++) {
            for (int j = 0; j < grid; j++) {
                try {
                    ans[i][j] = Integer.parseInt(klawisze[i][j].getText());
                } catch (NumberFormatException e) {
                    ans[i][j] = 0;
                }
            }
        }

        return ans;
    }

    private boolean czyKompletny() {
        boolean czyKompletny = true;
        for (int i = 0; i < grid; i++) {
            for (int j = 0; j < grid; j++) {
                try {
                    Integer.parseInt(klawisze[i][j].getText());
                } catch (NumberFormatException e) {
                    czyKompletny = false;
                    break;
                }
            }
        }
        return czyKompletny;
    }


    private void pokazTresc(String message) {
        JLabel messageLabel = new JLabel();
        messageLabel.setFont(new java.awt.Font("Verdana", 1, 20));
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setText(message);
        opcjaWstrzymaj.removeAll();
        opcjaWstrzymaj.add(messageLabel);
        opcjaWstrzymaj.repaint();
        this.setVisible(true);
    }

    private void startStopera() {
        Thread thread = new Thread(new Runnable() {

            public void run() {
                stoper.start();
                while (true) {
                    if (!wstrzymany) {
                        final String timeString = new SimpleDateFormat("mm:ss:SSS").format(stoper.sprawdzCzas());
                        pasekCzasu.setText("" + timeString);
                    }
                }
            }
        });
        thread.start();
    }

    private javax.swing.JMenuItem dodinfo;
    private javax.swing.JPanel podstawa;
    private javax.swing.JRadioButtonMenuItem nowicjusz;
    private javax.swing.JPanel Plansza;
    private javax.swing.JMenuItem wyjście;
    private javax.swing.JRadioButtonMenuItem ekspert;
    private javax.swing.JMenu gra;
    private javax.swing.JMenu pomoc;
    private javax.swing.JPanel opcjaWstrzymaj;
    private javax.swing.JRadioButtonMenuItem zaawansowany;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar menue;
    private javax.swing.JMenuItem NowaGRA;
    private javax.swing.JMenuItem NowaGRA6X6;
    private javax.swing.JButton nowaGraBUT;
    private javax.swing.JPanel opcje;
    private javax.swing.JButton zatrzymaj;
    private javax.swing.JMenuItem restartGRY;
    private javax.swing.JButton przyciskRESET;
    private javax.swing.JButton wznow;
    private javax.swing.JButton zatwierdz;
    private javax.swing.JLabel pasekCzasu;


    //Poniższe obramowania nie są gotowe - będą dodane później.

//    private void Obramowania_3X3 () {
//        for (int r = 0; r < grid; r++) {
//            for (int c = 0; c < grid; c++) {
//
//                if (r >= 0 && r <= 2) {
//
//                    if (c >= 0 && c <= 2) {
//                        pola[r][c].setBackground(Color.white);
//                        pola[r][c].setForeground(Color.black);
//                    }
//
//                    if (c >= 3 && c <= 5) {
//                        pola[r][c].setBackground(Color.WHITE);
//                    }
//
//                    if (c >= 6 && c <= 8) {
//                        pola[r][c].setBackground(Color.BLACK);
//                        pola[r][c].setForeground(Color.WHITE);
//                    }
//                }
//
//
//                if (r >= 3 && r <= 5) {
//
//                    if (c >= 0 && c <= 2) {
//                        pola[r][c].setBackground(Color.WHITE);
//                    }
//                                    if (c >= 3 && c <= 5) {
//                        pola[r][c].setBackground(Color.BLACK);
//                        pola[r][c].setForeground(Color.WHITE);
//                    }
//                                    if (c >= 6 && c <= 8) {
//                        pola[r][c].setBackground(Color.WHITE);
//                    }
//                }
//
//                if (r >= 6 && r <= 8) {
//                                                            if (c >= 0 && c <= 2) {
//                        pola[r][c].setBackground(Color.BLACK);
//                        pola[r][c].setForeground(Color.WHITE);
//                    }
//                                        if (c >= 3 && c <= 5) {
//                        pola[r][c].setBackground(Color.WHITE);
//                    }
//                                        if (c >= 6 && c <= 8) {
//                        pola[r][c].setBackground(Color.BLACK);
//                        pola[r][c].setForeground(Color.WHITE);
//                    }
//                }
//            }
//        }
//    }
}