import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Software
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        //menu
        String[] items={"Vada pav","Missal pav", "Samosa pav", "Tea  ", "Coffee", "Water bottle"};
        int[] prices={30,40,25,15,20,10};
        int[] quantity = new int[items.length];
        double total=0;
        double gtotal=0;

        //take customer input
        System.out.println("===Welcome to Shop===\n");

        System.out.println("Enter customer name");
        String name=sc.nextLine();

        System.out.println("Enter phone number");
        String number=sc.nextLine();

        //adress condition
        //addressCondition:
        // int a;
        // String address;
        // System.out.println("Takeaway(1) or Eat-in(2)");
        // a=sc.nextInt();
        // if(a==1)
        // {
        //    System.out.println("Enter address");
        //    address=sc.nextLine();
        // }
        // else if(a==2)
        // {
        //     System.out.println("Enjoy your food!");
        // }
        // else
        // {
        //     System.out.println("Invalid entry");
        // }
        // break addressCondition;

        //print menu
        System.out.println("\n\t---Menu---");
        for(int i=0;i<items.length;i++)
        {
            System.out.println((i+1) + ".)" + items[i] + "\t -₹."+prices[i]);
        }


        //taking order
        while(true)
        {
            System.out.println("Enter item number to order(0 to end order)");
            int choice=sc.nextInt();
            if(choice == 0)
            {
                break;
            }
            if(choice < 1 || choice > items.length)
            {
                System.out.println("Invalid entry");
                continue;

            }
            System.out.println("Enter quantity for "+ items[choice -1]+":");
            int qty = sc.nextInt();

            quantity[choice -1]+=qty;
            double itemTotal = prices[choice -1] * qty;
            total += itemTotal;

            System.out.println(qty+" "+items[choice-1]+" added to order");

        }
        System.out.println("Current total: ₹" + total);

        //print bill
        LocalDate date=LocalDate.now();        //print date and time
        LocalTime time=LocalTime.now();

        DateTimeFormatter formatD=DateTimeFormatter.ofPattern("dd/MM/yy");//format date
        String formattedD=date.format(formatD);

        DateTimeFormatter formatT=DateTimeFormatter.ofPattern("HH:mm");//format time
        String formattedT=time.format(formatT);

        System.out.println("\n================ FINAL BILL ================");
        System.out.println("Date: "+formattedD);
        System.out.println("Time: "+formattedT);
        System.out.println("Customer name : "+name);
        System.out.println("Phone number: "+ number);
        //continue addressCondition;
        //System.out.println("Address : "+ address);
        System.out.println("--------------------------------------------------------");
        System.out.println("Item\t \tOuantity\t Price\t Amount \t GST");
        System.out.println("--------------------------------------------------------");


        for(int i=0;i< items.length;i++)
        {
            if(quantity[i] >0)
            {
                double amount=prices[i]*quantity[i];
                total+=amount;
                double gstamount=amount+((amount*5)/100);
                gtotal+=gstamount;
                System.out.println(items[i]+ "\t\t" + quantity[i]+ "\t" + prices[i] + "\t" + amount + "\t" +gstamount);
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("Grand Total: ₹"+gtotal);


    }
}