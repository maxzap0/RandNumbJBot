package ru.randombot.bots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.util.Random;

public class BotCore extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            /*create Telegram send message*/
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));

            long maxRand;

            try {
                /*
                parse upper border for random number

                */
                maxRand = Integer.parseInt(update.getMessage().getText());
                long randNumb = new Random().nextLong(maxRand);
                sendMessage.setText(String.valueOf(randNumb));
            } catch (Exception e) {
                sendMessage.setText("Не корректное число!");
            }

            try {
                /*execute method for message*/
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "randnumbj_bot";
    }

    @Override
    public String getBotToken() {
        return "2119557029:AAFIlfz2ILOXIPebW9iw4df022W3Q_lXuZU";
    }
}
