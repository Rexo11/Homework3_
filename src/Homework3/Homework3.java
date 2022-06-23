package Homework3;

import java.util.Random;
import java.io.*;

public class Homework3 {
    public static void main(String[] args) throws IOException {
        //Базовый уровень (для зачета нужно сделать хотя мобы 2 из 3)
        //Задача №1
        //Дано: у нас есть две модели машин - жигули и toyota. Каждая из этих машин умеет: начинать движение,
        //останавливаться, включать фары. У жигули есть особенность: она ломается. У Toyota особенность: включает музыку
        //Необходимо:
        // 1.Создать абстрактный класс, который будет описывать общие действия этих машин (методы будут не абстрактные)
        // 2.Создать два класса, которые будут наследоваться от абстрактного класса, и реализовывать особенности этих машин
        // Методы должны просто печатать на экран действия машин (начал движение, включил музыку и тд.)

        //Продвинутый уровень
        //Задача №1
        // Сделать задачу №1 из базовой.
        // 1. Создать класс CarFactory, у которого есть два статических методы: создать жигули, создать toyota.
        // 2. Создать 20 тойот, 20 жигулей с помощью CarFactory, положить их в один массив.
        // 3. Пройтись по массиву, проверить к какому классу принадлежит машина, привести тип к классу машины
        // и вызвать характерные для нее методы.
        Car[] cars = new Car[40];

        for(int i = 0; i < 20; i++) {
            cars[i] = CarFactory.CreateGiguli("Жигуль " + i);
            cars[i+20] = CarFactory.CreateToyota("Тойота " + i);
        }

        System.out.println("Задача 1\n");

        for(Car car: cars) {
            System.out.println(car.getNumberCar());
            car.Start();
            car.Stop();
            car.TurnOnHeadlights();

            if (car instanceof Toyota) {
                Toyota carT = (Toyota) car;
                carT.TurnOnMusic();
                System.out.println("\n");
            }

            if (car instanceof Giguli) {
                Giguli carG = (Giguli) car;
                carG.BreakCar();
                System.out.println("\n");
            }
        }

        //Задача №2
        // 1. Создать класс Financial record, с двумя атрибутами: incomes, outcomes (доходы, расходы)
        // 2. Создать в этом классе геттеры, сеттеры и конструктор на все атрибуты
        // 3. Создать 10 отчетов, с разными доходами и расходами (Смотри класс new Random(1).nextInt(10000) )
        // 4. Записать в файл "report.txt" все данные из отчетов.
        // 5. Прочитать файл report.txt, просуммировать все доходы и вывести на экран, тоже самое с расходами
        // Ожидаемый результат: общие доходы - (какое то число), общие расходы - (какое то число)
        System.out.println("Задача 2\n");

        task2();
    }

    public static void task2() throws IOException {
        Random rnd = new Random();
        int sumIncomes = 0;
        int sumOutcomes = 0;

        //String path = Homework3.class.getClassLoader().getResource("record.txt").toString();
        //System.out.println(path);

        new FileWriter("resource/report.txt", false).close();
        new FileWriter("resource/result.txt", false).close();

        for (int i = 0; i < 10; i++) {
            FinancialRecord record = new FinancialRecord(rnd.nextInt(10000), rnd.nextInt(10000));

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("resource/report.txt", true))) {
                writer.write(record.getIncomes() + ";" + record.getOutcomes() + ";" + "\n");
            }
            catch (IOException e)  {
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("resource/report.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line + "\n");
                sumIncomes += Integer.parseInt(line.substring(0, line.indexOf(";")));
                sumOutcomes += Integer.parseInt(line.substring(line.indexOf(";") + 1, line.lastIndexOf(";")));
            }
        } catch (IOException e)  {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resource/result.txt", true))) {
            writer.write("общие доходы - " + sumIncomes + ", общие расходы - " + sumOutcomes);

        }
        catch (IOException e)  {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("resource/result.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line + "\n");
            }
        } catch (IOException e)  {
            e.printStackTrace();
        }
    }
}
