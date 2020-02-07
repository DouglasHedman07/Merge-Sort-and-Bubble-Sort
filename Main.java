import java.util.Arrays;
import java.util.Timer;
public class Main {

    public static void main(String[] args) {

        int[] arreglo1 = new int[10];
        int[] arreglo2 = new int[10];
        int[] arreglo3 = new int[10];


        for (int i = 0; i < arreglo1.length; i++) {
            int temp = (int) (Math.random() * 10) + 1;
            arreglo1[i] = temp;
            arreglo2[i] = temp;
            arreglo3[i] = temp;
        }

        arreglo1 = mergeSort(arreglo1);


        Timer timer = new Timer();
        long Time = System.currentTimeMillis();

        System.out.println("-----------------MERGE SORT---------------------------");
        System.out.println("Antes de Utilizar Merge Sort (Busqueda de Elementos): ");
        for (int i = 0; i < arreglo1.length; i++) {

            System.out.print(arreglo1[i] + ", ");
            System.out.println(Time + " Milisegundos");

        }
        System.out.println("");
        System.out.println("Despues de Utilizar Merge Sort (Ordenamiento de Elementos): ");
        System.out.print(Arrays.toString(arreglo1));
        System.out.println(Time+" Milisegundos");


        System.out.println("");
        System.out.println("----------------------BUBBLE SORT-----------------------");
        System.out.println("Antes de Utilizar Bubble Sort (Busqueda de Elementos): ");

        System.out.print(Arrays.toString(arreglo3));
        System.out.println(Time+" Milisegundos");
        System.out.println("");
        System.out.println("Despues de Utilizar Bubble Sort  (Ordenamiento de Elementos): ");
        long TIME = System.currentTimeMillis();
        arreglo3 = bubbleSort(arreglo3);
        System.out.print(Arrays.toString(arreglo3));
        System.out.println(TIME+" Milisegundos");System.out.println();


    }



    public static int[] bubbleSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]< arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public  static int[] mergeSort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }

        int medio = arr.length /2;

        int[] inferior = new int[medio];
        int[] superior = new int[arr.length - medio];
        for (int i = 0; i < medio; i++) {
            inferior[i] = arr[i];
        }

        for (int i = 0; i < superior.length ; i++) {
            superior[i] = arr[i + inferior.length];
        }
        return  merge(mergeSort(inferior), mergeSort(superior));
    }


    public static int[] merge(int[] a, int[] b){
        int[] retval = new int[a.length+ b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (j < a.length && k < b.length ){
            if(a[j] < b[k]){
                retval[i++] = a[j++];
            }else{
                retval[i++] = b[k++];
            }
        }

        while (j < a.length){
            retval[i++] = a[j++];
        }

        while (k < b.length){
            retval[i++] = b[k++];
        }
        return retval;

    }
}