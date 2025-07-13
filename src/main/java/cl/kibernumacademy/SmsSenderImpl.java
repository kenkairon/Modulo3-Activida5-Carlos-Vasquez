package cl.kibernumacademy;

public class SmsSenderImpl implements SmsSender {
    public void enviarSms(String destinatario, String mensaje) {
        System.out.println("Enviando SMS a " + destinatario + ": " + mensaje);
    }
}