import java.util.Arrays;
import java.util.Random;

public class Sudoku {
//tworzenie tablic 9x9 i 6x6 (tablice 3x3 i większe od 9x9 nie są jeszcze dodane)
    public static final int[][] PRAWIDLOWA_TABLICA_9X9 = {
            {4, 3, 5, 8, 7, 6, 1, 2, 9},
            {8, 7, 6, 2, 1, 9, 3, 4, 5},
            {2, 1, 9, 4, 3, 5, 7, 8, 6},
            {5, 2, 3, 6, 4, 7, 8, 9, 1},
            {9, 8, 1, 5, 2, 3, 4, 6, 7},
            {6, 4, 7, 9, 8, 1, 2, 5, 3},
            {7, 5, 4, 1, 6, 8, 9, 3, 2},
            {3, 9, 2, 7, 5, 4, 6, 1, 8},
            {1, 6, 8, 3, 9, 2, 5, 7, 4}};
    public static final int[][] PRAWIDLOWA_TABLICA_6X6 = {
            {1, 2, 3, 4, 5, 6},
            {4, 5, 6, 1, 2, 3},
            {2, 3, 4, 5, 6, 1},
            {5, 6, 1, 2, 3, 4},
            {3, 4, 5, 6, 1, 2},
            {6, 1, 2, 3, 4, 5}};

//zdefiniowanie podstawowych zmiennych
    public static final int SUDOKU_6x6 = 6;
    public static final int SUDOKU_9x9 = 9;
    public static final int POZIOM_GRY_EXP = 75;
    public static final int TRYB_GRY_ZAAWANSOWANY = 60;
    public static final int POZIOM_GRY_LATWY = 50;
    public static final int POZIOM_GRY_LATWIEJSZY = 4;
    public static final int TOLERANCJA = 5;
    public static final String USTAW_WARTOSC_9X9 = "123456789";
    public static final String USTAW_WARTOSC_6X6 = "123456";
    private int[][] puzzle;
    private Random random = new Random();

    // Tworzenie kopii tablicy - jest to potrzene do prawidłowego i logicznego działania sudoku
    private int[][] kopiaOD(int[][] oryginal) {
        int[][] kopia = new int[oryginal.length][];
        for (int i = 0; i < oryginal.length; i++) {
            kopia[i] = Arrays.copyOf(oryginal[i], oryginal[i].length);
        }
        return kopia;
    }

    // zmienianie wierszy tablicy - jest to potrzene do prawidłowego i logicznego działania sudoku
    private int[][] zamienRzedy(int[][] Plansza, int rzad1, int rzad2) {
        for (int j = 0; j < Plansza.length; j++) {
            int temp = Plansza[rzad1][j];
            Plansza[rzad1][j] = Plansza[rzad2][j];
            Plansza[rzad2][j] = temp;
        }
        return Plansza;
    }

    //zmienianie kolumn tablicy - jest to potrzene do prawidłowego i logicznego działania sudoku
    private int[][] zamienKolumny(int[][] Plansza, int kol1, int kol2) {
        for (int i = 0; i < Plansza.length; i++) {
            int temp = Plansza[i][kol1];
            Plansza[i][kol1] = Plansza[i][kol2];
            Plansza[i][kol2] = temp;
        }
        return Plansza;
    }

    // definiowanie i zmienianie wierszy / kolumn sudoku - dzięki poniższemu tworzy się logika która umożliwia poprawne stworzenie danej siatki.
    private int[][] zamienRzedyiKolumny(int[][] Plansza) {

        int zasieg = Plansza.length == SUDOKU_9x9 ? 7 : 5;
        int wierszePlanszy = Plansza.length == SUDOKU_9x9 ? 3 : 2;
        int kulumnyPlanszy = 3;

        for (int a = 0; a < zasieg; a += wierszePlanszy) {
            int rzad[] = dwieLosoweLiczby(a, wierszePlanszy);
            zamienRzedy(Plansza, rzad[0], rzad[1]);
        }

        for (int a = 0; a < zasieg; a += kulumnyPlanszy) {
            int[] kol = dwieLosoweLiczby(a, kulumnyPlanszy);
            zamienKolumny(Plansza, kol[0], kol[1]);
        }
        return Plansza;
    }

    private int[][] zamienSiatke(int[][] Plansza) {
        int pierwszaSiatka = 1 + random.nextInt(3);
        int drugaSiatka = 1 + random.nextInt(3);
        int numwierszePlanszy = Plansza.length == SUDOKU_9x9 ? 3 : 2;

        if ((pierwszaSiatka == 1 && drugaSiatka == 2) || (pierwszaSiatka == 2 && drugaSiatka == 1)) {
            for (int i = 0; i < numwierszePlanszy; i++) {
                zamienRzedy(Plansza, i, i + numwierszePlanszy);
            }
        } else if ((pierwszaSiatka == 2 && drugaSiatka == 3) || (pierwszaSiatka == 3 && drugaSiatka == 2)) {
            for (int i = numwierszePlanszy; i < numwierszePlanszy * 2; i++) {
                zamienRzedy(Plansza, i, i + numwierszePlanszy);
            }
        } else if ((pierwszaSiatka == 1 && drugaSiatka == 3) || (pierwszaSiatka == 3 && drugaSiatka == 1)) {
            for (int i = 0; i < numwierszePlanszy; i++) {
                zamienRzedy(Plansza, i, i + (numwierszePlanszy * 2));
            }
        }
        return Plansza;
    }

    private int[][] zamienLiczby(int[][] Plansza) {
        int[] num = dwieLosoweLiczby(1, Plansza.length);
        for (int i = 0; i < Plansza.length; i++) {
            for (int j = 0; j < Plansza.length; j++) {
                if (Plansza[i][j] == num[0]) {
                    Plansza[i][j] = num[1];
                } else if (Plansza[i][j] == num[1]) {
                    Plansza[i][j] = num[0];
                }
            }
        }
        return Plansza;
    }

    private int[] dwieLosoweLiczby(int min, int tolerance) {
        int a[] = new int[2];
        a[0] = min + random.nextInt(tolerance);
        a[1] = min + random.nextInt(tolerance);
        return a;
    }

    private int[][] createPlansza(int[][] Plansza) {
        for (int i = 0; i < 10; i++) {
            zamienRzedyiKolumny(Plansza);
            zamienSiatke(Plansza);
            zamienLiczby(Plansza);
        }
        return Plansza;
    }

    private int[][] createPuzzle(int[][] Plansza, int mode) {
        this.puzzle = kopiaOD(Plansza);
        int liczbaPustychBlokow = WezliczbePustychBlokow(Plansza, mode);
        for (int i = 0; i < liczbaPustychBlokow; i++) {
            int[] rzadkolumna = dwieLosoweLiczby(0, Plansza.length);
            this.puzzle[rzadkolumna[0]][rzadkolumna[1]] = 0;
        }
        return kopiaOD(this.puzzle);
    }

    //Poniższe tworzy poziomy trudności (zależność ile ma być pokazanych pól w danym kodzie)
    private int WezliczbePustychBlokow(int[][] Plansza, int mode) {
        int liczbaPustychBlokow = 0;
        int liczbaBlokow = Plansza.length * Plansza[0].length;

        if (POZIOM_GRY_LATWIEJSZY <= mode && mode <= POZIOM_GRY_EXP) {
            liczbaPustychBlokow = (int) Math.floor((mode * liczbaBlokow) / 100);
        } else {
            liczbaPustychBlokow = (int) Math.floor((TRYB_GRY_ZAAWANSOWANY * liczbaBlokow) / 100);
        }
        int tolerancja = (int) Math.floor(((liczbaBlokow - liczbaPustychBlokow) * 5) / 100);
        liczbaPustychBlokow += random.nextInt(tolerancja + 1); // to avoid negetive

        return liczbaPustychBlokow;
    }

    // sprawdzenie czy wynik jest poprawny lub błędny
    public boolean sprawdz(int[][] Plansza) {
        boolean jestPoprawne = true;
        int numOfwierszePlanszy = Plansza.length == 9 ? 3 : 2;
        final String setValues = Plansza.length == 9 ? USTAW_WARTOSC_9X9 : USTAW_WARTOSC_6X6;

        for (int i = 0; i < Plansza.length; i++) {
            String set = setValues;
            for (int j = 0; j < Plansza.length; j++) {
                set = set.replace("" + Plansza[i][j], "");
            }
            if (!set.isEmpty()) {
                jestPoprawne = false;
                return jestPoprawne;
            }
        }


        for (int j = 0; j < Plansza.length; j++) {
            String set = setValues;
            for (int i = 0; i < Plansza.length; i++) {
                set = set.replace("" + Plansza[i][j], "");
            }
            if (!set.isEmpty()) {
                jestPoprawne = false;
                return jestPoprawne;
            }
        }

        //sprawdz poziome i poprzeczne zależności (poprawność w braku powtarzalonści tych samych cyfr w dalej linii)
        for (int hg = 0; hg < Plansza.length; hg += numOfwierszePlanszy) {
            for (int vg = 0; vg < Plansza[0].length; vg += 3) {
                String set = setValues;
                for (int i = hg; i < (hg + numOfwierszePlanszy); i++) {
                    for (int j = vg; j < vg + 3; j++) {
                        set = set.replace("" + Plansza[i][j], "");
                    }
                }
                if (!set.isEmpty()) {
                    jestPoprawne = false;
                    return jestPoprawne;
                }
            }
        }

        return jestPoprawne;
    }

    public int[][] stworzNoweSudoku(int grid, int gameMode) {
        if (grid == SUDOKU_9x9) {
            return createPuzzle(createPlansza(PRAWIDLOWA_TABLICA_9X9), gameMode);
        } else if (grid == SUDOKU_6x6) {
            return createPuzzle(createPlansza(PRAWIDLOWA_TABLICA_6X6), gameMode);
        }

        return createPuzzle(createPlansza(PRAWIDLOWA_TABLICA_9X9), gameMode);
    }

    public int[][] resetPuzzle() {
        return puzzle;
    }

    private void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();


    }
}
