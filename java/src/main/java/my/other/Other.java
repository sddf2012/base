package my.other;

/**
 * @author liu peng bo
 * @date 2022-7-6 10:45
 */
public class Other {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            subListByPageTotal(130, 3, i);
        }
       /* Object a=null;
        Cat b=(Cat) a;
        System.out.println(b);*/
    }

    public static void subListByPageTotal(int totalSize, int pageTotal, int pageNum) {
        int listPageSize = totalSize / pageTotal; //每一页要处理的数据
        int listMod = totalSize % pageTotal; //剩余条数  即最后一页数据
        int start = (pageNum - 1) * listPageSize + 1;  //每一页从第几行开始处理数据
        int end = pageNum == pageTotal ? start + listPageSize - 1 + listMod : start + listPageSize - 1;
        System.out.println(start + "--" + end);
    }
}
