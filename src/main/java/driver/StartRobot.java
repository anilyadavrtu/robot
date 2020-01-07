package driver;

import domainobject.Product;
import robot.RobotImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * StartRobot
 * drive class of robot to start the robot by passing the product information
 */
public class StartRobot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your Product information ");
            System.out.println("Enter Barcode:");
            String barcode = reader.readLine();

            System.out.println("Enter Weight:");
            String weight = reader.readLine();

            System.out.println("Enter Distance:");
            String distance = reader.readLine();
            Product product = new Product(barcode, Double.valueOf(weight), Double.valueOf(distance));
            System.out.println(new RobotImpl().callRobot(product, 100));


    }
}
