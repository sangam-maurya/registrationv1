package com.example.demo;

public class A {
    public static void main(String[] args) {
        int arr[] = {3, 5, 4, 7, 8, 4, 7 , 3 ,5 ,5 };
        int a;
       for (int i=0; i<arr.length; i++){
           for (int j=0; j<arr.length; j++){
               if (arr[i]<arr[j]){
                   a=arr[i];
                   arr[i]=arr[j];
                   arr[j]=a;
               }
           }
       }
    for (int i:arr){
        System.out.print(i +" ");
    }
        System.out.println(" ");
    int tempArr[] = new int[arr.length];
    int temp =0;
    tempArr[temp++] =arr[0];
    for (int i=1; i< arr.length; i++){
        if (arr[i]!=arr[i-1]){
            tempArr[temp++]=arr[i];
        }
    }
    for (int i=0; i<temp; i++){
        System.out.print(tempArr[i] + " ");
    }
    }
}
