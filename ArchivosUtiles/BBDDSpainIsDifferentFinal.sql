CREATE DATABASE  IF NOT EXISTS `spainisdifferent` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `spainisdifferent`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: spainisdifferent
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `decision`
--

DROP TABLE IF EXISTS `decision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `decision` (
  `id` int NOT NULL AUTO_INCREMENT,
  `texto` varchar(200) NOT NULL,
  `presupuesto` float NOT NULL,
  `puntosCorrupcion` float NOT NULL,
  `popularidad` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `decision`
--

LOCK TABLES `decision` WRITE;
/*!40000 ALTER TABLE `decision` DISABLE KEYS */;
INSERT INTO `decision` VALUES (1,'Ha habido un temporal que ha arrasado las costas del mar cantabrico y los habitantes quieren una compensacion economica por los daños',-200,5,-1),(2,'Un pais vecino pide ayuda para llevar agua a sus habitantes por una sequia',-300,0,4),(3,'Cada vez mas turistas vienen a visitar España que podemos hacer para convertir el pais en un destino turistico?',400,30,4),(4,'La crisis de las pensiones sigue acechando en el pais, hay manifestaciones por las calles de la capital',-100,0,-5),(5,'La sequia esta temporada esta dejando los estanques en minimos historicos, dando problemas de suministros a distintos pueblos de la España profunda',-100,10,-2),(6,'Europa manda ayudas monetarias para mejorar la situacion economica en el pais, a que se podria destinar el dinero?',500,30,5),(7,'El equipo sanitario publico esta quedandose atras por la demanda publica y se requiere algun cambio urgente',0,20,-3),(8,'La crisis de los transportes tambien ha llegado a España y no esta afectando en gran medida a los suministros pero es un buen momento para aprovechar la situacion para...',0,0,-2),(9,'El ministerio de educacion nos esta forzando a hacer un cambio en la ultima legislacion del anterior gobierno, que podemos hacer?',0,0,-1),(10,'Nos llegan imagenes de manifestaciones por la situacion del mar muerto y nos piden que el gobierno se pronuncie ante el tema',0,0,-5),(11,'Se ha sabido que otro pais vecino ha infectado los moviles de varios cargos publicos entre ellos el tuyo con el virus Unicorn',-200,0,0),(12,'La oposicion te ha vuelto a llamar fascista/comunista y ha lanzado indirectas a tu partido y sus dirigentes',0,0,-4);
/*!40000 ALTER TABLE `decision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `decisiontomada`
--

DROP TABLE IF EXISTS `decisiontomada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `decisiontomada` (
  `partida_id` int NOT NULL,
  `respuesta_id` int NOT NULL,
  PRIMARY KEY (`partida_id`,`respuesta_id`),
  KEY `respuesta_id_idx` (`respuesta_id`),
  CONSTRAINT `fk_decisiontomada_partida` FOREIGN KEY (`partida_id`) REFERENCES `partida` (`id`),
  CONSTRAINT `fk_decisiontomada_respuesta` FOREIGN KEY (`respuesta_id`) REFERENCES `respuesta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `decisiontomada`
--

LOCK TABLES `decisiontomada` WRITE;
/*!40000 ALTER TABLE `decisiontomada` DISABLE KEYS */;
/*!40000 ALTER TABLE `decisiontomada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `megaproyecto`
--

DROP TABLE IF EXISTS `megaproyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `megaproyecto` (
  `nombre` varchar(40) NOT NULL,
  `modificador1` varchar(40) NOT NULL,
  `modificador2` varchar(40) NOT NULL,
  `modificador3` varchar(40) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `megaproyecto`
--

LOCK TABLES `megaproyecto` WRITE;
/*!40000 ALTER TABLE `megaproyecto` DISABLE KEYS */;
INSERT INTO `megaproyecto` VALUES ('Aeropuerto sin licencia','AER1','AER2','AER3'),('Ave','AVE1','AVE2','AVE3'),('Hospital de pandemia','HP1','HP2','HP3'),('Metro que nadie pidio','MET1','MET2','MET3');
/*!40000 ALTER TABLE `megaproyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partida`
--

DROP TABLE IF EXISTS `partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partida` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `nombrePartida` varchar(45) NOT NULL,
  `puntosCorrupcion` float NOT NULL,
  `presupuesto` float NOT NULL,
  `popularidad` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `email_idx` (`email`),
  CONSTRAINT `email` FOREIGN KEY (`email`) REFERENCES `usuario` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partida`
--

LOCK TABLES `partida` WRITE;
/*!40000 ALTER TABLE `partida` DISABLE KEYS */;
/*!40000 ALTER TABLE `partida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respuesta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `texto` varchar(200) NOT NULL,
  `modificadorCodigo` varchar(45) DEFAULT NULL,
  `presupuesto` float NOT NULL,
  `popularidad` float NOT NULL,
  `puntosCorrupcion` float NOT NULL,
  `decision_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `decision_id_idx` (`decision_id`),
  CONSTRAINT `decision_id` FOREIGN KEY (`decision_id`) REFERENCES `decision` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta`
--

LOCK TABLES `respuesta` WRITE;
/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
INSERT INTO `respuesta` VALUES (1,'Declaras la zona como catastrofica y le envias ayudas a toda la peña','HP1',-1000,20,100,1),(2,'No les mandas ayudas porque si viven alli es porque quieren','MET2',0,-15,0,1),(3,'Dices que les ayudaras pero parte de las ayudas se perderan por el camino','AER1',-1000,20,300,1),(4,'Dices que tu tienes menos agua que ellos y que por lo menos tu no te quejas','HP1',0,-10,0,2),(5,'Mandaras hacer construir un acueducto y de paso te llevas unos billetes','MET1',-800,5,400,2),(6,'Mandaras camiones con agua para que les de para unas semanas','AER1',-100,10,50,2),(7,'Propones contruir un resort de vacaciones llamado Benidorn 2 tu MegaCiudad de vacaciones','AER2',-1000,15,500,3),(8,'Propones quitar los parques, arboles y bancos en las aceras para que la gente consuma mas en bares','MET2',3000,-15,300,3),(9,'Propones hacer olimpiadas de balconing llamando asi la atencion de turistas ingleses','AER2',2000,0,100,3),(10,'Mandas a los antidisturbios y silencias las noticias para que el pais no se entere','AVE1',-100,-5,100,4),(11,'Prometes subidas que nunca llegaran engañando asi a la poblacion','AER1',500,5,0,4),(12,'Promueves un sistema mixto de pensiones con parte publica y parte privada donde te llevas cacho','AVE1',2000,-10,200,4),(13,'Si no esta en Madrid no nos importa','HP2',0,-20,0,5),(14,'Promueves una campaña con Aquaservice y lo vendes como una buena oportunidad para estar hidratados','MET1',200,10,200,5),(15,'Modificas pantanos vacios para poder crear grandes proyectos urbanisticos en ellos','AER2',-500,-10,500,5),(16,'Abrimos el proyecto Nuevo Madrid para recolocar el Gobierno y los ministerios en una gran zona moderna y con nuevas arquitecturas','AER3',-500,5,400,6),(17,'Destinamos el dinero para la cooperacion con empresas en la llamada cooperacion publico-privada.','AVE2',-800,-5,200,6),(18,'Gastamos el dinero en acciones en bolsa para \"estimular\"\" el mercado\"','AVE2',-300,0,100,6),(19,'Nos apoyamos en instituciones privadas con una cooperacion publico-privada','AER2',200,-5,100,7),(20,'Invertimos dinero en las contrucciones de nuevos centros sanitarios en distintas ubicaciones de Madrid','AVE3',-300,15,300,7),(21,'No cambiamos nada del presupuesto, de hecho se lo reducimos empujando asi a que la gente use metodos sanitarios privados','',1000,-25,100,7),(22,'Metemos camiones del ejercito para suplir la demanda','HP3',-1500,5,0,8),(23,'Aumentamos las ayudas a camioneros','',-1500,10,0,8),(24,'Aumentamos los precios de los productos para sacar beneficio de esta oportunidad','AER3',1000,-15,100,8),(25,'Cambiar todo el temario y examenes para poder asi obtener ganancias del cambio de material escolar','',-500,-5,200,9),(26,'Financiamos tablets para la mayoria de colegios concertados','',-1000,10,200,9),(27,'Quitamos el castellano como lengua oficial para ganar asi el apoyo de partidos independentistas','AVE3',-500,-25,400,9),(28,'Anunciamos una investigacion de la causa, aunque seguramente luego en la votacion del congreso no salga a la luz','AVE1',0,5,0,10),(29,'Apoyamos financieramente a las empresas relacionadas con el vertido toxico para que no vuelvan a cometer el mismo error','HP3',-500,10,200,10),(30,'Ignoramos el tema creando un escandalo politico mayor y dandole mas visibilidad en los medios','HP3',-150,-10,100,10),(31,'Sobornamos a los medios para que no saquen el tema a la luz','AER3',-150,0,100,11),(32,'Anunciamos que varios cargos han sido contagiados por este virus pero que no hay ningun peligro de filtraciones de datos','MET3',300,0,0,11),(33,'Abrimos una comision de investigacion y buscamos a los culpables de tal acto','HP2',300,5,0,11),(34,'Respondeles con la misma magnitud y busca momentos para poder exposearlos en publico','',200,5,100,12),(35,'Acepta de forma ironica que sois un Gobierno asi y que es lo que la gente ha votado','AVE2',500,5,0,12),(36,'Dices que no lo eres, y que se centren en los temas importantes como en ayudas a las PYMES','MET3',2000,0,0,12);
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `email` varchar(40) NOT NULL,
  `nombreUsuario` varchar(40) NOT NULL,
  `contraseña` varchar(40) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('','admin','admin'),('lore','lore','lore'),('oli','oli','oli'),('pepe','pepito','pepe1'),('rafa','rafa','rafa'),('thor','thor','thor');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-12 20:32:30
