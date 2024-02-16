import java.util.Scanner;
import java.util.Random;
public class Main
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int posizione;
        int temp;
        int temp2;
        int numero;
        String istruzione;
        int[] numeri=new int[100];
        Random generatore = new Random();

        System.out.println("quanti valori vuoi inserire?");
        int lunghezza=in.nextInt();

        System.out.println("sequenza:");
        for (int i=0; i<numeri.length;i++){
            numeri[i]=generatore.nextInt(50);
        }
        for (int i=0; i<lunghezza;i++){
            System.out.print(numeri[i]+" ");
        }
        System.out.println("\n----------");

        // MENU
        do{
            System.out.println("Vuoi inserire un numero? (digita inserisci)");
            System.out.println("Vuoi inserire un numero casuale? (digita random)");
            System.out.println("Vuoi rimuovere un numero(posizione)? (digita rimuovi posizione)");
            System.out.println("Vuoi rimuovere un numero(occorrenze)? (digita rimuovi occorrenze)");
            System.out.println("Vuoi visualizzare a video l'array? (digita visualizza)");
            System.out.println("Termina il programma (digita stop)");
            System.out.println("----------");

            //IL DO WHILE SALTA DEI CICLI SENZA LEGGERE L'ISTRUZIONE; QUESTA é UNA SOLUZIONE CHE HO TROVATO ONLINE
            in.skip("\\R?");
            istruzione=in.nextLine();



            // ISTRUZIONE INSERISCI
            if(istruzione.equalsIgnoreCase("inserisci")){
                System.out.println("inserisci la posizione del numero da inserire");
                posizione=in.nextInt()-1;
                if (posizione>=100 || posizione<0)
                    System.out.println("posizione invalida");
                else {

                    System.out.println("inserisci il numero da inserire");
                    numero = in.nextInt();
                    if (posizione==99)
                        numeri[99]=numero;
                    else {
                        temp = numeri[posizione];
                        numeri[posizione] = numero;
                        lunghezza++;
                        for (int i = posizione; i < numeri.length - 1; i++) {
                            temp2 = numeri[i + 1];
                            numeri[i + 1] = temp;
                            temp = temp2;
                        }
                    }
                }
            }

            // ISTRUZIONE VISUALIZZA
            if (istruzione.equalsIgnoreCase("visualizza")){
                for (int i=0; i<lunghezza;i++){
                    System.out.print(numeri[i]+" ");
                }
                System.out.println(" ");
            }

            // ISTRUZIONE RANDOM
            if (istruzione.equalsIgnoreCase("random")) {
                System.out.println("a che posizione vuoi inserire il numero casuale?");
                posizione = in.nextInt() - 1;
                if (posizione >= 100 || posizione < 0)
                    System.out.println("posizione invalida");
                else{
                    if (posizione==99)
                        numeri[99]=generatore.nextInt(50);
                    else {
                        temp = numeri[posizione];
                        numeri[posizione] = generatore.nextInt(50);
                        lunghezza++;
                        for (int i = posizione; i < numeri.length - 1; i++) {
                            temp2 = numeri[i + 1];
                            numeri[i + 1] = temp;
                            temp = temp2;
                        }
                    }
                }
            }

            // ISTRUZIONE CANCELLA (POSIZIONE)
            if (istruzione.equalsIgnoreCase("rimuovi posizione")){
                System.out.println("inserisci la posizione del numero che vuoi rimuovere");
                posizione=in.nextInt()-1;
                if (posizione>=100 || posizione<0)
                    System.out.println("posizione invalida");
                else {
                    lunghezza--;
                    temp = numeri[numeri.length - 1];
                    for (int i = numeri.length - 1; i > posizione; i--) {
                        temp2 = numeri[i - 1];
                        numeri[i - 1] = temp;
                        temp = temp2;
                    }
                }
            }

            // ISTRUZIONE CANCELLA (OCCORRENZE DI UN ELEMENTO INSERITO)
            if (istruzione.equalsIgnoreCase("rimuovi occorrenze")){
                System.out.println("quale numero vuoi eliminare?");
                int nDaRimuovere=in.nextInt();
                for (int i=0;i<lunghezza;i++){
                    if (numeri[i]==nDaRimuovere){
                        lunghezza--;
                        for (int j=i; j<numeri.length-1;j++){
                            numeri[j]=numeri[j+1];
                        }
                    }
                }
            }
            System.out.println("----------");


        }while(!istruzione.equalsIgnoreCase("stop"));
    }
}