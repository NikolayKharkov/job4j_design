package ru.job4j.ood.ocp;

public class SenderMailer {
    private LoggerFile logger;

    public SenderMailer() {
        logger = new LoggerFile();
    }

    public void sendMessage(String message) {
        logger.log(message);
    }

    public class LoggerFile {
        public void log(String logText) {
        }
    }
    /*
    Имеем класс "SenderMailer", который отправляет письма.
    Свои действия он логирует в текстовом формате, с помощью класса "LoggerFile".
    Появилось требование, сохранять логи в БД. Создаем класс "LoggerDB"
    В данной ситуации, мы нарушим принцип OCP, т.к придется изменить класс "SenderMailer", потому что теперь он
    должен будет хранить новый класс "LoggerDB", вместо "LoggerFile".
    Выйти из данной ситуации можно следующим способом:
    создаем interface "Logger", с его помощью реализуем классы, которые будут производить нужные нам типы логирования.
    В классе SenderMailer, делаем переменную "private Logger log", а так же добавляем в констурктор переменную типа
    "Logger".При таких изменениях, мы можем создавать и менять классы логирования, не затрагивая класс "SenderMailer".
     */
}
