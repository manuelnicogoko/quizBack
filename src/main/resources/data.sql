-- USUARIOS
INSERT INTO usuario (nombre, email, password, avatar, rol, puntuacion_total) VALUES
  ('admin', 'admin@email.com', 'adminpass', 'avatar1.jpg', 0, 0.0),
  ('usuario', 'usuario@email.com', 'usuariopass', 'avatar2.jpg', 1, 0.0);

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
  ('¿Quién es el protagonista de The Witcher 3?', 'geralt.jpg', 1, 1),
  ('¿Quién es la hechicera pelirroja amiga de Geralt?', 'triss.jpg', 2, 1),
  ('¿Quién es la bruja de los bosques de Velen?', 'keira.jpg', 3, 1);

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
INSERT INTO partida (nombre, max_jugadores, publica, vidas, tiempo_ronda, fecha_creacion, estado, codigo, quiz_id, usuario_id, numero_jugadores) VALUES
  -- Públicas
  ('RPG - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'RPG001', 1, 1, 2),
  ('RPG - Partida 2', 5, true, 2, 50, '2026-03-21', 0, 'RPG002', 2, 2, 3),
  ('Shooter - Partida 1', 3, true, 3, 45, '2026-03-21', 0, 'SHOOT1', 4, 1, 1),
  ('Shooter - Partida 2', 6, true, 4, 70, '2026-03-21', 0, 'SHOOT2', 5, 2, 6),
  ('Pintura - Partida 1', 4, true, 2, 60, '2026-03-21', 0, 'PAINT1', 7, 1, 2),
  ('Pintura - Partida 2', 5, true, 3, 55, '2026-03-21', 0, 'PAINT2', 8, 2, 3),
  ('Escultura - Partida 1', 3, true, 2, 40, '2026-03-21', 0, 'SCULP1', 10, 1, 1),
  ('Física - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'PHYS01', 13, 2, 2),
  ('Biología - Partida 1', 5, true, 2, 50, '2026-03-21', 0, 'BIO001', 16, 1, 3),
  ('Fútbol - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'FUTB01', 19, 2, 2),
  ('Baloncesto - Partida 1', 3, true, 2, 45, '2026-03-21', 0, 'BASK01', 22, 1, 1),
  ('Edad Media - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'MEDIEV', 25, 2, 2),
  ('Edad Moderna - Partida 1', 5, true, 2, 55, '2026-03-21', 0, 'MODERN', 28, 1, 3),
  ('Rock - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'ROCK01', 31, 2, 2),
  ('Pop - Partida 1', 3, true, 2, 45, '2026-03-21', 0, 'POP001', 34, 1, 1),

  -- Privadas
  ('RPG - Privada', 4, false, 3, 60, '2026-03-21', 0, 'RPGPRV', 3, 2, 2),
  ('Shooter - Privada', 5, false, 2, 50, '2026-03-21', 0, 'SHTPRV', 6, 1, 3),
  ('Pintura - Privada', 3, false, 2, 40, '2026-03-21', 0, 'PAIPRV', 9, 2, 1),
  ('Física - Privada', 4, false, 3, 60, '2026-03-21', 0, 'PHYPRV', 15, 1, 2),
  ('Pop - Privada', 5, false, 2, 55, '2026-03-21', 0, 'POPPRV', 36, 2, 3);

-- RONDAS (solo para la partida 1, tantas como preguntas en el quiz 1)
INSERT INTO ronda (numero_ronda, estado, partida_id, pregunta_id) VALUES
  (1, 1, 1, 1),
  (2, 2, 1, 2);
