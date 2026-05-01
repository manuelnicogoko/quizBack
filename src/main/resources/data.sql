-- USUARIOS
INSERT INTO usuario (nombre, email, password, avatar, rol, puntuacion_total) VALUES
  ('admin', 'admin@email.com', '$2a$10$84rAjWRqMYCQVJnB1/UVluBPQzKwOTaInlI8eAQjUvdeW7n.01XAO', '', 0, 0.0),
  ('usuario', 'usuario@email.com', '$2a$10$84rAjWRqMYCQVJnB1/UVluBPQzKwOTaInlI8eAQjUvdeW7n.01XAO', '', 1, 0.0);

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
INSERT INTO quiz (nombre, descripcion, portada, creador_id, categoria_id, subcategoria_id, estado) VALUES
  -- RPG
  ('The Witcher 3', 'Preguntas sobre RPGs', 'witcher3.jpg', 1, 1, 1, 4),
  ('Final Fantasy VII', 'Quiz sobre personajes y lugares de FFVII', 'ffvii.jpg', 2, 1, 1, 4),
  ('Elder Scrolls: Skyrim', 'Quiz sobre Skyrim y sus dragones', 'skyrim.jpg', 1, 1, 1, 4),
  -- Shooter
  ('DOOM', 'Preguntas sobre shooters', 'doom.jpg', 2, 1, 2, 4),
  ('Call of Duty', 'Quiz sobre armas y mapas de CoD', 'cod.jpg', 1, 1, 2, 4),
  ('Overwatch', 'Quiz sobre héroes de Overwatch', 'overwatch.jpg', 2, 1, 2, 4),
  -- Pintura
  ('Grandes pintores', 'Quiz sobre pintores famosos', 'picasso.jpg', 1, 2, 3, 4),
  ('Obras maestras', 'Quiz sobre obras de pintura', 'monalisa.jpg', 2, 2, 3, 4),
  ('Estilos de pintura', 'Quiz sobre estilos artísticos', 'impresionismo.jpg', 1, 2, 3, 4),
  -- Escultura
  ('Escultores famosos', 'Quiz sobre escultores', 'michelangelo.jpg', 2, 2, 4, 4),
  ('Obras de escultura', 'Quiz sobre obras de escultura', 'david.jpg', 1, 2, 4, 4),
  ('Tipos de escultura', 'Quiz sobre tipos de escultura', 'abstracta.jpg', 2, 2, 4, 4),
  -- Física
  ('Físicos célebres', 'Quiz sobre físicos famosos', 'einstein.jpg', 1, 3, 5, 4),
  ('Teorías físicas', 'Quiz sobre teorías de la física', 'relatividad.jpg', 2, 3, 5, 4),
  ('Experimentos históricos', 'Quiz sobre experimentos físicos', 'cavendish.jpg', 1, 3, 5, 4),
  -- Biología
  ('Biólogos célebres', 'Quiz sobre biólogos famosos', 'darwin.jpg', 2, 3, 6, 4),
  ('Descubrimientos biológicos', 'Quiz sobre descubrimientos', 'adn.jpg', 1, 3, 6, 4),
  ('Ramas de la biología', 'Quiz sobre ramas de la biología', 'botanica.jpg', 2, 3, 6, 4),
  -- Fútbol
  ('Jugadores de fútbol', 'Quiz sobre futbolistas famosos', 'messi.jpg', 1, 4, 7, 4),
  ('Equipos históricos', 'Quiz sobre equipos de fútbol', 'equiposFutbol.jpg', 2, 4, 7, 4),
  ('Copas del mundo', 'Quiz sobre mundiales de fútbol', 'mundial.jpg', 1, 4, 7, 4),
  -- Baloncesto
  ('Jugadores de baloncesto', 'Quiz sobre baloncestistas', 'jordan.jpg', 2, 4, 8, 4),
  ('Equipos de baloncesto', 'Quiz sobre equipos de baloncesto', 'equiposBaloncesto.jpg', 1, 4, 8, 4),
  ('NBA', 'Quiz sobre la NBA', 'nba.jpg', 2, 4, 8, 4),
  -- Edad Media
  ('Edad Media', 'Quiz sobre historia medieval', 'edadmedia.jpg', 1, 5, 9, 4),
  ('Castillos medievales', 'Quiz sobre castillos', 'castillo.jpg', 2, 5, 9, 4),
  ('Personajes medievales', 'Quiz sobre personajes', 'juana_arca.jpg', 1, 5, 9, 4),
  -- Edad Moderna
  ('Edad Moderna', 'Quiz sobre historia moderna', 'edadmoderna.jpg', 2, 5, 10, 4),
  ('Revoluciones modernas', 'Quiz sobre revoluciones', 'revolucion_francesa.jpg', 1, 5, 10, 4),
  ('Personajes modernos', 'Quiz sobre personajes', 'napoleon.jpg', 2, 5, 10, 4),
  -- Rock
  ('Bandas de rock', 'Quiz sobre bandas de rock', 'queen.jpg', 1, 6, 11, 4),
  ('Álbumes de rock', 'Quiz sobre álbumes', 'abbeyroad.jpg', 2, 6, 11, 4),
  ('Historia del rock', 'Quiz sobre historia del rock', 'woodstock.jpg', 1, 6, 11, 4),
  -- Pop
  ('Artistas pop', 'Quiz sobre artistas pop', 'bruno.jpg', 2, 6, 12, 4),
  ('Canciones pop', 'Quiz sobre canciones pop', 'bad_guy.jpg', 1, 6, 12, 4),
  ('Historia del pop', 'Quiz sobre historia del pop', 'pop_history.jpg', 2, 6, 12, 4);

-- PREGUNTAS para The Witcher 3 (quiz_id = 1)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es el personaje?', 'geralt.jpg', 1, 1),
  ('¿Quién es el personaje?', 'triss.jpg', 2, 1),
  ('¿Quién es el personaje?', 'keira.jpg', 3, 1);

-- PREGUNTAS para DOOM (quiz_id = 2)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Cómo se llama el protagonista de DOOM?', 'doomslayer.jpg', 1, 2),
  ('¿Qué demonio es el más grande en DOOM?', 'cyberdemon.jpg', 2, 2),
  ('¿Quién es el científico que libera a los demonios?', 'olivia.jpg', 3, 2);

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

-- PARTIDAS DE PRUEBA (15 públicas, 5 privadas)
INSERT INTO partida (nombre, max_jugadores, publica, vidas, tiempo_ronda, fecha_creacion, estado, codigo, codigo_anfitrion, codigo_socket, numero_jugadores, nombre_anfitrion, quiz_id) VALUES
  -- Públicas
  ('RPG - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'RPG001', 'ANF1', 'SOCK1', 2, 'admin', 1),
  ('RPG - Partida 2', 5, true, 2, 50, '2026-03-21', 0, 'RPG002', 'ANF2', 'SOCK2', 3, 'usuario', 2),
  ('Shooter - Partida 1', 3, true, 3, 45, '2026-03-21', 0, 'SHOOT1', 'ANF3', 'SOCK3', 1, 'admin', 4),
  ('Shooter - Partida 2', 6, true, 4, 70, '2026-03-21', 0, 'SHOOT2', 'ANF4', 'SOCK4', 6, 'usuario', 5),
  ('Pintura - Partida 1', 4, true, 2, 60, '2026-03-21', 0, 'PAINT1', 'ANF5', 'SOCK5', 2, 'admin', 7),
  ('Pintura - Partida 2', 5, true, 3, 55, '2026-03-21', 0, 'PAINT2', 'ANF6', 'SOCK6', 3, 'usuario', 8),
  ('Escultura - Partida 1', 3, true, 2, 40, '2026-03-21', 0, 'SCULP1', 'ANF7', 'SOCK7', 1, 'admin', 10),
  ('Física - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'PHYS01', 'ANF8', 'SOCK8', 2, 'usuario', 13),
  ('Biología - Partida 1', 5, true, 2, 50, '2026-03-21', 0, 'BIO001', 'ANF9', 'SOCK9', 3, 'admin', 16),
  ('Fútbol - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'FUTB01', 'ANF10', 'SOCK10', 2, 'usuario', 19),
  ('Baloncesto - Partida 1', 3, true, 2, 45, '2026-03-21', 0, 'BASK01', 'ANF11', 'SOCK11', 1, 'admin', 22),
  ('Edad Media - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'MEDIEV', 'ANF12', 'SOCK12', 2, 'usuario', 25),
  ('Edad Moderna - Partida 1', 5, true, 2, 55, '2026-03-21', 0, 'MODERN', 'ANF13', 'SOCK13', 3, 'admin', 28),
  ('Rock - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'ROCK01', 'ANF14', 'SOCK14', 2, 'usuario', 31),
  ('Pop - Partida 1', 3, true, 2, 45, '2026-03-21', 0, 'POP001', 'ANF15', 'SOCK15', 1, 'admin', 34),

  -- Privadas
  ('RPG - Privada', 4, false, 3, 60, '2026-03-21', 0, 'RPGPRV', 'ANF16', 'SOCK16', 2, 'usuario', 3),
  ('Shooter - Privada', 5, false, 2, 50, '2026-03-21', 0, 'SHTPRV', 'ANF17', 'SOCK17', 3, 'admin', 6),
  ('Pintura - Privada', 3, false, 2, 40, '2026-03-21', 0, 'PAIPRV', 'ANF18', 'SOCK18', 1, 'usuario', 9),
  ('Física - Privada', 4, false, 3, 60, '2026-03-21', 0, 'PHYPRV', 'ANF19', 'SOCK19', 2, 'admin', 15),
  ('Pop - Privada', 5, false, 2, 55, '2026-03-21', 0, 'POPPRV', 'ANF20', 'SOCK20', 3, 'usuario', 36);

-- RONDAS (solo para la partida 1, tantas como preguntas en el quiz 1)
INSERT INTO ronda (numero_ronda, estado, partida_id, pregunta_id) VALUES
  (1, 1, 1, 1),
  (2, 2, 1, 2);

-- QUIZZES PENDIENTES DE ACEPTAR (creador_id = 2, estado = 3 -> PENDIENTE)
INSERT INTO quiz (nombre, descripcion, portada, creador_id, categoria_id, subcategoria_id, estado) VALUES
  ('Quiz de Marvel', 'Preguntas sobre el universo Marvel', 'marvel.jpg', 2, 1, 1, 3),
  ('Quiz de Animales', '¿Cuánto sabes sobre animales?', 'animales.jpg', 2, 3, 6, 3),
  ('Quiz de Historia de España', 'Historia y personajes de España', 'espana.jpg', 2, 5, 9, 3),
  ('Quiz de Videojuegos Indie', 'Juegos indie populares', 'indie.jpg', 2, 1, 2, 3),
  ('Quiz de Música Clásica', 'Compositores y obras clásicas', 'clasica.jpg', 2, 6, 12, 3);

-- QUIZZES RECHAZADOS (creador_id = 2, estado = 2 -> RECHAZADO)
INSERT INTO quiz (nombre, descripcion, portada, creador_id, categoria_id, subcategoria_id, estado) VALUES
  ('Quiz de Series Canceladas', 'Preguntas sobre series que fueron canceladas', 'series_canceladas.jpg', 2, 1, 2, 2),
  ('Quiz de Animales Extintos', '¿Cuánto sabes sobre animales extintos?', 'extintos.jpg', 2, 3, 6, 2),
  ('Quiz de Inventos Fallidos', 'Inventos que no triunfaron en la historia', 'fallidos.jpg', 2, 5, 10, 2);