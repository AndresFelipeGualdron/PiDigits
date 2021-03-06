package edu.eci.arsw.math;

import java.util.ArrayList;

///  <summary>
///  An implementation of the Bailey-Borwein-Plouffe formula for calculating hexadecimal
///  digits of pi.
///  https://en.wikipedia.org/wiki/Bailey%E2%80%93Borwein%E2%80%93Plouffe_formula
///  *** Translated from C# code: https://github.com/mmoroney/DigitsOfPi ***
///  </summary>
public class PiDigits {

    private static int DigitsPerSum = 8;
    private static double Epsilon = 1e-17;
    private static ArrayList<ThreadDigits> hilos;



    /**
     * Returns a range of hexadecimal digits of pi.
     * @param start The starting location of the range.
     * @param count The number of digits to return
     * @return An array containing the hexadecimal digits.
     */
    public static byte[] getDigits(int start, int count) {
        if (start < 0) {
            throw new RuntimeException("Invalid Interval");
        }

        if (count < 0) {
            throw new RuntimeException("Invalid Interval");
        }

        byte[] digits = new byte[count];
        double sum = 0;

        for (int i = 0; i < count; i++) {
            if (i % DigitsPerSum == 0) {
                sum = 4 * sum(1, start)
                        - 2 * sum(4, start)
                        - sum(5, start)
                        - sum(6, start);

                start += DigitsPerSum;
            }

            sum = 16 * (sum - Math.floor(sum));
            digits[i] = (byte) sum;
        }

        return digits;
    }


    /**
     * La siguiente funcion obtiene digistos decimales del numero pi
     * @param start inicio de obtencion de digitos
     * @param count total de digitos a obtener
     * @param n numero de hilos que se va a utilizar
     * @return
     * @throws InterruptedException
     */
    public static byte[] getDigits(int start, int count, int n) throws InterruptedException {
        int div = (int)(count/n);
        int mod = count%n;
        int inicio = start;
        int largo = div + mod;
        hilos = new ArrayList<ThreadDigits>();
        for(int i = 0; i < n; i++){
            ThreadDigits threadDigits = new ThreadDigits(inicio,largo);
            hilos.add(threadDigits);
            inicio += largo;
            largo = div;
        }
        for(int i = 0; i < n; i++){
            hilos.get(i).start();
        }
        for(int i = 0; i < n; i++){
            hilos.get(i).join();
        }
        ArrayList<byte[]> r = new ArrayList<>();
        for(int i = 0; i < n; i++){
            r.add(hilos.get(i).getRta());
        }
        byte[] bites = new byte[count];
        int cont = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j<r.get(i).length; j++){
                bites[cont] = r.get(i)[j];
                cont++;
            }
        }
        return bites;

    }


    /**
     *
     * @param n número de threads que se ejecutan
     * @return
     */
    public String getDigits(int n){
        int div = (int)(1000000/n);
        int mod = 1000000%n;
        int inicio = 1;
        int fin = div + mod;
        for(int i = 0; i < n; i++){
            ThreadDigits threadDigits = new ThreadDigits(inicio,fin);

            inicio += div+1;
            fin += div;
        }
        return "";
    }

    /// <summary>
    /// Returns the sum of 16^(n - k)/(8 * k + m) from 0 to k.
    /// </summary>
    /// <param name="m"></param>
    /// <param name="n"></param>
    /// <returns></returns>
    private static double sum(int m, int n) {
        double sum = 0;
        int d = m;
        int power = n;

        while (true) {
            double term;

            if (power > 0) {
                term = (double) hexExponentModulo(power, d) / d;
            } else {
                term = Math.pow(16, power) / d;
                if (term < Epsilon) {
                    break;
                }
            }

            sum += term;
            power--;
            d += 8;
        }

        return sum;
    }

    /// <summary>
    /// Return 16^p mod m.
    /// </summary>
    /// <param name="p"></param>
    /// <param name="m"></param>
    /// <returns></returns>
    private static int hexExponentModulo(int p, int m) {
        int power = 1;
        while (power * 2 <= p) {
            power *= 2;
        }

        int result = 1;

        while (power > 0) {
            if (p >= power) {
                result *= 16;
                result %= m;
                p -= power;
            }

            power /= 2;

            if (power > 0) {
                result *= result;
                result %= m;
            }
        }

        return result;
    }

}
