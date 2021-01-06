# --- !Ups

CREATE TABLE dogs (
 id uuid not null
     PRIMARY KEY
     DEFAULT uuid_generate_v4(),
 name VARCHAR NOT NULL,
 color VARCHAR NOT NULL
);

# --- !Downs

DROP TABLE dogs;