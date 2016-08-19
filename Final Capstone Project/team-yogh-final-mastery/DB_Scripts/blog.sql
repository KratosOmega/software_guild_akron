DROP DATABASE IF EXISTS Blog;

CREATE DATABASE Blog;

USE Blog;

/* Status */
CREATE TABLE blog_status(
  status_id INT NOT NULL AUTO_INCREMENT,
  status_name VARCHAR(10) NOT NULL,
  PRIMARY KEY(status_id)
);


/* role */
CREATE TABLE authorities(
  user_name VARCHAR(15) NOT NULL,
  authority VARCHAR(20) NOT NULL,
  KEY (user_name)
);


/* Categoery */
CREATE TABLE blog_category(
  category_id INT NOT NULL AUTO_INCREMENT,
  category_name VARCHAR(20),
  PRIMARY KEY(category_id)
);


/* tag */
CREATE TABLE blog_tag(
  tag_id INT NOT NULL AUTO_INCREMENT,
  tag_name TEXT NOT NULL,
  PRIMARY KEY(tag_id)
);


/* Bridge Table */
CREATE TABLE blog_post_to_tag(
  post_id INT NOT NULL,
  tag_id INT NOT NULL,
  PRIMARY KEY(post_id, tag_id)
);


/* User */
CREATE TABLE blog_user(
  user_id INT NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(15) NOT NULL,
  user_password VARCHAR(20) NOT NULL,
  user_enabled TINYINT(1) NOT NULL,
  PRIMARY KEY(user_id),
  KEY (user_name)
);


/* Post */
CREATE TABLE blog_post(
  post_id INT NOT NULL AUTO_INCREMENT,
  post_title VARCHAR(30) NOT NULL,
  post_content TEXT NOT NULL,
  post_publish_date DATE,
  post_create_date DATE,
  user_id INT NOT NULL,
  category_id INT NOT NULL,
  status_id INT NOT NULL,
  PRIMARY KEY(post_id),
  FOREIGN KEY(user_id) REFERENCES blog_user(user_id),
  FOREIGN KEY(category_id) REFERENCES blog_category(category_id),
  FOREIGN KEY(status_id) REFERENCES blog_status(status_id)
);

/* Page */
CREATE TABLE blog_page(
  page_id INT NOT NULL AUTO_INCREMENT,
  page_tab VARCHAR(10) NOT NULL,
  page_content TEXT NOT NULL,
  status_id INT NOT NULL,
  PRIMARY KEY(page_id),
  FOREIGN KEY(status_id) REFERENCES blog_status(status_id)
);


/* Comment */
CREATE TABLE blog_comment(
  comment_id INT NOT NULL AUTO_INCREMENT,
  comment_content TEXT NOT NULL,
  comment_publish_date DATE,
  user_id INT NOT NULL,
  post_id INT NOT NULL,
  PRIMARY KEY(comment_id),
  FOREIGN KEY(user_id) REFERENCES blog_user(user_id),
  FOREIGN KEY(post_id) REFERENCES blog_post(post_id)
);


/*
-- Page

*/

/* Predefined Data */
-- Set the status
INSERT INTO blog_status(status_name) VALUES ('ACTIVE');
INSERT INTO blog_status(status_name) VALUES ('DRAFT');
INSERT INTO blog_status(status_name) VALUES ('SCHEDULE');
INSERT INTO blog_status(status_name) VALUES ('ARCHIVE');

/* Data below is for testing purpose */
INSERT INTO blog_category(category_name) VALUES ('Categoery # 1');
INSERT INTO blog_category(category_name) VALUES ('Categoery # 2');
INSERT INTO blog_tag(tag_name) VALUES ('Tag # 1');
INSERT INTO blog_tag(tag_name) VALUES ('Tag # 2');
INSERT INTO blog_user(user_name, user_password, user_enabled) VALUES ('Kratos', 'kratos123', 1);
INSERT INTO blog_user(user_name, user_password, user_enabled) VALUES ('Omega', 'omega123', 1);

INSERT INTO authorities (user_name, authority) VALUES ('Kratos', "ROLE_ADMIN");
INSERT INTO authorities (user_name, authority) VALUES ('Kratos', "ROLE_USER");
INSERT INTO authorities (user_name, authority) VALUES ('Omega', "ROLE_USER");
/* Data above is for testing purpose */


