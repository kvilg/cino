package ru.vsu.cs.java.cinema.console_ui;

import ru.vsu.cs.java.cinema.ControllersProvider;
import ru.vsu.cs.java.cinema.models.Record;

import java.util.Arrays;
import java.util.List;

public class RecordCommands extends CommandsGroup<ControllersProvider> {
    private static final IO io = IO.instance;

    private static AbstractCommand<ControllersProvider> addRecord = new AbstractCommand<ControllersProvider>() {
        @Override
        public String getName() {
            return "Добавить запись";
        }

        @Override
        public void action(ControllersProvider controller) {
            System.out.println("Введите имя: ");
            String name = io.readNextNonEmptyLine();
            System.out.println("Введите номер телефона: ");
            String number = io.readNextNonEmptyLine();

            Record m = new Record(name, number,null,null);
            controller.getMovieController().addNewRecord(m);
        }
    };

    private static AbstractCommand<ControllersProvider> addForUserRecord = new AbstractCommand<ControllersProvider>() {
        @Override
        public String getName() {
            return "Обновить запись";
        }

        @Override
        public void action(ControllersProvider controller) {
            System.out.println("Введите имя Обновляемой записи:");
            String name = io.readNextNonEmptyLine();
            List<Record> toUpdate = controller.getMovieController().findByName(name);
            System.out.println("1. " + toUpdate.get(0).number1);
            System.out.println("2. " + toUpdate.get(0).number2);
            System.out.println("3. " + toUpdate.get(0).number3);
            int i = 1;
            System.out.println("Выберите запись для Обновления или 0 для отмены:");
            for (Record m : toUpdate) {
                System.out.printf("%2d. %s\n", i, m.name);
                i++;
            }
            int updateChoice = io.readNextInt();
            if (updateChoice == 0) {
                System.out.println("Отмена операции обновления.");
            } else if (updateChoice > 0 && updateChoice < i) {
                Record updateRec = toUpdate.get(updateChoice-1);
                System.out.println("1. удалить номерт \n2. Добавить номер");
                int operation = io.readNextInt();
                if(operation == 1){
                    System.out.println("какой номер удалить ?");
                    System.out.println("1. " + updateRec.number1);
                    System.out.println("2. " + updateRec.number2);
                    System.out.println("3. " + updateRec.number3);
                    int delChoice = io.readNextInt();

                    if(delChoice == 1){
                        updateRec.setNumber1(updateRec.getNumber2());
                        updateRec.setNumber2(updateRec.getNumber3());
                        updateRec.setNumber3(null);
                        controller.getMovieController().updateRecord(updateRec);
                    }
                    if(delChoice == 2){
                        updateRec.setNumber2(updateRec.getNumber3());
                        updateRec.setNumber3(null);
                        controller.getMovieController().updateRecord(updateRec);
                    }
                    if(delChoice == 3){
                        updateRec.setNumber3(null);
                        controller.getMovieController().updateRecord(updateRec);
                    }
                }
                if(operation == 2){
                    if(updateRec.getNumber3() != null){
                        System.out.println("Нет места для нового номера");
                    }else {
                        System.out.println("Введите номер:");
                        System.out.println(updateRec.getNumber2() == null);
                        String number = io.readNextNonEmptyLine();
                        if(updateRec.getNumber1() == null){
                            updateRec.setNumber1(number);
                        }else if(updateRec.getNumber2() == null){
                            updateRec.setNumber2(number);
                        }else {
                            updateRec.setNumber3(number);
                        }
                        controller.getMovieController().updateRecord(updateRec);
                    }


                }


//                if (controller.getMovieController().removeMovieById(toUpdate.get(updateChoice - 1).id)) {
//                    System.out.println("Успешно удалено.");
//                } else {
//                    System.out.println("Не получилось удалить.");
//                }
            } else {
                System.out.println("Ошибка удаления. Неверный номер.");
            }
        }
    };

    private static AbstractCommand<ControllersProvider> deleteRecord = new AbstractCommand<ControllersProvider>() {
        @Override
        public String getName() {
            return "Удалить запись";
        }

        @Override
        public void action(ControllersProvider controller) {
            System.out.println("Введите имя удаляемой записи:");
            String name = io.readNextNonEmptyLine();
            List<Record> toDelete = controller.getMovieController().findByName(name);
            int i = 1;
            System.out.println("Выберите пользователя для удаления или 0 для отмены:");
            for (Record m : toDelete) {
                System.out.printf("%2d. %s\n", i, m.name);
                i++;
            }
            int deleteChoice = io.readNextInt();
            if (deleteChoice == 0) {
                System.out.println("Отмена операции удаления.");
            } else if (deleteChoice > 0 && deleteChoice < i) {
                Record remRec = toDelete.get(deleteChoice - 1);
                if (controller.getMovieController().remove(remRec)) {
                    System.out.println("Успешно удалено.");
                } else {
                    System.out.println("Не получилось удалить.");
                }
            } else {
                System.out.println("Ошибка удаления. Неверный номер.");
            }
        }
    };

    private static AbstractCommand<ControllersProvider> allRecord = new AbstractCommand<ControllersProvider>() {
        @Override
        public String getName() {
            return "Список всех записей";
        }

        @Override
        public void action(ControllersProvider controller) {
            List<Record> movies = controller.getMovieController().getAllRecord();
            int i = 1;
            for (Record m : movies) {
                System.out.printf("%2d. %s - %s - %s - %s\n", i, m.name,m.number1,m.number2,m.number3);
                i++;
            }
        }
    };

    public RecordCommands() {
        super(Arrays.asList(addRecord, deleteRecord, allRecord, addForUserRecord));
    }

    @Override
    public String getName() {
        return "Работа с номерами";
    }
}
