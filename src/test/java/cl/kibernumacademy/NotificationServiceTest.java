package cl.kibernumacademy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {

    @Mock
    private EmailSender emailSender;

    @Mock
    private SmsSender smsSender;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    void noDebeEnviarSiMensajeEsVacio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            notificationService.enviarNotificacion("", "juan@email.com");
        });
        assertEquals("Mensaje o destinatario inválido", exception.getMessage());
    }

    @Test
    void noDebeEnviarSiDestinatarioEsNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            notificationService.enviarNotificacion("Hola Juan", null);
        });
        assertEquals("Mensaje o destinatario inválido", exception.getMessage());
    }
}
