package io.novelis.demo.dao.impl;

import io.novelis.demo.dao.CommentDao;
import io.novelis.demo.domain.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Set;

public class CommentDaoImpl implements CommentDao {

    private StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

    private SessionFactory factory = meta.getSessionFactoryBuilder().build();
    @Override
    public void save() {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Comment c =new Comment();
        c.setCommentContent("commentaire 1");


    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public Set<Comment> findAll() {
        return null;
    }

    @Override
    public Comment findById(Long id) {
        return null;
    }
}
