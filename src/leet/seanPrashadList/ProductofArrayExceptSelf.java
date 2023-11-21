package leet.seanPrashadList;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int multiply = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            multiply = multiply * nums[i];
            prefixProduct[i] = multiply;
        }
        multiply = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            prefixProduct[i] = prefixProduct[i - 1] * multiply;
            multiply = multiply * nums[i];
        }
        prefixProduct[0] = multiply;
        return prefixProduct;
    }

    public static void main(String[] args) {
        new ProductofArrayExceptSelf().productExceptSelf(
                new int[]{2, 3, 4, 5}
        );
    }
}
