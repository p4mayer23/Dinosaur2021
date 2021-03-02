
/**
 * Write a description of class Ptero here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ptero extends Dinosaur
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Ptero
     */
    public Ptero()
    {
        //super() --> must be the first line of a constructor
        super("Ptero"); // Calls the explicit constructor of the parent class
        
        
        
        
    }

    public boolean attack(Dinosaur other)
    {
        boolean result = false;
        
        if(this.getHealth() > 0)
        {
            if(other.getHealth() > 0)
            {
                int rand = (int)(Math.random()*100); 
                int rand2 = (int)(Math.random()*100);  
                if(other.getType().equals("TRex"))
                {
                    rand2 = rand2 + 5; 
                }
                if(other.getType().equals("Veloci"))
                {
                    rand2 = rand2 + 5; 
                }
                double aweight = rand*this.getBattleFactor(other);
                System.out.println("My weight is " + aweight);
                System.out.println(this.toString());
                double dweight = rand*other.getBattleFactor(this);
                System.out.println("Other weight is " + dweight);
                System.out.println(other.toString());
                double subweight = aweight - dweight; 
                if(subweight < 0)
                {
                    //other.update(this);
                    result = false; 
                }
                else if(subweight >= 0)
                {
                    //this.update(other); 
                    result = true; 
                }
            } 
        }
     return result;
      
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        if(this.getAge() == 0)
            return super.toString();// super. calls the method of the parent class
        else
            return this.getType() + " " + this.getWins() + " " + this.getBattleCount()
            + " " + this.getHealth();
    }
}
