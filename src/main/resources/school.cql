create (hf:School {name : 'Uniwersytet w Bialymstoku'})

create (hf)-[:DEPARTMENT]->(MAT_INF:Department {name : 'Mathematics and Informatics', description :'matematyka i informatyka'})
create (hf)-[:DEPARTMENT]->(BIOL_CHEM:Department {name : 'Biology and Chemistry', description :'biologia i chemia'})
create (hf)-[:DEPARTMENT]->(EKO_ZRZ:Department {name : 'Economics and management', description :'ekonomia i zarzadzanie'})
create (hf)-[:DEPARTMENT]->(FILO:Department {name : 'Philology', description :'filologia'})
create (hf)-[:DEPARTMENT]->(FIZ:Department {name : 'Physics', description :'fizyka'})
create (hf)-[:DEPARTMENT]->(HIS_SOC:Department {name : 'History and Sociology', description :'historia i socjologia'})
create (hf)-[:DEPARTMENT]->(PG_PS:Department {name : 'Pedagogy and Psychology', description :'pedagogika i psychologia'})
create (hf)-[:DEPARTMENT]->(PRA:Department {name : 'Law',  description:'prawo'})
create (hf)-[:DEPARTMENT]->(EKO_INF_WIL:Department {name : 'Economics and informatics in Vinius', description :'ekonomia i informatyka w wilnie'})

create (MAT_INF)-[:CLASSES]->(year1MAT:Class {name : 'First year', types :'Mathematics'})
create (MAT_INF)-[:CLASSES]->(year2MAT:Class {name : 'Second year', types :'Mathematics'})
create (MAT_INF)-[:CLASSES]->(year3MAT:Class {name : 'Third year', types :'Mathematics'})

create (BIOL_CHEM)-[:CLASSES]->(year1BIOL:Class {name : 'First year', types :'Biology'})
create (BIOL_CHEM)-[:CLASSES]->(year2BIOL:Class {name : 'Second year', types :'Biology'})
create (BIOL_CHEM)-[:CLASSES]->(yearBIOL:Class {name : 'Third year', types :'Biology'})

create (EKO_ZRZ)-[:CLASSES]->(year1ZRZ:Class {name : 'First year', types :'Management'})
create (EKO_ZRZ)-[:CLASSES]->(year2ZRZ:Class {name : 'Second year', types :'Management'})
create (EKO_ZRZ)-[:CLASSES]->(year3ZRZ:Class {name : 'Third year', types :'Management'})

create (FILO)-[:CLASSES]->(year1FILO:Class {name : 'First year', types :'English philology'})
create (FILO)-[:CLASSES]->(year2FILO:Class {name : 'Second year', types :'English philology'})
create (FILO)-[:CLASSES]->(year3FILO:Class {name : 'Third year', types :'English philology'})

create (FIZ)-[:CLASSES]->(year1FIZ:Class {name : 'First year', types :'Physics'})
create (FIZ)-[:CLASSES]->(year2FIZ:Class {name : 'Second year', types :'Physics'})
create (FIZ)-[:CLASSES]->(year3FIZ:Class {name : 'Third year', types :'Physics'})

create (HIS_SOC)-[:CLASSES]->(year1HIS:Class {name : 'First year', types :'History'})
create (HIS_SOC)-[:CLASSES]->(year2HIS:Class {name : 'Second year', types :'History'})
create (HIS_SOC)-[:CLASSES]->(year3HIS:Class {name : 'Third year', types :'History'})

create (PG_PS)-[:CLASSES]->(year1PG:Class {name : 'First year', types :'Psychology'})
create (PG_PS)-[:CLASSES]->(year2PG:Class {name : 'Second year', types :'Psychology'})
create (PG_PS)-[:CLASSES]->(year3PG:Class {name : 'Third year', types :'Psychology'})

create (PRA)-[:CLASSES]->(year1PRA:Class {name : 'First year', types :'Law'})
create (PRA)-[:CLASSES]->(year2PRA:Class {name : 'Second year', types :'Law'})
create (PRA)-[:CLASSES]->(year3PRA:Class {name : 'Third year', types :'Law'})

create (EKO_INF_WIL)-[:CLASSES]->(year1MAT_VI:Class {name : 'First year', types :'Mathematics'})
create (EKO_INF_WIL)-[:CLASSES]->(year2MAT_VI:Class {name : 'Second year', types :'Mathematics'})
create (EKO_INF_WIL)-[:CLASSES]->(year3MAT_VI:Class {name : 'Third year', types :'Mathematics'})