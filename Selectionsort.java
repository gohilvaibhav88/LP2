import java.util.*;
public class Selectionsort{
    public static void sort(int arr[] , int size){
        for(int i=0 ; i<size-1 ; i++){
            int min = i;
            for(int j=i+1 ; j< size ; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min]= temp;
        }
    }
    public static void main(String args[]){
        int size;
        System.out.print("Enter the size : ");
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        int arr[] = new int[size];

        System.out.print("Enter the elements of Array :");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        sort(arr, size);

        System.out.print("Sorted Array is : ");
        for(int i =0 ;i<arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }
}