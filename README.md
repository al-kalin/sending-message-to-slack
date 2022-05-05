# Sending message to slack

Java - Sending Message to Slack Webhook (https://www.woolha.com/tutorials/java-sending-message-to-slack-webhook)

![image](https://user-images.githubusercontent.com/19717001/166907153-4ab3e90e-494a-4e0c-8886-9e723f4bae11.png)

If you're using Slack, it can be very useful if your application can send messages to the messaging platform.
The reason is it allows important events to be notified to your teams quickly. 
For example, if something error or doesn't work as expected, it would be better if the application can send 
what happens so that certain people can know it as soon as possible. This tutorial is about sending message
to Slack from Java application.

Setup Slack Webhook
1. Create a Slack app (if you don't have already)
Creating a Slack application is very simple. Open this link - https://api.slack.com/apps?new_app=1. 
You'll be asked to enter your application name and choose the development workspace. Just follow all the steps.

![image](https://user-images.githubusercontent.com/19717001/166907973-f0337c4d-23fb-4b72-b2b1-d5b39a930521.png)

2. Enable Incoming Webhook
Open your application page (https://api.slack.com/apps) and click on Incoming Webhooks in Feature section. 
You'll be redirected to a page where you can manage incoming webhooks. 
What you need to do is make incoming webhooks enabled by clicking on the toggle button.

![image](https://user-images.githubusercontent.com/19717001/166908419-1965864e-d7f4-43cc-9a86-88b4a4beaa60.png)

3. Add Webhook URL
After that, scroll to the bottom of the page and click on Add New Webhook to Workspace button. 
You should see a page for confirming your identity on your workspace. For each webhook URL, 
you can only choose one channel where messages can be post to via the URL.

![image](https://user-images.githubusercontent.com/19717001/166910384-2dbb0127-fa4c-451c-807e-b11e698a520c.png)

If successful, you should see a new URL added in your Webhook URL list. It should look something like this:

https://hooks.slack.com/services/TXXXXXXXX/BXXXXXXXX/XxxxXxxxXxxxXxxxXxxxXxxx

Dependencies
There are some dependencies you need to download to your project. If you're using maven, add it to pom.xml file.

Code
First, define a class "SlackMessage.java" that represents a message that will be sent as response body.
To make it simple, in this tutorial, I only use four arguments:

- username: the user that will appear as the message sender. It will be labeled as APP to distinguish between
  bot/system and real user.
- text: the message text.
- icon_emoji: emoji of the message.

For full list of all supported arguments, read the documentation of Slack's chat.postMessage API 
(https://api.slack.com/methods/chat.postMessage).

If your webhook is created using legacy integrations, you can choose the destination channel by adding channel argument.
You won't be able to do it if your webhook is created from a Slack app, as exemplified in this tutorial.

To make the code reusable, it's better to define a utility class with a method for sending message. 
To send a message to Slack webhook, we need to send a POST method to the webhook URL. 
The request body which is the message can be in x-www-form-urlencoded or application/json. We use the later in this tutorial.

SlackUtils.java

Lastly, use the sendMessage method to send a message by passing an instance of SlackMessage.

