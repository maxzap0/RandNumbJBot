package ru.randombot.bots;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.randombot.bots.services.CreateMessageService;

public class BotCore extends TelegramLongPollingBot {

    CreateMessageService createMessageService = new CreateMessageService();

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            switch (update.getMessage().getText().toLowerCase()) {
                case "/start" -> execute(createMessageService.startMessage(update));
                case "/time" -> execute(createMessageService.createTime(update));
                default -> execute(createMessageService.createRandomLong(update));
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
