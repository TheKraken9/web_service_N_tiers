create table info_foncier(id int not null, partielle int not null, price double precision );

-- Insérer des données de test dans la table info_foncier
INSERT INTO info_foncier (id, partielle, price) VALUES
(1, '112', 150000.00),
(2, '142', 120000.00),
(1, '135', 200000.00),
(3, '156', 180000.00),
(4, '185', 250000.00);
