package org.example;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;

public class EmailSenders {
    public static void main(String[] args) {
        // Set up properties for the email server (Gmail SMTP)
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Replace with your actual email and password (securely stored)
        String senderEmail = "manjeet.instantsys@gmail.com";
        String senderPassword = "sfcb cxkn svsn qfxh";

        // Replace with the recipient's email address
        String recipientEmail = "sharmaboymanjeet12@gmail.com";

        // Specify the full path to the Extent Report file
        String reportFilePath = "C:\\Users\\ManjeetSharma\\Downloads\\AssetsTransferApiAutomation\\extent-report.htmex";

        try {
            // Create a session with your credentials
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmail, senderPassword);
                }
            });

            // Create a new message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Extent Report");

            // Create a multipart message
            Multipart multipart = new MimeMultipart();

            // Create the email body text
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Dear Client, please find the attached Extent Report.");
            multipart.addBodyPart(textPart);

            // Attach the Extent Report file
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File(reportFilePath));
            multipart.addBodyPart(attachmentPart);

            // Set the message content
            message.setContent(multipart);

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions more gracefully and log them
        }
    }
}
