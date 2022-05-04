import org.junit.jupiter.api.Test;
import utils.SlackUtils;

public class SendMessageToSlackTest {

    //region Slack data
    public static final String SLACK_USER = "User_who_send_message";
    public static final String SLACK_CHANNEL = "slack_channel_name";
    public static final String ICON_EMOJI = ":incoming_envelope:";
    //endregion

    /**
     * Some test with sending message to slack.
     */
    @Test
    void sendMessage() {
        doSomeCheck();
        SlackUtils.sendMessageToSlack(SLACK_CHANNEL, SLACK_USER, "All checks is Ok", ICON_EMOJI);
    }
    /**
     * Some checks
     */
    void doSomeCheck() {
        System.out.println("Do some check");
    }
}
