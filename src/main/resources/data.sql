-- INSERT INTO genres (name, description, created_at, updated_at)
-- VALUES ('Horror', 'A genre of horror stories', NOW(), NOW());
--
-- INSERT INTO publishers (name, address, created_at, updated_at)
-- VALUES ( 'Penguin', '123 Main St, Anytown, USA', NOW(), NOW());

-- Insert into publishers
insert into publishers (created_at, updated_at, address, contact_details, name)
values (now(), now(), 'www.bmg.com', 'This is a great service both for recording and music publishing', 'BMG'),
       (now(), now(), 'https://concord.com/', 'They have incredible connections and know many influential people in the music industry', 'Concord');

-- Insert into genres
insert into genres (created_at, updated_at, name, description)
values (now(), now(), 'Soul', 'It is good for your soul'),
       (now(), now(), 'Jazz', 'Jazz hands and careless whispers'),
       (now(), now(), 'House', 'Hakkuh!');


-- Insert into Albums met dynamische genre_id en publisher_id
insert into albums (created_at, updated_at, genre_id, publisher_id, title, release_year)
values (
           now(),
           now(),
           (select id from genres where name = 'Jazz'),
           (select id from publishers where name = 'BMG'),
           'Rock album',
           2021
       );

-- Insert into Albums met statische genre_id en publisher_id
insert into albums (created_at, updated_at, genre_id, publisher_id, title, release_year)
values ( now(), now(), 1, 1, 'The best of', 1986),
       (now(), now(), null, 2, 'Hakkuhbar', 1979);

-- Insert into artists
insert into artists (created_at, updated_at, biography, name)
values (now(), now(), 'The house band for Stax Records in Memphis, Tennessee', 'Booker T & the M.G.''s'),
       (now(), now(), 'Probably the best known heavy metal band', 'Metallica'),
       (now(), now(), 'The pioneers of electronic music', 'Kraftwerk');

insert into stock (created_at, updated_at, condition, price, album_id)
values (now(), now(), 'good', 19.95, 1),
       (now(), now(), 'medium', 20.00, 1),
       (now(), now(), 'good', 15.50, 1),
       (now(), now(), 'poor', 5.95, 2);

insert into album_artists (album_id, artist_id)
values (3, 1);

-- UPDATE Albums
-- SET genre_id = (
--     SELECT id FROM genres WHERE name = 'House'
-- )
-- WHERE title = 'Hakkuhbar';