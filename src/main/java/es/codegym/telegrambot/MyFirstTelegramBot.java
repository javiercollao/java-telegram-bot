package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "MyBotDeMaraton_bot";
    public static final String TOKEN = "6785011361:AAEPPqPLILdHs0egPhB5Y-uobK_9NAe4yT8";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if(update.hasMessage() && update.getMessage().getText().equals("/start")){
            sendTextMessageAsync("Comencemos _cursiva_ *hola* ");
        }

        if(update.hasMessage() && update.getMessage().getText().contains("hola") || update.getMessage().getText().contains("Hola") ){
            sendTextMessageAsync("Hola compadre!");
        }

        if(update.hasMessage() && update.getMessage().getText().contains("chao") || update.getMessage().getText().contains("Chao") ){
            sendTextMessageAsync("nos vemos compadre!");
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}