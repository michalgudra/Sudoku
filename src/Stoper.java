// Klasa stworzona na potrzeby zaimplementowania stopera do Sudoku.
public class Stoper {

    private long startCzas = 0;
    private long stopCzas = 0;
    private long wstrzymaj = 0;
    private boolean dzialajacy = false;
//ustawienie startu
    public void start() {
        this.startCzas = System.currentTimeMillis();
        stopCzas = 0;
        this.dzialajacy = true;
    }
//ustawienie stopu
    public void stop() {
        this.stopCzas = System.currentTimeMillis();
        this.dzialajacy = false;
    }
//ustawienie wstrzymania czasu
    public void zatrzymaj() {
        if(dzialajacy) {
            wstrzymaj = System.currentTimeMillis();
            stop();
        }
    }
//wznowienie czasu
    public void wznow() {
        if(!dzialajacy){
            long duration = System.currentTimeMillis() - wstrzymaj;
            startCzas += duration;
            this.dzialajacy = true;
        }
    }
//Sprawdzenie jak dużo czasu upłyneło od startu do uzupełnienia całego sudoku i kliknięcia przycisku "zatwierdź"
    public long sprawdzCzas() {
        long uplynelo;
        if (dzialajacy) {
            uplynelo = (System.currentTimeMillis() - startCzas);
        } else {
            uplynelo = (stopCzas - startCzas);
        }
        return uplynelo;
    }
}