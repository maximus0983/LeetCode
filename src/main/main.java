package main;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.toArray();
        List<Double> l = new ArrayList<>();
        l.toArray(new Double[2]);
        String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};

        Arrays.sort(units, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for (String s : units) {
            System.out.println(s);
        }
//        File file = new File("/attachments");
//        System.out.println(formatSize(file.getTotalSpace()));
//        System.out.println(formatSize(file.getFreeSpace()));
//        System.out.println(formatSize(file.getUsableSpace()));
    }

    private static String formatSize(long size) {
        String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int unitIndex = 0;
        System.out.println(Arrays.toString(units));
        Map m = new HashMap<>();

        while (size > 1024) {
            size /= 1024;
            unitIndex++;
        }
        return String.format("%d %s", size, units[unitIndex]);
    }

}
