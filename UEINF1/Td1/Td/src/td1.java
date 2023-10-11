package Td1.Td.src;

public class td1 {
    public static void main(String[] args) {
        int resMain = addition(3, 5);
        System.out.println(resMain);

        int test[] = {1,2,4,3};
        resMain = addition2(test);
        System.out.println(resMain);
    }

    /**
     * The function "addition" takes two integers as input and returns their sum.
     * 
     * @param a The parameter "a" is an integer value that represents the first number to be added.
     * @param b The parameter "b" is an integer value that is passed into the "addition" method.
     * @return The sum of the two input integers, a and b, is being returned.
     */
    public static int addition(int a, int b) {
        int res = a + b;
        return res;
    }

    /**
     * The function "addition2" takes an array of integers as input and returns the sum of all the
     * elements in the array.
     * 
     * @param array The parameter "array" is an integer array that contains the numbers to be added
     * together.
     * @return The method is returning the sum of all the elements in the input array.
     */
    public static int addition2(int [] array){
        int res2 = 0;

        for(int i = 0; i < array.length; i++){
            res2 += array[i];
        }
        return res2;
    }
}
