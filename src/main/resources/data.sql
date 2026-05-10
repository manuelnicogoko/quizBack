INSERT INTO parametro_app (nombre, tipo_dato, valor) VALUES
  ('maxPartidasJugando', 'int', '20'),
  ('maxPartidasPendientes', 'int', '30'),
  ('maxJugadorPartida', 'int', '20'),
  ('minJugadorPartida', 'int', '1'),
  ('maxPreguntas', 'int', '20'),
  ('minPreguntas', 'int', '3'),
  ('maxTiempoRonda', 'int', '60'),
  ('minTiempoRonda', 'int', '10'),
  ('maxQuizzesCreados', 'int', '80'),
  ('maxUsuariosCreados', 'int', '200'),
  ('maxCategoriasCreadas', 'int', '50'),
  ('maxSubcategoriasCreadas', 'int', '100'),
  ('maxVidas', 'int', '4'),
  ('minVidas', 'int', '1'),
  ('maxPistasRespuestas', 'int', '5');

-- USUARIOS
INSERT INTO usuario (nombre, email, password, avatar, rol, puntuacion_total) VALUES
  ('admin', 'admin@email.com', '$2a$10$84rAjWRqMYCQVJnB1/UVluBPQzKwOTaInlI8eAQjUvdeW7n.01XAO', '', 0, 200.0),
  ('usuario', 'usuario@email.com', '$2a$10$84rAjWRqMYCQVJnB1/UVluBPQzKwOTaInlI8eAQjUvdeW7n.01XAO', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778379461/profile1_avfx4d.png', 1, 300.0),
  ('usuario1', 'usuario1@email.com', '$2a$10$84rAjWRqMYCQVJnB1/UVluBPQzKwOTaInlI8eAQjUvdeW7n.01XAO', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778379467/profile2_bkfr4d.png', 1, 200.0),
  ('usuario2', 'usuario2@email.com', '$2a$10$84rAjWRqMYCQVJnB1/UVluBPQzKwOTaInlI8eAQjUvdeW7n.01XAO', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778379472/profile3_y4akw5.png', 1, 100.0),
  ('usuario3', 'usuario3@email.com', '$2a$10$84rAjWRqMYCQVJnB1/UVluBPQzKwOTaInlI8eAQjUvdeW7n.01XAO', '', 1, 50.0);

-- CATEGORIAS
INSERT INTO categoria (nombre, logo, descripcion, estado) VALUES
  -- ('Videojuegos', 'videojuegos.png', 'Todo sobre videojuegos', 4),
  ('Videojuegos', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117622/categoriaLogo/1/videojuegos.png', 'Todo sobre videojuegos', 4),
  ('Arte', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117623/categoriaLogo/2/arte.png', 'Todo sobre arte', 4),
  ('Ciencia', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117624/categoriaLogo/3/ciencia.png', 'Ciencia y descubrimientos', 4),
  ('Deportes', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117625/categoriaLogo/4/deportes.png', 'Todo sobre deportes', 4),
  ('Historia', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117626/categoriaLogo/5/historia.png', 'Hechos históricos y personajes', 4),
  ('Música', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117627/categoriaLogo/6/musica.png', 'Música y artistas', 4),
  ('Cine', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117627/categoriaLogo/6/musica.png', 'Todo sobre películas y cine', 4);

-- SUBCATEGORIAS
INSERT INTO subcategoria (nombre, logo, descripcion, categoria_id, estado) VALUES
  ('RPG', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117843/subcategoriaLogo/1/rpg.png', 'Juegos de rol', 1, 4),
  ('Shooter', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117849/subcategoriaLogo/2/shooter.png', 'Juegos de disparos', 1, 4),
  ('Pintura', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117850/subcategoriaLogo/3/pintura.png', 'Pintores y estilos', 2, 4),
  ('Escultura', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117850/subcategoriaLogo/4/escultura.png', 'Escultores y obras', 2, 4),
  ('Física', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117851/subcategoriaLogo/5/fisica.png', 'Física y científicos', 3, 4),
  ('Biología', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117852/subcategoriaLogo/6/biologia.png', 'Biología y naturaleza', 3, 4),
  ('Fútbol', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117853/subcategoriaLogo/7/futbol.png', 'Todo sobre fútbol', 4, 4),
  ('Baloncesto', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117854/subcategoriaLogo/8/baloncesto.png', 'Todo sobre baloncesto', 4, 4),
  ('Edad Media', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117854/subcategoriaLogo/9/edadmedia.png', 'Historia medieval', 5, 4),
  ('Edad Moderna', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117844/subcategoriaLogo/10/edadmoderna.png', 'Historia moderna', 5, 4),
  ('Rock', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117845/subcategoriaLogo/11/rock.png', 'Música rock', 6, 4),
  ('Pop', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117845/subcategoriaLogo/12/pop.png', 'Música pop', 6, 4),
  ('MOBA', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117846/subcategoriaLogo/13/moba.png', 'Juegos de arena de batalla multijugador', 1, 4),
  ('Ciencia Ficción', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117847/subcategoriaLogo/14/cienciaFiccion.png', 'Películas de ciencia ficción', 7, 4),
  ('Fantasía', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117848/subcategoriaLogo/15/fantasia.png', 'Películas de fantasía', 7, 4);

-- QUIZZES
INSERT INTO quiz (nombre, descripcion, portada, creador_id, categoria_id, subcategoria_id, estado) VALUES
  -- RPG
  ('The Witcher 3', 'Quiz sobre personajes', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117794/quizPortada/1/witcher3.jpg', 1, 1, 1, 4),
  ('Final Fantasy VII', 'Quiz sobre personajes', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117806/quizPortada/2/ffvii.jpg', 2, 1, 1, 4),
  ('Elder Scrolls: Skyrim', 'Quiz sobre personajes de Skyrim', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117819/quizPortada/3/skyrim.jpg', 1, 1, 1, 4),
  -- Shooter
  ('DOOM', 'Preguntas sobre personajes de DOOM', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117819/quizPortada/3/skyrim.jpg', 2, 1, 2, 4),
  ('Call of Duty', 'Quiz sobre armas de CoD', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117837/quizPortada/5/cod.jpg', 1, 1, 2, 4),
  ('Overwatch', 'Quiz sobre héroes de Overwatch', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117838/quizPortada/6/overwatch.jpg', 2, 1, 2, 4),
  -- Pintura
  ('Grandes pintores', 'Quiz sobre pintores famosos', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117839/quizPortada/7/picasso.jpg', 1, 2, 3, 4),
  ('Obras maestras', 'Quiz sobre obras de pintura', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117841/quizPortada/8/monalisa.jpg', 2, 2, 3, 4),
  ('Estilos de pintura', 'Quiz sobre estilos artísticos', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117842/quizPortada/9/impresionismo.jpg', 1, 2, 3, 4),
  -- Escultura
  ('Escultores famosos', 'Quiz sobre escultores', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117795/quizPortada/10/michelangelo.jpg', 2, 2, 4, 4),
  ('Obras de escultura', 'Quiz sobre obras de escultura', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117796/quizPortada/11/david.jpg', 1, 2, 4, 4),
  ('Tipos de escultura', 'Quiz sobre tipos de escultura', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117797/quizPortada/12/abstracta.jpg', 2, 2, 4, 4),
  -- Física
  ('Físicos célebres', 'Quiz sobre físicos famosos', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117798/quizPortada/13/einstein.jpg', 1, 3, 5, 4),
  ('Teorías físicas', 'Quiz sobre teorías de la física', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117799/quizPortada/14/relatividad.jpg', 2, 3, 5, 4),
  ('Experimentos históricos', 'Quiz sobre experimentos físicos', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117800/quizPortada/15/cavendish.jpg', 1, 3, 5, 4),
  -- Biología
  ('Biólogos célebres', 'Quiz sobre biólogos famosos', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117801/quizPortada/16/darwin.jpg', 2, 3, 6, 4),
  ('Descubrimientos biológicos', 'Quiz sobre descubrimientos', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117802/quizPortada/17/adn.jpg', 1, 3, 6, 4),
  ('Ramas de la biología', 'Quiz sobre ramas de la biología', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117804/quizPortada/18/botanica.jpg', 2, 3, 6, 4),
  -- Fútbol
  ('Jugadores de fútbol', 'Quiz sobre futbolistas famosos', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117805/quizPortada/19/messi.jpg', 1, 4, 7, 4),
  ('Equipos históricos', 'Quiz sobre equipos de fútbol', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117808/quizPortada/20/equiposFutbol.jpg', 2, 4, 7, 4),
  ('Copas del mundo', 'Quiz sobre mundiales de fútbol', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117809/quizPortada/21/mundial.jpg', 1, 4, 7, 4),
  -- Baloncesto
  ('Jugadores de baloncesto', 'Quiz sobre baloncestistas', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117810/quizPortada/22/jordan.jpg', 2, 4, 8, 4),
  ('Equipos de baloncesto', 'Quiz sobre equipos de baloncesto', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117811/quizPortada/23/equiposBaloncesto.jpg', 1, 4, 8, 4),
  ('NBA', 'Quiz sobre la NBA', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117812/quizPortada/24/nba.jpg', 2, 4, 8, 4),
  -- Edad Media
  ('Edad Media', 'Quiz sobre historia medieval', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117813/quizPortada/25/edadmedia.jpg', 1, 5, 9, 4),
  ('Castillos medievales', 'Quiz sobre castillos', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117814/quizPortada/26/castillo.jpg', 2, 5, 9, 4),
  ('Personajes medievales', 'Quiz sobre personajes', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117815/quizPortada/27/juana_arca.jpg', 1, 5, 9, 4),
  -- Edad Moderna
  ('Edad Moderna', 'Quiz sobre historia moderna', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117817/quizPortada/28/edadmoderna.jpg', 2, 5, 10, 4),
  ('Revoluciones modernas', 'Quiz sobre revoluciones', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117818/quizPortada/29/revolucion_francesa.jpg', 1, 5, 10, 4),
  ('Personajes modernos', 'Quiz sobre personajes', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117820/quizPortada/30/napoleon.jpg', 2, 5, 10, 4),
  -- Rock
  ('Bandas de rock', 'Quiz sobre bandas de rock', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117821/quizPortada/31/queen.jpg', 1, 6, 11, 4),
  ('Álbumes de rock', 'Quiz sobre álbumes', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117822/quizPortada/32/abbeyroad.jpg', 2, 6, 11, 4),
  ('Historia del rock', 'Quiz sobre historia del rock', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117823/quizPortada/33/woodstock.jpg', 1, 6, 11, 4),
  -- Pop
  ('Artistas pop', 'Quiz sobre artistas pop', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117825/quizPortada/34/bruno.jpg', 2, 6, 12, 4),
  ('Canciones pop', 'Quiz sobre canciones pop', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117826/quizPortada/35/bad_guy.jpg', 1, 6, 12, 4),
  ('Historia del pop', 'Quiz sobre historia del pop', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117828/quizPortada/36/pop_history.jpg', 2, 6, 12, 4),
  --Ciencia Ficción
  ('Star Wars Episodio IV', 'Preguntas sobre Una Nueva Esperanza', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117829/quizPortada/37/sw_iv.jpg', 1, 7, 14, 4),
  ('Star Wars Personajes', '¿Cuánto sabes de los personajes de Star Wars?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117830/quizPortada/38/sw_personajes.jpg', 2, 7, 14, 4),
  ('Star Wars Naves', 'Quiz sobre naves icónicas de Star Wars', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117831/quizPortada/39/sw_naves.jpg', 1, 7, 14, 4),
  -- Fantasía
  ('El Señor de los Anillos: La Comunidad', 'Preguntas sobre personajes de la película', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117833/quizPortada/40/lotr1.jpg', 1, 7, 15, 4),
  ('El Señor de los Anillos: Las Dos Torres', 'Preguntas sobre personajes de la película', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117834/quizPortada/41/lotr2.jpg', 2, 7, 15, 4),
  ('Personajes de El Señor de los Anillos', '¿Reconoces a los personajes de la saga?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117836/quizPortada/42/lotr_personajes.jpg', 1, 7, 15, 4),
  -- MOBA
  ('Adivina el campeón de LoL', '¿Puedes adivinar el campeón de League of Legends por su imagen y pistas?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117837/quizPortada/43/lol.jpg', 1, 1, 13, 4);

-- -- PARTIDAS DE PRUEBA (15 públicas, 5 privadas)
-- INSERT INTO partida (nombre, max_jugadores, publica, vidas, tiempo_ronda, fecha_creacion, estado, codigo, codigo_anfitrion, codigo_socket, numero_jugadores, nombre_anfitrion, quiz_id) VALUES
--   -- Públicas
--   ('RPG - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'RPG001', 'ANF1', 'SOCK1', 2, 'admin', 1),
--   ('RPG - Partida 2', 5, true, 2, 50, '2026-03-21', 0, 'RPG002', 'ANF2', 'SOCK2', 3, 'usuario', 2),
--   ('Shooter - Partida 1', 3, true, 3, 45, '2026-03-21', 0, 'SHOOT1', 'ANF3', 'SOCK3', 1, 'admin', 4),
--   ('Shooter - Partida 2', 6, true, 4, 70, '2026-03-21', 0, 'SHOOT2', 'ANF4', 'SOCK4', 6, 'usuario', 5),
--   ('Pintura - Partida 1', 4, true, 2, 60, '2026-03-21', 0, 'PAINT1', 'ANF5', 'SOCK5', 2, 'admin', 7),
--   ('Pintura - Partida 2', 5, true, 3, 55, '2026-03-21', 0, 'PAINT2', 'ANF6', 'SOCK6', 3, 'usuario', 8),
--   ('Escultura - Partida 1', 3, true, 2, 40, '2026-03-21', 0, 'SCULP1', 'ANF7', 'SOCK7', 1, 'admin', 10),
--   ('Física - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'PHYS01', 'ANF8', 'SOCK8', 2, 'usuario', 13),
--   ('Biología - Partida 1', 5, true, 2, 50, '2026-03-21', 0, 'BIO001', 'ANF9', 'SOCK9', 3, 'admin', 16),
--   -- ('Fútbol - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'FUTB01', 'ANF10', 'SOCK10', 2, 'usuario', 19),
--   -- ('Baloncesto - Partida 1', 3, true, 2, 45, '2026-03-21', 0, 'BASK01', 'ANF11', 'SOCK11', 1, 'admin', 22),
--   -- ('Edad Media - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'MEDIEV', 'ANF12', 'SOCK12', 2, 'usuario', 25),
--   -- ('Edad Moderna - Partida 1', 5, true, 2, 55, '2026-03-21', 0, 'MODERN', 'ANF13', 'SOCK13', 3, 'admin', 28),
--   -- ('Rock - Partida 1', 4, true, 3, 60, '2026-03-21', 0, 'ROCK01', 'ANF14', 'SOCK14', 2, 'usuario', 31),
--   -- ('Pop - Partida 1', 3, true, 2, 45, '2026-03-21', 0, 'POP001', 'ANF15', 'SOCK15', 1, 'admin', 34),

--   -- Privadas
--   ('RPG - Privada', 4, false, 3, 60, '2026-03-21', 0, 'RPGPRV', 'ANF16', 'SOCK16', 2, 'usuario', 3),
--   ('Shooter - Privada', 5, false, 2, 50, '2026-03-21', 0, 'SHTPRV', 'ANF17', 'SOCK17', 3, 'admin', 6),
--   ('Pintura - Privada', 3, false, 2, 40, '2026-03-21', 0, 'PAIPRV', 'ANF18', 'SOCK18', 1, 'usuario', 9),
--   ('Física - Privada', 4, false, 3, 60, '2026-03-21', 0, 'PHYPRV', 'ANF19', 'SOCK19', 2, 'admin', 15),
--   ('Pop - Privada', 5, false, 2, 55, '2026-03-21', 0, 'POPPRV', 'ANF20', 'SOCK20', 3, 'usuario', 36);


-- QUIZZES PREGUNTAS

-- The Witcher 3 (quiz_id = 1)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es el personaje?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117629/imagenPreg/1/1/geralt.jpg', 1, 1),         -- id 1
  ('¿Quién es el personaje?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117630/imagenPreg/1/2/triss.jpg', 2, 1),          -- id 2
  ('¿Quién es el personaje?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117632/imagenPreg/1/3/keira.jpg', 3, 1);          -- id 3

-- Final Fantasy VII (quiz_id = 2)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es el protagonista de FFVII?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117669/imagenPreg/2/4/cloud.jpg', 1, 2),      -- id 4
  ('¿Quién es la florista de Midgar?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117670/imagenPreg/2/5/aerith.jpg', 2, 2),        -- id 5
  ('¿Quién es el villano principal?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117671/imagenPreg/2/6/sephiroth.jpg', 3, 2);      -- id 6

-- Elder Scrolls: Skyrim (quiz_id = 3)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Cómo se llama el protagonista?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117708/imagenPreg/3/7/dovahkiin.jpg', 1, 3),      -- id 7
  ('¿Qué dragón es el antagonista principal?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117708/imagenPreg/3/7/dovahkiin.jpg', 2, 3),-- id 8
  ('¿Qué ciudad es la capital de Skyrim?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117711/imagenPreg/3/9/solitude.jpg', 3, 3);  -- id 9

-- DOOM (quiz_id = 4)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Cómo se llama el protagonista de DOOM?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117747/imagenPreg/4/10/doomslayer.jpg', 1, 4), -- id 10
  ('¿Qué demonio es el más grande en DOOM?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117749/imagenPreg/4/11/cyberdemon.jpg', 2, 4),  -- id 11
  ('¿Quién es el científico que libera a los demonios?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117750/imagenPreg/4/12/olivia.jpg', 3, 4); -- id 12

-- Call of Duty (quiz_id = 5)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Cuál es el modo multijugador más famoso?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117774/imagenPreg/5/13/cod_multiplayer.jpg', 1, 5), -- id 13
  ('¿Qué arma es icónica en la saga?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117775/imagenPreg/5/14/ak47.jpg', 2, 5),                    -- id 14
  ('¿En qué guerra se ambienta el primer juego?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117776/imagenPreg/5/15/ww2.jpg', 3, 5);           -- id 15

-- Overwatch (quiz_id = 6)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es la heroína que viaja en el tiempo?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117778/imagenPreg/6/16/tracer.jpg', 1, 6),       -- id 16
  ('¿Qué gorila científico es un tanque?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117779/imagenPreg/6/17/winston.jpg', 2, 6),              -- id 17
  ('¿Quién es el francotirador de hielo?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117781/imagenPreg/6/18/widowmaker.jpg', 3, 6);           -- id 18

-- Grandes pintores (quiz_id = 7)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién pintó "La noche estrellada"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117782/imagenPreg/7/19/vangogh.jpg', 1, 7),               -- id 19
  ('¿Quién pintó "Guernica"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117784/imagenPreg/7/20/picasso.jpg', 2, 7),                          -- id 20
  ('¿Quién pintó "La última cena"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117785/imagenPreg/7/21/davinci.jpg', 3, 7);                    -- id 21

-- Obras maestras (quiz_id = 8)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién pintó la Mona Lisa?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117785/imagenPreg/7/21/davinci.jpg', 1, 8),                       -- id 22
  ('¿Qué obra representa a Adán y Dios tocándose?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117788/imagenPreg/8/23/capilla_sistina.jpg', 2, 8), -- id 23
  ('¿Qué cuadro muestra relojes derretidos?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117789/imagenPreg/8/24/persistencia_memoria.jpg', 3, 8); -- id 24

-- Estilos de pintura (quiz_id = 9)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Qué estilo es "Impresión, sol naciente"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117789/imagenPreg/8/24/persistencia_memoria.jpg', 1, 9),   -- id 25
  ('¿Qué movimiento es "El grito"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117791/imagenPreg/9/26/expresionismo.jpg', 2, 9),              -- id 26
  ('¿Qué estilo es "Composición VII" de Kandinsky?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117793/imagenPreg/9/27/abstracto.jpg', 3, 9);  -- id 27

-- Escultores famosos (quiz_id = 10)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién esculpió el David?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117633/imagenPreg/10/28/david.jpg', 1, 10),                          -- id 28
  ('¿Quién esculpió "El pensador"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117634/imagenPreg/10/29/pensador.jpg', 2, 10),                  -- id 29
  ('¿Quién esculpió "La piedad"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117635/imagenPreg/10/30/piedad.jpg', 3, 10);                      -- id 30

-- Obras de escultura (quiz_id = 11)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Dónde está el Moái?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117637/imagenPreg/11/31/moai.jpg', 1, 11),                                -- id 31
  ('¿Qué escultura está en Nueva York?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117638/imagenPreg/11/32/libertad.jpg', 2, 11),              -- id 32
  ('¿Qué esfinge está en Egipto?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117639/imagenPreg/11/33/esfinge.jpg', 3, 11);                     -- id 33

-- Tipos de escultura (quiz_id = 12)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Qué es una escultura abstracta?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117640/imagenPreg/12/34/abstracta.jpg', 1, 12),               -- id 34
  ('¿Qué es una escultura cinética?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117641/imagenPreg/12/35/kinetica.jpg', 2, 12),                 -- id 35
  ('¿Qué es una escultura monumental?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117642/imagenPreg/12/36/monumental.jpg', 3, 12);             -- id 36

-- Físicos célebres (quiz_id = 13)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién desarrolló la teoría de la relatividad?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117643/imagenPreg/13/37/einstein.jpg', 1, 13),  -- id 37
  ('¿Quién es conocido como el padre de la física moderna?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117645/imagenPreg/13/38/newton.jpg', 2, 13), -- id 38
  ('¿Quién descubrió la radiactividad?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117646/imagenPreg/13/39/curie.jpg', 3, 13);                 -- id 39

-- Teorías físicas (quiz_id = 14)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Qué teoría explica la gravedad?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117647/imagenPreg/14/40/gravedad.jpg', 1, 14),                -- id 40
  ('¿Qué teoría describe el comportamiento de la luz?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117648/imagenPreg/14/41/cuantica.jpg', 2, 14), -- id 41
  ('¿Qué teoría unifica la electricidad y el magnetismo?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117649/imagenPreg/14/42/electromagnetismo.jpg', 3, 14); -- id 42

-- Experimentos históricos (quiz_id = 15)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién realizó el experimento de la doble rendija?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117650/imagenPreg/15/43/doble_rendija.jpg', 1, 15), -- id 43
  ('¿Qué experimento demostró la existencia de electrones?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117651/imagenPreg/15/44/tubo_crookes.jpg', 2, 15), -- id 44
  ('¿Quién midió la carga del electrón?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117652/imagenPreg/15/45/gota_aceite.jpg', 3, 15);           -- id 45

-- Biólogos célebres (quiz_id = 16)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién propuso la teoría de la evolución?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117653/imagenPreg/16/46/darwin.jpg', 1, 16),          -- id 46
  ('¿Quién descubrió la penicilina?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117654/imagenPreg/16/47/fleming.jpg', 2, 16),                   -- id 47
  ('¿Quién es conocido como el padre de la genética?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117655/imagenPreg/16/48/mendel.jpg', 3, 16);   -- id 48

-- Descubrimientos biológicos (quiz_id = 17)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién descubrió la estructura del ADN?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117657/imagenPreg/17/49/adn.jpg', 1, 17),               -- id 49
  ('¿Qué científico identificó los glóbulos rojos?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117657/imagenPreg/17/50/sangre.jpg', 2, 17),     -- id 50
  ('¿Quién desarrolló la teoría celular?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117659/imagenPreg/17/51/celula.jpg', 3, 17);               -- id 51

-- Ramas de la biología (quiz_id = 18)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Qué rama estudia las plantas?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117660/imagenPreg/18/52/botanica.jpg', 1, 18),                   -- id 52
  ('¿Qué rama estudia los animales?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117661/imagenPreg/18/53/zoologia.jpg', 2, 18),                  -- id 53
  ('¿Qué rama estudia los microorganismos?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117663/imagenPreg/18/54/microbiologia.jpg', 3, 18);      -- id 54

-- Jugadores de fútbol (quiz_id = 19)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es el máximo goleador de la historia?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117664/imagenPreg/19/55/messi.jpg', 1, 19),        -- id 55
  ('¿Quién ganó 5 Balones de Oro?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117665/imagenPreg/19/56/cristiano.jpg', 2, 19),                   -- id 56
  ('¿Quién es conocido como "O Rei"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117667/imagenPreg/19/57/pele.jpg', 3, 19);                     -- id 57

-- Equipos históricos (quiz_id = 20)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Qué equipo ha ganado más Champions?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117673/imagenPreg/20/58/realmadrid.jpg', 1, 20),           -- id 58
  ('¿Qué club es conocido como "Los Diablos Rojos"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117674/imagenPreg/20/59/manutd.jpg', 2, 20),    -- id 59
  ('¿Qué equipo es famoso por su tiki-taka?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117675/imagenPreg/20/60/barcelona.jpg', 3, 20);         -- id 60

-- Copas del mundo (quiz_id = 21)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Qué país ha ganado más Mundiales?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117676/imagenPreg/21/61/brasil.jpg', 1, 21),                 -- id 61
  ('¿En qué año se jugó el primer Mundial?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117676/imagenPreg/21/61/brasil.jpg', 2, 21),        -- id 62
  ('¿Quién marcó el "Gol del Siglo"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117678/imagenPreg/21/63/maradona.jpg', 3, 21);                 -- id 63

-- Jugadores de baloncesto (quiz_id = 22)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es considerado el mejor de la historia?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117678/imagenPreg/21/63/maradona.jpg', 1, 22),     -- id 64
  ('¿Quién tiene el récord de triples en la NBA?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117680/imagenPreg/22/65/curry.jpg', 2, 22),        -- id 65
  ('¿Quién es apodado "King James"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117681/imagenPreg/22/66/lebron.jpg', 3, 22);                    -- id 66

-- Equipos de baloncesto (quiz_id = 23)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Qué equipo tiene más anillos de la NBA?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117683/imagenPreg/23/67/lakers.jpg', 1, 23),           -- id 67
  ('¿Qué equipo es conocido como "Los Celtics"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117684/imagenPreg/23/68/celtics.jpg', 2, 23),       -- id 68
  ('¿Qué equipo juega en el Madison Square Garden?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117684/imagenPreg/23/68/celtics.jpg', 3, 23);     -- id 69

-- NBA (quiz_id = 24)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién fue el MVP de la NBA en 2021?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117686/imagenPreg/24/70/jokic.jpg', 1, 24),                -- id 70
  ('¿Qué jugador tiene más puntos en la historia?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117688/imagenPreg/24/71/kareem.jpg', 2, 24),      -- id 71
  ('¿Qué equipo ganó el anillo en 2020?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117689/imagenPreg/24/72/lakers2020.jpg', 3, 24);            -- id 72

-- Edad Media (quiz_id = 25)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿En qué año cayó Constantinopla?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117690/imagenPreg/25/73/constantinopla.jpg', 1, 25),           -- id 73
  ('¿Qué guerra duró 100 años?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117692/imagenPreg/25/74/guerra100.jpg', 2, 25),                      -- id 74
  ('¿Quién fue Juana de Arco?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117693/imagenPreg/25/75/juana_arca.jpg', 3, 25);                      -- id 75

-- Castillos medievales (quiz_id = 26)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Dónde está el castillo de Neuschwanstein?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117693/imagenPreg/25/75/juana_arca.jpg', 1, 26), -- id 76
  ('¿Qué castillo inspiró a Disney?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117695/imagenPreg/26/77/disney_castle.jpg', 2, 26),             -- id 77
  ('¿Qué castillo está en Edimburgo?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117696/imagenPreg/26/78/edimburgo.jpg', 3, 26);                -- id 78

-- Personajes medievales (quiz_id = 27)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién fue Ricardo Corazón de León?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117696/imagenPreg/26/78/edimburgo.jpg', 1, 27),               -- id 79
  ('¿Quién fue Gengis Kan?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117696/imagenPreg/26/78/edimburgo.jpg', 2, 27),                             -- id 80
  ('¿Quién fue Saladino?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117700/imagenPreg/27/81/saladino.jpg', 3, 27);                             -- id 81

-- Edad Moderna (quiz_id = 28)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿En qué año comenzó la Revolución Francesa?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117701/imagenPreg/28/82/revolucion_francesa.jpg', 1, 28), -- id 82
  ('¿Quién fue Napoleón Bonaparte?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117702/imagenPreg/28/83/napoleon.jpg', 2, 28),                   -- id 83
  ('¿Qué invento revolucionó la imprenta?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117703/imagenPreg/28/84/imprenta.jpg', 3, 28);            -- id 84

-- Revoluciones modernas (quiz_id = 29)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién lideró la independencia de América?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117704/imagenPreg/29/85/bolivar.jpg', 1, 29),        -- id 85
  ('¿Qué revolución ocurrió en Rusia en 1917?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117706/imagenPreg/29/86/rusia1917.jpg', 2, 29),       -- id 86
  ('¿Quién fue Martin Luther King?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117707/imagenPreg/29/87/mlk.jpg', 3, 29);                        -- id 87

-- Personajes modernos (quiz_id = 30)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién fue Albert Einstein?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117713/imagenPreg/30/88/einstein.jpg', 1, 30),                      -- id 88
  ('¿Quién fue Marie Curie?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117714/imagenPreg/30/89/curie.jpg', 2, 30),                             -- id 89
  ('¿Quién fue Mahatma Gandhi?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117715/imagenPreg/30/90/gandhi.jpg', 3, 30);                         -- id 90

-- Bandas de rock (quiz_id = 31)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es el vocalista de Queen?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117716/imagenPreg/31/91/queen.jpg', 1, 31),                    -- id 91
  ('¿Qué banda compuso "Stairway to Heaven"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117717/imagenPreg/31/92/ledzeppelin.jpg', 2, 31),      -- id 92
  ('¿Qué banda es famosa por "Satisfaction"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117719/imagenPreg/31/93/rollingstones.jpg', 3, 31);    -- id 93

-- Álbumes de rock (quiz_id = 32)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién grabó "Abbey Road"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117720/imagenPreg/32/94/abbeyroad.jpg', 1, 32),                      -- id 94
  ('¿Qué álbum es "The Wall"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117721/imagenPreg/32/95/thewall.jpg', 2, 32),                         -- id 95
  ('¿Qué álbum es "Back in Black"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117722/imagenPreg/32/96/backinblack.jpg', 3, 32);                -- id 96

-- Historia del rock (quiz_id = 33)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Dónde fue el festival de Woodstock?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117723/imagenPreg/33/97/woodstock.jpg', 1, 33),            -- id 97
  ('¿Quién fue el "Rey del Rock"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117725/imagenPreg/33/98/elvis.jpg', 2, 33),                       -- id 98
  ('¿Qué banda británica revolucionó la música en los 60?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117726/imagenPreg/33/99/beatles.jpg', 3, 33); -- id 99

-- Artistas pop (quiz_id = 34)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es conocido como el "Rey del Pop"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117727/imagenPreg/34/100/mj.jpg', 1, 34),              -- id 100
  ('¿Quién canta "Bad Guy"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117728/imagenPreg/34/101/billie.jpg', 2, 34),                            -- id 101
  ('¿Quién es la artista de "Rolling in the Deep"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117729/imagenPreg/34/102/adele.jpg', 3, 34);      -- id 102

-- Canciones pop (quiz_id = 35)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién canta "Shape of You"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117730/imagenPreg/35/103/edsheeran.jpg', 1, 35),                    -- id 103
  ('¿Qué grupo canta "Dancing Queen"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117732/imagenPreg/35/104/abba.jpg', 2, 35),                    -- id 104
  ('¿Quién canta "Like a Prayer"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117733/imagenPreg/35/105/madonna.jpg', 3, 35);                     -- id 105

-- Historia del pop (quiz_id = 36)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién fue la primera superestrella pop?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117734/imagenPreg/36/106/elvis.jpg', 1, 36),            -- id 106
  ('¿Qué artista popularizó el "moonwalk"?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117735/imagenPreg/36/107/mj.jpg', 2, 36),                 -- id 107
  ('¿Qué grupo británico marcó los 60?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117736/imagenPreg/36/108/beatles.jpg', 3, 36);                -- id 108

-- Star Wars Episodio IV (quiz_id = 37)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es el protagonista principal?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778121432/fotonoticia_20150620132813_412_rxux0j.jpg', 1, 37),                 -- id 109
  ('¿Qué droide acompaña a Luke?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778121463/360_F_928173610_MDO4XGYmOJ2685TTwhNW2Y1vktrWh8kX_spriwj.jpg', 2, 37),                         -- id 110
  ('¿Quién es el villano principal?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778121502/thumb-1920-59190_ukryjt.jpg', 3, 37);                     -- id 111

-- Star Wars Personajes (quiz_id = 38)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es la princesa de Alderaan?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117741/imagenPreg/38/112/leia.jpg', 1, 38),                   -- id 112
  ('¿Quién es el contrabandista amigo de Luke?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117742/imagenPreg/38/113/han.jpg', 2, 38),            -- id 113
  ('¿Quién es el maestro Jedi verde?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117743/imagenPreg/38/114/yoda.jpg', 3, 38);                     -- id 114

-- Star Wars Naves (quiz_id = 39)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Cómo se llama la nave de Han Solo?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117744/imagenPreg/39/115/falcon.jpg', 1, 39),                -- id 115
  ('¿Qué nave usa el Imperio?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117745/imagenPreg/39/116/tie.jpg', 2, 39),                             -- id 116
  ('¿Qué nave destruye la Estrella de la Muerte?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117746/imagenPreg/39/117/xwing.jpg', 3, 39);        -- id 117

-- El Señor de los Anillos: La Comunidad (quiz_id = 40)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es el portador del anillo?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117751/imagenPreg/40/118/frodo.jpg', 1, 40),                   -- id 118
  ('¿Quién es el mago gris?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117752/imagenPreg/40/119/gandalf.jpg', 2, 40),                           -- id 119
  ('¿Quién es el rey de Gondor?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117753/imagenPreg/40/120/aragorn.jpg', 3, 40);                       -- id 120

-- El Señor de los Anillos: Las Dos Torres (quiz_id = 41)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es el traidor de la comunidad?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117754/imagenPreg/41/121/boromir.jpg', 1, 41),             -- id 121
  ('¿Quién es el elfo arquero?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117755/imagenPreg/41/122/legolas.jpg', 2, 41),                        -- id 122
  ('¿Quién es el enano guerrero?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117757/imagenPreg/41/123/gimli.jpg', 3, 41);                        -- id 123

-- Personajes de El Señor de los Anillos (quiz_id = 42)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es el señor oscuro?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117758/imagenPreg/42/124/sauron.jpg', 1, 42),                         -- id 124
  ('¿Quién es la dama de Lothlórien?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117759/imagenPreg/42/125/galadriel.jpg', 2, 42),                -- id 125
  ('¿Quién es el hobbit leal amigo de Frodo?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117760/imagenPreg/42/126/sam.jpg', 3, 42);              -- id 126

-- Adivina el campeón de LoL (quiz_id = 43)
INSERT INTO pregunta (enunciado, imagen, posicion, quiz_id) VALUES
  ('¿Quién es este campeón?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117761/imagenPreg/43/127/ahri.jpg', 1, 43),         -- id 127
  ('¿Quién es este campeón?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117762/imagenPreg/43/128/yasuo.jpg', 2, 43),        -- id 128
  ('¿Quién es este campeón?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117764/imagenPreg/43/129/teemo.jpg', 3, 43),        -- id 129
  ('¿Quién es este campeón?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117765/imagenPreg/43/130/lux.jpg', 4, 43),          -- id 130
  ('¿Quién es este campeón?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117766/imagenPreg/43/131/garen.jpg', 5, 43),        -- id 131
  ('¿Quién es este campeón?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117767/imagenPreg/43/132/jinx.jpg', 6, 43),         -- id 132
  ('¿Quién es este campeón?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117769/imagenPreg/43/133/thresh.jpg', 7, 43),       -- id 133
  ('¿Quién es este campeón?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117770/imagenPreg/43/134/lee_sin.jpg', 8, 43),      -- id 134
  ('¿Quién es este campeón?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117771/imagenPreg/43/135/miss_fortune.jpg', 9, 43), -- id 135
  ('¿Quién es este campeón?', 'https://res.cloudinary.com/dcrii9pgf/image/upload/v1778117772/imagenPreg/43/136/ekko.jpg', 10, 43);        -- id 136

-- QUIZZES PREGUNTAS

-- QUIZZES PISTAS

-- The Witcher 3
INSERT INTO pista (pregunta_id, texto) VALUES
  (1, 'Cazador de monstruos'),
  (1, 'Tiene cabello blanco'),
  (2, 'Hechicera pelirroja'),
  (2, 'Amiga de Geralt'),
  (3, 'Bruja de los bosques'),
  (3, 'Ayuda a Geralt en Velen');

-- Final Fantasy VII
INSERT INTO pista (pregunta_id, texto) VALUES
  (4, 'Espadachín rubio'),
  (4, 'Ex SOLDADO'),
  (5, 'Vende flores en Midgar'),
  (5, 'Tiene poderes ancestrales'),
  (6, 'Cabello plateado'),
  (6, 'Porta una katana larga');

-- Elder Scrolls: Skyrim
INSERT INTO pista (pregunta_id, texto) VALUES
  (7, 'Sangre de dragón'),
  (7, 'Puede usar gritos'),
  (8, 'Dragón devorador de mundos'),
  (8, 'Primer dragón de la historia'),
  (9, 'Ciudad portuaria'),
  (9, 'Sede de la reina Elisif');

-- DOOM
INSERT INTO pista (pregunta_id, texto) VALUES
  (10, 'Lucha contra demonios'),
  (10, 'No habla'),
  (11, 'Demonio gigante'),
  (11, 'Tiene un cañón en el brazo'),
  (12, 'Científica de la UAC'),
  (12, 'Libera a los demonios');

-- Call of Duty
INSERT INTO pista (pregunta_id, texto) VALUES
  (13, 'Todos contra todos'),
  (13, 'Equipos de 6 vs 6'),
  (14, 'Rifle de asalto soviético'),
  (14, 'Muy usado en shooters'),
  (15, 'Conflicto global'),
  (15, '1939-1945');

-- Overwatch
INSERT INTO pista (pregunta_id, texto) VALUES
  (16, 'Británica veloz'),
  (16, 'Usa cronocargadores'),
  (17, 'Gorila de la Luna'),
  (17, 'Ama los cacahuetes'),
  (18, 'Letal a larga distancia'),
  (18, 'Piel azul');

-- Grandes pintores
INSERT INTO pista (pregunta_id, texto) VALUES
  (19, 'Pintor neerlandés'),
  (19, 'Oreja cortada'),
  (20, 'Cubismo'),
  (20, 'Español del siglo XX'),
  (21, 'Renacimiento italiano'),
  (21, 'Inventor y artista');

-- Obras maestras
INSERT INTO pista (pregunta_id, texto) VALUES
  (22, 'Leonardo da Vinci'),
  (22, 'Retrato en el Louvre'),
  (23, 'Miguel Ángel'),
  (23, 'Techo del Vaticano'),
  (24, 'Salvador Dalí'),
  (24, 'Surrealismo');

-- Estilos de pintura
INSERT INTO pista (pregunta_id, texto) VALUES
  (25, 'Claude Monet'),
  (25, 'Siglo XIX'),
  (26, 'Edvard Munch'),
  (26, 'Expresión de emociones'),
  (27, 'Vasili Kandinsky'),
  (27, 'Sin figuras reconocibles');

-- Escultores famosos
INSERT INTO pista (pregunta_id, texto) VALUES
  (28, 'Miguel Ángel'),
  (28, 'Renacimiento'),
  (29, 'Auguste Rodin'),
  (29, 'Escultor francés'),
  (30, 'Miguel Ángel'),
  (30, 'Obra religiosa');

-- Obras de escultura
INSERT INTO pista (pregunta_id, texto) VALUES
  (31, 'Isla de Pascua'),
  (31, 'Cabezas gigantes'),
  (32, 'Regalo de Francia'),
  (32, 'Símbolo de libertad'),
  (33, 'Mitología egipcia'),
  (33, 'Cuerpo de león, cabeza humana');

-- Tipos de escultura
INSERT INTO pista (pregunta_id, texto) VALUES
  (34, 'No representa figuras reales'),
  (34, 'Formas geométricas'),
  (35, 'Movimiento real o aparente'),
  (35, 'Alexander Calder'),
  (36, 'De gran tamaño'),
  (36, 'Espacios públicos');

-- Físicos célebres
INSERT INTO pista (pregunta_id, texto) VALUES
  (37, 'Famoso por E=mc^2'),
  (37, 'Nació en Alemania'),
  (38, 'Ley de la gravedad'),
  (38, 'Manzana'),
  (39, 'Premio Nobel'),
  (39, 'Descubrió el polonio');

-- Teorías físicas
INSERT INTO pista (pregunta_id, texto) VALUES
  (40, 'Newton'),
  (40, 'Atracción entre masas'),
  (41, 'Max Planck'),
  (41, 'Fotones'),
  (42, 'James Clerk Maxwell'),
  (42, 'Ondas electromagnéticas');

-- Experimentos históricos
INSERT INTO pista (pregunta_id, texto) VALUES
  (43, 'Interferencia de luz'),
  (43, 'Thomas Young'),
  (44, 'Rayos catódicos'),
  (44, 'J.J. Thomson'),
  (45, 'Robert Millikan'),
  (45, 'Gotas de aceite');

-- Biólogos célebres
INSERT INTO pista (pregunta_id, texto) VALUES
  (46, 'Islas Galápagos'),
  (46, 'Selección natural'),
  (47, 'Antibióticos'),
  (47, 'Moho'),
  (48, 'Leyes de la herencia'),
  (48, 'Guisantes');

-- Descubrimientos biológicos
INSERT INTO pista (pregunta_id, texto) VALUES
  (49, 'Watson y Crick'),
  (49, 'Doble hélice'),
  (50, 'Jan Swammerdam'),
  (50, 'Células sanguíneas'),
  (51, 'Schleiden y Schwann'),
  (51, 'Unidad básica de la vida');

-- Ramas de la biología
INSERT INTO pista (pregunta_id, texto) VALUES
  (52, 'Estudia las plantas'),
  (52, 'Fotosíntesis'),
  (53, 'Estudia los animales'),
  (53, 'Fauna'),
  (54, 'Estudia microorganismos'),
  (54, 'Bacterias y virus');

-- Jugadores de fútbol
INSERT INTO pista (pregunta_id, texto) VALUES
  (55, 'Argentino'),
  (55, 'FC Barcelona'),
  (56, 'Portugués'),
  (56, 'Real Madrid y Manchester United'),
  (57, 'Brasileño'),
  (57, 'Tres Mundiales');

-- Equipos históricos
INSERT INTO pista (pregunta_id, texto) VALUES
  (58, 'Equipo blanco'),
  (58, 'España'),
  (59, 'Inglaterra'),
  (59, 'Old Trafford'),
  (60, 'España'),
  (60, 'Tiki-taka');

-- Copas del mundo
INSERT INTO pista (pregunta_id, texto) VALUES
  (61, 'Cinco títulos'),
  (61, 'Sudamérica'),
  (62, 'Uruguay'),
  (62, 'Año 1930'),
  (63, 'Argentina'),
  (63, 'Mano de Dios');

-- Jugadores de baloncesto
INSERT INTO pista (pregunta_id, texto) VALUES
  (64, 'Chicago Bulls'),
  (64, 'N° 23'),
  (65, 'Golden State Warriors'),
  (65, 'Triples'),
  (66, 'Los Angeles Lakers'),
  (66, 'LeBron');

-- Equipos de baloncesto
INSERT INTO pista (pregunta_id, texto) VALUES
  (67, 'Los Ángeles'),
  (67, 'Morado y oro'),
  (68, 'Boston'),
  (68, 'Verde y blanco'),
  (69, 'Nueva York'),
  (69, 'NBA');

-- NBA
INSERT INTO pista (pregunta_id, texto) VALUES
  (70, 'Denver Nuggets'),
  (70, 'Serbio'),
  (71, 'Kareem Abdul-Jabbar'),
  (71, 'Sky Hook'),
  (72, 'Los Angeles Lakers'),
  (72, 'Burbuja de Orlando');

-- Edad Media
INSERT INTO pista (pregunta_id, texto) VALUES
  (73, '1453'),
  (73, 'Fin de la Edad Media'),
  (74, 'Inglaterra y Francia'),
  (74, 'Más de un siglo'),
  (75, 'Santa francesa'),
  (75, 'Guerra de los Cien Años');

-- Castillos medievales
INSERT INTO pista (pregunta_id, texto) VALUES
  (76, 'Alemania'),
  (76, 'Baviera'),
  (77, 'Disney'),
  (77, 'Inspiración de la Bella Durmiente'),
  (78, 'Escocia'),
  (78, 'Capital escocesa');

-- Personajes medievales
INSERT INTO pista (pregunta_id, texto) VALUES
  (79, 'Rey inglés'),
  (79, 'Cruzadas'),
  (80, 'Imperio Mongol'),
  (80, 'Conquistador asiático'),
  (81, 'Sultán musulmán'),
  (81, 'Rival de los cruzados');

-- Edad Moderna
INSERT INTO pista (pregunta_id, texto) VALUES
  (82, '1789'),
  (82, 'Revolución Francesa'),
  (83, 'Emperador francés'),
  (83, 'Batalla de Waterloo'),
  (84, 'Gutenberg'),
  (84, 'Imprenta moderna');

-- Revoluciones modernas
INSERT INTO pista (pregunta_id, texto) VALUES
  (85, 'Libertador de América'),
  (85, 'Venezuela'),
  (86, 'Lenin'),
  (86, 'Bolcheviques'),
  (87, 'Derechos civiles'),
  (87, 'Estados Unidos');

-- Personajes modernos
INSERT INTO pista (pregunta_id, texto) VALUES
  (88, 'Físico alemán'),
  (88, 'Teoría de la relatividad'),
  (89, 'Científica polaca'),
  (89, 'Radiactividad'),
  (90, 'Líder pacifista'),
  (90, 'Independencia de la India');

-- Bandas de rock
INSERT INTO pista (pregunta_id, texto) VALUES
  (91, 'Freddie Mercury'),
  (91, 'Bohemian Rhapsody'),
  (92, 'Led Zeppelin'),
  (92, 'Rock británico'),
  (93, 'Rolling Stones'),
  (93, 'Mick Jagger');

-- Álbumes de rock
INSERT INTO pista (pregunta_id, texto) VALUES
  (94, 'The Beatles'),
  (94, 'Portada con paso de cebra'),
  (95, 'Pink Floyd'),
  (95, 'Muro conceptual'),
  (96, 'AC/DC'),
  (96, 'Rock australiano');

-- Historia del rock
INSERT INTO pista (pregunta_id, texto) VALUES
  (97, 'Estados Unidos'),
  (97, '1969'),
  (98, 'Elvis Presley'),
  (98, 'Graceland'),
  (99, 'The Beatles'),
  (99, 'Liverpool');

-- Artistas pop
INSERT INTO pista (pregunta_id, texto) VALUES
  (100, 'Michael Jackson'),
  (100, 'Moonwalk'),
  (101, 'Billie Eilish'),
  (101, 'Álbum "When We All Fall Asleep..."'),
  (102, 'Adele'),
  (102, 'Voz poderosa');

-- Canciones pop
INSERT INTO pista (pregunta_id, texto) VALUES
  (103, 'Ed Sheeran'),
  (103, '2017'),
  (104, 'Grupo sueco'),
  (104, 'ABBA'),
  (105, 'Madonna'),
  (105, 'Pop de los 80');

-- Historia del pop
INSERT INTO pista (pregunta_id, texto) VALUES
  (106, 'Elvis Presley'),
  (106, 'Década de 1950'),
  (107, 'Michael Jackson'),
  (107, 'Baile icónico'),
  (108, 'The Beatles'),
  (108, 'Beatlemania');

-- Star Wars Episodio IV
INSERT INTO pista (pregunta_id, texto) VALUES
  (109, 'Luke Skywalker'),
  (109, 'Joven Jedi'),
  (110, 'Droide azul y blanco'),
  (110, 'R2-D2'),
  (111, 'Sith'),
  (111, 'Padre de Luke');

-- Star Wars Personajes
INSERT INTO pista (pregunta_id, texto) VALUES
  (112, 'Hermana de Luke'),
  (112, 'Princesa rebelde'),
  (113, 'Halcón Milenario'),
  (113, 'Contrabandista'),
  (114, 'Maestro Jedi'),
  (114, 'Pequeño y verde');

-- Star Wars Naves
INSERT INTO pista (pregunta_id, texto) VALUES
  (115, 'Han Solo'),
  (115, 'Nave rápida'),
  (116, 'Nave imperial'),
  (116, 'Forma de H'),
  (117, 'Luke la pilota'),
  (117, 'Batalla final');

-- El Señor de los Anillos: La Comunidad
INSERT INTO pista (pregunta_id, texto) VALUES
  (118, 'Hobbit'),
  (118, 'Portador del anillo'),
  (119, 'Mago gris'),
  (119, 'Líder de la comunidad'),
  (120, 'Rey de Gondor'),
  (120, 'Andúril');

-- El Señor de los Anillos: Las Dos Torres
INSERT INTO pista (pregunta_id, texto) VALUES
  (121, 'Miembro de la comunidad'),
  (121, 'Hijo de Denethor'),
  (122, 'Elfo arquero'),
  (122, 'Ojos azules'),
  (123, 'Enano guerrero'),
  (123, 'Hacha');

-- Personajes de El Señor de los Anillos
INSERT INTO pista (pregunta_id, texto) VALUES
  (124, 'Sauron'),
  (124, 'Ojo de fuego'),
  (125, 'Galadriel'),
  (125, 'Lothlórien'),
  (126, 'Samwise Gamyi'),
  (126, 'Leal a Frodo');

-- Adivina el campeón de LoL
INSERT INTO pista (pregunta_id, texto) VALUES
  (127, 'Zorra de nueve colas'),
  (127, 'Campeona maga de mid'),
  (128, 'Samurái del viento'),
  (128, 'Famoso por su frase: "El viento es mi guía"'),
  (129, 'Yordle explorador'),
  (129, 'Coloca setas invisibles'),
  (130, 'Dama de la luz'),
  (130, 'Hermana de Garen'),
  (131, 'Guerrero de Demacia'),
  (131, 'Usa una espada enorme'),
  (132, 'Artillera loca'),
  (132, 'Cabello azul y armas gigantes'),
  (133, 'Carcelero de las almas'),
  (133, 'Soporte con linterna'),
  (134, 'Monje ciego'),
  (134, 'Especialista en artes marciales'),
  (135, 'Pirata pistolera'),
  (135, 'Dispara balas dobles'),
  (136, 'Controla el tiempo'),
  (136, 'Joven prodigio de Zaun');

-- QUIZZES PISTAS

-- QUIZZES RESPUESTAS

-- The Witcher 3
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (1, 'Geralt'),
  (2, 'Triss Merigold'),
  (3, 'Keira Metz');

-- Final Fantasy VII
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (4, 'Cloud'),
  (4, 'Cloud Strife'),
  (5, 'Aerith'),
  (5, 'Aerith Gainsborough'),
  (6, 'Sephiroth');

-- Elder Scrolls: Skyrim
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (7, 'Dovahkiin'),
  (8, 'Alduin'),
  (9, 'Solitude');

-- DOOM
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (10, 'Doom Slayer'),
  (11, 'Cyberdemon'),
  (12, 'Olivia Pierce');

-- Call of Duty
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (13, 'Team Deathmatch'),
  (14, 'AK-47'),
  (15, 'Segunda Guerra Mundial');

-- Overwatch
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (16, 'Tracer'),
  (17, 'Winston'),
  (18, 'Widowmaker');

-- Grandes pintores
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (19, 'Vincent van Gogh'),
  (20, 'Pablo Picasso'),
  (21, 'Leonardo da Vinci');

-- Obras maestras
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (22, 'Leonardo da Vinci'),
  (23, 'La creación de Adán'),
  (24, 'La persistencia de la memoria');

-- Estilos de pintura
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (25, 'Impresionismo'),
  (26, 'Expresionismo'),
  (27, 'Abstracto');

-- Escultores famosos
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (28, 'Miguel Ángel'),
  (29, 'Auguste Rodin'),
  (30, 'Miguel Ángel');

-- Obras de escultura
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (31, 'Isla de Pascua'),
  (32, 'Estatua de la Libertad'),
  (33, 'La Esfinge');

-- Tipos de escultura
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (34, 'Escultura abstracta'),
  (35, 'Escultura cinética'),
  (36, 'Escultura monumental');

-- Físicos célebres
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (37, 'Albert Einstein'),
  (38, 'Isaac Newton'),
  (39, 'Marie Curie');

-- Teorías físicas
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (40, 'Teoría de la gravedad'),
  (41, 'Teoría cuántica'),
  (42, 'Teoría del electromagnetismo');

-- Experimentos históricos
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (43, 'Experimento de la doble rendija'),
  (44, 'Experimento del tubo de Crookes'),
  (45, 'Experimento de la gota de aceite');

-- Biólogos célebres
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (46, 'Charles Darwin'),
  (47, 'Alexander Fleming'),
  (48, 'Gregor Mendel');

-- Descubrimientos biológicos
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (49, 'Watson y Crick'),
  (50, 'Jan Swammerdam'),
  (51, 'Schleiden y Schwann');

-- Ramas de la biología
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (52, 'Botánica'),
  (53, 'Zoología'),
  (54, 'Microbiología');

-- Jugadores de fútbol
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (55, 'Lionel Messi'),
  (56, 'Cristiano Ronaldo'),
  (57, 'Pelé');

-- Equipos históricos
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (58, 'Real Madrid'),
  (59, 'Manchester United'),
  (60, 'FC Barcelona');

-- Copas del mundo
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (61, 'Brasil'),
  (62, '1930'),
  (63, 'Diego Maradona');

-- Jugadores de baloncesto
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (64, 'Michael Jordan'),
  (65, 'Stephen Curry'),
  (66, 'LeBron James');

-- Equipos de baloncesto
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (67, 'Los Angeles Lakers'),
  (68, 'Boston Celtics'),
  (69, 'New York Knicks');

-- NBA
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (70, 'Nikola Jokic'),
  (71, 'Kareem Abdul-Jabbar'),
  (72, 'Los Angeles Lakers');

-- Edad Media
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (73, '1453'),
  (74, 'Guerra de los Cien Años'),
  (75, 'Heroína francesa');

-- Castillos medievales
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (76, 'Alemania'),
  (77, 'Neuschwanstein'),
  (78, 'Castillo de Edimburgo');

-- Personajes medievales
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (79, 'Rey de Inglaterra'),
  (80, 'Conquistador mongol'),
  (81, 'Sultán de Egipto');

-- Edad Moderna
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (82, '1789'),
  (83, 'Emperador francés'),
  (84, 'Imprenta de Gutenberg');

-- Revoluciones modernas
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (85, 'Simón Bolívar'),
  (86, 'Revolución Rusa'),
  (87, 'Martin Luther King');

-- Personajes modernos
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (88, 'Albert Einstein'),
  (89, 'Marie Curie'),
  (90, 'Mahatma Gandhi');

-- Bandas de rock
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (91, 'Freddie Mercury'),
  (92, 'Led Zeppelin'),
  (93, 'The Rolling Stones');

-- Álbumes de rock
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (94, 'The Beatles'),
  (95, 'Pink Floyd'),
  (96, 'AC/DC');

-- Historia del rock
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (97, 'Estados Unidos'),
  (98, 'Elvis Presley'),
  (99, 'The Beatles');

-- Artistas pop
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (100, 'Michael Jackson'),
  (101, 'Billie Eilish'),
  (102, 'Adele');

-- Canciones pop
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (103, 'Ed Sheeran'),
  (104, 'ABBA'),
  (105, 'Madonna');

-- Historia del pop
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (106, 'Elvis Presley'),
  (107, 'Michael Jackson'),
  (108, 'The Beatles');

-- Star Wars Episodio IV
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (109, 'Luke Skywalker'),
  (110, 'R2-D2'),
  (111, 'Darth Vader');

-- Star Wars Personajes
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (112, 'Leia Organa'),
  (113, 'Han Solo'),
  (114, 'Yoda');

-- Star Wars Naves
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (115, 'Halcón Milenario'),
  (116, 'TIE Fighter'),
  (117, 'X-Wing');

-- El Señor de los Anillos: La Comunidad
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (118, 'Frodo Bolsón'),
  (119, 'Gandalf'),
  (120, 'Aragorn');

-- El Señor de los Anillos: Las Dos Torres
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (121, 'Boromir'),
  (122, 'Legolas'),
  (123, 'Gimli');

-- Personajes de El Señor de los Anillos
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (124, 'Sauron'),
  (125, 'Galadriel'),
  (126, 'Sam');

-- Adivina el campeón de LoL
INSERT INTO respuesta (pregunta_id, texto) VALUES
  (127, 'Ahri'),
  (128, 'Yasuo'),
  (129, 'Teemo'),
  (130, 'Lux'),
  (131, 'Garen'),
  (132, 'Jinx'),
  (133, 'Thresh'),
  (134, 'Lee Sin'),
  (135, 'Miss Fortune'),
  (136, 'Ekko');

-- QUIZZES RESPUESTAS

-- QUIZZES PENDIENTES DE ACEPTAR (creador_id = 2, estado = 3 -> PENDIENTE)
INSERT INTO quiz (nombre, descripcion, portada, creador_id, categoria_id, subcategoria_id, estado) VALUES
  ('Quiz de Marvel', 'Preguntas sobre el universo Marvel', 'marvel.jpg', 2, 1, 1, 3),
  ('Quiz de Animales', '¿Cuánto sabes sobre animales?', 'animales.jpg', 2, 3, 6, 3),
  ('Quiz de Historia de España', 'Historia y personajes de España', 'espana.jpg', 2, 5, 9, 3),
  ('Quiz de Videojuegos Indie', 'Juegos indie populares', 'indie.jpg', 2, 1, 2, 3),
  ('Quiz de Música Clásica', 'Compositores y obras clásicas', 'clasica.jpg', 2, 6, 12, 3);

-- QUIZZES RECHAZADOS (creador_id = 2, estado = 2 -> RECHAZADO)
INSERT INTO quiz (nombre, descripcion, portada, creador_id, categoria_id, subcategoria_id, estado) VALUES
  ('Quiz de Series Canceladas', 'Preguntas sobre series que fueron canceladas', 'series_canceladas.jpg', 2, 1, 2, 5),
  ('Quiz de Animales Extintos', '¿Cuánto sabes sobre animales extintos?', 'extintos.jpg', 2, 3, 6, 5),
  ('Quiz de Inventos Fallidos', 'Inventos que no triunfaron en la historia', 'fallidos.jpg', 2, 5, 10, 5);

-- -- RONDAS (solo para la partida 1, tantas como preguntas en el quiz 1)
-- INSERT INTO ronda (numero_ronda, estado, partida_id, pregunta_id) VALUES
--   (1, 1, 1, 1),
--   (2, 2, 1, 2);