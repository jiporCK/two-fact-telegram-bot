import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class TelegramService {



    public void sendCodeToTelegram(String code) {
        try {
            String text = URLEncoder.encode("Your confirm code is: " + code, StandardCharsets.UTF_8);
            String url = String.format(
                    "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s",
                    Environment.botToken,
                    Environment.chatId,
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
