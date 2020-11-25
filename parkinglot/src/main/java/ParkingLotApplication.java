import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gojek.coding.parkinglot.challenge.dsl.processor.CommandLineDslProcessor;
import com.gojek.coding.parkinglot.challenge.exception.ParkingLotException;
import com.gojek.coding.parkinglot.challenge.service.impl.CarParkingServiceImpl;

public class ParkingLotApplication {

  public static void main(String[] args) throws IOException, ParkingLotException {
    CommandLineDslProcessor commandLineDslProcessor = new CommandLineDslProcessor(new CarParkingServiceImpl());
    System.out.println("\n\n\n");
    System.out.println("Please execute Parking lot application with input file as argument");
    File inputFile = new File(args[0]);
    String input = null;
    switch (args.length) {
      case 0:
        while (true) {
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
          input = bufferedReader.readLine().trim();
          try {
            commandLineDslProcessor.processDSLCommands(input);
          } catch (Exception exception) {
            System.out.println("Error occured:" + exception.getMessage());
            break;
          }

        }
        break;
      case 1:
        BufferedReader bufferReader = new BufferedReader(new FileReader(inputFile));
        while ((input = bufferReader.readLine()) != null) {
          input = input.trim();
          try {
            commandLineDslProcessor.processDSLCommands(input);
          } catch (Exception exception) {
            System.out.println("Error occured:" + exception.getMessage());
          }
        }
        break;
    }

  }

}
