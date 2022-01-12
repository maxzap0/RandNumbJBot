package ru.randombot;

import ru.randombot.bots.TelegramRun;

public class RunApp {
    public static void main(String[] args)  {
        TelegramRun.getInstance().start();
    }
}
