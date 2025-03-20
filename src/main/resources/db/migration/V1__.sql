CREATE TABLE livro
(
    id     BIGINT NOT NULL,
    titulo VARCHAR(255) NULL,
    autor  VARCHAR(255) NULL,
    CONSTRAINT pk_livro PRIMARY KEY (id)
);