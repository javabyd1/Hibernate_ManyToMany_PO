import model.Orders;
import model.Product;
import org.hibernate.Session;
import utility.HibernateUtility;

import java.time.LocalDate;

/**
 * Created by HP on 2017-11-18.
 */
public class Main {

    public static void main(String[] args) {


        Orders orders1 = new Orders();
        orders1.setOrdersDate(LocalDate.parse("2017-02-02"));

        Orders orders2 = new Orders();
        orders2.setOrdersDate(LocalDate.parse("2015-12-12"));

        Product product1 = new Product();
        product1.setProductName("Books");
        product1.setDescription("Intresting book");

        Product product2 = new Product();
        product2.setProductName("Car");
        product2.setDescription("Red car");

        Product product3 = new Product();
        product3.setProductName("Car");
        product3.setDescription("Fast car");


        orders1.getProductList().add(product1);
        orders2.getProductList().add(product2);

        Session session = HibernateUtility.getHibernateSession();
        session.beginTransaction();

        session.save(orders1);
        session.save(orders2);

        session.getTransaction().commit();
        session.close();
        HibernateUtility.closeSession();

    }


}
