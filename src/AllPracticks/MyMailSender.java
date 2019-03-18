//package AllPracticks;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Date;
//import java.util.Properties;
//
//public class MyMailSender {
//
//    public static void main(String[] args) throws MessagingException {
//        generateAndSendEmail();
//    }
//
//    public static void generateAndSendEmail() throws AddressException, MessagingException {
//        Properties props = new Properties();
//        props.put("mail.transport.protocol", "smtps");
//        props.put("mail.smtps.host", "smtp.gmail.com");
//        props.put("mail.smtps.auth", "true");
//        props.put("mail.smtp.sendpartial", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//
//        Session session = Session.getDefaultInstance(props);
//
//
//        MimeMessage message = new MimeMessage(session);
//        message.setSubject("тестовое письмо!");
//
//        //добавляем текст письма
//        message.setText("Asta la vista, baby!");
//
//        //указываем получателя
//        message.addRecipient(Message.RecipientType.TO, new InternetAddress("developer.optimum@gmail.com"));
//
//        //указываем дату отправления
//        message.setSentDate(new Date());
//
//        String userLogin = "arti996yandex@gmail.com";
//        String userPassword = "039329656a";
//
//        //авторизуемся на сервере:
//        Transport transport = session.getTransport();
//        transport.connect("smtp.gmail.com", 465, userLogin, userPassword);
//
//        //отправляем сообщение:
//        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
//
//    }
//}