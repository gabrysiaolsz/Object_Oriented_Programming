import java.util.Scanner;

public class sito
{
    public static void main (String args[])
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] liczby = new int [N+1];
        int i, j;

        for(i=2; i*i<=N; i++)
        {
            if(liczby[i]==0)
            {
                for(j=i*i; j<=N; j+=i)
                {
                    liczby[j]=1;
                }
            }
        }
        System.out.println("Kolejne liczby pierwsze z przedziału [2, ..., " + N + "] to:");

        for(i=2; i<=N; i++)
        {
            if(liczby[i]==0)
            {
                System.out.println(i);
            }
        }
    }
}
