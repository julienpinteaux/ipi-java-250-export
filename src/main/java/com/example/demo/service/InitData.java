package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;
import com.example.demo.entity.LigneFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@Transactional
public class InitData {

    @Autowired
    private EntityManager em;

    public void insertTestData() {

        Client client  = new Client();
        client.setNom("PETRILLO");
        client.setPrenom("Alexandre");
        em.persist(client);

        Client client2  = new Client();
        client2.setNom("PINTEAUX");
        client2.setPrenom("Julien");
        em.persist(client2);

        Client client3  = new Client();
        client3.setNom("BEN");
        client3.setPrenom("Dylan");
        em.persist(client3);            

        Article article = new Article();
        article.setLibelle("Carte mère ASROCK 2345");
        article.setPrix(79.90);
        em.persist(article);
        
        Article article2 = new Article();
        article2.setLibelle("Carte graphique MSI 1080Ti");
        article2.setPrix(879.90);
        em.persist(article2);
        
        Article article3 = new Article();
        article3.setLibelle("Disque dur");
        article3.setPrix(59.90);
        em.persist(article3);

        Facture facture = new Facture();
        facture.setClient(client);
        em.persist(facture);
        
        Facture facture2 = new Facture();
        facture2.setClient(client);
        em.persist(facture2);

        LigneFacture ligneFacture1 = new LigneFacture();
        ligneFacture1.setFacture(facture);
        ligneFacture1.setArticle(article);
        ligneFacture1.setQuantite(2);
        
        LigneFacture ligneFacture2 = new LigneFacture();
        ligneFacture2.setFacture(facture);
        ligneFacture2.setArticle(article2);
        ligneFacture2.setQuantite(1);
        
        LigneFacture ligneFacture3 = new LigneFacture();
        ligneFacture3.setFacture(facture2);
        ligneFacture3.setArticle(article3);
        ligneFacture3.setQuantite(3);
        
        em.persist(ligneFacture1);
        em.persist(ligneFacture2);
        em.persist(ligneFacture3);

    }
}
