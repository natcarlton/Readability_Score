class Problem {
    public static void main(String[] args) {
        for (int i = 0; args.length > i; i++) {
            if (args[i].equals("test")) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}