import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;
public class ConvertDecimal {
    /* ToBinary*/
    static int octalToBinary(int octal){
        int decimal = 0, i = 0;
        int binary = 0;
        while(octal != 0)
        {
            decimal += (octal%10) * Math.pow(8,i);
            ++i;
            octal/=10;
        }

        i = 1;

        while (decimal != 0)
        {
            binary += (decimal % 2) * i;
            decimal /= 2;
            i *= 10;
        }
        return binary;
    }
    static String hexaToBinary (String hex){
        String binary = "";
        for (int i = 0; i < hex.length(); i++) {
            char ch = hex.charAt(i);
            switch (ch) {
                case '0':
                    binary += "0000";
                    break;
                case '1':
                    binary += "0001";
                    break;
                case '2':
                    binary += "0010";
                    break;
                case '3':
                    binary += "0011";
                    break;
                case '4':
                    binary += "0100";
                    break;
                case '5':
                    binary += "0101";
                    break;
                case '6':
                    binary += "0110";
                    break;
                case '7':
                    binary += "0111";
                    break;
                case '8':
                    binary += "1000";
                    break;
                case '9':
                    binary += "1001";
                    break;
                case 'A':
                    binary += "1010";
                    break;
                case 'B':
                    binary += "1011";
                    break;
                case 'C':
                    binary += "1100";
                    break;
                case 'D':
                    binary += "1101";
                    break;
                case 'E':
                    binary += "1110";
                    break;
                case 'F':
                    binary += "1111";
                    break;
                default:
                    return null;
            }
        }
        return binary;
    }
    static int decimalToBinary(int decimalNumber){
        int B_Number = 0;
        int cnt = 0;
        while (decimalNumber != 0) {
            int rem = decimalNumber % 2;
            double c = Math.pow(10, cnt);
            B_Number += rem * c;
            decimalNumber /= 2;
            cnt++;
        }
        return B_Number;
    }
    /*Convert Medthod*/
    static long octalConvert(long binary){

        int octalVal = 0, decimalVal = 0, i = 0, j = 0;

        while(binary > 0)
        {
            decimalVal = (int) (decimalVal  + Math.pow(2, i++) * (binary % 10));
            binary = binary / 10;
        }

        while(decimalVal != 0)
        {
            octalVal = (int) (octalVal + (decimalVal % 8) * Math.pow(10, j++));
            decimalVal = decimalVal / 8;
        }
        return octalVal;
    }
    static void hexConvert(String number,int value){
        int binnum, hexDigit=0, m=1, c=1, rem, i=0;
        String [] base = {"BIN","OCT","DEC","HEX"};
        char[] hexnum = new char[20];
        binnum = Integer.parseInt(number);
        while(binnum!=0)
        {
            rem = binnum%10;
            hexDigit = hexDigit + (rem*m);
            if(c%4==0)
            {
                if(hexDigit<10)
                    hexnum[i] = (char)(hexDigit+48);
                else
                    hexnum[i] = (char)(hexDigit+55);
                m = 1;
                c = 1;
                hexDigit = 0;
                i++;
            }
            else
            {
                m = m*2;
                c++;
            }
            binnum = binnum/10;
        }

        if(c!=1)
            hexnum[i] = (char)(hexDigit+48);
        if(c==1)
            i--;

        System.out.printf("%s to HEX : ",base[value-1]);
        for(i=1; i>=0; i--)
            System.out.print(hexnum[i]);
    }
    static int decimalConvert(String bin){
        int binary = Integer.parseInt(bin);
        int decimalNumber = 0, i = 0;
        long remainder;
        while (binary != 0) {
            remainder = binary % 10;
            binary /= 10;
            decimalNumber += remainder * Math.pow(2, i);
            ++i;
        }
        return decimalNumber;
    }
    public static void main(String[] args) {
        while (true) {
            Scanner scn = new Scanner(System.in);
            System.out.println(" \n!!!! This is program to convert Binary,Octal,Hex,Decimal !!!!");
            System.out.println("\t\t\t\t### Please Choose number ### \n\t\t\t\t\t  Enter -1 to exit \n1.Binary \n2.Octal \n3.Decimal \n4.Hex ");
            System.out.print("Enter the number:");
            int choice = scn.nextInt();
            if(choice == -1){
                break;
            }else if(choice == 1) {
                System.out.print("Enter Binary:");
                String binaryNumber = scn.next();
                int bin = Integer.parseInt(binaryNumber);
                System.out.printf("BIN to OCT : %s\n", octalConvert(Long.parseLong(binaryNumber)));
                System.out.printf("BIN to DEC : %d\n", decimalConvert(binaryNumber));
                hexConvert(binaryNumber, choice);
            } else if (choice == 2) {
                System.out.print("\nEnter Octaldecimal:");
                int octal = scn.nextInt();
                int octalbinary = octalToBinary(octal);
                String binOct = Integer.toString(octalbinary);
                System.out.printf("OCT to BIN : %s\n", binOct);
                System.out.printf("OCT to DEC : %d\n", decimalConvert(binOct));
                hexConvert(binOct, choice);
            } else if (choice == 3) {
                System.out.print("\nEnter Decimal:");
                int decimalNumber = scn.nextInt();
                int decimalbinary = decimalToBinary(decimalNumber);
                String binDec = Integer.toString(decimalbinary);
                System.out.printf("DEC to BIN : %s\n", decimalbinary);
                System.out.printf("DEC to OCT : %d\n", octalConvert(Long.parseLong(binDec)));
                hexConvert(binDec, choice);
            } else if (choice == 4) {
                System.out.print("\nEnter Hexadecimal:");
                String hexNumber = scn.next();
                String hexbinary = hexaToBinary(hexNumber);
                System.out.printf("HEX to BIN : %s\n", hexbinary);
                System.out.printf("HEX to OCT : %d\n", octalConvert(Long.parseLong(hexbinary)));
                System.out.printf("HEX to DEC : %d\n", decimalConvert(hexbinary));
            } else {
                System.out.println("Invalid Input");
            }
            System.out.println("\n");
        }
    }
}
