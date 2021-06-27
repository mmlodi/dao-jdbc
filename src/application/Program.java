package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("\n=== Teste 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment =====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll =====");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: seller INSERT =====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department );
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new Id= " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller UPDATE =====");
        seller = sellerDao.findById(1);
        seller.setName("Marta Waineaewe");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 6: seller DELETE =====");
        System.out.print("DIGITE UM ID PARA SER DELETADO: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Id: "+id+", Deletado");


        sc.close();

    }
}
