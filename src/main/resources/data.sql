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
INSERT INTO tb_genre (name) VALUES ('FICCAO CIENTIFICA');

INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('MARIGHELLA', null, '2021', 'https://m.media-amazon.com/images/M/MV5BMmZkNjg3MTgtY2E3OC00YTBmLWI3YTktZWVlZDIxMjAwOTcwXkEyXkFqcGdeQXVyMTkzODUwNzk@._V1_FMjpg_UX1000_.jpg', 'Neste filme biográfico, acompanhamos a história de Carlos Marighella, em 1969, um homem que não teve tempo pra ter medo.', 1);
INSERT INTO tb_movie (title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('HOMEM-ARANHA: SEM VOLTA PARA CASA', null, 2021, 'https://s2.glbimg.com/TxQm7TbPjtdv99GcVGFgroItgxU=/e.glbimg.com/og/ed/f/original/2021/11/16/hasvc_cartaz.posted_1080x1350px_data.jpg', 'Em Homem-Aranha: Sem Volta para Casa, Peter Parker (Tom Holland) precisará lidar com as consequências da sua identidade como o herói mais querido do mundo. após ter sido revelada pela reportagem do Clarim Diário, com uma gravação feita por Mysterio (Jake Gyllenhaal) no filme anterior', 3);
INSERT INTO tb_movie (title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('DEBI LOIDE 2', null, 2014, 'https://br.web.img2.acsta.net/pictures/14/10/23/13/15/276424.jpg', 'Mais nova aventura dos inseparáveis Lloyd Christmas (Jim Carrey) e Harry Dunne (Jeff Daniels). Desta vez, Harry descobre que teve uma filha ilegítima, que hoje precisa dele para um transplante de rim. Ele leva o amigo Lloyd para conhecer a garota, e os dois percebem que não têm a responsabilidade necessária para serem pais.', 2);
INSERT INTO tb_movie (title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('AVATAR', null, 2010, 'https://br.web.img3.acsta.net/medias/nmedia/18/87/30/40/20028676.jpg', 'Jake Sully (Sam Worthington) ficou paraplégico após um combate na Terra. Ele é selecionado para participar do programa Avatar em substituição ao seu irmão gêmeo, falecido. Jake viaja a Pandora, uma lua extraterrestre, onde encontra diversas e estranhas formas de vida. O local é também o lar dos NaVi, seres humanóides que, apesar de primitivos, possuem maior capacidade física que os humanos.', 6);
INSERT INTO tb_movie (title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('OS FAROFEIROS', null, 2018, 'https://br.web.img3.acsta.net/pictures/18/01/03/19/24/3938254.jpg', 'Quatro colegas de trabalho se programam para curtir o feriado prolongado em uma casa de praia e, chegando lá, descobrem que se meteram em uma tremenda roubada. Para começar o destino não é Búzios, mas Maringuaba; a residência alugada é encontrada caindo aos pedaços, bem diferente do prometido; a praia está sempre cheia; e as confusões são inúmeras.', 2);
INSERT INTO tb_movie (title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('SOBRENATURAL', null, 2011, 'https://maniacosporfilme.files.wordpress.com/2011/08/insidious.jpg', 'O professor Josh Lambert e sua esposa Renai se mudam com seus três filhos – os garotos Dalton e Foster e o bebê Cali – para uma casa muito grande. Quando Dalton está explorando o sótão, ele cai da escada e bate com a cabeça no chão. Na manhã seguinte, Dalton não acorda e fica em coma, mas os médicos não conseguem diagnosticar o seu problema.', 4);
INSERT INTO tb_movie (title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('A ILHA DO MEDO', null, 2010, 'http://2.bp.blogspot.com/-M0R0KFo-kOc/U778Byzi-bI/AAAAAAAANMI/POj94JZQPTc/s1600/review-a-ilha-do-medo1.jpg', '1954. Teddy Daniels (Leonardo DiCaprio) investiga o desaparecimento de um paciente no Shutter Island Ashecliffe Hospital, em Boston. No local, ele descobre que os médicos realizam experiências radicais com os pacientes, envolvendo métodos ilegais e anti-éticos. Teddy tenta buscar mais informações, mas enfrenta a resistência dos médicos em lhe fornecer os arquivos que possam permitir que o caso seja aberto.', 5);



INSERT INTO tb_review (text, user_id, movie_id) VALUES ('Muito bom!', 2, 1);
INSERT INTO tb_review (text, user_id, movie_id) VALUES ('Emocionante', 2, 1);
INSERT INTO tb_review (text, user_id, movie_id) VALUES ('Super Heroir favorito. Filmes Sensacional', 2, 2);
INSERT INTO tb_review (text, user_id, movie_id) VALUES ('Altas risadas', 2, 3);
INSERT INTO tb_review (text, user_id, movie_id) VALUES ('Lindo Filme. Cores vibrantes.', 2, 4);
INSERT INTO tb_review (text, user_id, movie_id) VALUES ('Para rir muito', 2, 5);
INSERT INTO tb_review (text, user_id, movie_id) VALUES ('Terror SObrenatural', 2, 6);
INSERT INTO tb_review (text, user_id, movie_id) VALUES ('Frio na espinha', 2, 7);
