package school.service

import org.neo4j.ogm.session.Session
import school.Neo4jSessionFactory

class ImportService {

    static void reload() {
        Session session = Neo4jSessionFactory.getInstance().getNeo4jSession()
        session.purgeDatabase()
        session.query(load("school.cql"), new HashMap<>())
    }

    static String load(String cqlFile) {
        StringBuilder sb = new StringBuilder()
        BufferedReader reader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(cqlFile)))
        String line
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line)
                sb.append(" ")
            }
        } catch (Exception e) {
            throw new RuntimeException(e)
        }
        return sb.toString()
    }
}
