CREATE TABLE IF NOT EXISTS users (
	email varchar(50) NOT NULL,  
	password varchar(50) NOT NULL,
	name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
  PRIMARY KEY (email)
);


CREATE TABLE IF NOT EXISTS blog (
	id integer PRIMARY KEY AUTOINCREMENT,
	name varchar(50) NOT NULL,  
	url varchar(50) NOT NULL,
	user_email varchar(50) NOT NULL,
	categories varchar(50)
);


-- CREATE TABLE IF NOT EXISTS categories (
-- 	id integer PRIMARY KEY AUTOINCREMENT,
-- 	name varchar(50) NOT NULL
-- );


-- CREATE TABLE IF NOT EXISTS blog_categories (
--	id_blog integer NOT NULL,
--	id_category integer NOT NULL,  
--  PRIMARY KEY (id_blog,id_category)
-- );


CREATE TABLE IF NOT EXISTS posts (
	id integer PRIMARY KEY AUTOINCREMENT,
	title varchar(50) NOT NULL,  
	content varchar(50) NOT NULL,
	created_at TIMESTAMP NOT NULL,
	updated_at TIMESTAMP NOT NULL,
	blog_id integer NOT NULL
);


CREATE TABLE IF NOT EXISTS comment (
	id integer PRIMARY KEY AUTOINCREMENT,
	content varchar(50) NOT NULL,
	created_at TIMESTAMP NOT NULL,
	published INTEGER NOT NULL DEFAULT 0,
	user_email varchar(50) NOT NULL,
	post_id integer NOT NULL
);


