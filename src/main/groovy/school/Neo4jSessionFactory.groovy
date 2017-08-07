package school

import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.SessionFactory

class Neo4jSessionFactory {

    private static SessionFactory sessionFactory = new SessionFactory("school.domain")
    private static Neo4jSessionFactory factory = new Neo4jSessionFactory()

    static Neo4jSessionFactory getInstance() {
        return factory
    }

    private Neo4jSessionFactory() {
    }

    Session getNeo4jSession() {
        return sessionFactory.openSession()
    }
}
