import java.util.Scanner;

class bity
{

    // Zwraca pozycje bitu najbardziej na lewo.

    static int getLeftmostBit(int n)
    {
        int m = 0;
        while (n > 1)
        {
            n = n >> 1;
            m++;
        }
        return m;
    }

    //Otrzymując pozycję bitu najbardziej na lewo, zwraca kolejny bit najbardziej na lewo

    static int getNextLeftmostBit(int n, int m)
    {
        int temp = 1 << m;
        while (n < temp)
        {
            temp = temp >> 1;
            m--;
        }
        return m;
    }

// Funkcja rekursywna
//Zwraca liczbę "jedynek" w liczbach od 1 do n

    static int countSetBits(int n)
    {
        // Bierze pozycje bitu najbardziej na lewo
        // To będzie górna granica dla następnych bitów
        int m = getLeftmostBit(n);

        return countSetBits(n, m);
    }

    static int countSetBits( int n, int m)
    {
        if (n == 0)
            return 0;

        // Bierze pozycje kolejnego najbardziej na lewo bitu "1"
        m = getNextLeftmostBit(n, m);

        // Jeśli n jest w pozycji 2^x-1, np. 1, 3, 7, 15, 31....
        // to już mamy (dodajemy 1 do m bo pozycje są od 0)

        if (n == (1 << (m + 1)) - 1)
            return (m + 1) * (1 << m);

        // ustalamy nowe n do kolejnego wywołania rekurencji
        n = n - (1 << m);
        return (n + 1) + countSetBits(n) + m * (1 << (m - 1));
    }

    public static void main (String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj n:");
        int n = scanner.nextInt();
        System.out.println ("Liczba bitów od 0 do n wynosi " + countSetBits(n));
    }
} 