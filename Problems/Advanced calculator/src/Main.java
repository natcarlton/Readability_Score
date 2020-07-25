/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        switch (operator) {
            case "MAX":
                System.out.println(maxVal(args));
                break;
            case "MIN":
                System.out.println(minVal(args));
                break;
            case "SUM":
                System.out.println(sum(args));
                break;
        }
    }

    public static int maxVal(String[] args) {
        int max = Integer.parseInt(args[1]);
        for (int i = 2; i < args.length; i++) {
            int currentInt = Integer.parseInt(args[i]);
            max = Math.max(currentInt, max);
        }
        return max;
    }

    public static int minVal(String[] args) {
        int min = Integer.parseInt(args[1]);
        for (int i = 2; i < args.length; i++) {
            int currentInt = Integer.parseInt(args[i]);
            min = Math.min(currentInt, min);
        }
        return min;
    }

    public static int sum(String[] args) {
        int sum = 0;
        for (int i = 1; i < args.length; i++) {
            int currentInt = Integer.parseInt(args[i]);
            sum += currentInt;
        }
        return sum;
    }
}