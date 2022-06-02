import java.util.Scanner;

public class Assignment02 {
    public static void main(String[] args){
        begin();
        int mid = midW();
        double midT = midTerm(mid);
        int fina = midW(mid);
        double finT = finalTerm(fina);
        int home = midW(mid, fina);
        double homeT = homework(home);
        report(midT,finT,homeT);
    }

    public static void begin(){
        System.out.println("This program reads exam/homework scores and reports your overall course grade\n");
    }

    public static int midW(){
        Scanner input = new Scanner(System.in);
        System.out.print("Midterm: \nWeight (0-100)?");
        int a = input.nextInt();
        boolean check = check(a, 100);
        while(!check){
            System.out.println("Your Weight is not right number, please try again!");
            a = input.nextInt();
            check = check(a, 100);
        }
        return a;
    }
    public static int midW(int b){
        Scanner input = new Scanner(System.in);
        System.out.print("Final: \nWeight (0-100)? ");
        int a = input.nextInt();
        boolean check = check(a, 100);
        int total = a+b;
        while(!check||total>100){
            System.out.print("Your Weight is not right number, please try again!  ");
            a = input.nextInt();
            check = check(a, 100);
            total = a+b;
        }
        return a;
    }

    public static int midW(int b, int c){
        Scanner input = new Scanner(System.in);
        System.out.print("Homework: \nWeight (0-100)? ");
        int a = input.nextInt();
        boolean check = check(a, 100);
        int total = a+b+c;
        int sug = 100 - (b+c);
        while(!check||total!=100){
            System.out.println("Your Weight is not right number!  ");
            System.out.print("please, input Weight again, maybe ("+ sug +") is the right: ");
            a = input.nextInt();
            check = check(a, 100);
            total = a+b+c;
        }
        return a;
    }

    public static double midTerm(int a){
        double midScore;
        int totalP;
        Scanner input = new Scanner(System.in);
        System.out.print("Score earned:  ");
        totalP = input.nextInt();
        System.out.print("Were scores shifted (1=yes, 2=no)?  ");
        int b = input.nextInt();
        if(b==1){
            System.out.print("Shifted amount?  ");
            int d = input.nextInt();
            totalP += d;
            if(totalP>100){
                totalP = 100;
            }
        }
        System.out.println("Total Points = "+totalP+" / 100");
        midScore = Math.round((totalP/100.0)*a*10);
        midScore = midScore/10;
        System.out.println("Weighted score = " + midScore + " / "+a+"\n");
        return midScore;
    }

    public static double finalTerm(int a){
        double finalScore;
        int totalP;
        Scanner input = new Scanner(System.in);
       
        System.out.print("Score earned:  ");
        totalP = input.nextInt();
        System.out.print("Were scores shifted (1=yes, 2=no)?  ");
        int b = input.nextInt();
        if(b==1){
            System.out.print("Shifted amount?  ");
            int d = input.nextInt();
            totalP += d;
            if(totalP>100){
                totalP = 100;
            }
        }
        System.out.println("Total Points = "+totalP+" / 100");
        finalScore = Math.round((totalP/100.0)*a*10);
        finalScore = finalScore/10;
        System.out.println("Weighted score = " + finalScore + " / "+a+"\n");
        return finalScore;
    }

    public static double homework(int a){
        double finalScore;
        int totalA;
        int totalP=0;
        int totalM=0;
        Scanner input = new Scanner(System.in);
        System.out.print("Number of assignments?  ");
        totalA = input.nextInt();
        for(int i=1;i<=totalA;i++){
            System.out.print("Assignment "+i+" score and max? ");
            totalP += input.nextInt();
            totalM += input.nextInt();
        }
        
        System.out.print("How many sections did you attend?  ");
        int b = input.nextInt();
        int totalSec = b*5;
        if(totalSec>30){
            totalSec = 30;
        }
        totalP += totalSec;
        if(totalP>150){
            totalP=150;
        }
        totalM += 30;
        if(totalM>150){
            totalM = 150;
        }
        System.out.println("Section Points = "+totalSec+" / 30");
        System.out.println("Total Points = "+totalP+" / "+totalM);
        finalScore = Math.round(((double)totalP/totalM)*a*10);
        finalScore = finalScore/10;
        System.out.println("Weighted score = " + finalScore + " / "+a+"\n");
        return finalScore;
    }

    public static void report(double a, double b, double c){
        double finalS = a + b + c;
        System.out.println("Overall percentage = " + finalS);
        double gpa=0;
        if(finalS>=85){
            gpa = 3.0;
            System.out.println("Your grade will be at least: "+gpa);
            System.out.println("You will get the best grade. Good job!");
        }else if(finalS>=75){
            gpa = 2.0;
            System.out.println("Your grade will be at least: "+gpa);
            System.out.println("You need more training.");
        }else if(finalS>=60){
            gpa = 1.0;
            System.out.println("Your grade will be at least: "+gpa);
            System.out.println("Careful, you will lost your point.");
        }else{
            gpa = 0.0;
            System.out.println("Your grade will be at least: "+gpa);
            System.out.println("You really need study harder!");
        }
    }

    public static boolean check(int a, int b){
        if(a<0 || a>b){
            return false;
        }else{
            return true;
        }
    }
}
