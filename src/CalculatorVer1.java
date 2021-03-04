import java.util.Scanner;

public class CalculatorVer1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the expression: ");
        String input = sc.nextLine();

        //System.out.println(input); //check if input is correct

        String[] stringar = input.split(" ");

        /*for (int i = 0; i < stringar.length; i++) { //check if creating string array with 3 elements
            System.out.println(stringar[i]);
        }*/

        //System.out.println(romanDetectionNumber(stringar[0])); // check if the first number is Roman

       /* for (int i = 0; i < romnum1().length; i++) { //check if roman numbers are correct
            System.out.println(romnum1()[i]);
        }*/

        if (romanDetectionNumber(stringar[0])) {
            int x3 = Roman.getArabicNumber(stringar[0]);
            int x4 = Roman.getArabicNumber(stringar[2]);
            int result = cal(stringar, x3, x4);
            System.out.println("Your output" + Roman.getRomanResult(result));
        } else if (!romanDetectionNumber(stringar[0])) {
            int x1 = Integer.parseInt(stringar[0]);
            int x2 = Integer.parseInt(stringar[2]);
            System.out.println("Your output: " + cal(stringar, x1, x2));
        }

    }

    public static String[] romnum1() {
        String[] romnum1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        return romnum1;
    }

    public static int sum(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static int sub(int a, int b) {
        int sub = a - b;
        return sub;
    }

    public static int mul(int a, int b) {
        int mul = a * b;
        return mul;
    }

    public static int div(int a, int b) {
        int div = a / b;
        return div;
    }

    public static int cal(String[] string, int x1, int x2) {
        int result = 0;
        switch (string[1]) {
            case "+":
                result = sum(x1, x2);
                break;
            case "-":
                result = sub(x1, x2);
                break;
            case "*":
                result = mul(x1, x2);
                break;
            case "/":
                result = div(x1, x2);
                break;
        }
        return result;
    }

    public static boolean romanDetectionNumber(String st) {
        boolean result = true;
        for (int i = 0; i < romnum1().length; i++) {
            if (st.contains(romnum1()[i])) {
                return true;
            }
        }
        return false;
    }


}

class Roman {
    public static int getArabicNumber(String input) {
        int result = 0;
        switch (input) {
            case "I":
                result = 1;
                break;
            case "II":
                result = 2;
                break;
            case "III":
                result = 3;
                break;
            case "IV":
                result = 4;
                break;
            case "V":
                result = 5;
                break;
            case "VI":
                result = 6;
                break;
            case "VII":
                result = 7;
                break;
            case "VIII":
                result = 8;
                break;
            case "IX":
                result = 9;
                break;
            case "X":
                result = 10;
                break;
        }
        return result;
    }

    public static String getRomanNumber(int input) {
        String result = "0";
        switch (input) {
            case 0:
                result = "";
                break;
            case 1:
                result = "I";
                break;
            case 2:
                result = "II";
                break;
            case 3:
                result = "III";
                break;
            case 4:
                result = "IV";
                break;
            case 5:
                result = "V";
                break;
            case 6:
                result = "VI";
                break;
            case 7:
                result = "VII";
                break;
            case 8:
                result = "VIII";
                break;
            case 9:
                result = "IX";
                break;
            case 10:
                result = "X";
                break;
            case 20:
                result = "XX";
                break;
            case 30:
                result = "XXX";
                break;
            case 40:
                result = "XL";
                break;
            case 50:
                result = "L";
                break;
            case 60:
                result = "LX";
                break;
            case 70:
                result = "LXX";
                break;
            case 80:
                result = "LXXX";
                break;
            case 90:
                result = "XC";
                break;
            case 100:
                result = "C";
                break;
        }
        return result;
    }

    public static String getRomanResult(int a) {
        String result;

        int length = String.valueOf(a).length();
        String number = String.valueOf(a);
        String[] stringar1 = number.split("");

        if (length == 2) {
            String decimal1 = stringar1[0].concat("0");
            int deci = Integer.parseInt(decimal1);
            int single = Integer.parseInt(stringar1[1]);
            String decimalroman = getRomanNumber(deci);
            String singleroman = getRomanNumber(single);
            result = decimalroman.concat(singleroman);
        } else {
            result = getRomanNumber(a);
        }
        return result;
    }
}