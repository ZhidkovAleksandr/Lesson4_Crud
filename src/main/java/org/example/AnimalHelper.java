package org.example;
import Entity.Animal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AnimalHelper {
   public EntityManagerFactory emf;
    public EntityManager em;

    public AnimalHelper(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();
        this.emf = emf;
        this.em = em;
    }

    public Animal getById(int id){

        Animal someAnimal = new Animal();
        em.getTransaction().begin();
        someAnimal = em.find(Animal.class, id);
        em.getTransaction().commit();
        //emf.close();
        return someAnimal;
    }

    public void add(Animal animal){
        em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();
        //emf.close();
        System.out.println("Successfully added: "+ animal);
    }

    public void remove(Animal animal){
        em.getTransaction().begin();
        em.remove(animal);
        em.getTransaction().commit();
        //emf.close();
        System.out.println("Successfully deleted: "+ animal.getId());
    }

}
