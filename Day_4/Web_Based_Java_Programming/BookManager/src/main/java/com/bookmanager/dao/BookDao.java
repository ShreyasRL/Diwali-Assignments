package com.bookmanager.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookdb";
    private String jdbcUsername = "root"; 
    private String jdbcPassword = "123456"; 

    private static final String INSERT_BOOK_SQL = "INSERT INTO books (title, author, price) VALUES (?, ?, ?);";
    private static final String SELECT_BOOK_BY_ID = "SELECT id, title, author, price FROM books WHERE id = ?;";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books;";
    private static final String DELETE_BOOK_SQL = "DELETE FROM books WHERE id = ?;";
    private static final String UPDATE_BOOK_SQL = "UPDATE books SET title = ?, author = ?, price = ? WHERE id = ?;";

    public BookDao() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Create
    public void insertBook(Book book) throws SQLException {
        try (Connection connection = getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.executeUpdate();
        }
    }

    // Read all
    public List<Book> selectAllBooks() {
        List<Book> books = new ArrayList()<>();
        try (Connection connection = getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                books.add(new Book(id, title, author, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Read by id
    public Book selectBook(int id) {
        Book book = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                book = new Book(id, title, author, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    // Update
    public boolean updateBook(Book book) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); 
             PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK_SQL)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDouble(3, book.getPrice());
            statement.setInt(4, book.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }


    public boolean deleteBook(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); 
             PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
