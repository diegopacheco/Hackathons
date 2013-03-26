# Tasks schema
 
# --- !Ups

CREATE SEQUENCE achievement_id_seq;
CREATE TABLE achievement (
    id integer NOT NULL DEFAULT nextval('achievement_id_seq'),
    label varchar(255)
);
 
# --- !Downs
 
DROP TABLE achievement;
DROP SEQUENCE achievement_id_seq;