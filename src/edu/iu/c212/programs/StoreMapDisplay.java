package edu.iu.c212.programs;

import edu.iu.c212.models.Item;

import javax.swing.*;
import java.awt.*;

public class StoreMapDisplay {
    static int WIDTH = 700;
    static int HEIGHT = 500;
    public static void display(Item product){
        JFrame frame = new JFrame("High's Hardware Product Lookup: " + product.getName());
        frame.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        StoreMap map = new StoreMap(product.getAisleNum());
        frame.add(map);
        frame.setVisible(true);
        frame.setFocusable(true);
    }
}
