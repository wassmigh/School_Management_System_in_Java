CREATE TABLE `sys`.`enseignant_matiere`(
    enseignant_id INT,
    matiere_id INT,
    FOREIGN KEY (enseignant_id) REFERENCES enseignants(id),etudiant_matiere
    FOREIGN KEY (matiere_id) REFERENCES matieres(id),
    PRIMARY KEY (enseignant_id, matiere_id)
);