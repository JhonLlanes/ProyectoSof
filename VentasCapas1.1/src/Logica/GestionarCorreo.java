/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

/**
 *
 * @author jhonllanes
 */
import java.io.UnsupportedEncodingException;
import java.util.Properties;
    import javax.mail.Address;
    import javax.mail.BodyPart;
    import javax.mail.Message;
    import javax.mail.MessagingException;
    import javax.mail.Multipart;
    import javax.mail.Session;
    import javax.mail.Transport;
    import javax.mail.internet.InternetAddress;
    import javax.mail.internet.MimeBodyPart;
    import javax.mail.internet.MimeMessage;
    import javax.mail.internet.MimeMultipart;

public class GestionarCorreo {
    
    public static boolean sendMessage(String mensaje,String subject, 
String correo){

        boolean rpta=false;
        Properties props = new Properties();
        // Nombre del host de correo, es smtp.gmail.com
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        // TLS si está disponible
        props.setProperty("mail.smtp.starttls.enable", "true");
        // Puerto de gmail para envio de correos
        props.setProperty("mail.smtp.port","587");
        // Cuenta de correo en gmail
        props.setProperty("mail.smtp.user", "correo@gmail.com");
        // Si requiere o no usuario y password para conectarse.
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props);
        //Verficiar el envio
        session.setDebug(true);
        MimeMessage  message = new MimeMessage(session);
        try {
            message.setSubject(subject);
            message.setText(mensaje);
           // Address address = new InternetAddress(dt,"NombrePersona");
           // message.setFrom(address);
            //La direccion de la persona a enviar
            Address address2 = new InternetAddress(correo,false);
            message.addRecipient(Message.RecipientType.TO,address2);
            Transport t = session.getTransport("smtp");
            t.connect("correo@gmail.com","clave");
            t.sendMessage(message,message.getAllRecipients());
            t.close();
            rpta=true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            return rpta;
        }
        return rpta;
}
    
}
