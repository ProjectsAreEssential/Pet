import java.util.Random;

public class Pet {
   // Instance variables
   private String name;
   private String species;
   private int age;
   private int healthScore;
   
   // Static variable to track how many pets in total their are
   private static int totalPets = 0;
   
   // Random object to intialize healthScore
   private static Random rand = new Random();
   
   public Pet(String name, String species, int age) {
      this.name = name;
      this.species = species;
      
      // Handle negative input for the age
      if (age < 0) {
         throw new IllegalArgumentException("Age cannot be negative");
      } else {
         this.age = age;
      }
      
      // Health score will be generated randomly from 1-10
      this.healthScore = rand.nextInt(10) + 1;
      
      Pet.totalPets++; // Increment the total pets by one everytime a Pet object is created
   }
   
   // Gets the name of the pet
   public String getName() {
      return name;
   }
   
   // Gets the species of the pet
   public String getSpecies() {
      return species;
   }
   
   // Gets the age of the pet
   public int getAge() {
      return age;
   }
   
   // Gets the health score of the pet
   public int getHealthScore() {
      return healthScore;
   }
   
   // Gets the total amount of pets
   public static int getTotalPets() {
      return totalPets;
   }
   
   // Print a string representation of the stats the pet has
   public String toString() {
      return "Name: " + name + "\n"
           + "Species: " + species + "\n"
           + "Age: " + age + "\n"
           + "Health Score: " + healthScore;
   }
}