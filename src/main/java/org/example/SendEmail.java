package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    public static void main(String[] args) throws MessagingException, IOException
    {

        String senderEmail = "manjeet.instantsys@gmail.com";
        String recipientEmail = "sharmaboymanjeet12@gmail.com";

        // Set the sender password
        String senderPassword = "sfcb cxkn svsn qfxh";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "25");


        Session session = Session.getInstance(props);


        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(senderEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
        message.setSubject("Extent Report");
        message.setText("Please find the attached extent report for your reference.");
        MimeBodyPart attachment = new MimeBodyPart();
        attachment.attachFile(new File("C:\\Users\\ManjeetSharma\\Downloads\\javamailTest\\testng.xml"));

        Transport transport = session.getTransport("smtp");
        transport.connect(senderEmail, senderPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully!");

    }


}