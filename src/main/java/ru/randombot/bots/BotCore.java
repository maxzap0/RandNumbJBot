package ru.randombot.bots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.randombot.bots.Services.CreateMessageService;

public class BotCore extends TelegramLongPollingBot {

    CreateMessageService createMessageService = new CreateMessageService();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            switch (update.getMessage().getText()) {
                case "/start":
                    try {
                        execute(createMessageService.startMessage(update));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    try {
                        execute(createMessageService.createRandomLong(update));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
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
