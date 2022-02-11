package cn.xxs.util;

import cn.xxs.entity.Admin;
import cn.xxs.entity.User;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class SendMail extends Thread {
	
	//实现会议发起人向发送邮件 通知
	public void send(final String fromemail,String[] to,String subject,String context) throws GeneralSecurityException, MessagingException
	{
		InternetAddress[] toAddress = new InternetAddress[to.length];
		for(int i=0;i<to.length;i++)
		{
			toAddress[i] =new InternetAddress(to[i]);
			Properties properties = new Properties();

	        properties.setProperty("mail.host","smtp.qq.com");

	        properties.setProperty("mail.transport.protocol","smtp");

	        properties.setProperty("mail.smtp.auth","true");


	        //QQ存在一个特性设置SSL加密
	        MailSSLSocketFactory sf = new MailSSLSocketFactory();
	        sf.setTrustAllHosts(true);
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.ssl.socketFactory", sf);

	        //创建一个session对象
	        Session session = Session.getDefaultInstance(properties, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(fromemail,"lfijxchdysejbfcj");
	            }
	        });
	        //开启debug模式
	        session.setDebug(true);

	        //获取连接对象
	        Transport transport = session.getTransport();

	        //连接服务器
	        transport.connect("smtp.qq.com",fromemail,"lfijxchdysejbfcj");

	        //创建邮件对象
	        MimeMessage mimeMessage = new MimeMessage(session);

	        //邮件发送人
	        mimeMessage.setFrom(new InternetAddress(fromemail));
	        //邮件接收人
	        
	       mimeMessage.setRecipient(Message.RecipientType.TO,toAddress[i]);
	        
	        

	        //邮件标题
	        mimeMessage.setSubject(subject);

	        //邮件内容
	        mimeMessage.setContent(context,"text/html;charset=UTF-8");

	        //发送邮件
	        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());

	        //关闭连接
	        transport.close();
	        
	        
		}
	}

}
