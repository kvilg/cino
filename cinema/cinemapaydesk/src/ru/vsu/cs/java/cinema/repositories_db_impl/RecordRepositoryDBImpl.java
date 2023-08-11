package ru.vsu.cs.java.cinema.repositories_db_impl;

import ru.vsu.cs.java.cinema.models.Record;
import ru.vsu.cs.java.cinema.repositories.RecordRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordRepositoryDBImpl implements RecordRepository {

    private final ConnectorFactory factory;
    private static final String TABLE_NAME = "Records";
    private static final String ID_COLUMN_NAME = "id";
    private static final String NAME_COLUMN_NAME = "name";
    private static final String NUMBER1_COLUMN_NAME = "number1";
    private static final String NUMBER2_COLUMN_NAME = "number2";
    private static final String NUMBER3_COLUMN_NAME = "number3";

    public RecordRepositoryDBImpl(ConnectorFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Record entity) {
        final String query = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (null, ?, ?, ?, ?)",
                TABLE_NAME, ID_COLUMN_NAME, NAME_COLUMN_NAME, NUMBER1_COLUMN_NAME, NUMBER2_COLUMN_NAME, NUMBER3_COLUMN_NAME);
        try (Connection connection = factory.create()) {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.name);
            ps.setString(2, entity.number1);

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void update(Record entity) {
        final String query = String.format("UPDATE %s SET (%s, %s, %s, %s, %s) = (null, ?, ?, ?, ?)  WHERE %s = ?",
                TABLE_NAME, ID_COLUMN_NAME, NAME_COLUMN_NAME, NUMBER1_COLUMN_NAME, NUMBER2_COLUMN_NAME, NUMBER3_COLUMN_NAME,NAME_COLUMN_NAME);

        System.out.println("___________________");
        System.out.println(query);
        System.out.println("___________________");
        System.out.println(entity.name);
        System.out.println(entity.number1);
        System.out.println(entity.number2);
        System.out.println(entity.number3);
        System.out.println("___________________");
        try (Connection connection = factory.create()) {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.name);
            ps.setString(2, entity.number1);
            ps.setString(3, entity.number2);
            ps.setString(4, entity.number3);
            ps.setString(5, entity.name);
            ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(Record entity) {
        final String query = String.format("DELETE FROM %s WHERE %s = ?",
                TABLE_NAME, NAME_COLUMN_NAME);

        try (Connection connection = factory.create()) {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.name);
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Record get(long idX) {
        List<Record> answer = new ArrayList<>();
        final String query =
                String.format("SELECT %s, %s, %s, %s, %s FROM %s WHERE %s == ?",
                        ID_COLUMN_NAME, NAME_COLUMN_NAME, NUMBER1_COLUMN_NAME,
                        NUMBER2_COLUMN_NAME,NUMBER3_COLUMN_NAME, TABLE_NAME, ID_COLUMN_NAME);
        try (Connection connection = factory.create()) {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, idX);
            ResultSet r = ps.executeQuery();
            if (!r.isAfterLast()) {
                while (r.next()) {
                    long id = r.getLong(1);
                    String name = r.getString(2);
                    String number = r.getString(3);
                    answer.add(new Record(id, name, number,null, null));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (answer.size() != 1)
            return null;
        return answer.get(0);
    }


    @Override
    public List<Record> find(String n) {
        List<Record> answer = new ArrayList<>();
        final String query =
                String.format("SELECT %s, %s, %s, %s, %s FROM %s WHERE %s LIKE ?",
                        ID_COLUMN_NAME, NAME_COLUMN_NAME, NUMBER1_COLUMN_NAME,
                        NUMBER2_COLUMN_NAME, NUMBER3_COLUMN_NAME,
                        TABLE_NAME, NAME_COLUMN_NAME);
        try (Connection connection = factory.create()) {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + n + "%");
            ResultSet r = ps.executeQuery();
            if (!r.isAfterLast()) {
                while (r.next()) {
                    long id = r.getLong(1);
                    String name = r.getString(2);
                    String number1 = r.getString(3);
                    String number2 = r.getString(4);
                    String number3 = r.getString(5);
                    answer.add(new Record(id, name, number1,number2, number3));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return answer;
    }




    @Override
    public List<Record> getAllRecord() {
        List<Record> answer = new ArrayList<>();
        final String query = String.format("SELECT %s, %s, %s, %s, %s FROM %s",
                ID_COLUMN_NAME, NAME_COLUMN_NAME, NUMBER1_COLUMN_NAME,
                NUMBER2_COLUMN_NAME, NUMBER3_COLUMN_NAME, TABLE_NAME);
        try (Connection connection = factory.create()) {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet r = ps.executeQuery();
            if (!r.isAfterLast()) {
                while (r.next()) {
                    long id = r.getLong(1);
                    String name = r.getString(2);
                    String number1 = r.getString(3);
                    String number2 = r.getString(4);
                    String number3 = r.getString(5);



                    answer.add(new Record(id, name, number1,number2, number3));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return answer;
    }
}
