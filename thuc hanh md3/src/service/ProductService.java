package service;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductService extends ConnectionJDBC implements IProductService {
    @Override
    public List<Product> showList() {
        List<Product> list = new ArrayList<>();

        try {
            Connection connection = getConnection();
            String sql = "select * from productList";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String category = rs.getString("category");
                list.add(new Product(id, name, price, quantity, color, category));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Product product) {
        try {
            Connection connection = getConnection();
            String sql = "select * from productList;\n" +
                    "insert into productList (name, price, quantity, color, category, description)\n" +
                    "VALUE (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Product findByid(int id) {
        Product product = null;
        try {
            Connection connection = getConnection();
            String sql = "select * from product where id=? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                product = new Product(id, name, price, quantity, color);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public void remove(int id) {
        try{
            Connection connection = getConnection();
            String sql = "delete from product where id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> list = new ArrayList<>();
        try{
            Connection connection = getConnection();

            String sql = "select * from productlist where name like ?";
            String nameFind = "%"+name+"%";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,nameFind);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
               int id = rs.getInt("id");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String category = rs.getString("category");
                list.add(new Product(id,name,price,quantity,color,category));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
