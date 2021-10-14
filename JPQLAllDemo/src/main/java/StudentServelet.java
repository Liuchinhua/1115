import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

@WebServlet("/JPQLAllServelet")
public class StudentServelet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQLAllDemo");
        EntityManager em = emf.createEntityManager();
        //insertQuery(response);
        //update(request,response);
        deleteQuery(response);
        //insert update delete之所以寫在getTransaction之前
        //是為了在印出之前更新完資料
        em.getTransaction().begin();
        Query query = em.createQuery("Select s from Student s ");
        @SuppressWarnings("unchecked") 
        //這是為了讓程式不要把下面list的警告告訴我 但這不嚴謹
        //下面這段包含if的程式是嚴謹的寫法
        List<Student> list = null;
        if(query.getResultList()  instanceof List ) {
            list = (List<Student>) query.getResultList();
         }
        System.out.print("sid");
        System.out.print("\t sname");
        System.out.println("\t age");
        for (Student s : list) {
            System.out.print(s.getSid());
            System.out.print("\t" + s.getSname());
            System.out.print("\t" + s.getAge());
            System.out.println();
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
        response.getWriter().append("See Tomcat Console Student Data<br/>");
	}
	
	void deleteQuery(HttpServletResponse response)throws ServletException, IOException {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQLAllDemo");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

//        Query query = em.createQuery("delete from Student where sid=1102");
//        int r=query.executeUpdate();
//        if(r>0)
//        	System.out.println("delete successfully");
//        else
//        	System.out.println("delete failed");

        Student sx=em.find(Student.class, 1001);          
        em.remove(sx);
        em.getTransaction().commit();

        em.close();
        emf.close();

        response.getWriter().append("See Tomcat Console Student Data");
    }
	
	private void update(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQLAllDemo");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        Query query = em.createQuery("update Student SET age=19 where sid=103");
//        int r=query.executeUpdate();
//        if(r>0)
//        	System.out.println("update successfully");
//        else
//        	System.out.println("update failed");

        Student sx=new Student(101,"Mary",18);
        em.merge(sx);
        em.getTransaction().commit();
        em.close();
        emf.close();
        response.getWriter().append("See Tomcat Console Student Data");
}
	
	void insertQuery(HttpServletResponse response)throws ServletException, IOException {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQLAllDemo");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student s1 = new Student();
        s1.setSid(1001);
        s1.setSname("Max");
        s1.setAge(27);

        Student s2 = new Student(1102,"Yen",21);
//        s2.setSid(1102);
//        s2.setSname("Yen");
//        s2.setAge(21);       
       
        em.persist(s1);
        em.persist(s2);       

        em.getTransaction().commit();
        em.close();
        emf.close();
        response.getWriter().append("See Tomcat Console Student Data");
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
