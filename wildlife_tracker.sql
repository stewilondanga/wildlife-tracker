--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: stewart
--

CREATE TABLE animals (
    id integer NOT NULL,
    name character varying,
    health character varying,
    age integer
);


ALTER TABLE animals OWNER TO stewart;

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: stewart
--

CREATE SEQUENCE animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_id_seq OWNER TO stewart;

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: stewart
--

ALTER SEQUENCE animals_id_seq OWNED BY animals.id;


--
-- Name: locations; Type: TABLE; Schema: public; Owner: stewart
--

CREATE TABLE locations (
    id integer NOT NULL,
    name character varying,
    x_coord numeric,
    y_coord numeric
);


ALTER TABLE locations OWNER TO stewart;

--
-- Name: locations_id_seq; Type: SEQUENCE; Schema: public; Owner: stewart
--

CREATE SEQUENCE locations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE locations_id_seq OWNER TO stewart;

--
-- Name: locations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: stewart
--

ALTER SEQUENCE locations_id_seq OWNED BY locations.id;


--
-- Name: rangers; Type: TABLE; Schema: public; Owner: stewart
--

CREATE TABLE rangers (
    id integer NOT NULL,
    username character varying,
    firstname character varying,
    lastname character varying,
    badge integer,
    phone character varying
);


ALTER TABLE rangers OWNER TO stewart;

--
-- Name: rangers_id_seq; Type: SEQUENCE; Schema: public; Owner: stewart
--

CREATE SEQUENCE rangers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rangers_id_seq OWNER TO stewart;

--
-- Name: rangers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: stewart
--

ALTER SEQUENCE rangers_id_seq OWNED BY rangers.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: stewart
--

CREATE TABLE sightings (
    id integer NOT NULL,
    animal_id integer,
    location_id integer,
    ranger_id integer
);


ALTER TABLE sightings OWNER TO stewart;

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: stewart
--

CREATE SEQUENCE sightings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sightings_id_seq OWNER TO stewart;

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: stewart
--

ALTER SEQUENCE sightings_id_seq OWNED BY sightings.id;


--
-- Name: animals id; Type: DEFAULT; Schema: public; Owner: stewart
--

ALTER TABLE ONLY animals ALTER COLUMN id SET DEFAULT nextval('animals_id_seq'::regclass);


--
-- Name: locations id; Type: DEFAULT; Schema: public; Owner: stewart
--

ALTER TABLE ONLY locations ALTER COLUMN id SET DEFAULT nextval('locations_id_seq'::regclass);


--
-- Name: sightings id; Type: DEFAULT; Schema: public; Owner: stewart
--

ALTER TABLE ONLY sightings ALTER COLUMN id SET DEFAULT nextval('sightings_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: stewart
--

COPY animals (id, name, health, age) FROM stdin;
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: stewart
--

SELECT pg_catalog.setval('animals_id_seq', 1, false);


--
-- Data for Name: locations; Type: TABLE DATA; Schema: public; Owner: stewart
--

COPY locations (id, name, x_coord, y_coord) FROM stdin;
\.


--
-- Name: locations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: stewart
--

SELECT pg_catalog.setval('locations_id_seq', 1, false);


--
-- Data for Name: rangers; Type: TABLE DATA; Schema: public; Owner: stewart
--

COPY rangers (id, username, firstname, lastname, badge, phone) FROM stdin;
\.


--
-- Name: rangers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: stewart
--

SELECT pg_catalog.setval('rangers_id_seq', 1, false);


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: stewart
--

COPY sightings (id, animal_id, location_id, ranger_id) FROM stdin;
\.


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: stewart
--

SELECT pg_catalog.setval('sightings_id_seq', 1, false);


--
-- Name: animals animals_name_key; Type: CONSTRAINT; Schema: public; Owner: stewart
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_name_key UNIQUE (name);


--
-- Name: animals animals_pkey; Type: CONSTRAINT; Schema: public; Owner: stewart
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: locations locations_name_key; Type: CONSTRAINT; Schema: public; Owner: stewart
--

ALTER TABLE ONLY locations
    ADD CONSTRAINT locations_name_key UNIQUE (name);


--
-- Name: locations locations_pkey; Type: CONSTRAINT; Schema: public; Owner: stewart
--

ALTER TABLE ONLY locations
    ADD CONSTRAINT locations_pkey PRIMARY KEY (id);


--
-- Name: rangers rangers_pkey; Type: CONSTRAINT; Schema: public; Owner: stewart
--

ALTER TABLE ONLY rangers
    ADD CONSTRAINT rangers_pkey PRIMARY KEY (id);


--
-- Name: rangers rangers_username_key; Type: CONSTRAINT; Schema: public; Owner: stewart
--

ALTER TABLE ONLY rangers
    ADD CONSTRAINT rangers_username_key UNIQUE (username);


--
-- Name: sightings sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: stewart
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- Name: sightings sightings_animal_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: stewart
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_animal_id_fkey FOREIGN KEY (animal_id) REFERENCES animals(id) ON DELETE CASCADE;


--
-- Name: sightings sightings_location_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: stewart
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_location_id_fkey FOREIGN KEY (location_id) REFERENCES locations(id) ON DELETE CASCADE;


--
-- Name: sightings sightings_ranger_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: stewart
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_ranger_id_fkey FOREIGN KEY (ranger_id) REFERENCES rangers(id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

