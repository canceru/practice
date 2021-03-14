package file_scan;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        //File root = new File("D:\\课程\\2021-1-17-春招冲刺班-项目1\\mysearcher");
        File root = new File("D:\\install");

        // 实际项目中用哪个都可以
        traversalDepth(root);
        //traversalBroadcast(root);

//        String[] list = root.list();
//        System.out.println(Arrays.toString(list));

//        File[] files = root.listFiles();
//        System.out.println(Arrays.toString(files));

        // Filter 过滤/过滤器
//        File[] files = root.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                System.out.println(name);
//                if (name.endsWith(".jar")) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        });
//
//        System.out.println(Arrays.toString(files));
    }

    // 广度优化 —— 层序遍历 —— 队列
    private static void traversalBroadcast(File root) {
        // 无论是不是普通文件还是文件夹都放入队列
        Queue<File> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            File file = queue.poll();
            boolean directory = file.isDirectory();
            if (directory) {
                System.out.println("文件夹: " + file);
            } else {
                System.out.println("普通文件: " + file);
            }

            File[] files = file.listFiles();
            if (files == null) {
                continue;
            }
            if (files.length == 0) {
                continue;
            }

            for (File child : files) {
                queue.offer(child);
            }
        }
    }

    // 深度优先 —— 栈 —— 递归
    public static void traversalDepth(File root) {
        System.out.println("文件夹: " + root);
        File[] files = root.listFiles();

        // 判断是不是叶子结点
        if (files == null) {
            return;
        }

        if (files.length == 0) {
            return;
        }
        // 判断结束

        // 针对每个孩子，进行递归处理
        // 只处理文件夹孩子即可
        for (File file : files) {
            if (!file.isDirectory()) {
                System.out.println("普通文件: " + file);
                continue;
            }

            traversalDepth(file);
        }
    }
}
