package edu.iu.c212.utils;

import edu.iu.c212.models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    private static File inputFile = new File("src/edu/iu/c212/resources/input.txt");
    private static File outputFile = new File("src/edu/iu/c212/resources/output.txt");
    private static File inventoryFile = new File("src/edu/iu/c212/resources/inventory.txt");
    private static File staffFile = new File("src/edu/iu/c212/resources/staff.txt");
    private static File staffAvailabilityFile = new File("src/edu/iu/c212/resources/staff_availability_IN.txt");
    private static File shiftSchedulesFile = new File("src/edu/iu/c212/resources/shift_schedules_IN.txt");
    private static File storeScheduleFile = new File("src/edu/iu/c212/resources/store_schedule_OUT.txt");

    public static List<Item> readInventoryFromFile() throws IOException {
        System.out.println(inventoryFile/*.toURI()*/.getPath() + "\n" + inventoryFile.exists());
        ArrayList<Item> inventory = new ArrayList();
        try {
            //Stores the content of the txt file
            Scanner inFile = new Scanner(inventoryFile);
            //Stores the content of the txt file.
            while (inFile.hasNextLine()) {
                StringBuilder thisStringB = new StringBuilder();
                thisStringB.append(inFile.nextLine());
                String thisString = thisStringB.toString();
                String[] stringItem = thisString.split(",");
                Item thisItem = new Item(stringItem[0], Double.parseDouble(stringItem[1]), Integer.parseInt(stringItem[2]), Integer.parseInt(stringItem[3]));
                inventory.add(thisItem);
            }
        }
        //Catches Exception
        catch (IOException exception) {
            System.exit(1);
        }
        return inventory;
    }

    public static List<Staff> readStaffFromFile() throws IOException {
        ArrayList<Staff> allStaff = new ArrayList();
        String rolePhrase = "";
        try {
            //Stores the content of the txt file
            Scanner inFile = new Scanner(staffAvailabilityFile);
            //Stores the content of the txt file.
            while (inFile.hasNextLine()) {
                StringBuilder thisStringB = new StringBuilder();
                thisStringB.append(inFile.nextLine());
                String thisString = thisStringB.toString();
                String[] stringStaff = thisString.split(" ");
                if (stringStaff[3].equals("M")){
                    rolePhrase = "Manager";
                } else if (stringStaff[3].equals("C")){
                    rolePhrase = "Cashier";
                } else if (stringStaff[3].equals("G")){
                    rolePhrase = "GardenWorker";
                }
                else {rolePhrase = stringStaff[3];}
                Staff thisStaff = new Staff(stringStaff[0] + " " + stringStaff[1], Integer.parseInt(stringStaff[2]), rolePhrase, stringStaff[4]);
                allStaff.add(thisStaff);
            }
        }
        //Catches Exception
        catch (IOException exception) {
            System.exit(1);
        }
        return allStaff;
    }

    public static void writeInventoryToFile(List<Item> items) {
        try {
            FileWriter toFile = new FileWriter(inventoryFile, false);
            for (int i = 0; i < items.size(); i++) {
                toFile.write(items.get(i).getName());
                toFile.write(",");
                toFile.write(String.valueOf(items.get(i).getPrice()));
                toFile.write(",");
                toFile.write(String.valueOf(items.get(i).getQuantity()));
                toFile.write(",");
                toFile.write(String.valueOf(items.get(i).getAisleNum()));
                if (!(i == (items.size() - 1))) {
                    toFile.write(System.getProperty("line.separator"));
                }
            }
            toFile.close();
        }
        catch (IOException exception){
            System.exit(1);
        }
    }

    public static void writeStaffToFile(List<Staff> employees) {
        try {
            FileWriter toFile = new FileWriter(staffAvailabilityFile, false);
            for (int i = 0; i < employees.size(); i++) {
                toFile.write(employees.get(i).getFullName());
                toFile.write(" ");
                toFile.write(String.valueOf(employees.get(i).getAge()));
                toFile.write(" ");
                if (employees.get(i).getRole().equals("Manager")){
                    toFile.write("M");
                } else if (employees.get(i).getRole().equals("GardenWorker")){
                    toFile.write("G");
                } else if (employees.get(i).getRole().equals("Cashier")){
                    toFile.write("C");
                }
                else {toFile.write(employees.get(i).getRole());}
                toFile.write(" ");
                toFile.write(employees.get(i).getAvailability());
                if (!(i == (employees.size() - 1))) {
                    toFile.write(System.getProperty("line.separator"));
                }
            }
            toFile.close();
        }
        catch (IOException exception){
            System.exit(1);
        }
    }

    public static List<String> readCommandsFromFile() throws IOException {
        // TODO
        return null;
    }

    public static void writeStoreScheduleToFile(List<String> lines) {
        // TODO
    }

    public static void writeLineToOutputFile(String line) {
        // TODO
    }

}