package ru.randombot.bots.Services;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Random;

public class CreateMessageService {

    private final String startMessage = """
            Привет! Этот бот выдаёт случайное число.
            Введите верхнюю границу числа которую хотите получить.
            Приятного использования.""";

    public SendMessage startMessage(Update update) {
        return createTextMessage(update, startMessage);
    }

    public SendMessage createRandomLong(Update update) {
        long maxRand;
        long randNumb;
        String mess;
        try {
            maxRand = Integer.parseInt(update.getMessage().getText());
            randNumb = new Random().nextLong(maxRand);
            mess = String.valueOf(randNumb);
        } catch (Exception e) {
            mess="Некорректный ввод";
        }
        return createTextMessage(update, mess);
    }

    /*create Telegram send message*/
    private SendMessage createTextMessage(Update update, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText(text);
        return sendMessage;
    }

}
