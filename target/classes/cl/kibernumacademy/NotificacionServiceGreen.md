````java

# GREEN

Se implementa la lógica mínima para que las pruebas pasen:

- Se valida si `mensaje` es `null` o vacío.
- Se valida si `destinatario` es `null`.

Si alguno es inválido, se lanza una `IllegalArgumentException`.

Las pruebas de `NotificationServiceTest` ahora pasan ✅

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
        if (mensaje == null || mensaje.trim().isEmpty() || destinatario == null) {
            throw new IllegalArgumentException("Mensaje o destinatario inválido");
        }

        if (destinatario.contains("@")) {
            emailSender.enviarCorreo(destinatario, mensaje);
        } else {
            smsSender.enviarSms(destinatario, mensaje);
        }
    }
}
