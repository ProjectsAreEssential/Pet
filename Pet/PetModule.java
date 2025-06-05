import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PetModule {
   public static void collectAndSavePets() {
      Scanner console = new Scanner(System.in); // Read input from the console
      
      Pet[] pets = readInput(console);
      
      try {
         PrintStream output = new PrintStream(new File("out.txt"));
         outputFile(pets, output);
      } catch (FileNotFoundException e) {
         System.out.println("Error: Could not write to file." + e);
      }
       
      console.close(); // Close the console
   }
   
   public static Pet[] readInput(Scanner console) {
      System.out.print("How many pets would you like to enter? ");
      int amount = console.nextInt();
      
      System.out.println(); // Create a blank line for readability
      
      // Create an array comprised of pet objects based on the amount
      Pet[] pets = new Pet[amount];
      
      console.nextLine(); // Consume the leftover line
      
      for (int i = 0; i < amount; i++) {
         System.out.print("What is your pet's name? ");
         String name = console.nextLine();
         
         System.out.print("What is the species of the pet? ");
         String species = console.nextLine();
         
         System.out.print("How old is your pet? ");
         int age = console.nextInt();
         
         console.nextLine(); // Consume the leftover line
         
         System.out.println(); // Create a blank line for readability
         
         // Create each pet object
         Pet pet = new Pet(name, species, age);
         
         // Store that pet inside the pets collection
         pets[i] = pet;
      }
      
      return pets; // Return the array of pets
   }
   
   public static void outputFile(Pet[] pets, PrintStream output) {
      output.println("--- Pet Report --- ");
      
      for (int i = 0; i < pets.length; i++) {
         output.println("Pet #" + (i + 1));
         output.println(pets[i].toString()); // Prints all pet details
         output.println(); // Blank line for spacing
      }
      output.println("Total Pets: " + Pet.getTotalPets()); // Prints the total amount of pets at the end
   }
}
