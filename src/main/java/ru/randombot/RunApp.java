package ru.randombot;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.randombot.bots.TelegramRun;

public class RunApp {
    public static void main(String[] args) throws TelegramApiException {
        TelegramRun.getInstance().start();
    }
}
