package com.reminder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

//    @Scheduled(cron = "0 0 * * * *")
    public void sendEmailWithTable(String recipient, String subject) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(recipient);
            helper.setSubject(subject);

            // HTML Table
            String emailContent = "<html><body>"
                    + "<h3>Test Data Table</h3>"
                    + "<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse; width: 100%; text-align: left;'>"
                    + "<tr style='background-color: #f2f2f2;'>"
                    + "<th>ID</th><th>Name</th><th>Email</th>"
                    + "</tr>"
                    + "<tr><td>1</td><td>John Doe</td><td>john@example.com</td></tr>"
                    + "<tr><td>2</td><td>Jane Doe</td><td>jane@example.com</td></tr>"
                    + "</table>"
                    + "</body></html>";

            helper.setText(emailContent, true); // Enable HTML

            mailSender.send(mimeMessage);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send email", e);
        }
    }
}

