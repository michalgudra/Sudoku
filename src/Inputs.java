import javax.swing.JButton;
import javax.swing.JPanel;

public class Inputs extends javax.swing.JPanel {

    private SudokuGUI Plansza;
    private JPanel pole;
    private JButton przyciskWejscia;
    private int numerPrzycisku;

    public Inputs(SudokuGUI Plansza, JPanel pole, JButton inButton, int numerPrzycisku) {
        this.Plansza = Plansza;
        this.pole = pole;
        this.przyciskWejscia = inButton;
        this.numerPrzycisku = numerPrzycisku;
        wejscioweParametry();

        if(numerPrzycisku < 7) {
            this.remove(siedem);
            this.remove(osiem);
            this.remove(dziewiec);
        }
    }

    private void wejscioweParametry() {

        jeden = new javax.swing.JButton();
        dwa = new javax.swing.JButton();
        trzy = new javax.swing.JButton();
        cztery = new javax.swing.JButton();
        piec = new javax.swing.JButton();
        szesc = new javax.swing.JButton();
        siedem = new javax.swing.JButton();
        osiem = new javax.swing.JButton();
        dziewiec = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(3, 3));

        jeden.setBackground(new java.awt.Color(255, 255, 255));
        jeden.setText("1");
        jeden.setAlignmentY(0.0F);
        jeden.setIconTextGap(1);
        jeden.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jeden.setMinimumSize(new java.awt.Dimension(15, 15));
        jeden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAns(evt);
            }
        });
        add(jeden);

        dwa.setBackground(new java.awt.Color(255, 255, 255));
        dwa.setText("2");
        dwa.setAlignmentY(0.0F);
        dwa.setIconTextGap(1);
        dwa.setMargin(new java.awt.Insets(2, 2, 2, 2));
        dwa.setMinimumSize(new java.awt.Dimension(15, 15));
        dwa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAns(evt);
            }
        });
        add(dwa);

        trzy.setBackground(new java.awt.Color(255, 255, 255));
        trzy.setText("3");
        trzy.setAlignmentY(0.0F);
        trzy.setIconTextGap(1);
        trzy.setMargin(new java.awt.Insets(2, 2, 2, 2));
        trzy.setMinimumSize(new java.awt.Dimension(15, 15));
        trzy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAns(evt);
            }
        });
        add(trzy);

        cztery.setBackground(new java.awt.Color(255, 255, 255));
        cztery.setText("4");
        cztery.setAlignmentY(0.0F);
        cztery.setIconTextGap(1);
        cztery.setMargin(new java.awt.Insets(2, 2, 2, 2));
        cztery.setMinimumSize(new java.awt.Dimension(15, 15));
        cztery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAns(evt);
            }
        });
        add(cztery);

        piec.setBackground(new java.awt.Color(255, 255, 255));
        piec.setText("5");
        piec.setAlignmentY(0.0F);
        piec.setIconTextGap(1);
        piec.setMargin(new java.awt.Insets(2, 2, 2, 2));
        piec.setMinimumSize(new java.awt.Dimension(15, 15));
        piec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAns(evt);
            }
        });
        add(piec);

        szesc.setBackground(new java.awt.Color(255, 255, 255));
        szesc.setText("6");
        szesc.setAlignmentY(0.0F);
        szesc.setIconTextGap(1);
        szesc.setMargin(new java.awt.Insets(2, 2, 2, 2));
        szesc.setMinimumSize(new java.awt.Dimension(15, 15));
        szesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAns(evt);
            }
        });
        add(szesc);

        siedem.setBackground(new java.awt.Color(255, 255, 255));
        siedem.setText("7");
        siedem.setAlignmentY(0.0F);
        siedem.setIconTextGap(1);
        siedem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        siedem.setMinimumSize(new java.awt.Dimension(15, 15));
        siedem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAns(evt);
            }
        });
        add(siedem);

        osiem.setBackground(new java.awt.Color(255, 255, 255));
        osiem.setText("8");
        osiem.setAlignmentY(0.0F);
        osiem.setIconTextGap(1);
        osiem.setMargin(new java.awt.Insets(2, 2, 2, 2));
        osiem.setMinimumSize(new java.awt.Dimension(15, 15));
        osiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAns(evt);
            }
        });
        add(osiem);

        dziewiec.setBackground(new java.awt.Color(255, 255, 255));
        dziewiec.setText("9");
        dziewiec.setAlignmentY(0.0F);
        dziewiec.setIconTextGap(1);
        dziewiec.setMargin(new java.awt.Insets(2, 2, 2, 2));
        dziewiec.setMinimumSize(new java.awt.Dimension(15, 15));
        dziewiec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAns(evt);
            }
        });
        add(dziewiec);
    }

    private void setAns(java.awt.event.ActionEvent evt){
        Plansza.ustawPrzyciski(evt.getActionCommand(), pole, przyciskWejscia);
    }

    private javax.swing.JButton jeden;
    private javax.swing.JButton dwa;
    private javax.swing.JButton trzy;
    private javax.swing.JButton cztery;
    private javax.swing.JButton piec;
    private javax.swing.JButton szesc;
    private javax.swing.JButton siedem;
    private javax.swing.JButton osiem;
    private javax.swing.JButton dziewiec;

}