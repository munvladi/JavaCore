import java.util.Scanner;

public class CalculatorVer1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the expression: ");
        String input = sc.nextLine();

        //System.out.println(input); //check if input is correct

        String[] stringar = input.split(" ");

        if (stringar.length != 3) {
            try {
                throw new Exception("Use this format: X + X, or 5 + 5");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(2);
            }
        } else if (!romanDetectionNumber(stringar[0]) && !isNumeric(stringar[0])) {
            try {
                throw new Exception("Use roman or arabic numbers from 1 to 10 only!");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        } else if (!romanDetectionNumber(stringar[2]) && !isNumeric(stringar[2])) {
            try {
                throw new Exception("Use roman or arabic numbers from 1 to 10 only");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        } else if (!operatorDetection(stringar[1])) {
            try {
                throw new Exception("Use the following operators: +, -, *, /");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(3);
            }
        }

        /*for (int i = 0; i < stringar.length; i++) { //check if creating string array with 3 elements
            System.out.println(stringar[i]);
        }*/

        //System.out.println(romanDetectionNumber(stringar[0])); // check if the first number is Roman

       /* for (int i = 0; i < romnum1().length; i++) { //check if roman numbers are correct
            System.out.println(romnum1()[i]);
        }*/

        if (romanDetectionNumber(stringar[0]) && romanDetectionNumber(stringar[2])) {
            int x3 = Roman.getArabicNumber(stringar[0]);
            int x4 = Roman.getArabicNumber(stringar[2]);
            int result = cal(stringar, x3, x4);
            System.out.println("Your output: " + Roman.getRomanResult(result));
        }else if (!romanDetectionNumber(stringar[0]) && !romanDetectionNumber(stringar[2])
        && !isArabicNumberFrom1to10(stringar[0], stringar[2])) {
            try {
                throw new Exception("Use numbers from 1 to 10 only");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(5);
            }
        } else if (!romanDetectionNumber(stringar[0]) && !romanDetectionNumber(stringar[2])
                && isArabicNumberFrom1to10(stringar[0], stringar[2])) {
            int x1 = Integer.parseInt(stringar[0]);
            int x2 = Integer.parseInt(stringar[2]);
            System.out.println("Your output: " + cal(stringar, x1, x2));
        }else {
            try {
                throw new Exception("Use only roman or arabic numbers at the same time");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(4);
            }
        }
    }

    public static String[] romnum1() {
        String[] romnum1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        return romnum1;
    }

    public static String[] operators() {
        String[] operators = {"+", "-", "*", "/"};
        return operators;
    }

    public static boolean operatorDetection(String st) {
        boolean result = true;
        for (int i = 0; i < operators().length; i++) {
            if (st.contains(operators()[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArabicNumberFrom1to10(String a, String b){
        int x1 = Integer.parseInt(a);
        int x2 = Integer.parseInt(b);
        boolean result;
        if(x1 > 0 && x1 < 11 && x2 > 0 && x2 < 11){
            result = true;
        } else{
            result = false;
        }
        return result;
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
            if (st.equals(romnum1()[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
                result = "-";
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

        if(a == 0){
            result = "0";
        }else if (length == 2) {
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