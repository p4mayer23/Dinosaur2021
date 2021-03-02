import java.util.ArrayList; 
import java.util.List; 

/**
 * Write a description of class DinoDriver2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver2
{
    public static void main(String[] args)
    { 
        
        //Dinosaur[] pop = new Dinosaur[25];
        //Dinosaur.setPop(pop.length); 
        List<Dinosaur> dinoPop = new ArrayList<Dinosaur>(); 
        
        for(int i = 0; i < 30; i++)
        {
            double rand = Math.random(); 
            if(rand < 0.33) //make a TRex
            {
                Dinosaur t = new TRex(); 
                dinoPop.add(t);
            }
            else if(rand < 0.67) //make a Veloci
            {
                dinoPop.add(new Veloci());  
            }
            else //make a Ptero
            {
                dinoPop.add(new Ptero());  
            }
            DinoDriver2.ageUpRand(dinoPop.get(i)); 
        }
        
        /*
        for(int i = 0; i < pop.length; i++) // loop for the length of array
        {
            double rand = Math.random(); // rand decimal
            if(rand < 0.33)
                pop[i] = new TRex();
            else if (rand < 0.67)
                pop[i] = new Veloci();
            else
                pop[i] = new Ptero();
            DinoDriver2.ageUpRand(pop[i]); 
        }
        */
        
        int roundNum = 1;
        int battleRoundSize = dinoPop.size(); 
        while(battleRoundSize > 1)
        {
            System.out.println("*********** Round " + (roundNum) + " ***********");  
            DinoDriver2.battleRound(dinoPop); 
            roundNum++; 
            battleRoundSize = dinoPop.size(); 
        }
        
        for( Dinosaur d : dinoPop ) // d gets assigned to pop[i]
        {
            if(d.getHealth() > 0)
            {
                System.out.println(d.toString()); // can also just put d
            }
        }
        
             
        
    }
    
    private static void battleRound(List<Dinosaur> p)
    {
        int size = p.size(); 
        int attackerWins = 0;
        int battles = 0;
        for(int i = 0; i < p.size(); i++)
        {
            Dinosaur d = p.get(i); 
            if(d.getHealth() > 0)
            {
                int rand;
                
                do
                {
                    rand = (int)(Math.random()*p.size()); 
                } while(p.get(rand).getHealth() == 0 || p.get(rand) == d);
                
                boolean fight = d.attack(p.get(rand)); 
                battles++; 
                if(fight == true)
                {
                    attackerWins++;
                    d.update(p.get(rand), p); 
                }
                if(fight == false)
                {
                    p.get(rand).update(d, p); 
                }
            }
        }//round is over
        System.out.println("*********** Population: " + p.size() +
        " ***********"); 
        System.out.println("***********   Total Battles: " + battles
        + " ***********   Attacker Wins: " + attackerWins + " times\n");
        
    }
    
    private static Dinosaur ageUpRand(Dinosaur other)
    {
         int randNum = (int)(Math.random()*35); 
         //other.setBattleCount(randNum); 
         for(int i = 0; i<randNum; i++)
         {
             other.ageUp(); 
         } 
         return other;
    }
    
    
}
