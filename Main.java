import java.util.Scanner;
import java.util.Random;
public class Main
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int posizione=0;
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


        do{
            System.out.println("Vuoi inserire un numero? (digita inserisci)");
            System.out.println("Vuoi rimuovere un numero? (digita rimuovi)");
            System.out.println("Vuoi visualizzare a video l'array (digita visualizza)");
            System.out.println("Termina il programma (digita stop)");
            istruzione=in.nextLine();
            istruzione=in.nextLine();
            // ISTRUZIONE INSERISCI
            if(istruzione.equalsIgnoreCase("inserisci")){
                System.out.println("inserisci la posizione");
                posizione=in.nextInt()-1;
                System.out.println("inserisci il numero da inserire");
                numero=in.nextInt();
                temp=numeri[posizione];
                numeri[posizione]=numero;
                lunghezza++;
                for (int i=posizione;i<numeri.length-1;i++) {

                    temp2=numeri[i+1];
                    numeri[i+1]=temp;
                    temp=temp2;

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
            if (istruzione.equalsIgnoreCase("random")){
                System.out.println("a che posizione vuoi inserire il numero casuale?");
                posizione=in.nextInt()-1;
                temp=numeri[posizione];
                numeri[posizione]=generatore.nextInt(50);
                lunghezza++;
                for (int i=posizione;i<numeri.length-1;i++) {

                    temp2=numeri[i+1];
                    numeri[i+1]=temp;
                    temp=temp2;

                }
            }

            // ISTRUZIONE CANCELLA
            if (istruzione.equalsIgnoreCase("rimuovi")){
                System.out.println("inserisci la posizione del numero che vuoi rimuovere");
                posizione=in.nextInt()-1;
                lunghezza--;
                temp=numeri[numeri.length-1];
                for (int i=numeri.length-1;i>posizione;i--){

                    temp2=numeri[i-1];
                    numeri[i-1]=temp;
                    temp=temp2;


                }
            }



         }while(!istruzione.equalsIgnoreCase("stop"));
    }
}