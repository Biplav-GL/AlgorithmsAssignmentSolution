package com.gl;
import java.util.Scanner;

import com.gl.services.BinarySearch;
import com.gl.services.GetDuplicates;
import com.gl.services.printAnyArray;
import com.gl.services.MergeSort;

public class Main {

    public static void main(String[] args) {

        //Taking the inputs from the User
        Scanner sc = new Scanner(System.in);

        //Input the Number of Companies
        System.out.println("Enter the number of Companies");
        int numberOfCompany = sc.nextInt();

        double[] sharePrices = new double[numberOfCompany];
        boolean[] dailyPriceDetails = new boolean[numberOfCompany];

        for (int i = 1; i <= numberOfCompany; i++) {
            //Input the share Prices
            System.out.println("Enter current stock price of the company " + i);
            sharePrices[i-1] = sc.nextDouble();

            //Input the share price increment or decrement details
            System.out.println("Whether company's stock price rose today compare to yesterday?");
            dailyPriceDetails[i-1] = sc.nextBoolean();
        }


        printAnyArray.printDoubleArray(sharePrices);
        printAnyArray.printBooleanArray(dailyPriceDetails);


        boolean loopCondition = true;
        while (loopCondition) {
            System.out.println("------------------------------------");
            System.out.println(("Enter the operation that you want to perform"));
            System.out.println(("1. Display the companies stock prices in ascending order"));
            System.out.println(("2. Display the companies stock prices in descending order"));
            System.out.println(("3. Display the total no of companies for which stock prices rose today"));
            System.out.println(("4. Display the total no of companies for which stock prices declined today"));
            System.out.println(("5. Search a specific stock price"));
            System.out.println(("6. Press 0 to exit"));
            System.out.println("------------------------------------");

            //Getting input from the User for the next Operation
            int selection = sc.nextInt();

            switch(selection) {
                case 0:
                    System.out.println("Exited Successfully");
                    loopCondition = false;
                    break;

                case 1:
                    MergeSort.performMergeSort(sharePrices, 0, sharePrices.length-1, true);
                    System.out.println("Stock prices in ascending order are :");
                    printAnyArray.printDoubleArray(sharePrices);
                    break;

                case 2:
                    MergeSort.performMergeSort(sharePrices, 0, sharePrices.length-1, false);
                    System.out.println("Stock prices in descending order are :");
                    printAnyArray.printDoubleArray(sharePrices);
                    break;

                case 3:
                    int noOfAscendingStockPrice  = GetDuplicates.findDuplicatesInArray(dailyPriceDetails, true);
                    System.out.println("Total no of companies whose stock price rose today : " + noOfAscendingStockPrice);
                    break;

                case 4:
                    int noOfDescendingStockPrice  = GetDuplicates.findDuplicatesInArray(dailyPriceDetails, false);
                    System.out.println("Total no of companies whose stock price rose today : " + noOfDescendingStockPrice);
                    break;

                case 5:
                    System.out.println("Enter the key value to search for Specific Share Price: ");
                    double inputByUser = sc.nextDouble();
                    boolean output  = BinarySearch.performBinarySearch(sharePrices, 0, sharePrices.length-1, inputByUser);
                    if (output) {
                        System.out.println("Stock of value " + inputByUser + " is present ");
                    } else {
                        System.out.println("Stock of value " + inputByUser + " is not present");
                    }
                    break;
            }
        }

        sc.close();
    }
}
