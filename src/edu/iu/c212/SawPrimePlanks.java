package edu.iu.c212;

import java.util.ArrayList;
import java.util.List;

public class SawPrimePlanks {
    List<Integer> lengths = new ArrayList<>();
    public List<Integer> getPlankLengths(int longPlankLength){
        lengths = new ArrayList<>();
        sawPlank(longPlankLength);
        return lengths;
    }

    public int sawPlank(int plankLength){
        int primeNumChecker = 2;
        if (isNotPrime(plankLength)){
            while(true){
                if ((plankLength % primeNumChecker) == 0){
                    for (int i = 0; i < primeNumChecker; i++){
                        sawPlank(plankLength/primeNumChecker);
                    }
                    break;
                }
                else {
                    primeNumChecker++;
                }
            }
        }
        else {
            lengths.add(plankLength);
        }
        return plankLength;
    }

    public boolean isNotPrime(int num){
        boolean notPrime = false;

        if (num <= 1){
            notPrime = false;
        }
        else {
            for (int i = 2; i <= num/2; i++){
                if ((num % i) == 0){
                    notPrime = true;
                    break;
                }
            }
        }
        return notPrime;
    }
}
