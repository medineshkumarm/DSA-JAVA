class Main {
    public static void main(String[] args) {
        String needle = "hello";
        System.out.println(buildLPSArray(needle));
    }

    public static int[] buildLPSArray(String needle) {
        int[] lps = new int[needle.length()];
        int len = 0, i = 1;

        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}