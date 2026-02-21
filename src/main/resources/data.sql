-- USUARIOS
INSERT INTO usuario (nombre, email, password, avatar, rol, puntuacion_total) VALUES
  ('admin', 'admin@email.com', 'adminpass', 'avatar1.png', 0, 0.0),
  ('usuario', 'usuario@email.com', 'usuariopass', 'avatar2.png', 1, 0.0);

-- CATEGORIAS
INSERT INTO categoria (nombre, logo, descripcion) VALUES
  ('Videojuegos', 'logo_videojuegos.png', 'Todo sobre videojuegos'),
  ('Arte', 'logo_arte.png', 'Todo sobre arte');

-- SUBCATEGORIAS
INSERT INTO subcategoria (nombre, logo, descripcion, valor, categoria_id) VALUES
  ('RPG', 'logo_rpg.png', 'Juegos de rol', 'rpg', 1),
  ('Survival', 'logo_survival.png', 'Juegos de supervivencia', 'survival', 1),
  ('Contemporaneo', 'logo_contemporaneo.png', 'Arte contemporáneo', 'contemporaneo', 2),
  ('Abstracto', 'logo_abstracto.png', 'Arte abstracto', 'abstracto', 2);

-- QUIZZES
INSERT INTO quiz (nombre, descripcion, creador_id, categoria_id, subcategoria_id) VALUES
  ('Personajes de The Witcher 3', 'Preguntas sobre RPGs', 1, 1, 1),
  ('Minecraft', 'Preguntas sobre Survival', 2, 1, 2);

-- PREGUNTAS (ejemplo para quiz 1 y 2)
INSERT INTO pregunta (enunciado, imagen, posicion, pistas, respuestas, quiz_id) VALUES
  ('¿Quién es el personaje de la imagen?', 'Geralt.png', 1, ARRAY['Protagonista de The Witcher', 'Cazador de monstruos'], ARRAY['Geralt', 'Geralt de Rivia'], 1),
  ('¿Quién es el personaje de la imagen?', 'Triss.png', 2, ARRAY['Hechicera pelirroja', 'Amiga de Geralt'], ARRAY['Triss', 'Triss Merigold'], 1),
  ('¿Qué criatura ves en la imagen?', 'creeper.png', 1, ARRAY['Explota al acercarse', 'Verde y silencioso'], ARRAY['Creeper'], 2),
  ('¿Qué criatura ves en la imagen?', 'pig.png', 2, ARRAY['Animal pasivo', 'Rosa y cuadrado'], ARRAY['Cerdo', 'Pig'], 2);

-- PARTIDAS
INSERT INTO partida (nombre, max_jugadores, publica, vidas, tiempo_ronda, fecha_creacion, estado, codigo, quiz_id, usuario_id) VALUES
  ('Partida Pública 1', 4, true, 3, 60, '2026-02-18', 0, 'ABC123', 1, 1),
  ('Partida Pública 2', 3, true, 2, 45, '2026-02-18', 0, 'DEF456', 2, 2);

-- RONDAS (solo para la partida 1, tantas como preguntas en el quiz 1)
INSERT INTO ronda (numero_ronda, estado, partida_id, pregunta_id) VALUES
  (1, 1, 1, 1),
  (2, 2, 1, 2);
