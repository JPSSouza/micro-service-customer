-- Adminer 4.8.1 PostgreSQL 16.0 (Debian 16.0-1.pgdg120+1) dump

CREATE TABLE "public"."cliente" (
    "nome" VARCHAR(80) NOT NULL,
    "email" VARCHAR(50) NOT NULL,
    "cpf" VARCHAR(11) NOT NULL,
    CONSTRAINT "cliente_cpf" PRIMARY KEY ("cpf")
) WITH (oids = false);
