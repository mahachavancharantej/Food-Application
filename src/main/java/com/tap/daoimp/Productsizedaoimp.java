package com.tap.daoimp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.Productsizedao;
import com.tap.dao.Productsizedao;
import com.tap.module.Productsize;
import com.tap.utitity.DBconnection;

public class Productsizedaoimp implements Productsizedao {

    private Connection connection;

    public Productsizedaoimp() {
        connection = DBconnection.getconnection();
    }

    @Override
    public void addProductSize(Productsize productsize) {

        String sql = "INSERT INTO product_sizes(product_id,size_name,price) VALUES(?,?,?)";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, productsize.getProductId());
            pstmt.setString(2, productsize.getSizeName());
            pstmt.setDouble(3, productsize.getPrice());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Productsize getProductSize(int sizeId) {

        Productsize ps = null;

        String sql = "SELECT * FROM product_sizes WHERE size_id=?";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, sizeId);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {

                ps = new Productsize();

                ps.setSizeId(rs.getInt("size_id"));
                ps.setProductId(rs.getInt("product_id"));
                ps.setSizeName(rs.getString("size_name"));
                ps.setPrice(rs.getDouble("price"));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    @Override
    public void updateProductSize(Productsize productSize) {

        String sql="UPDATE product_sizes SET product_id=?,size_name=?,price=? WHERE size_id=?";

        try {

            PreparedStatement pstmt=connection.prepareStatement(sql);

            pstmt.setInt(1, productSize.getProductId());
            pstmt.setString(2, productSize.getSizeName());
            pstmt.setDouble(3, productSize.getPrice());
            pstmt.setInt(4, productSize.getSizeId());

            pstmt.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProductSize(int sizeId) {

        String sql="DELETE FROM product_sizes WHERE size_id=?";

        try {

            PreparedStatement pstmt=connection.prepareStatement(sql);

            pstmt.setInt(1,sizeId);

            pstmt.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Productsize> getAllProductSizes() {

        List<Productsize> list = new ArrayList<>();

        String sql="SELECT * FROM product_sizes";

        try {

            PreparedStatement pstmt=connection.prepareStatement(sql);

            ResultSet rs=pstmt.executeQuery();

            while(rs.next()) {

                Productsize ps=new Productsize();

                ps.setSizeId(rs.getInt("size_id"));
                ps.setProductId(rs.getInt("product_id"));
                ps.setSizeName(rs.getString("size_name"));
                ps.setPrice(rs.getDouble("price"));

                list.add(ps);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Productsize> getSizesByProduct(int productId) {

        List<Productsize> list = new ArrayList<>();

        String sql="SELECT * FROM product_sizes WHERE product_id=?";

        try {

            PreparedStatement pstmt=connection.prepareStatement(sql);

            pstmt.setInt(1,productId);

            ResultSet rs=pstmt.executeQuery();

            while(rs.next()) {

                Productsize ps=new Productsize();

                ps.setSizeId(rs.getInt("size_id"));
                ps.setProductId(rs.getInt("product_id"));
                ps.setSizeName(rs.getString("size_name"));
                ps.setPrice(rs.getDouble("price"));

                list.add(ps);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}