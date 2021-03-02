import java.util.ArrayList; 
import java.util.List; 
import java.util.Iterator;
/**
 * Write a description of class Dinosaur here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Dinosaur
{
    // instance variables - replace the example below with your own
    private String type;
    private int age;
    private String gender;
    private int health; // range between 0 - 100
    private int wins;
    private int battleCount;
    private static int population; // can be changed, true for all instances of class 
    // final int sum; // constant
 
    /**
     * Default Constructor for objects of class Dinosaur
     */
    public Dinosaur()
    {
        // String type = "hello"; <-----local variables can have the same name
        // as instance variables
        this.type = "Dino";
        this.age = 0;
        // write code ethat will assign a gender to this dinosaur
        // 50% male and 50% female
        int randGend = (int)(Math.random()*2);
        if(randGend == 0)
            this.gender = "male";
        if(randGend == 1)
            this.gender = "female";
        
        this.health = 10;
        
        this.wins = 0;
        
        this.battleCount = 0;
        
        
    }
    
    /**
     * Explicit constructor for the Dino Clas
     */
    public Dinosaur(String t)
    {
        this.type = t;
        this.age = 0;
        int randGend = (int)(Math.random()*2);
        if(randGend == 0)
            this.gender = "male";
        if(randGend == 1)
            this.gender = "female";
        this.health = 10; 
        this.wins = 0;
        this.battleCount = 0;
    }
    
    /********** Getters **********/
    // Getters return the private instance data (accessor) 
    public String getType()
    {
        return this.type;
    }
    public int getAge()
    {
        return this.age;
    }
    public String getGender()
    {
        return this.gender;
    }
    public int getHealth()
    {
        return this.health;
    }
    public int getWins()
    {
        return this.wins;
    }
    public int getBattleCount()
    {
        return this.battleCount;
    }
    public static int getPop()
    {
        return population; 
    }
    
    /********** Setters **********/
    // Setters allow you to change the private instance data (mutator) 
    public void setType(String t)
    {
        this.type = t;
    }
    public void setAge(int a)
    {
        this.age = a;
    }
    public void setGender(String g)
    {
        this.gender = g;
    }
    public void setHealth(int h)
    {
        this.health = h;
    }
    public void setWins(int w)
    {
        this.wins = w;
    }
    public void setBattleCount(int bc)
    {
        this.battleCount = bc; 
    }
    public static void setPop(int p)
    {
        Dinosaur.population = p; 
    }
    
    public boolean equals(Dinosaur d)
    {
        //write code that will return true if two dinos are "equal"
        //return true if they're equal, false otherwise. 
        if(this.type.equals(d.getType()))
        {
                if(this.gender.equals(d.getGender()))
                {
                    return true;
                }
        }
        return false;
    }
    
    public void ageUp()
    {
        if(this.health > 0) // if the dino is alive
        {
            this.age++;
            // if age is less than 10, health increases by ten.
            if(this.age < 10)
                this.health = this.health + 10;
                // no change to health if age is between 10 and 24
            
                // health decrease by 5 if age is between 25 and 30
                else if(this.age >= 25 && this.age <=30)
                {
                    this.health = this.health - 5;
                    if(this.health <= 0)
                       Dinosaur.setPop(getPop()-1);
                }
                // Health decreases by 10 if greater than 30
                else if(this.age > 30)
                {
                    this.health = this.health - 10;
                    if(this.health <= 0)
                        Dinosaur.setPop(getPop()-1);
                }
        }
    }
    
    public int ageUp(int a)
    {
        for(int i = 0; i < a; i++)
        {
            this.age++;
            this.ageUp();
        }
        return this.age;
    }
        
    public double getBattleFactor(Dinosaur other)
    {
        double deciHealth = this.health * 0.0067;
        double relExpCalc = 0;
        // System.out.println(deciHealth);
        if(this.battleCount + other.getBattleCount() > 0)
        {
            double relExp = (double)(this.battleCount) / (double)(this.battleCount
            +other.battleCount);
            // System.out.println(relExp);
            relExpCalc = relExp * 0.33;
        }
        // System.out.println(relExpCalc);
        double battleFactor = deciHealth + relExpCalc;
        return battleFactor; 
    }
    
    public void update(Dinosaur loser, List<Dinosaur> p)
    {
        // reduce the health of the losing dino
        loser.setHealth(loser.getHealth() - 25);
        // reduce the health of the winner
        //this.setHealth(this.getHealth() - 5);
        Dinosaur i1 = this;
        Dinosaur i2 = loser;
        //Iterator<Dinosaur> itr = p.iterator(); 
        if(loser.getHealth() <= 0)
        {
            //i2 = itr.next(); 
            loser.setHealth(0);  
            p.remove(i2);  
        }
        if(this.getHealth() <= 0)
        {
            //i1 = itr.next();
            this.setHealth(0); 
            p.remove(i1); 
        }
        // increase the wins for this dino
        this.setWins(this.getWins()+1);
        // increase battleCount for both
        this.setBattleCount(this.getBattleCount()+1); 
        loser.setBattleCount(loser.getBattleCount()+1);
        
    }
    
    public abstract boolean attack(Dinosaur other);
    
    private boolean breedable(Dinosaur mate)
    {
        if(this.getGender().equals(mate.getGender()))
        {
            return false;
        }
        else if(this.getAge() > 10 && mate.getAge() > 10)
        {
           if(this.getType().equals(mate.getType()))
           {
               return true; 
           }
        }
        return false;
    }
    
    /**
     * Return this.Dino as a string
     */
    public String toString()
    {
        String answer = this.type + " " + this.age + " " + this.gender + " " + this.health;
        return answer;
    }
}

