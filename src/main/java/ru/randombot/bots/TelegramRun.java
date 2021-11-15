package ru.randombot.bots;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/*telegram bot runner. Singelton.*/

public class TelegramRun extends Thread{
    private static TelegramRun telegramRun = null;
    //Run Telegram bot
        /*
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new BotCore());*/

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
