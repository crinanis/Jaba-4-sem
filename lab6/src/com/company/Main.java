package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Letters.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
public class Main {
    static {
        new DOMConfigurator().doConfigure("e:\\1POIT\\2\\Jaba\\labs\\lab6\\log\\log4j.xml",
                LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DAO dao = new DAO();
        List<Person> personList;
        List<Letter> letterList;
        Connection connection = dao.getConnection();

        //TODO: ЛЮДИ
        System.out.println("\n Все люди:");
        LOG.info("""

                 Все люди:
                """);
        IGenDAO<Person, Integer> personDAO = dao.getPersonDAO(connection);
        personList = personDAO.getAll();
        System.out.println(personList);
        LOG.info(personList + "\n");

        System.out.println("\n Информация о пользователях, а также количестве полученных и отправленных ими письмах:");
        LOG.info("\n Информация о пользователях, а также количестве полученных и отправленных ими письмах:");
        personList = ((DAO_Person) (personDAO)).infoAboutPerson_N_Letter();
        System.out.println(personList);
        LOG.info(personList + "\n");

        //TODO: ПИСЬМА

        System.out.println("\nСписок всех писем");
        LOG.info("\nСписок всех писем");
        IGenDAO<Letter, Integer> letterDAO = dao.getLetterDAO(connection);
        letterList = letterDAO.getAll();
        System.out.println(letterList);
        LOG.info(letterList + "\n");

        System.out.println("\n Пользователь, длина писем которого наименьшая:");
        LOG.info("\n Пользователь, длина писем которого наименьшая:");
        letterList = ((DAO_Letter)(letterDAO)).personWithSmallestLetter();
        System.out.println((letterList));
        LOG.info(letterList + "\n");

        System.out.println("\n Вывести информацию о пользователях, которые получили хотя бы одно сообщение с заданной темой:");
        LOG.info("\n Вывести информацию о пользователях, которые получили хотя бы одно сообщение с заданной темой:");
        letterList = ((DAO_Letter)(letterDAO)).receiversWithTopic();
        System.out.println(letterList);
        LOG.info(letterList + "\n");

        System.out.println("\n Вывести информацию о пользователях, которые не получали сообщения с заданной темой:");
        LOG.info("\n Вывести информацию о пользователях, которые не получали сообщения с заданной темой:");
        letterList = ((DAO_Letter)(letterDAO)).receiversWithoutTopic();
        System.out.println(letterList);
        LOG.info(letterList + "\n");

        System.out.println("\n Направить письмо заданного человека с заданной темой всем адресатам:");
        LOG.info("\n Направить письмо заданного человека с заданной темой всем адресатам:");
        var request = new DAO_Letter(connection);
        request.pointLetter("Budanava Ksenya Andreevna", "SPAM MESSAGE");
        System.out.println("\n Письмо с заданной темой было отправлено всем адресатам");
        LOG.info("Письмо с заданной темой было отправлено всем адресатам");
    }
}