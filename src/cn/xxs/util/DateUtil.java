package cn.xxs.util;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 获取当天凌晨和第二天凌晨时间戳
 * 
 * @author wlx
 *
 */
public class DateUtil {
	/**
	 * 当天凌晨时间戳
	 * @return
	 */
	public static Timestamp getStartTimestamp() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date start = calendar.getTime();
		Timestamp timestamp = new Timestamp(start.getTime());
		return timestamp;
	}
	/**
	 * 第二天凌晨时间戳
	 * @return
	 */
	public static Timestamp getEndTimestamp() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date start = calendar.getTime();
		Timestamp timestamp = new Timestamp(start.getTime());
		return timestamp;
	}
	/*
	 * 传入一个时间 返回其当日凌晨时间
		 */
	public static Timestamp getStartTimestamp(String time)
	{
		Calendar calendar = Calendar.getInstance();
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date newTime=null;
		 try {
	            newTime = format.parse(time);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    
		 calendar.setTime(newTime);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			Date start = calendar.getTime();
			Timestamp timestamp = new Timestamp(start.getTime());
			return timestamp;
	}
	/*
	 * 传入一个时间 返回其当日凌晨时间
		 */
	public static Timestamp getEndTimestamp(String time)
	{
		Calendar calendar = Calendar.getInstance();
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date newTime=null;
		 try {
	            newTime = format.parse(time);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		 calendar.setTime(newTime);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			Date start = calendar.getTime();
			Timestamp timestamp = new Timestamp(start.getTime());
			return timestamp;
	}

	
	/*
	 * 获取当前时间
	 */
	public static String getNowTimestamp(){
		Date t = new Date();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return df.format(t);
	}
	
	/*
	 * 传入一个Date类型的日期，对其进行分钟加减的操作
	 */
	public static String AddTime(Date time,int m) throws ParseException
	{   
		Calendar nowTime = Calendar.getInstance(); //得到当前时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str=df.format(time);
		nowTime.setTime(df.parse(str));
		nowTime.add(Calendar.MINUTE,m);
		Date date=nowTime.getTime();  //将nowtime转换为data格式
		return df.format(date);
		
	}
	public static void main(String[] args) throws ParseException {
		System.out.println(getStartTimestamp().toString());
		System.out.println(getEndTimestamp().toString());
		System.out.println(getNowTimestamp());
		Date now = new Date();
		System.out.println(AddTime(now,-10));
		String time="2021-4-27";
		System.out.println("##########");
		System.out.println(getStartTimestamp(time).toString());
		System.out.println(getEndTimestamp(time).toString());
	}

}