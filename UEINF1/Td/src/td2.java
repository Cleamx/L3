public class td2 {
    public static void main(String[] args) {
        multiplication(5);
    }

    /**
     * The function takes an integer as input and prints the multiplication table
     * for that number up to
     * 10, returning the input number.
     * 
     * @param a The parameter "a" is an integer value that represents the number you
     *          want to multiply.
     * @return The method is returning the value of the parameter 'a', which is an
     *         integer.
     */
    public static int multiplication(int a) {
        int resMultipication = 0;
        for (int i = 0; i <= 10; i++) {
            resMultipication = a * i;
            System.out.println(a + " x " + i + " = " + resMultipication);
        }
        return a;
    }
}
