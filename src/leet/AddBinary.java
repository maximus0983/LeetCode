package leet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AddBinary {
    public String addBinary(String a, String b) {
        BigDecimal al = toDecimal(a);
        BigDecimal bl = toDecimal(b);
        return toBinary(al.add(bl));
    }

    private String toBinary(BigDecimal l) {
        if (l.compareTo(BigDecimal.ZERO) == 0) {
            return "0";
        }

        StringBuilder binaryNumber = new StringBuilder();
        BigDecimal quotient = l;

        while (quotient.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal remainder = quotient.remainder(new BigDecimal(2));
            binaryNumber.append(remainder);
            quotient = quotient.divide(new BigDecimal(2), 0, RoundingMode.DOWN);
        }

        binaryNumber = binaryNumber.reverse();
        return binaryNumber.toString();
    }

    private BigDecimal toDecimal(String a) {
        String[] split = a.split("");
        BigDecimal base = new BigDecimal(1);
        BigDecimal res = new BigDecimal(0);
        for (int i = split.length - 1; i >= 0; i--) {
            res = res.add(BigDecimal.valueOf(Long.parseLong(split[i])).multiply(base));
            base = base.multiply(BigDecimal.valueOf(2));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}
