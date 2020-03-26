package CalculateDistance;

import java.util.Scanner;

public class CalcDistance
{
    //must start here
    public static final double MAX_DISTANCE = 48608.92; //feet
    public static final double MIN_DISTANCE = 18228.345; //feet
    public static final double FIELD_ELEV = 25;
    public static final double TCH = 49;

    public static void main(String[] args)
    {
        double distance = MAX_DISTANCE;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter angle 1: ");
        double angle1 = scan.nextDouble();
        System.out.println("Enter angle 2: ");
        double angle2 = scan.nextDouble();


        System.out.println("calculating...");
        double height1 = calcHeight(angle1, distance);
        double height2 = calcHeight(angle2, distance);

        double difference = calcDifference(height1, height2);

        System.out.println("Starting difference: " + difference);

//        || height1 % 100 > 1 || height2 % 100 > 1
        while (difference > 10)
        {
            distance--;
            height1 = calcHeight(angle1, distance);
            height2 = calcHeight(angle2, distance);
            difference = calcDifference(height1, height2);

            if (height1 % 100 < 1 && height2 % 100 < 1)
            {
                System.out.println("Current h1: " + height1 + " Current h2: " + height2
                        + " Current difference: " + difference);
            }
        }

        System.out.println("Distance: " + distance);
        System.out.println("Height1: " + height1);
        System.out.println("Height2: " + height2);

        System.out.println("***********************8");

        while (distance > MIN_DISTANCE)
        {
            if (height1 % 100 < 1 || height2 % 100 < 1)
            {
                System.out.println("Current h1: " + height1 + " Current h2: " + height2
                        + " Current distance: " + distance);
            }
            distance--;
            height1 = calcHeight(angle1, distance);
            height2 = calcHeight(angle2, distance);
        }


    }
    private static double calcHeight(double angle, double distance)
    {
        return distance * Math.tan(Math.toRadians(angle)) + FIELD_ELEV +TCH;
    }
    private static double calcDifference(double height1, double height2)
    {
        return Math.abs(height1 - height2);
    }
}
