USE cryptum;

DROP TABLE IF EXISTS parametro_app;

CREATE TABLE parametro_app (
    nombre VARCHAR(255) NOT NULL,
    tipo_dato VARCHAR(255) NOT NULL,
    valor VARCHAR(255) NOT NULL,
    PRIMARY KEY (nombre)
);

TRUNCATE TABLE parametro_app;

INSERT INTO parametro_app (nombre, tipo_dato, valor) VALUES ('maxPartidasJugando', 'Integer', '20');
INSERT INTO parametro_app (nombre, tipo_dato, valor) VALUES ('maxPartidasPendientes', 'Integer', '30');
INSERT INTO parametro_app (nombre, tipo_dato, valor) VALUES ('maxPreguntas', 'Integer', '20');
INSERT INTO parametro_app (nombre, tipo_dato, valor) VALUES ('minPreguntas', 'Integer', '3');
INSERT INTO parametro_app (nombre, tipo_dato, valor) VALUES ('maxQuizzesCreados', 'Integer', '80');
INSERT INTO parametro_app (nombre, tipo_dato, valor) VALUES ('maxUsuariosCreados', 'Integer', '200');
INSERT INTO parametro_app (nombre, tipo_dato, valor) VALUES ('maxCategoriasCreadas', 'Integer', '50');
INSERT INTO parametro_app (nombre, tipo_dato, valor) VALUES ('maxSubcategoriasCreadas', 'Integer', '100');
INSERT INTO parametro_app (nombre, tipo_dato, valor) VALUES ('maxPistasRespuestas', 'Integer', '5');