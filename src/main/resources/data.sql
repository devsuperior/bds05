INSERT INTO tb_user (name, email, password) VALUES ('Bob Smith', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana Green', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_genre (name) VALUES ('DRAMA');
INSERT INTO tb_genre (name) VALUES ('COMEDIA');
INSERT INTO tb_genre (name) VALUES ('AVENTURA');
INSERT INTO tb_genre (name) VALUES ('TERROR');
INSERT INTO tb_genre (name) VALUES ('SUSPENSE');

INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('MARIGHELLA', null, '2021', 'https://www.adorocinema.com/filmes/filme-223298/', 'Neste filme biográfico, acompanhamos a história de Carlos Marighella, em 1969, um homem que não teve tempo pra ter medo.', 1);

INSERT INTO tb_review (text, user_id, movie_id) VALUES ('Muito bom!', 2, 1);