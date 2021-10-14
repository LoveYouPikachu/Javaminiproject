package notedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMenu {
    static List<Bills> billsList=new ArrayList<>();

    //The first time the class is loaded
    static {
        billsList.add(new Bills("dinner","cash","output",247,"2021-03-03","family dinner"));
        billsList.add(new Bills("salary","bank","input",5000,"2021-03-04","salary day"));
        billsList.add(new Bills("clothes","cash","output",500,"2021-04-11","buy cloth"));
        billsList.add(new Bills("stock ","bank","input",1000,"2021-05-01","Stocks soar"));
    }
    public static void main(String[] args)
    {
        run();
    }
    public static void showMain()
    {
        System.out.println("--------Handy notebook--------");
        System.out.println("1.Add accounts 2.Delete accounts 3.Check accounts 4.Exit system");
        System.out.println("Please enter the function number 1-4:");
    }
    public static void run()
    {
        showMain();
        Scanner scanner=new Scanner(System.in);
        //Get input options
        boolean flag=true;
        //Create flag

        //judge1,2,3,4
        while (flag)
        {
            int op=scanner.nextInt();
            switch (op)
            {
                case 1:
                    addBills();
                    break;
                case 2:
                    delBills();
                    break;
                case 3:
                    select();
                    break;
                case 4:
                    System.out.println("Exit system");
                    flag=false;
                    break;
                default:
                    System.out.println("please input again");
            }
        }
        System.out.println("Exit system!!See You");
    }

    private static void delBills() {
        System.out.println("input id");
        Scanner inscanner=new Scanner(System.in);
        int id=inscanner.nextInt();
        billsList.remove(id-1);
        System.out.println("delete success");
        showMain();
    }

    private static void addBills() {
        Scanner inScanner=new Scanner(System.in);
        Bills bills=new Bills();
        System.out.println("input name");
        bills.setName(inScanner.next());
        System.out.println("input account");
        bills.setAccount(inScanner.next());
        System.out.println("input type");
        bills.setType(inScanner.next());
        System.out.println("input total");
        bills.setTotal(inScanner.nextDouble());
        System.out.println("input time");
        bills.setTime(inScanner.next());
        System.out.println("input desc");
        bills.setDesc(inScanner.next());
        billsList.add(bills);
        System.out.println("success!!!");
        showMain();
    }

    /**
     * 1.Query all 2.Query by time 3.Inquiries about income and expenses
     */
    private static void select() {
        System.out.println("--------Accounting query---------");
        System.out.println("1.Query all 2.Query by time 3.Inquiries about income and expenses ");
        //create scanner
        Scanner scanner=new Scanner(System.in);
        int op=scanner.nextInt();
        switch (op)
        {
            case 1:
                selectAll();
                break;
            case 2:
                selectByDate();
                break;
            case 3:
                selectByType();
                break;
        }
        showMain();
    }

    private static void selectByType() {
        System.out.println("--------income and expenses---------");
        System.out.println("input:income and expenses");
        //create scanner
        Scanner scanner=new Scanner(System.in);
        String type=scanner.next();
        //Filter elements in the collection
        List<Bills> billsList = MainMenu.billsList.stream().filter(bills -> {
            String type1 = bills.getType();
            return type1.equals(type);
        }).collect(Collectors.toList());
        print(billsList);
    }

    private static void selectByDate() {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("--------Query by time---------");
        System.out.println("input:income and expenses");
        //create scanner
        Scanner scanner=new Scanner(System.in);
        System.out.println("input:start time");
        String start=scanner.next();
        System.out.println("output:end time");
        String end=scanner.next();
        List<Bills> billsList =MainMenu.billsList.stream().filter(bills ->{
            String time=bills.getTime();
            //Parse the string into a specific time
            try {
                Date startDate=format.parse(start);
                Date endDate=format.parse(end);
                Date timeDate=format.parse(time);
                if(timeDate.before(endDate)&& timeDate.after(startDate))
                {
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        } ).collect(Collectors.toList()) ;
        print(billsList);
    }

    private static void selectAll() {
        print(billsList);
    }
    public static void print(List<Bills> billsList)
    {
        System.out.println("Id\t\tname\t\taccount\t\ttype\t\ttotal\t\ttime\t\t\tdesc");
        for (int i = 0; i < billsList.size(); i++) {
            Bills bills=billsList.get(i);
            System.out.println(i+1+"\t\t"+bills.getName()+"\t\t"+bills.getAccount()+"\t\t"+bills.getType()+"\t\t"+bills.getTotal()+"\t\t"+bills.getTime()+"\t\t"+bills.getDesc());
        }
    }
}
