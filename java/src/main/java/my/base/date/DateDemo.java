package my.base.date;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liu peng bo
 * @date 2022-7-25 13:23
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        /*String str="20220725240000";
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        Date strDate=dateFormat.parse(str);
        System.out.println(strDate);
        System.out.println(new Date().before(strDate));*/
        //System.out.println(new BigDecimal("0.00")+"%");
        List<String> a=new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("1");
        System.out.println(a.stream().collect(Collectors.toSet()).size());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -3);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        System.out.println(calendar.getTime());

    }
}
