package cl.kibernumacademy;

public class EmailSenderImpl implements EmailSender {
    public void enviarCorreo(String destinatario, String mensaje) {
        System.out.println("Enviando correo a " + destinatario + ": " + mensaje);
    }
}
