import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class TelegramService {

    private static final String botToken = "8106845039:AAEGegzIJR1-h73xbGrutAQRykzU71AjDTg";

    private static final String chatId = "1154817160";

    public void sendCodeToTelegram(String code) {
        try {
            String text = URLEncoder.encode("Your confirm code is: " + code, StandardCharsets.UTF_8);
            String url = String.format(
                    "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s",
                    botToken,
                    chatId,
                    text
            );

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            client.send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println("Telegram response: " + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
