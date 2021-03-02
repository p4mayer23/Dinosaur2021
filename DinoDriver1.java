
/**
 * Write a description of class DinoDriver1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver1
{
    public static void main(String[] args)
    {
        Dinosaur d1 = new Dinosaur();
        Dinosaur d2 = new Dinosaur();
        
        System.out.println(d1.equals(d2));
        
        Dinosaur[] pop = new Dinosaur[10];
        
        for(int i = 0; i < pop.length; i++) // loop for the length of array
        {
            pop[i] = new Dinosaur("T-rex");
        }
        
        // Age up all dinos to a random age between 0 and 35
        for(int i = 0; i < pop.length; i++)
        {
            int randAge = (int)(Math.random()*36);
            for(int j = 0; j < randAge; j++)
            {
            pop[i].ageUp();
            }
        }
        for(int i = 0; i < pop.length; i++)
        {
            System.out.println(pop[i].toString()); 
        }
    }
}
