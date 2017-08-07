create (hf:School {name : 'Uniwersytet w Bialymstoku'})

create (hf)-[:DEPARTMENT]->(MATINF:Department {name : 'Matematyka i Informatyka', name2 :'cos tam'})
create (hf)-[:DEPARTMENT]->(BIOL:Department {name : 'Biologia', name2 :'cos tam2'})

create (MATINF)-[:CLASSES]->(rok3MAT:Class {name : 'Trzeci rok MatInf', types :'Infa'})
create (BIOL)-[:CLASSES]->(rok3BIOL:Class {name : 'Trzeci rok Biol', types :'Biologia'})


create (hf)-[:STAFF]->(DT:Teacher {academic_title :'Dr', name : 'Dominik', lastName :'Tomaszuk', pesel :'85'})
create (hf)-[:STAFF]->(MR:Teacher {academic_title :'Dr', name : 'Mariusz', lastName :'Rybnik', pesel :'85'})

create (hf)-[:STAFF]->(AN:Teacher {academic_title :'Mgr', name : 'Anna', lastName :'Mynyk', pesel :'75'})
create (hf)-[:STAFF]->(MB:Teacher {academic_title :'Mgr', name : 'Marta', lastName :'Glabas', pesel :'75'})

create (hf)-[:STUDENT]->(_001:Student { firstName :'Michal', lastName :'Korwel', pesel :'95'})
create (hf)-[:STUDENT]->(_002:Student { firstName :'Adrian', lastName :'Rusin', pesel :'95'})

create (hf)-[:STUDENT]->(_003:Student { firstName :'Justyna', lastName :'Kapelewska', pesel :'95'})
create (hf)-[:STUDENT]->(_004:Student { firstName :'Kasia', lastName :'Kap', pesel :'98'})

create (rok3MAT)-[:STUDENT]->(_001)
create (rok3MAT)-[:STUDENT]->(_002)

create (rok3BIOL)-[:STUDENT]->(_003)
create (rok3BIOL)-[:STUDENT]->(_004)


create (progIN:Subject {name : 'Programowanie w Internecie', code :'123'})
create (progOB:Subject {name : 'Programowanie Obiektowe', code :'456'})

create (ana:Subject {name : 'Anatomia', code :'123456'})
create (foto:Subject {name : 'Fotosynteza', code :'456123'})

create (progOB)-[:SUBJECT]->(rok3MAT)
create (progIN)-[:SUBJECT]->(rok3MAT)

create (ana)-[:SUBJECT]->(rok3BIOL)
create (foto)-[:SUBJECT]->(rok3BIOL)

create (DT)-[:TEACHER]->(progIN)
create (MR)-[:TEACHER]->(progOB)

create (AN)-[:TEACHER]->(ana)
create (MB)-[:TEACHER]->(foto)

create (MATINF)-[:STAFF]->(DT)
create (MATINF)-[:STAFF]->(MR)

create (BIOL)-[:STAFF]->(AN)
create (BIOL)-[:STAFF]->(MB)