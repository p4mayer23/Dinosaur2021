
/**
 * Write a description of class TRex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TRex extends Dinosaur
{
    // instance variables - replace the example below with your own
    private int numEaten; // specific to the TRex class and not Dinosaur

    /**
     * Constructor for objects of class TRex
     */
    public TRex()
    {
        //super() --> must be the first line of a constructor
        super("TRex"); // Calls the explicit constructor of the parent class
        
        
        this.numEaten = 0; 
        
    }
    
    public boolean attack(Dinosaur other)
    {
          boolean result = false;
        

                int rand = (int)(Math.random()*100); 
                int rand2 = (int)(Math.random()*100);   
                if(other.getType().equals("Ptero"))
                {
                    rand2 = rand2 - 5; 
                } 
                if(other.getType().equals("Veloci"))
                {
                    rand2 = rand2 + 5; 
                }
                double aweight = rand*this.getBattleFactor(other);
                System.out.println("My weight is " + aweight);
                System.out.println(this.toString());
                double dweight = rand2*other.getBattleFactor(this); 
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
