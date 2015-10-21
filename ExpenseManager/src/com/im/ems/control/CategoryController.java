/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.im.ems.control;

import com.im.ems.model.Category;
import com.im.ems.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nadun Liyanage
 */
public class CategoryController {
    
    public static void save(Category category){
        //2. Create SQL
        String sql = "INSERT INTO category (id,name) VALUES (?,?)";
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, category.getId());
            ps.setString(2, category.getName());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Success!");
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    
    public static void update(Category category){
        String sql = "UPDATE category SET name=? WHERE id=?";
        
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success!");
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    public static void delete(Category category){
        String sql = "DELETE FROM category  WHERE id=?";
        
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, category.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success!");
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    public static List<Category> list(){
        List<Category> list  = new ArrayList<Category>();
        
        String sql = "SELECT * FROM category";
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //1. Get Data
                int id = rs.getInt("id");
                String name = rs.getString("name");
                //2. Create Object
                Category category = new Category();
                //3. Set Data
                category.setId(id);
                category.setName(name);
                //4. Add to List
                list.add(category);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    
    
    
}
