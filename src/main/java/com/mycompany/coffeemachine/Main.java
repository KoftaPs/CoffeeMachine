
package com.mycompany.coffeemachine;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    
    public static void main(String[] args)
    {
        
        CoffeeMachine machine = new CoffeeMachine(20000, 5000);
        
        
        boolean exit = false;
       
        
       while(!exit)
       {
            try {
                Scanner scanner = new Scanner(System.in);
                int coffetypeNum = 0;
                String coffeType = "";
                int grindLevel = 0;
                int size = 0;
                
                String[]coffeetypesNames = {"Espresso-Single","Espresso-Double","Americano-Single","Americano-Double"};
                System.out.println("select the type of the coffe you want: ");
                System.out.print("""
                                 
                                   1. Espresso-Single
                                   2. Espresso-Double
                                   3. Americano-Single
                                   4. Americano-Double
                                   Type Number:   """);
                
                coffetypeNum = scanner.nextInt() - 1;
                coffeType = coffeetypesNames[coffetypeNum];
                
                System.out.print("\ngrindLevel: ");
                grindLevel = scanner.nextInt();
                
                System.out.print("\nsize: ");
                size = scanner.nextInt();
                
                
                
                Coffeecup cup =   machine.serveCoffee(coffeType, grindLevel, size);
                
                System.out.println("\n\n"+cup.getInfo()+"\n");
                
                
                if(machine.isCleaningNeeded())
                {
                    machine.clean();
                }
                if(machine.waterLevel < 200 || machine.beansLevel < 200)
                {
                    try{
                        machine.fillWater(4000);
                        machine.fillBeans(15000);
                    }
                    catch(CoffeExp e)
                    {
                        System.out.println(e.toString());
                    }
                }} catch (CoffeExp ex) {
                System.out.println(ex.toString());
            }
           
          
       }
        
       
        
        
    }
}
