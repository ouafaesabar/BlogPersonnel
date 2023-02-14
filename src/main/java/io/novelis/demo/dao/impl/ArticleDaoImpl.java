package io.novelis.demo.dao.impl;

import io.novelis.demo.dao.ArticleDao;
import io.novelis.demo.domain.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;
import java.util.Set;

public class ArticleDaoImpl implements ArticleDao {


    private StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

    private SessionFactory factory = meta.getSessionFactoryBuilder().build();
    @Override
    public void save() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Article a = new Article();
        a.setArticleTitle("Bonjouur");
        a.setArticleContent("Bonjouur tout le monde");
        session.persist(a);
        try {
            transaction.commit();
            System.out.print("article saved");
        }catch (Exception e)
        {
            transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    @Override
    public void update() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Article a = new Article();
        a.setArticleId(2L);
        a.setArticleTitle("title1");
        session.merge(a);

        try {
            transaction.commit();
            System.out.print("article updated");
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

    }

    @Override
    public void delete() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Article a = new Article();
        a.setArticleId(2L);
        session.remove(a);
        try {
            transaction.commit();
            System.out.print("article deleted");
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }


    }

    @Override
    public List<Article> findAll() {
        Session session = factory.openSession();
        List<Article> articles = session.createQuery("select a from Article a",Article.class).list();
        return articles;
    }

    @Override
    public Article findById(Long id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Article a = session.get(Article.class,id);
        session.close();
        return a;
    }
}
