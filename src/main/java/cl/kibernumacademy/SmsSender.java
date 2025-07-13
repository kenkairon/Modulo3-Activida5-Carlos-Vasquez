package cl.kibernumacademy;

public interface SmsSender {
    void enviarSms(String destinatario, String mensaje);
}