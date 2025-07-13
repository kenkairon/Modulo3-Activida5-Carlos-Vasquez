// NotificationService.java
package cl.kibernumacademy;

public class NotificationService {

    private final EmailSender emailSender;
    private final SmsSender smsSender;

    public NotificationService(EmailSender emailSender, SmsSender smsSender) {
        this.emailSender = emailSender;
        this.smsSender = smsSender;
    }

    public void enviarNotificacion(String mensaje, String destinatario) {
        validarDatos(mensaje, destinatario);

        if (esCorreo(destinatario)) {
            emailSender.enviarCorreo(destinatario, mensaje);
        } else {
            smsSender.enviarSms(destinatario, mensaje);
        }
    }

    private void validarDatos(String mensaje, String destinatario) {
        if (mensaje == null || mensaje.trim().isEmpty() || destinatario == null) {
            throw new IllegalArgumentException("Mensaje o destinatario inválido");
        }
    }

    private boolean esCorreo(String destinatario) {
        return destinatario.contains("@");
    }
}
