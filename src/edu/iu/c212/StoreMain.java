package edu.iu.c212;

import edu.iu.c212.models.Item;
import edu.iu.c212.programs.StoreMapDisplay;
import edu.iu.c212.utils.FileUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StoreMain {
    public static void main(String[] args) throws IOException {
        StoreMapDisplay d = new StoreMapDisplay();
        d.display(new Item("Hammer", 50, 4, 18));
        SawPrimePlanks s = new SawPrimePlanks();
        System.out.println(s.getPlankLengths(616));
        System.out.println(s.getPlankLengths(616).size());
        FileUtils f = new FileUtils();
        System.out.println(f.readInventoryFromFile());
    }
}
