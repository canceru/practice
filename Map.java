public static void main1(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("及时雨","宋江");
        System.out.println(map.get("及时雨"));

        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
}




Map常用方法



Set方法


注意：
1. Set是继承自Collection的一个接口类
2. Set中只存储了key，并且要求key一定要唯一
3. Set的底层是使用Map来实现的，其使用key与Object的一个默认对象作为键值对插入到Map中的
4. Set最大的功能就是对集合中的元素进行去重
5. 实现Set接口的常用类有TreeSet和HashSet，还有一个LinkedHashSet，LinkedHashSet是在HashSet的基础
上维护了一个双向链表来记录元素的插入次序。
6. Set中的Key不能修改，如果要修改，先将原来的删除掉，然后再重新插入
7. Set中不能插入null的key。
8. TreeSet和HashSet的区别

TreeMap 和 TreeSet 即 java 中利用搜索树实现的 Map 和 Set；实际上用的是红黑树，而红黑树是一棵近似平衡的二叉搜索树，即在二叉搜索树的基础之上 + 颜色以及红黑树性质验证，关于红黑树的内容后序再进行讲解。



public static void main1(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("及时雨","宋江");
        System.out.println(map.get("及时雨"));

        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
}


public static void main2(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("abcd");
        set.add("abcde");
        set.add("abcd");
        System.out.println(set);

        Iterator<String> it = set.iterator();//迭代器

        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(set.size());
        it.remove();
        System.out.println(set.size());
    }


public static void main3(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_0000; i++) {
            int num = random.nextInt(10_0000);
            list.add(num);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10_0000; i++) {
            if(set.contains(list.get(i))){
                System.out.println(list.get(i));
                return;
            }else {
                set.add(list.get(i));
            }
        }
    }


public static void main4(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_0000; i++) {
            int num = random.nextInt(10_0000);
            list.add(num);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10_0000; i++) {
            set.add(list.get(i));
        }
        //遍历set
    }



public static void main5(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_0000; i++) {
            int num = random.nextInt(10_0000);
            list.add(num);
        }

        //1、遍历list
        for (Integer key : list) {
            if(map.get(key) == null) {
                map.put(key,1);
            }else {
                int val = map.get(key);
                map.put (key,val+1);
            }
        }

        for (Map.Entry<Integer,Integer> entry :map.entrySet()) {
            if(entry.getValue() > 1) {
                System.out.println("重复的数字:"
                        +entry.getKey()+"次数："+entry.getValue());
            }
        }
    }