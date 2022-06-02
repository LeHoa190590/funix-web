import java.util.Scanner;

public class Assignment01 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello, chao mung ban den voi game Lucky Number");
        System.out.println("Ban muon khoang maximum la bao nhieu, so ngau nhien trong khoang do:");
        System.out.println("Ban chon so: ");
        //chon so maximum
        int maxNum = input.nextInt();
        System.out.println("Toi dang nghi toi 1 so trong khoang tu 0 toi" + maxNum +"...");
        int luckyNum;
        int totalGame = 0;
        double allGues = 0.0;
        int bestScr = 99;
        String Ans = "Yes";
        do{
        int totalGues = 1;
        //tao so random 0 - max
        luckyNum = (int)(Math.random()*(maxNum+1));
        System.out.println("Toi da nghi ra 1 con so la:... ");
        //System.out.println("Toi da nghi ra 1 con so la: "+luckyNum);
        System.out.print("Ban doan do la so may: ");
        int number = input.nextInt();
        //kiem tra so may man
        totalGues = checker(number, luckyNum, totalGues);
        System.out.println("Chuc mung ban da doan dung con so may man sau "+totalGues+" lan du doan!");
        allGues += totalGues;
        if(bestScr>totalGues){
            bestScr = totalGues;
        }
        totalGame++;
        System.out.println("Ban co muon tiep tuc khong? ");
        Ans = input.next();
        }while(Ans.equals("Yes")||Ans.equals("Y")||Ans.equals("yes")||Ans.equals("y")||Ans.equals("YES"));
        System.out.println("Ban da tra loi la: "+Ans);
        System.out.println("Ban da choi tat ca la: "+totalGame+" Game.");
        System.out.println("Tong so lan du doan cua ban la: "+allGues+" lan");
        System.out.println("Trung binh moi van ban doan: "+allGues/totalGame+" lan");
        System.out.println("Game tot nhat, ban doan dung voi: "+bestScr+" lan");
    }
    
    public static int checker(int a, int b, int c){
        Scanner input = new Scanner(System.in);
        while(a!=b){
            if(a<b){
                System.out.println("So may man lon hon so du doan cua ban");
                System.out.print("Ban doan? ");
                c++;
                a = input.nextInt();
            }else{
                System.out.println("So may man nho hon so du doan cua ban");
                System.out.print("Ban doan? ");
                c++;
                a = input.nextInt();
            }
        }
        return c;
    }
}
