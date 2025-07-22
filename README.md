# 🐶 Rate My Dog

Una aplicación web construida con Spring Boot que permite subir y valorar fotos de perros, con posibilidad de añadir comentarios. Inspirado en el proyecto "Rate My Cat" de Boni García, adaptado y personalizado.

---

## 📁 Estructura del proyecto

```
rate-my-dog/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── Grigoriy/
│   │   │           └── rate_my_dog/
│   │   │               ├── RateMyDogApplication.java     ← Clase principal
│   │   │               ├── controller/
│   │   │               │   └── DogController.java         ← Controlador Web (routes)
│   │   │               ├── service/
│   │   │               │   └── DogService.java            ← Lógica de negocio
│   │   │               ├── model/
│   │   │               │   └── Dog.java                   ← Clase modelo (Entidad)
│   │   │               └── repository/
│   │   │                   └── DogRepository.java         ← Interfaz JPA Repository
│   │   └── resources/
│   │       ├── static/                                    ← Archivos estáticos (CSS, imágenes, JS)
│   │       │   ├── css/
│   │       │   └── images/
│   │       │       └── tu-perro1.jpg, tu-perro2.jpg...
│   │       ├── templates/                                 ← Vistas Thymeleaf
│   │       │   ├── index.html                             ← Página principal
│   │       │   └── dog-details.html                       ← Página detalle de perro (opcional)
│   │       └── application.properties                     ← Configuración
│
├── .gitignore
├── pom.xml                                                ← Dependencias y configuración Maven
└── README.md                                              ← Descripción del proyecto

```

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.5.3
- Maven
- Thymeleaf
- H2 Database (en memoria)
- HTML/CSS (básico)
- Eclipse o IntelliJ como IDE

---

## 🛠️ Pasos para construir el proyecto

### 1. Crear estructura del proyecto con Maven

### 2. Configurar el archivo `pom.xml`

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.5.3</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

### 3. Clase principal

```java
@SpringBootApplication
public class RateMyDogApplication {
    public static void main(String[] args) {
        SpringApplication.run(RateMyDogApplication.class, args);
    }
}
```

---

## 🧩 Componentes clave

### 🐕 Modelo `Dog.java`

```java
public class Dog {
    private Long id;
    private String name;
    private String imagePath;
    // Constructores, getters y setters
}
```

### 🔧 Servicio `DogService.java`

```java
@Service
public class DogService {
    private final List<Dog> dogList = List.of(
        new Dog(1L, "Luna", "/images/dog1.jpg"),
        new Dog(2L, "Toby", "/images/dog2.jpg")
    );

    public List<Dog> getAllDogs() {
        return dogList;
    }
}
```

### 🌐 Controlador `DogController.java`

```java
@Controller
public class DogController {
    @Autowired
    private DogService dogService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("dogs", dogService.getAllDogs());
        return "index";
    }
}
```

---

## 🖼️ Vista `index.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head><title>Rate My Dog</title></head>
<body>
    <h1>Rate My Dog 🐶</h1>
    <div th:each="dog : ${dogs}">
        <h3 th:text="${dog.name}"></h3>
        <img th:src="@{${dog.imagePath}}" width="300" />
        <!-- Espacio para puntuación y comentarios -->
    </div>
</body>
</html>
```

---

## 📷 Añadir imágenes

Coloca las fotos de los perros en:

```
src/main/resources/static/images/
```

Ejemplo: `dog1.jpg`, `dog2.jpg`, etc.

---

## 🗃️ Base de datos

- Uso de H2 en memoria (no persistente)
- Spring Boot la configura automáticamente sin ajustes adicionales

---

## 👤 Autor

**Grigoriy** – Proyecto personal inspirado en [Boni García – Rate My Cat](https://github.com/bonigarcia/rate-my-cat)
