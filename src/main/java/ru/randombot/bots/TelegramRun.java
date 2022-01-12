package ru.randombot.bots;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/*telegram bot runner. Singleton.*/

public class TelegramRun extends Thread{
    private static TelegramRun telegramRun = null;
    //Run Telegram bot

    public static TelegramRun getInstance() {
        if (telegramRun == null) {
            telegramRun = new TelegramRun();
        }
        return telegramRun;
    }

    private TelegramRun() {
    }

    @Override
    public void run() {

        TelegramBotsApi botsApi;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new BotCore());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
