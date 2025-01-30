package com.bank.backoffice.notifications.domain;

public class MoneyTransferNotificationReceived extends Email {

    private final String accountNumberFrom;
    private final Double amount;

    public MoneyTransferNotificationReceived(EmailId id, String accountNumberFrom, Double amount, String from) {
        super(id, "pepito@yahoo.com", from, "Notificación: Se ha realizado una transferencia desde tu cuenta", formatBody(accountNumberFrom, amount));

        this.accountNumberFrom = accountNumberFrom;
        this.amount = amount;
    }

    private static String formatBody(String accountNumberFrom, Double amount) {
        return String.format("""
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset=\"UTF-8\">
                    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
                    <title>Notificación de Pago Recibido</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            background-color: #f4f4f4;
                            margin: 0;
                            padding: 0;
                        }
                        .container {
                            max-width: 600px;
                            background-color: #ffffff;
                            margin: 20px auto;
                            padding: 20px;
                            border-radius: 8px;
                            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                        }
                        .header {
                            background-color: #28a745;
                            color: white;
                            padding: 15px;
                            text-align: center;
                            font-size: 20px;
                            border-radius: 8px 8px 0 0;
                        }
                        .content {
                            padding: 20px;
                            text-align: center;
                            font-size: 16px;
                            color: #333;
                        }
                        .footer {
                            margin-top: 20px;
                            font-size: 14px;
                            color: #777;
                            text-align: center;
                        }
                        .highlight {
                            color: #28a745;
                            font-weight: bold;
                        }
                    </style>
                </head>
                <body>
                    <div class=\"container\">
                        <div class=\"header\">Notificación de Pago Recibido</div>
                        <div class=\"content\">
                            <p>Estimado cliente,</p>
                            <p>Ha recibido un pago en su cuenta <span class=\"highlight\">#%s</span></p>
                            <p>por un monto de <span class=\"highlight\">$%.2f</span>.</p>
                            <p>Puede verificar esta transacción en su cuenta bancaria.</p>
                        </div>
                        <div class=\"footer\">&copy; 2025 Tu Banco. Todos los derechos reservados.</div>
                    </div>
                </body>
                </html>
                """, accountNumberFrom, amount);

    }

    public static MoneyTransferNotificationReceived send(String id, String accountNumberFrom, Double amount, String from) {
        MoneyTransferNotificationReceived newsletter = new MoneyTransferNotificationReceived(new EmailId(id), accountNumberFrom, amount, from);

        //newsletter.record(new ReceivedTransactionNotificationEmailSent(id, student.id()));

        return newsletter;
    }

}
