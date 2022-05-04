package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class SlackUtils {
  /*
    Tutorial sending message to slack.
    https://www.woolha.com/tutorials/java-sending-message-to-slack-webhook
    https://slack.com/
    */

    private static final String SLACK_WEB_HOOK_URL = "https://hooks.slack.com/services/";
    private static final String WORKSPACE_ACCESS_REQUEST = "TXXXXXXXX/BXXXXXXXX/XxxxXxxxXxxxXxxxXxxxXxxx";

    public static void sendMessage(SlackMessage message) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SLACK_WEB_HOOK_URL + WORKSPACE_ACCESS_REQUEST);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(message);

            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            client.execute(httpPost);
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageToSlack(String channel, String userName, String messageText, String iconEmoji) {
        SlackMessage slackMessage = SlackMessage.builder()
                .channel(channel)
                .username(userName)
                .text(messageText)
                .icon_emoji(iconEmoji)
                .build();
        SlackUtils.sendMessage(slackMessage);
    }
}
