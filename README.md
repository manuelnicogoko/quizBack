<h1>Cryptum — Backend</h1>

<img width="1843" height="644" alt="completeLogoDark" src="https://github.com/user-attachments/assets/50f3ef71-510a-4646-8cb6-dfa10ff65c55" />

<p>
  API REST y WebSocket de la plataforma de quizzes multijugador Cryptum.
  Gestiona la autenticación, la lógica de partidas en tiempo real, la creación
  de quizzes y el almacenamiento de imágenes en la nube.
</p>

<p><strong><a href="https://cryptum.vercel.app/">Demo en producción →</a></strong></p>

<hr>

<h2>Repositorios</h2>

<table>
  <thead>
    <tr><th>Parte</th><th>Enlace</th></tr>
  </thead>
  <tbody>
    <tr><td>Frontend</td><td><a href="https://github.com/manuelnicogoko/quizFront">github.com/manuelnicogoko/quizFront</a></td></tr>
    <tr><td>Backend (este repo)</td><td><a href="https://github.com/manuelnicogoko/quizBack">github.com/manuelnicogoko/quizBack</a></td></tr>
  </tbody>
</table>

<hr>

<h2>Tecnologías</h2>

<ul>
  <li><strong>Java 21 + Spring Boot</strong> — Framework principal</li>
  <li><strong>Spring Security + JWT</strong> — Autenticación y autorización</li>
  <li><strong>Spring WebSocket (STOMP)</strong> — Comunicación en tiempo real</li>
  <li><strong>Spring Data JPA + Hibernate</strong> — Persistencia de datos</li>
  <li><strong>H2</strong> — Base de datos embebida para desarrollo</li>
  <li><strong>MySQL</strong> — Base de datos en producción</li>
  <li><strong>Cloudinary</strong> — Almacenamiento de imágenes en la nube</li>
  <li><strong>SpringDoc OpenAPI</strong> — Documentación interactiva con Swagger</li>
  <li><strong>Lombok</strong> — Reducción de código boilerplate</li>
  <li><strong>Jakarta Validation</strong> — Validación de datos de entrada</li>
</ul>

<hr>

<h2>Funcionalidades principales</h2>

<ul>
  <li>Registro e inicio de sesión con JWT</li>
  <li>Creación y edición de quizzes con preguntas, respuestas y pistas</li>
  <li>Organización de partidas multijugador en tiempo real vía WebSocket</li>
  <li>Sistema de rondas, vidas y puntuación por tiempo de respuesta</li>
  <li>Partidas públicas y privadas con código de acceso</li>
  <li>Categorías y subcategorías para clasificar los quizzes</li>
  <li>Subida de imágenes a Cloudinary (portadas, avatares, preguntas)</li>
  <li>Notificaciones para los usuarios</li>
  <li>Panel de administración con gestión completa de entidades</li>
  <li>Documentación interactiva con Swagger/OpenAPI</li>
</ul>

<hr>

<h2>Instalación local</h2>

<h3>Requisitos previos</h3>
<ul>
  <li>Java 21</li>
  <li>Maven</li>
</ul>

<h3>Pasos</h3>

<pre><code># 1. Clonar el repositorio
git clone https://github.com/manuelnicogoko/quizBack
cd quizBack

# 2. Configurar variables de entorno en application-dev.properties
# (ver sección de variables de entorno)

# 3. Arrancar la aplicación
mvn spring-boot:run
</code></pre>

<p>La API estará disponible en <code>http://localhost:9000</code>.</p>

<hr>

<h2>Variables de entorno</h2>

<p>Edita <code>src/main/resources/application-dev.properties</code> con tus valores:</p>

<pre><code># Cloudinary
cloudinary.cloud-name=TU_CLOUD_NAME
cloudinary.api-key=TU_API_KEY
cloudinary.api-secret=TU_API_SECRET

# Correo
spring.mail.username=TU_EMAIL
spring.mail.password=TU_PASSWORD
</code></pre>

<p>En desarrollo se usa base de datos <strong>H2 embebida</strong> (no requiere instalación). La consola H2 está disponible en <code>http://localhost:9000/h2-console</code>.</p>

<hr>

<h2>API / Swagger</h2>

<p>La documentación interactiva de todos los endpoints está disponible mediante Swagger UI:</p>

<ul>
  <li><strong>Local:</strong> <a href="http://localhost:9000/swagger-ui/index.html">Enlace DOCUMENTACIÓN LOCAL</a></li>
  <li><strong>Producción:</strong> <a href="https://quizback-production-c223.up.railway.app/swagger-ui/index.html">Enlace DOCUMENTACIÓN DEPLOY</a></li>
</ul>

<hr>

<h2>Estructura del proyecto</h2>

<pre><code>src/main/java/com/example/proyectoquiz/
├── config/          # Configuración (CORS, WebSocket, ModelMapper)
├── controllers/     # Controladores REST
├── domain/          # Entidades JPA
├── dto/             # Data Transfer Objects
├── exceptions/      # Excepciones personalizadas
├── repository/      # Interfaces de acceso a datos
├── security/        # Seguridad, filtros JWT y autenticación
├── services/        # Lógica de negocio
└── utils/           # Utilidades
</code></pre>

<hr>

<h2>Autor</h2>

<p><strong>Manuel González</strong> — Proyecto Final de Ciclo</p>
