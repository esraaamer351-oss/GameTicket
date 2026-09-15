1package gameticket_package;
import static gameticket_package.Fans.vector;
import java.util.*;
/** My Exception Class.*/ 
class myexception extends Exception
{

    public myexception(String message) {
        
         super(message);
        
    }
    
}

/**
 * main class used to set all data ,book ticket,remove ticket , bet match and upgrade ticket
 * @author Abdelrhman
 */
public class GameTicket {
  
 
   static Scanner input = new Scanner(System.in);//static data members.
    public static void main(String[] args) throws myexception {
       
  
        
        Match m1= new Match(1,"ahly","enpi","cairo","18/6/2020","8:00pm","national")  ;
        Match m2= new Match(2,"zamalek","etihad","smouha","11/6/2020","8:00pm","national")  ;
        Match m3= new Match(3,"hars hodud","pyramids","cairo","20/6/2020","8:00pm","national")  ;
        Match m4= new Match(4,"egypt","tunsia","cairo","24/6/2020","8:00pm","international")  ;
        Match m5= new Match(5,"brazil","clompia","cairo","28/6/2020","8:00pm","international")  ;
        Match m6= new Match(6,"japan","china","cairo","30/6/2020","8:00pm","international")  ;
        
        vector.add(m1);
        vector.add(m2);
        vector.add(m3);
        vector.add(m4);
        vector.add(m5);
        vector.add(m6);
        
 
       
        Fans fan = new Fans(18,"abdelrhman") ;
        int operation;
        while (true) 
        {            
            System.out.println("press 1 to reverse ticket ");
            System.out.println("press 2 to remove ticket");
            System.out.println("press 3 to upgrade ticket");
            System.out.println("press 4 to exit");
            operation= input.nextInt();
            
            
            if (operation==1)
            {
                fan.BookTicket(fan);
                System.out.println("do you want to make a bet?");
                System.out.println("press 1 to agree");
                System.out.println("press 2 to disagree");
                int in=input.nextInt();
                if (in==1)
                {
                    System.out.println("enter name your team");
                    String teamName=input.next();
                   
                }
               
                
        
            }
            else if (operation==2)
            {
                if (!fan.ticket.isEmpty())
                {
                    fan.RemoveTicket(fan);
                }
                else
                    throw new myexception("Your tickets is Empty"); 
              
               

            }
            else if (operation==3)
            {
                fan.upgradeTicket(fan);
            }
            else if (operation==4)
                break;
            
        }
       
}
     
} 






/**
 *
 * 
 * this class make fans able to do all operations
 */
 class Fans
{
   private int id ;  
   private String name;
 static Vector<Match> vector = new Vector<>() ; //static data members.
 static Scanner input = new Scanner(System.in);//static data members.
   public Vector<Ticket> ticket ; 
   
    
/**
 * 
 * @param id
 * @param name 
 */
    public Fans(int id, String name) {
        this.id = id;
        this.name = name;
        
        ticket=new Vector<>();
    }
    /**
     * method to book the ticket
     * @param fan
     * @throws myexception 
     */
    public static void BookTicket(Fans fan) throws myexception
   {
       try {
                  
       System.out.println("Press 1 for national matches ");
       System.out.println("press 2 for international matches ");
        int type = input.nextInt();
        if (type==1)
        {
            
            for(int i=0;i<3;++i)
            {
                    System.out.println("id:"+vector.elementAt(i).getMatch_id());
                    System.out.println(vector.elementAt(i).getFirst()+" vs "+vector.elementAt(i).getSecond());
                    System.out.println("Date: "+vector.elementAt(i).getDate());
                    System.out.println("Time: "+vector.elementAt(i).getTime());
                    System.out.println("Staduim: "+vector.elementAt(i).getStadium());
            }
        }
        else 
        {
             for(int i=3;i<6;++i)
            {
                    System.out.println("id:"+vector.elementAt(i).getMatch_id());
                    System.out.println(vector.elementAt(i).getFirst()+" vs "+vector.elementAt(i).getSecond());
                    System.out.println("Date: "+vector.elementAt(i).getDate());
                    System.out.println("Time: "+vector.elementAt(i).getTime());
                    System.out.println("Staduim: "+vector.elementAt(i).getStadium());
            }
        }
        
        System.out.println("Please Enter match id");
        int id = input.nextInt();
       
       
         Match match = new Match() ;
        for(int i =0;i<vector.size();++i)
        {
            if (vector.elementAt(i).getMatch_id()==id)
            {
                match = vector.elementAt(i) ;
                
               
            }
        }
        
        
           System.out.println("Class A press 1");
           System.out.println("Class B press 2");
           System.out.println("Class C press 3");
        System.out.println("Price:"+match.price[0]+"\t Price:"+match.price[1]+"\t Price"+match.price[2]);
        System.out.println("Seats:"+match.seats[0]+"\tSeats:"+match.seats[1]+"\tSeats:"+match.seats[2]);
        int category = input.nextInt();
        Ticket  tic ;
        if(category==1) 
        {
            if(match.seats[0]==0)
            {
                System.out.println("This class is Full");
                return;
            }
           tic = new Category1(match) ;
           match.seats[0]--;
        }
        else if (category==2)
        {
            if(match.seats[1]==0)
            {
                System.out.println("This class is Full");
                return;
            }
            tic = new Category2(match) ;
            match.seats[1]-- ;
        }
        else 
        {
            if(match.seats[2]==0)
            {
                System.out.println("This class is Full");
                return;
            }
            tic= new Category3(match);
            match.seats[2]--;
        }
        
        
        
        fan.ticket.add(tic) ;
        fan.ticket.elementAt(fan.ticket.size()-1).display_info();
        System.out.println("You have been Book Ticket successfully");
        
        
       } catch (NullPointerException e) {
           System.out.println("Invaild data !!");
           return ;
       }
        
   }
    /**
     * remove ticket method to remove ticket static method
     * @param fan
     * @throws myexception 
     */
   public static void RemoveTicket(Fans fan) throws myexception
   {
       for(int i=0;i<fan.ticket.size();++i)
                fan.ticket.elementAt(i).display_info();
               System.out.println("Enter match id to remove");
                int id = input.nextInt();
                for(int i=0;i<fan.ticket.size();++i)
                { 
                    
                    if(fan.ticket.elementAt(i).getMatch().getMatch_id()==id)
                    {
                       
                            fan.ticket.remove(i); 
                          
                    }
                    
                }
   }
   /**
    * upgrade ticket method to upgrade ticket static method
    * @param fan
    * @throws myexception 
    */
   public static void upgradeTicket(Fans fan) throws myexception
   {
       for(int i=0;i<fan.ticket.size();++i)
           fan.ticket.elementAt(i).display_info();
       System.out.println("Enter Match id to upgrade");
       int id = input.nextInt();
       for(int i=0;i<fan.ticket.size();++i)
           if(fan.ticket.elementAt(i).match.getMatch_id()==id)
           {
               if (fan.ticket.elementAt(i) instanceof Category1)
               {
                   throw new myexception("Your Class is the First Class");
               }
               else if (fan.ticket.elementAt(i) instanceof Category2)
               {
                   for (int ii=0;ii<vector.size();++ii)
                       if(vector.elementAt(ii).getMatch_id()==id)
                       {
                         Ticket t = new Category1(vector.elementAt(ii)) ;
                         fan.ticket.remove(i) ;
                         fan.ticket.add(t);
                         break;
                        }
               }
               else 
               {
                   
                   System.out.println("Press 1 to upgrade to ClassA");
                   System.out.println("Press 2 to upgrade to ClassA");
                   int kind = input.nextInt();
                   if (kind==1)
                   {
                       for (int ii=0;ii<vector.size();++ii)
                       if(vector.elementAt(ii).getMatch_id()==id)
                       {
                         Ticket t = new Category1(vector.elementAt(ii)) ;
                         fan.ticket.remove(i) ;
                         fan.ticket.add(t);
                         break;
                        }
                   }
                   else 
                   {
                       for (int ii=0;ii<vector.size();++ii)
                       if(vector.elementAt(ii).getMatch_id()==id)
                       {
                         Ticket t = new Category2(vector.elementAt(ii)) ;
                         fan.ticket.remove(i) ;
                         fan.ticket.add(t);
                         break;
                        }
                   }
               }
               break;
           }
   }
    

    
}




/**
 *
 * abstract class 
 */
 abstract class Ticket
{
    
 
    private String bet ;
/**
 * 
 * @return 
 */
    public String getBet() {
        return bet;
    }
/**
 * 
 * @param bet 
 */
    public void setBet(String bet) {
        this.bet = bet;
    }
   Match match ;
/**
 * 
 * @param match 
 */
    public Ticket(Match match) {
      
        this.match = match;
       
    }
 
   
/**
 * 
 * @return 
 */
    public Match getMatch() {
        return match;
    }
/**
 * 
 * @param match 
 */
    public void setMatch(Match match) {
        this.match = match;
    }
 /** abstract method used to display informations */
    public abstract void display_info();
 
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *this class used for fan who book ticket in category 1
 * @author Abdelrhman
 */
 class Category1 extends Ticket
{
  final int price ;
  int seats_num  ;
  /**
   * 
   * @param match 
   */
    public Category1(Match match) {
        super(match);
        this.seats_num= this.match.seats[0] ;
        this.price= this.match.price[0] ;
    }
     
    
    
    
    //overriding.
    @Override
    public void display_info()
    {
        System.out.println("Class A "+" Price:"+price);
        
        match.display_info();
        
    }
    
    
}



/**
 *this class used for fan who book ticket in category 2
 * @author Abdelrhman
 */
 class Category2 extends Ticket
{
    final int price ;
    int seats_num  ;
    /**
     * 
     * @param match 
     */
    public Category2(Match match) {
        super(match) ;
         this.seats_num= this.match.seats[1] ;
        this.price= this.match.price[1] ;
    }
    @Override
    
     
      public void display_info()
    {
         System.out.println("Class B "+" Price: "+price);
        System.out.println();
        match.display_info();
    }
   
}



/**
 *this class used for fan who book ticket in category 3
 * @author Abdelrhman
 */
 class Category3 extends Ticket
{
    
    final int price  ;
    int seats_num  ;
    /**
     * 
     * @param match 
     */
    public Category3(Match match) {
        super(match);
         this.seats_num= this.match.seats[2] ;
        this.price= this.match.price[2] ;
    }
    @Override
      public void display_info()
    {
      System.out.println("Class C "+" Price:"+price);
        match.display_info();   
    }
    
    
}


/**
 *
 * this class for each match and set all match information
 */
 class Match
{
   private int match_id ;
   private String First ;
   private String Second ;
   private String stadium ;
   private String date ;
   private String time ;
   private String kind ;
   private String winners ;
    public int price [] ; // price for each category
    public int seats[] ;  // number of seats for eatch category
       /**
        * this method used to set values
        */
private void sets()
{
        price = new int[3] ;
        seats = new int [5] ;
        price[0]=200 ;
        price[1]=150 ;
        price[2]=50 ;
        seats[0]=100 ;
        seats[1]=200 ;
        seats[2]=300 ;
}
/**
 * 
 * @param match_id 
 */
    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }
/**
 * 
 * @param First 
 */
    public void setFirst(String First) {
        this.First = First;
    }
/**
 * 
 * @param Second 
 */
    public void setSecond(String Second) {
        this.Second = Second;
    }
/**
 * 
 * @param stadium 
 */
    public void setStadium(String stadium) {
        this.stadium = stadium;
    }
/**
 * 
 * @param date 
 */
    public void setDate(String date) {
        this.date = date;
    }
/**
 * 
 * @param time 
 */
    public void setTime(String time) {
        this.time = time;
    }
/**
 * 
 * @param kind 
 */
    public void setKind(String kind) {
        this.kind = kind;
    }
/**
 * 
 * @param winners 
 */
    public void setWinners(String winners) {
        this.winners = winners;
    }
/**
 * 
 * @param price 
 */
    public void setPrice(int[] price) {
        this.price = price;
    }
/**
 * 
 * @param seats 
 */
    public void setSeats(int[] seats) {
        this.seats = seats;
    }
/**
 * 
 * @return 
 */
    public String getKind() {
        return kind;
    }
/**
 * 
 * @return 
 */
    public int[] getPrice() {
        return price;
    }
/**
 * 
 * @return 
 */
    public int[] getSeats() {
        return seats;
    }
/**
 * 
 */
    public Match() {
    }

   

   
  
    /**
     * constructor
     * @param match_id
     * @param First
     * @param Second
     * @param stadium
     * @param date
     * @param time
     * @param kind 
     */
    public Match(int match_id, String First, String Second, String stadium, String date, String time, String kind) {
        sets();
        this.match_id = match_id;
        this.First = First;
        this.Second = Second;
        this.stadium = stadium;
        this.date = date;
        this.time = time;
        this.kind = kind;
       
    }
    
/**
 * 
 * @return 
 */
    public int getMatch_id() {
        return match_id;
    }
/**
 * 
 * @return 
 */
    public String getFirst() {
        return First;
    }
/**
 * 
 * @return 
 */
    public String getSecond() {
        return Second;
    }
/**
 * 
 * @return 
 */
    public String getStadium() {
        return stadium;
    }
/**
 * 
 * @return 
 */
    public String getDate() {
        return date;
    }
/**
 * 
 * @return 
 */
    public String getTime() {
        return time;
    }
     
   
    /** method to display match information */
    public void display_info()
    {
        System.out.println("Match id:"+getMatch_id());
        System.out.println(getFirst()+" vs "+getSecond());
        System.out.println("Date: "+getDate());
        System.out.println("Stadium:"+getStadium());
        System.out.println("Time:"+getTime());
    }
    /** method check the bet if correct or not.*/
    public boolean check_bet(String team)
    {
        if(this.winners.equals(team))
            return true ;
        return false ;
    }
}
