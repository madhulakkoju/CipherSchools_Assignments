import java.util.Scanner;
import java.util.ArrayDeque;

class BalanceBrackets
{
    // method to check whether the string has balanced brackets
    // returns Boolean value
    static boolean isBalanced(String inputString)
    {
        ArrayDeque<Character> stk = new ArrayDeque<Character>();
        // using a Double Ended queue as a Stack.
        int n = inputString.length(); // String Length to iterate over
        char buf;
        int stkLength = 0; // traces the stack content count.
        for(int i=0;i<n;i++)
        {
            buf = inputString.charAt(i);
            if(buf =='{' || buf == '(' || buf == '[')
            {
                stk.addFirst(buf); // adding the brace character to head of the stack
                stkLength ++; // when an element is added to stack increment stkLength counter
            }
            else if(buf =='}' || buf == ')' || buf == ']')
            {
                // character is a closing brace
                if(stkLength == 0) // stack is empty
                    return false; // there is no opening brace to pair for the closing brace 
                    // so unbalanced return false.
                char checkChar = stk.peek();
                if(checkChar =='{' && buf =='}')
                {
                    stk.poll(); // remove head of the stack
                    stkLength--;
                }
                else if(checkChar =='[' && buf ==']')
                {
                    stk.poll(); // remove head of the stack
                    stkLength--;
                }
                else if(checkChar =='(' && buf ==')')
                {
                    stk.poll(); // remove head of the stack
                    stkLength--;
                }
                else
                {
                    // the braces doesn't match so, Unbalanced
                    return false;
                }
            }
            else
            {
                // this is for a case where the charactrer doesnot belong to any of the braces.
                // we ignore these characters , alphabets, numerals.
            }
        }

        return true; // return true od the string is Balanced 
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        while(testCases>0)
        {
            testCases --;
            if(isBalanced(sc.nextLine())) // check for bracket balance
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
    }
}
