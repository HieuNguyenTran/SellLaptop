package vn.edu.nlu.mail;



import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

import java.util.Properties;

public class Mail {
    static  String username = "vitieulac@gmail.com";
    static  String password = "towspsysqxsdhmwa";

    public  static  void sendMail(String emailKH, String id) {
        Properties pro = new Properties();
        pro.put("mail.smtp.host", "smtp.gmail.com");
        pro.put("mail.smtp.port", "587");
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.starttls.enable", "true");



        Session session = Session.getInstance(pro, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        try {

            message.setFrom(new InternetAddress(username, "LAPTOP-NLU"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailKH));
            message.setSubject("FORGOT PASSWORD ");
            String url = "http://localhost:8080/ProjectGroup02/ForgetPass_Receive?id=" + id;
            String text= "Chào bạn để lấy lại mật khẩu vui lòng click vào đường dẫn bên dưới, chúng tôi cam kết đây là liến kết an toàn:\n"
                    + url + "\n";
            message.setContent(text, "text/html; charset=utf-8");

            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

