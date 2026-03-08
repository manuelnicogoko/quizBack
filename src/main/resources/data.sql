-- USUARIOS
INSERT INTO usuario (nombre, email, password, avatar, rol, puntuacion_total) VALUES
  ('admin', 'admin@email.com', 'adminpass', 'avatar1.png', 0, 0.0),
  ('usuario', 'usuario@email.com', 'usuariopass', 'avatar2.png', 1, 0.0);

-- CATEGORIAS
INSERT INTO categoria (nombre, logo, descripcion, estado) VALUES
  ('Videojuegos', 'videojuegos.png', 'Todo sobre videojuegos', 4),
  ('Arte', 'arte.png', 'Todo sobre arte', 4),
  ('Ciencia', 'ciencia.png', 'Ciencia y descubrimientos', 4),
  ('Deportes', 'deportes.png', 'Todo sobre deportes', 4),
  ('Historia', 'historia.png', 'Hechos históricos y personajes', 4),
  ('Música', 'musica.png', 'Música y artistas', 4);

-- SUBCATEGORIAS
INSERT INTO subcategoria (nombre, logo, descripcion, categoria_id, estado) VALUES
  ('RPG', 'rpg.png', 'Juegos de rol', 1, 4),
  ('Shooter', 'shooter.png', 'Juegos de disparos', 1, 4),
  ('Pintura', 'pintura.png', 'Pintores y estilos', 2, 4),
  ('Escultura', 'escultura.png', 'Escultores y obras', 2, 4),
  ('Física', 'fisica.png', 'Física y científicos', 3, 4),
  ('Biología', 'biologia.png', 'Biología y naturaleza', 3, 4),
  ('Fútbol', 'futbol.png', 'Todo sobre fútbol', 4, 4),
  ('Baloncesto', 'baloncesto.png', 'Todo sobre baloncesto', 4, 4),
  ('Edad Media', 'edadmedia.png', 'Historia medieval', 5, 4),
  ('Edad Moderna', 'edadmoderna.png', 'Historia moderna', 5, 4),
  ('Rock', 'rock.png', 'Música rock', 6, 4),
  ('Pop', 'pop.png', 'Música pop', 6, 4);

-- QUIZZES
INSERT INTO quiz (nombre, descripcion, creador_id, categoria_id, subcategoria_id) VALUES
  ('Personajes de The Witcher 3', 'Preguntas sobre RPGs', 1, 1, 1),
  ('Personajes de DOOM', 'Preguntas sobre shooters', 2, 1, 2);

-- PREGUNTAS para The Witcher 3 (quiz_id = 1)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es el protagonista de The Witcher 3?', 'geralt.png', 1, 1),
  ('¿Quién es la hechicera pelirroja amiga de Geralt?', 'triss.png', 2, 1),
  ('¿Quién es la bruja de los bosques de Velen?', 'keira.png', 3, 1);

-- PREGUNTAS para DOOM (quiz_id = 2)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Cómo se llama el protagonista de DOOM?', 'doomslayer.png', 1, 2),
  ('¿Qué demonio es el más grande en DOOM?', 'cyberdemon.png', 2, 2),
  ('¿Quién es el científico que libera a los demonios?', 'olivia.png', 3, 2);

-- PISTAS para preguntas de The Witcher 3
INSERT INTO pista (pregunta_id, texto) VALUES
  (1, 'Cazador de monstruos'),
  (1, 'Tiene cabello blanco'),
  (2, 'Hechicera pelirroja'),
  (2, 'Amiga de Geralt'),
  (3, 'Bruja de los bosques'),
  (3, 'Ayuda a Geralt en Velen');

-- PISTAS para preguntas de DOOM
INSERT INTO pista (pregunta_id, texto) VALUES
  (4, 'Lucha contra demonios'),
  (4, 'No habla'),
  (5, 'Demonio gigante'),
  (5, 'Tiene un cañón en el brazo'),
  (6, 'Científica de la UAC'),
  (6, 'Libera a los demonios');

-- RESPUESTAS para preguntas de The Witcher 3
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (1, 'Geralt'),
  (2, 'Triss Merigold'),
  (3, 'Keira Metz');

-- RESPUESTAS para preguntas de DOOM
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (4, 'Doom Slayer'),
  (5, 'Cyberdemon'),
  (6, 'Olivia Pierce');

-- PARTIDAS
INSERT INTO partida (nombre, max_jugadores, publica, vidas, tiempo_ronda, fecha_creacion, estado, codigo, quiz_id, usuario_id) VALUES
  ('Partida Pública 1', 4, true, 3, 60, '2026-02-18', 0, 'ABC123', 1, 1),
  ('Partida Pública 2', 3, true, 2, 45, '2026-02-18', 0, 'DEF456', 2, 2);

-- RONDAS (solo para la partida 1, tantas como preguntas en el quiz 1)
INSERT INTO ronda (numero_ronda, estado, partida_id, pregunta_id) VALUES
  (1, 1, 1, 1),
  (2, 2, 1, 2);
