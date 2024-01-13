public class td7 {
    public static void main(String[] args) {
        System.out.println(toFarenheit(45));
        System.out.println(toCelsius(113));
    }

    /**
     * La fonction convertit une température en Celsius en Fahrenheit.
     * 
     * @param celsius Le paramètre « Celsius » représente une valeur de température en degrés Celsius.
     * @return La méthode renvoie la température en Fahrenheit.
     */
    public static int toFarenheit(int celsius){
        int resFarenheit = (celsius * 9/5) + 32;
        return resFarenheit;
    }

    /**
     * La fonction convertit une température en Fahrenheit en Celsius.
     * 
     * @param farenheit Le paramètre « farenheit » représente une valeur de température en Fahrenheit.
     * @return La méthode renvoie la température en Celsius.
     */
    public static int toCelsius(int farenheit){
        int resCelsius = (farenheit - 32) * 5/9;
        return resCelsius;
    }

}
