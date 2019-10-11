package edu.auburn;

import java.sql.*;

public class SQLiteDataAdapter implements IDataAccess {
    Connection conn = null;
    int errorCode = 0;

    public boolean connect(String path) {
        try {
            // db parameters
            String url = "jdbc:sqlite:" + path;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            errorCode = CONNECTION_OPEN_FAILED;
            return false;
        }

    }

    @Override
    public boolean disconnect() {
        return true;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        switch (errorCode) {
            case CONNECTION_OPEN_FAILED: return "Connection is not opened!";
            case PRODUCT_LOAD_FAILED: return "Cannot load the product!";
        };
        return "OK";
    }

    public ProductModel loadProduct(int productID) {
        try {
            ProductModel product = new ProductModel();

            String sql = "SELECT ProductId, Name, Price, Quantity FROM Products WHERE ProductId = " + productID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            product.mProductID = rs.getInt("ProductId");
            product.mName = rs.getString("Name");
            product.mPrice = rs.getDouble("Price");
            product.mQuantity = rs.getDouble("Quantity");
            return product;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            errorCode = PRODUCT_LOAD_FAILED;
            return null;
        }
    }

    @Override
    public CustomerModel loadCustomer(int customerID) {
        try {
            CustomerModel customer = new CustomerModel();

            String sql = "SELECT CustomerId, Name, Address, Phone FROM Customer WHERE CustomerID = " + customerID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            customer.mCustomerID = rs.getInt("CustomerId");
            customer.mName = rs.getString("Name");
            customer.mAddress = rs.getString("Address");
            customer.mPhone = rs.getString("Phone");
            return customer;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            errorCode = PRODUCT_LOAD_FAILED;
            return null;
        }
    }

    @Override
    public PurchaseModel loadPurchase(int id) {
        return null;

    }

    @Override
    public boolean saveProduct(ProductModel product) {
        
    
         try {
             String sql = "INSERT INTO Products(Name,Vendor, Price,Quantity) VALUES(?,?,?,?)";
             PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, product.mName);
                    pstmt.setString(2, "AllVendors");                  
                    pstmt.setDouble(3,product.mPrice);  
                    pstmt.setInt(4, (int) product.mQuantity);
                    pstmt.executeUpdate();
                    return true;
                } catch (SQLException e) {
                    System.out.println("exception");
                    System.out.println(e.getMessage());
                }
         
         return false;
     }

    @Override
    public boolean saveCustomer(CustomerModel customer) {
     try {
         String sql = "INSERT INTO Customer(Name,Phone,Address) VALUES(?,?,?)";
         PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, customer.mName);
                pstmt.setString(2, customer.mAddress);  
                pstmt.setString(3,  customer.mPhone);
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println("exception");
                System.out.println(e.getMessage());
            }
       
       return false;
   }


    @Override
    public boolean savePurchase(PurchaseModel purchase) {
     try {
         String sql = "INSERT INTO Purchase(CustomerID,ProductID,Cost,Tax,TotalCost,Price,Quantity,Date) VALUES(?,?,?,?,?,?,?,?)";
        
         PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt("\"" +purchase.mCustomerID  + "\""));
                pstmt.setInt(2, Integer.parseInt("\"" + purchase.mProductID + "\""));
                pstmt.setDouble(3, Double.parseDouble("\"" + purchase.mCost+ "\""));

                pstmt.setDouble(4, Double.parseDouble("\"" +purchase.mTax  + "\""));
                pstmt.setDouble(5, Double.parseDouble("\"" + purchase.mTotalCost + "\""));
                pstmt.setDouble(6, Double.parseDouble("\"" + purchase.mPrice+ "\""));
                 
                pstmt.setInt(7, Integer.parseInt("\"" + purchase.mQuantity+ "\""));
                pstmt.setString(8,  "\"" + purchase.mDate+ "\"");

                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println("exception");
                System.out.println(e.getMessage());
            }
       
       return false;

    }

}
