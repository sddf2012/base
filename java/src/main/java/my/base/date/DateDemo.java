package my.base.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liu peng bo
 * @date 2022-7-25 13:23
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        String str="20220725235959";
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        Date strDate=dateFormat.parse(str);
        System.out.println(new Date().before(strDate));
    }
}
